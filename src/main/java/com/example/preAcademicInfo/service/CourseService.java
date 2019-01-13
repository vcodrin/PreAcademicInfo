package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.bases.AbstractCourseType;
import com.example.preAcademicInfo.bases.Record;
import com.example.preAcademicInfo.constants.Constants;
import com.example.preAcademicInfo.constants.CourseAttribute;
import com.example.preAcademicInfo.dto.CourseDTO;
import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.model.laboratory.Laboratory;
import com.example.preAcademicInfo.model.laboratory.LaboratoryRecord;
import com.example.preAcademicInfo.model.lecture.Lecture;
import com.example.preAcademicInfo.model.lecture.LectureRecord;
import com.example.preAcademicInfo.model.seminar.Seminar;
import com.example.preAcademicInfo.model.seminar.SeminarRecord;
import com.example.preAcademicInfo.repository.CourseRepository;
import com.example.preAcademicInfo.repository.LaboratoryRepository;
import com.example.preAcademicInfo.repository.LectureRepository;
import com.example.preAcademicInfo.repository.SeminarRepository;
import com.example.preAcademicInfo.utils.EnvUtil;
import com.example.preAcademicInfo.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final EnvUtil envUtil;
    private final Environment environment;


    @Autowired
    public CourseService(CourseRepository courseRepository, EnvUtil envUtil) {
        this.courseRepository = courseRepository;
        this.envUtil = envUtil;
        environment = envUtil.getEnv();
    }

    @Transactional
    public void createCourse(@Valid CourseDTO courseDTO, String seminar, String laboratory, String lecture, List<ValidationError> errors) {
        Course course = courseDTO.getCourse();
        if (!laboratory.isEmpty()) {
            Integer howMany = FormatUtils.stringToInt(laboratory);
            if (howMany != null && FormatUtils.integerBetweenRange(howMany, 7, 14)) {
                List<LaboratoryRecord> laboratoryRecords = new ArrayList<>();
                Laboratory l = courseDTO.getLaboratory();
                l.setRequiresPresence(false);
                l.setCourse(course);
                for (int i = 0; i < howMany; i++) {
                    LaboratoryRecord laboratoryRecord = new LaboratoryRecord();
                    laboratoryRecord.setLaboratory(l);
                    laboratoryRecords.add(laboratoryRecord);
                }
                l.setRecords(laboratoryRecords);
                course.setLaboratory(l);
            }else {
                errors.add(new ValidationError("errors.notANumber", environment));
            }
        }
        if (!seminar.isEmpty()) {
            Integer howMany = FormatUtils.stringToInt(seminar);
            if (howMany != null && FormatUtils.integerBetweenRange(howMany, 7, 14)) {
                List<SeminarRecord> seminarRecords = new ArrayList<>();
                Seminar s = courseDTO.getSeminar();
                s.setRequiresPresence(false);
                s.setCourse(course);
                for (int i = 0; i < howMany; i++) {
                    SeminarRecord seminarRecord = new SeminarRecord();
                    seminarRecord.setSeminar(s);
                    seminarRecords.add(seminarRecord);

                }
                s.setRecords(seminarRecords);
                course.setSeminar(s);
            }else {
                errors.add(new ValidationError("errors.notANumber", environment));
            }
        }
        if (!lecture.isEmpty()) {
            Integer howMany = FormatUtils.stringToInt(lecture);
            if (howMany != null && FormatUtils.integerBetweenRange(howMany, 7, 14)) {
                List<LectureRecord> lectureRecords = new ArrayList<>();
                Lecture l = courseDTO.getLecture();
                l.setRequiresPresence(false);
                l.setCourse(course);
                for (int i = 0; i < howMany; i++) {
                    LectureRecord lectureRecord = new LectureRecord();
                    lectureRecord.setLecture(l);
                    lectureRecords.add(lectureRecord);
                }
                l.setRecords(lectureRecords);
                course.setLecture(l);
            } else {
                errors.add(new ValidationError("errors.notANumber", environment));
            }
        }
        System.out.println(errors);
        if (errors.isEmpty()) {
            courseRepository.save(course);
        }
    }
}
