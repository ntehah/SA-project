package com.SA.Avatar.Controller;

import com.SA.Avatar.Entity.Avatar;
import com.SA.Avatar.NotFoundException;
import com.SA.Avatar.Service.AvatarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
   private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping("/{id}")
    public Avatar view(@PathVariable String id) throws NotFoundException {
       return avatarService.getAvatarById(id);
    }

    @PostMapping
    public void add(@RequestBody Avatar avatar){
        avatarService.save(avatar);
    }

    @PutMapping
    public void update(@RequestBody Avatar avatar) throws NotFoundException {
        avatarService.update(avatar);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        avatarService.remove(id);
    }

}
