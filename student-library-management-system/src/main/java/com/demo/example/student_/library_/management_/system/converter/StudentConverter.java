package com.demo.example.student_.library_.management_.system.converter;

import com.demo.example.student_.library_.management_.system.model.Student;
import com.demo.example.student_.library_.management_.system.requestdto.StudentRequestDto;

public class StudentConverter {

    //converter - it converts the request dto into model class. So that model class can be saved in database.

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setDept(studentRequestDto.getDept());
        student.setGender(studentRequestDto.getGender());
        student.setDob(studentRequestDto.getDob());
        student.setSem(studentRequestDto.getSem());
        student.setEmail(studentRequestDto.getEmail());
        student.setMobile(studentRequestDto.getMobile());

        return student;
    }
}
