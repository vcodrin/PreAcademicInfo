package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.bases.AbstractCourseType;
import com.example.preAcademicInfo.bases.Record;
import com.example.preAcademicInfo.constants.Constants;
import com.example.preAcademicInfo.constants.CourseAttribute;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final EnvUtil envUtil;
    private final Environment environment;
    private final LaboratoryRepository laboratoryRepository;
    private final SeminarRepository seminarRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, EnvUtil envUtil, LaboratoryRepository laboratoryRepository, SeminarRepository seminarRepository, LectureRepository lectureRepository) {
        this.courseRepository = courseRepository;
        this.envUtil = envUtil;
        environment = envUtil.getEnv();
        this.laboratoryRepository = laboratoryRepository;
        this.seminarRepository = seminarRepository;
        this.lectureRepository = lectureRepository;
    }

    public void createCourse(Course course, Map<String, String[]> values, List<ValidationError> errors) {
        if (values != null) {
            values.forEach((k, v) -> {
                if (v.length == 0) {
                    errors.add(new ValidationError("errors.course.invalid", environment));
                }
                if (v.length == 2) {
                    String requires = v[0];
                    Integer howMany = FormatUtils.stringToInt(v[1]);
                    if (!requires.isEmpty()) {
                        if (requires.equals(Constants.IS_CHECKED)) {
                            if (howMany != null && FormatUtils.integerBetweenRange(howMany, 7, 14)) {
                                if (k.equals(CourseAttribute.LABORATORY.getName())) {
                                    List<LaboratoryRecord> laboratoryRecords = new ArrayList<>();
                                    Laboratory laboratory = new Laboratory();
                                    populateBaseCourseType(laboratory, 0, 0, 0, true, false);
                                    laboratory.setCourse(course);
                                    for (int i = 0; i < howMany; i++) {
                                        LaboratoryRecord laboratoryRecord = new LaboratoryRecord();
                                        laboratoryRecord.setLaboratory(laboratory);
                                        laboratoryRecords.add(laboratoryRecord);
                                    }
                                    laboratory.setRecords(laboratoryRecords);
                                    course.setLaboratory(laboratory);
                                } else if (k.equals(CourseAttribute.SEMINAR.getName())) {
                                    List<SeminarRecord> seminarRecords = new ArrayList<>();
                                    Seminar seminar = new Seminar();
                                    populateBaseCourseType(seminar, 0, 0, 0, true, false);
                                    seminar.setCourse(course);
                                    for (int i = 0; i < howMany; i++) {
                                        SeminarRecord seminarRecord = new SeminarRecord();
                                        seminarRecord.setSeminar(seminar);
                                        seminarRecords.add(seminarRecord);

                                    }
                                    seminar.setRecords(seminarRecords);
                                    course.setSeminar(seminar);
                                } else if (k.equals(CourseAttribute.LECTURE.getName())) {
                                    List<LectureRecord> lectureRecords = new ArrayList<>();
                                    Lecture lecture = new Lecture();
                                    lecture.setCourse(course);
                                    populateBaseCourseType(lecture, 0, 0, 0, true, false);
                                    for (int i = 0; i < howMany; i++) {
                                        LectureRecord lectureRecord = new LectureRecord();
                                        lectureRecord.setLecture(lecture);
                                        lectureRecords.add(lectureRecord);
                                    }
                                    lecture.setRecords(lectureRecords);
                                    course.setLecture(lecture);
                                }

                            } else {
                                errors.add(new ValidationError("errors.course.numberOfRecords", environment));
                            }
                        } else {
                            errors.add(new ValidationError("errors.course.invalidRequestParameters", environment));
                        }
                    }
                } else {
                    errors.add(new ValidationError("errors.course.invalidRequestParameters", environment));
                }
            });
            if (errors.isEmpty()) {
                courseRepository.save(course);
            }
        }
    }


    private void populateBaseCourseType(AbstractCourseType courseType, int i, int i1, int i2, boolean b, boolean b1) {
        courseType.setTotalAttendances(i);
        courseType.setMinAttendances(i1);
        courseType.setFinalGradePercentage(i2);
        courseType.setRequiresGrades(b);
        courseType.setRequiresPresence(b1);

    }
}
