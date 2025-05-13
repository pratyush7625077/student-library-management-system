package com.demo.example.student_.library_.management_.system.service;

import com.demo.example.student_.library_.management_.system.converter.StudentConverter;
import com.demo.example.student_.library_.management_.system.enums.CardStatus;
import com.demo.example.student_.library_.management_.system.model.Card;
import com.demo.example.student_.library_.management_.system.model.Student;
import com.demo.example.student_.library_.management_.system.repository.StudentRepository;
import com.demo.example.student_.library_.management_.system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(StudentRequestDto studentRequestDto) {

        // first convert the student requestDto into student model class
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        // whenever the student is created card also automatically gets created
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        student.setCard(card);

        card.setStudent(student);

        studentRepository.save(student);
        return "Student and Card saved successfully";
    }

        public Student getByStudentId(int id){
            Optional<Student> studentOptional = studentRepository.findById(id);
            if(studentOptional.isPresent()){
                return studentOptional.get();
            }else{
                throw new RuntimeException("Student not found : "+id);
            }

        }

        public List <Student> getAllStudents(){
            List<Student> studentList = studentRepository.findAll();
            return studentList;
        }

        public List<Student> getAllStudentsByPage(int pageNo, int pageSize){
            List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())).getContent();
            return studentList;
        }

        public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id :"+id+" got deleted along with it it's card";
        }



        public String updateStudent(int id, StudentRequestDto studentRequestDto){
            // check whether student is present with that id or not
           Student student =  getByStudentId(id);
           if(student!= null){
                student.setName(studentRequestDto.getName());
                student.setMobile(studentRequestDto.getMobile());
                student.setDob(studentRequestDto.getDob());
                student.setSem(studentRequestDto.getSem());
                student.setEmail(studentRequestDto.getEmail());
                student.setDept(studentRequestDto.getDept());
                student.setGender(studentRequestDto.getGender());

                studentRepository.save(student);
                return "Student updated successfully";
           }else{
               return "Student not found , we cannot update";
           }
        }
    }

