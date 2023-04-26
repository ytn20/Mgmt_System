package com.student.api.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository {

    <Student, Long>


}
