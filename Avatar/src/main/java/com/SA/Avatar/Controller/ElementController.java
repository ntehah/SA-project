package com.SA.Avatar.Controller;

import com.SA.Avatar.DTO.ElementOperationDTO;
import com.SA.Avatar.Entity.Element;
import com.SA.Avatar.NotFoundException;
import com.SA.Avatar.Service.ElementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/element")
public class ElementController {
    private final ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }


    @GetMapping("/{id}")
    public Element view(@PathVariable String id) throws NotFoundException {
        return elementService.getElementById(id);
    }

    @PostMapping
    public void add(@RequestBody Element element) {
        elementService.add(element);
    }

    @PutMapping
    public void update(@RequestBody Element element) throws NotFoundException {
        elementService.update(element);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        elementService.remove(id);
    }

    @PostMapping("/buy-element")
    public String buyElementByStudent(@RequestBody ElementOperationDTO elementOperationDTO) throws NotFoundException {
        return elementService.buyElementByStudent(elementOperationDTO);
    }

    @PostMapping("/return-element")
    public String returnElement(@RequestBody ElementOperationDTO elementOperationDTO) throws NotFoundException {
        return elementService.returnElement(elementOperationDTO);
    }
}
