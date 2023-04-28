package com.student.api.student.controller;
import com.student.api.student.controller.StudentApi;
import com.student.api.student.domain.Student;
import com.student.api.student.repository.StudentRepository;
import com.student.api.student.service.mapper.StudentMapper;
import org.openapitools.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("api")

public class StudentController implements StudentApi {

    private StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
//    public ResponseEntity<StudentResponseDto> createStudent(StudentDto studentDto) {
    public ResponseEntity<Object> createStudent(StudentDto studentDto) {

        try{
            Student newStudent = StudentMapper.INSTANCE.StudentDtoToStudent(studentDto);
            Student savedStudent = studentRepository.save(newStudent);
            StudentDto savedStudentDto = StudentMapper.INSTANCE.studentToStudentDto(savedStudent);
            return ResponseEntity.status(200).body(savedStudentDto);
        } catch (Exception e){
            ErrorResponseDto errorResponseDto = new ErrorResponseDto();
            errorResponseDto.appId("StudentRepository").errorCode(500).message("Error creating a Student").
                    dateTime(new Date().toString());
            return ResponseEntity.status(500).body(errorResponseDto);

        }
    }

    @Override
//    public ResponseEntity<StudentListResponseDto> findStudents() {
    public ResponseEntity<Object> findStudents() {
        List<Student> students = studentRepository.findAll();
        StudentListDto studentDtoList = new StudentListDto();
        for (Student student: students) {
            StudentDto studentDto = StudentMapper.INSTANCE.studentToStudentDto(student);
            studentDtoList.add(studentDto);
        }
        return ResponseEntity.status(400).body(studentDtoList);
    }

    @Override
//    public ResponseEntity<StudentResponseDto> findStudentsById(Long studentId) {
    public ResponseEntity<Object> findStudentsById(Long studentId) {

        Optional<Student>studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()){
            Student studentFindById = studentOptional.get();
            StudentDto studentDto = StudentMapper.INSTANCE.studentToStudentDto(studentFindById);
            return ResponseEntity.status(200).body(studentDto);
        }else{
            ErrorResponseDto errorResponseDto =new ErrorResponseDto();
            errorResponseDto.errorCode(500).message("Error! Could not find ID");
            return ResponseEntity.status(500).body(errorResponseDto);
        }
    }




}