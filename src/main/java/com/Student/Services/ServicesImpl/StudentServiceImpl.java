package com.Student.Services.ServicesImpl;

import com.Student.Dao.StudentRepo;
import com.Student.Exceptions.Error;
import com.Student.Models.Student;
import com.Student.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl  implements StudentServices {

    private StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student)  throws Error  {
        if(student.getName()== null || student.getName().equals("")){
            throw new Error("Name can not be null");
        }
        else if(student.getAge() == null || student.getAge().equals(""))
        {
            throw new  Error("Age can not be null");
        }else if(student.getRollNo() == null || student.getRollNo().equals("")){
            throw new Error("Roll Number can not be Null");
        }else if(student.getGender() == null || student.getGender().equals("")){
            throw new Error("Gender  can not be Null");
        }else{

            return studentRepo.save(student);
        }

    }

    @Override
    public Student updateStudent(Student student) throws Error {

        if(student.getName()== null || student.getName().equals("")){
            throw new Error("Name can not be null");
        }
        else if(student.getAge() == null || student.getAge().equals(""))
        {
            throw new  Error("Age can not be null");
        }else if(student.getRollNo() == null || student.getRollNo().equals("")){
            throw new Error("Roll Number can not be Null");
        }else if(student.getGender() == null || student.getGender().equals("")){
            throw new Error("Gender  can not be Null");
        }else{

            return studentRepo.save(student);
        }

    }


    @Override
    public Student getByStudentId(int id) throws Error{

      Optional student= studentRepo.findById(id);
      if(student.isEmpty()){
          throw new Error("Student Not Found");
      }else {
          return studentRepo.findById(id).get();
    }

    }

    @Override
    public void deleteStudent(int id) throws Error {

        Optional student= studentRepo.findById(id);
        if(student.isEmpty()){
            throw new Error("Student Not Found");
        }else {
         Student stu=   studentRepo.findById(id).get();
         studentRepo.delete(stu);

        }

    }


}
