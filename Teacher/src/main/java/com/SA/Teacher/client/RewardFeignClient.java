package com.SA.Teacher.client;

import com.SA.Teacher.DTO.Reward;
import com.SA.Teacher.DTO.RewardOperationDTO;
import com.SA.Teacher.exeption.NotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("Avatar")
public interface RewardFeignClient {
    @GetMapping("/reward/{id}")
    public Reward view(@PathVariable String id) throws NotFoundException;

    @PostMapping("/reward")
    public void add(@RequestBody Reward reward);

    @PutMapping("/reward")
    public void update(@RequestBody Reward reward) throws NotFoundException;

    @DeleteMapping("reward/{id}")
    public void delete(@PathVariable String id) throws NotFoundException;

    @PostMapping("reward/buy-reward")
    public String buyRewardByStudent(@RequestBody RewardOperationDTO rewardOperationDTO) throws NotFoundException;
}
