package com.demo.example.student_.library_.management_.system.repository;

import com.demo.example.student_.library_.management_.system.model.Author;
import com.demo.example.student_.library_.management_.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
