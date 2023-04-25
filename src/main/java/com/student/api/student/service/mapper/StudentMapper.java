package com.student.api.student.service.mapper;

import com.student.api.student.domain.Student;

public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto studentToStudentDto(Student student);
    Student StudentDtoToStudent(StudentDto studentDto);


}
