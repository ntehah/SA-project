package com.SA.SchoolService.Service;

import com.SA.SchoolService.Model.School;
import com.SA.SchoolService.Repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    

    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public void deleteSchool(String schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    public void updateSchool(School school, String schoolId) {
        school.setId(schoolId);
        schoolRepository.save(school);
    }
}
