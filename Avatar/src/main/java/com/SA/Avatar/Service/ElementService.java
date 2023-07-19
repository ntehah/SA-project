package com.SA.Avatar.Service;

import com.SA.Avatar.Client.StudentClient;
import com.SA.Avatar.DTO.ElementOperationDTO;
import com.SA.Avatar.DTO.StudentDTO;
import com.SA.Avatar.Entity.Avatar;
import com.SA.Avatar.Entity.Element;
import com.SA.Avatar.Repo.ElementRepo;
import com.SA.Avatar.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ElementService {

    @Autowired
    StudentClient studentClient;
    @Autowired
    AvatarService avatarService;
    private final ElementRepo elementRepo;

    public ElementService(ElementRepo elementRepo) {
        this.elementRepo = elementRepo;
    }

    public void add(Element element) {
        log.info("element was added");
        elementRepo.insert(element);
    }

    public void remove(String id) throws NotFoundException {
        log.info("element was removed");
        elementRepo.delete(elementRepo.findById(id).orElseThrow(() -> new NotFoundException("Element Not Found")));
    }

    public void update(Element newElement) throws NotFoundException {
        log.info("element was updated");
        Element oldElement = elementRepo.findById(newElement.getId()).
                orElseThrow(() -> new NotFoundException("Element Not Found"));
        newElement.setId(oldElement.getId());
        elementRepo.save(newElement);


    }

    public Element getElementById(String id) throws NotFoundException {
        log.info("element was get");
        return elementRepo.findById(id).orElseThrow(() -> new NotFoundException("Avatar Not Found"));
    }

    public String buyElementByStudent(ElementOperationDTO elementOperationDTO) throws NotFoundException {
        log.info("buyElementByStudent");
        StudentDTO studentDTO = studentClient.getStudent(elementOperationDTO.getStudentId());
        Avatar avatar = avatarService.getAvatarById(studentDTO.getAvatar_id());
        Element element = getElementById(elementOperationDTO.getElementId());
        if (studentDTO.getScore() < element.getPrice()) return "Score is less than element price";
        Element element1 = avatar.getVariable(element.getElementType().toString());
        double studentScore = studentDTO.getScore();
        if (element1 != null) {
            double oldElementPrice = element1.getPrice();
            double newElementPrice = element.getPrice();
            double diffrence = oldElementPrice - newElementPrice;
            if (diffrence > 0) studentClient.updateStudentScore(studentDTO.getId(), studentScore + diffrence);
            if (diffrence < 0) studentClient.updateStudentScore(studentDTO.getId(), studentScore - diffrence);
        }
        studentClient.updateStudentScore(studentDTO.getId(), studentScore - element.getPrice());
        avatar.setVariable(element.getElementType().toString(), element);
        avatarService.save(avatar);
        return "Buy new Element";
    }

    public String returnElement(ElementOperationDTO elementOperationDTO) throws NotFoundException {
        log.info("returnElement");
        StudentDTO studentDTO = studentClient.getStudent(elementOperationDTO.getStudentId());
        Avatar avatar = avatarService.getAvatarById(studentDTO.getAvatar_id());
        Element element = getElementById(elementOperationDTO.getElementId());
        avatar.setVariable(element.getElementType().toString(), null);
        studentClient.updateStudentScore(studentDTO.getId(), studentDTO.getScore() + element.getPrice());
        avatarService.save(avatar);

        return "Element Returned ";

    }

}
