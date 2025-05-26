package com.lab01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab01.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}