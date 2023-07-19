package com.SA.Avatar.Service;

import com.SA.Avatar.Entity.Avatar;
import com.SA.Avatar.Repo.AvatarRepo;
import com.SA.Avatar.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AvatarService {
    private final AvatarRepo avatarRepo;

    public AvatarService(AvatarRepo avatarRepo) {
        this.avatarRepo = avatarRepo;
    }

    public void save(Avatar avatar) {
        log.info("Avatar was saved successfully");
        avatarRepo.insert(avatar);
    }

    public void remove(String id) throws NotFoundException {
        log.info("Avatar was removed");
        avatarRepo.delete(avatarRepo.findById(id).orElseThrow(() -> new NotFoundException("Avatar Not Found")));
    }

    public void update(Avatar newAvatar) throws NotFoundException {
        log.info("Avatar was updated");
        Avatar oldAvatar = avatarRepo.findById(newAvatar.getId()).
                orElseThrow(() -> new NotFoundException("Avatar Not Found"));
        oldAvatar.setEars(newAvatar.getEars());
        oldAvatar.setBody(newAvatar.getBody());
        oldAvatar.setEye(newAvatar.getEye());
        oldAvatar.setHat(newAvatar.getHat());
        oldAvatar.setHair(newAvatar.getHair());
        oldAvatar.setEyebrow(newAvatar.getEyebrow());
        oldAvatar.setHead(newAvatar.getHead());
        oldAvatar.setHat_colour(newAvatar.getHat_colour());
        oldAvatar.setMouth(newAvatar.getMouth());
        oldAvatar.setTop(newAvatar.getTop());
        oldAvatar.setTop_colour(newAvatar.getTop_colour());
        oldAvatar.setNose(newAvatar.getNose());
        avatarRepo.save(oldAvatar);


    }

    public Avatar getAvatarById(String id) throws NotFoundException {
        log.info("Avatar was get ");
        return avatarRepo.findById(id).orElseThrow(() -> new NotFoundException("Avatar Not Found"));
    }
}
