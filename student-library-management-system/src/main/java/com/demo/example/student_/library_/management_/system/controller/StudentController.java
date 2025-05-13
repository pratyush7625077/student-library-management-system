package com.demo.example.student_.library_.management_.system.controller;

import com.demo.example.student_.library_.management_.system.model.Student;
import com.demo.example.student_.library_.management_.system.requestdto.StudentRequestDto;
import com.demo.example.student_.library_.management_.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.addStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        try{
            Student student = studentService.getByStudentId(id);
            return student;
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
         List<Student> studentList = studentService.getAllStudents();
         return studentList;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id,studentRequestDto);
        return response;
    }

    @GetMapping("/getByPage")
    public List<Student> getStudentByPage(@RequestParam int pageNo, @RequestParam int pageSize){
      List<Student> studentList =  studentService.getAllStudentsByPage(pageNo, pageSize);
        return studentList;
    }
}
