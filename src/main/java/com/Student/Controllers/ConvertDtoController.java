package com.Student.Controllers;

import com.Student.DTO.StudentDTO;
import com.Student.Models.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ConvertDtoController {


    public StudentDTO entityToDto(Student student){

        StudentDTO dto= new StudentDTO();
        dto.setId(student.getId());
        dto.setRollNo(student.getRollNo());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setGender(student.getGender());
        return dto;
    }

    public List<StudentDTO> getAllStudentDTO(List<Student> students){
        return  students.stream().map(u -> entityToDto(u)).collect(Collectors.toList());


    }


    public List<Student> getAllStudent(List<StudentDTO> users){
        return  users.stream().map(u -> dtoToEntity(u)).collect(Collectors.toList());


    }


    public Student dtoToEntity(StudentDTO studentDto){

        Student stu= new Student();
        stu.setId(studentDto.getId());
        stu.setAge(studentDto.getAge());
        stu.setName(studentDto.getName());
        stu.setGender(studentDto.getGender());
        stu.setRollNo(studentDto.getRollNo());
        return stu;

    }

}
