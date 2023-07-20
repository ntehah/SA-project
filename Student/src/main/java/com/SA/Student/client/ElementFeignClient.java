package com.SA.Student.client;

import com.SA.Student.DTO.ElementOperationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("Avatar")
public interface ElementFeignClient {
        @RequestMapping("/element/buy-element")
        public String buyElementByStudent(@RequestBody ElementOperationDTO elementOperationDTO);
}
