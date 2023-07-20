package com.SA.SchoolService.Controller;

import com.SA.SchoolService.Model.School;
import com.SA.SchoolService.Service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool (@RequestBody School school){

        schoolService.addSchool(school);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<School> getSchools (){

        return schoolService.getSchools();
    }

    @DeleteMapping("/{school_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchool(@PathVariable String school_id){
        schoolService.deleteSchool(school_id);
    }

    @PutMapping("/{school_id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSchool(@RequestBody School school, @PathVariable String school_id){
        schoolService.updateSchool(school,school_id);
    }


}
