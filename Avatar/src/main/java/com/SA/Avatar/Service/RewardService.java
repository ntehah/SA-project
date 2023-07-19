package com.SA.Avatar.Service;

import com.SA.Avatar.Client.StudentClient;
import com.SA.Avatar.DTO.RewardOperationDTO;
import com.SA.Avatar.DTO.StudentDTO;
import com.SA.Avatar.Entity.Reward;
import com.SA.Avatar.NotFoundException;
import com.SA.Avatar.Repo.RewardRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RewardService {
    @Autowired
    StudentClient studentClient;
    private final RewardRepo rewardRepo;

    public RewardService(RewardRepo rewardRepo) {
        this.rewardRepo = rewardRepo;
    }

    public void add(Reward reward) {
        log.info("reward was added");
        rewardRepo.insert(reward);
    }

    public void remove(String id) throws NotFoundException {
        log.info("reward was removed");
        rewardRepo.delete(rewardRepo.findById(id).orElseThrow(() -> new NotFoundException("Reward Not Found")));
//                orElseThrow(()->new NotFoundException("Reward Not Found")));
    }

    public void update(Reward newReward) throws NotFoundException {
         log.info("reward was updated");
        Reward oldReward = rewardRepo.findById(newReward.getId()).
                orElseThrow(() -> new NotFoundException("Reward Not Found"));
        newReward.setId(oldReward.getId());
        rewardRepo.save(newReward);


    }

    public Reward getRewardById(String id) throws NotFoundException {
        log.info("getRewardById");
        return rewardRepo.findById(id).orElseThrow(() -> new NotFoundException("Reward Not Found"));
    }

    public String buyRewardByStudent(RewardOperationDTO rewardOperationDTO) throws NotFoundException {
        log.info("buyRewardByStudent");
        StudentDTO studentDTO = studentClient.getStudent(rewardOperationDTO.getStudentId());
        Reward reward = getRewardById(rewardOperationDTO.getRewardId());

        if (studentDTO.getScore() < reward.getPrice()) return "Score is less than reward price";
        studentClient.updateStudentScore(studentDTO.getId(), studentDTO.getScore() - reward.getPrice());
        studentClient.addRewardToStudent(studentDTO.getId(), reward.getId());
        return "Reward buy successfully";
    }


}
