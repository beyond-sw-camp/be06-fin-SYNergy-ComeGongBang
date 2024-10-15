package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchGradeService {

    private final GradeRepository gradeRepository;

    public List<Grade> getGrade() {
        return gradeRepository.findAll();
    }

}
