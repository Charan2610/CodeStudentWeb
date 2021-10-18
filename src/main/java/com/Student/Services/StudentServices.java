package com.Student.Services;

import com.Student.Exceptions.Error;
import com.Student.Exceptions.StudentException;
import com.Student.Models.Student;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface StudentServices {


    public List<Student>  getStudents();

    public Student addStudent(Student student) throws ValidationException, Error;

    public Student updateStudent(Student student) throws Error;

    public Student getByStudentId( int id) throws Error, StudentException;

    public void deleteStudent(int id) throws Error;

}
