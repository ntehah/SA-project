package com.SA.Avatar.Controller;

import com.SA.Avatar.DTO.RewardOperationDTO;
import com.SA.Avatar.Entity.Reward;
import com.SA.Avatar.NotFoundException;
import com.SA.Avatar.Service.RewardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{id}")
    public Reward view(@PathVariable String id) throws NotFoundException {
        return rewardService.getRewardById(id);
    }

    @PostMapping
    public void add(@RequestBody Reward reward){
        rewardService.add(reward);
    }

    @PutMapping
    public void update(@RequestBody Reward reward) throws NotFoundException {
        rewardService.update(reward);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        rewardService.remove(id);
    }
    @PostMapping("/buy-reward")
    public String buyRewardByStudent(@RequestBody RewardOperationDTO rewardOperationDTO) throws NotFoundException {
        return rewardService.buyRewardByStudent(rewardOperationDTO);
    }
}
