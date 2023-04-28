package com.student.api.student.service.mapper;
import com.student.api.student.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.StudentDto;



//Mapper
@Mapper(componentModel = "spring")

public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto studentToStudentDto(Student student);
    Student StudentDtoToStudent(StudentDto studentDto);


}
