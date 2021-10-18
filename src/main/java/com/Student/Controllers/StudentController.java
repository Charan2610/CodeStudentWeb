package com.Student.Controllers;


import com.Student.DTO.StudentDTO;
import com.Student.Exceptions.Error;
import com.Student.Exceptions.StudentException;
import com.Student.Models.Student;
import com.Student.Models.Users;
import com.Student.Services.ServicesImpl.StudentServiceImpl;
import com.Student.Services.ServicesImpl.UserSerivesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    private StudentServiceImpl studentServicesImpl;

    private UserSerivesImpl userServicesImpl;

    @Autowired
    public void setUserServicesImpl(UserSerivesImpl userServicesImpl) {
        this.userServicesImpl = userServicesImpl;
    }

    @Autowired
    public void setStudentServicesImpl(StudentServiceImpl studentServicesImpl) {
        this.studentServicesImpl = studentServicesImpl;
    }

    private ConvertDtoController convertDtoController;

    @Autowired
    public void setConvertDtoController(ConvertDtoController convertDtoController) {
        this.convertDtoController = convertDtoController;
    }


    @GetMapping("/allStudents")
    public ResponseEntity<?>  getAllStudents(){
       List<Student> students= studentServicesImpl.getStudents();
       List<StudentDTO> sdto = convertDtoController.getAllStudentDTO(students);
       return ResponseEntity.ok(sdto);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) throws Error {

      Student student= studentServicesImpl.getByStudentId(id);
      StudentDTO studto=   convertDtoController.entityToDto(student);
      return ResponseEntity.ok(studto);
    }


    @PostMapping("/addStudent")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) throws Error {
     Student students =  convertDtoController.dtoToEntity(studentDTO);
    Student stu= studentServicesImpl.addStudent(students);
    StudentDTO studto=  convertDtoController.entityToDto(stu);
    return studto;
    }


    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO) throws Error {

      Student student=  convertDtoController.dtoToEntity(studentDTO);
       Student stu= studentServicesImpl.updateStudent(student);
       StudentDTO studto= convertDtoController.entityToDto(stu);
       return  ResponseEntity.ok(studto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) throws Error {
        studentServicesImpl.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }


    @GetMapping("/user/{username}/{password}")
    public Users getUserByEmailAndPassword(@PathVariable("username") String username,@PathVariable("password") String password){
      Users user=  userServicesImpl.findByEmailAndPassword(username,password);
        return user;
    }

}
