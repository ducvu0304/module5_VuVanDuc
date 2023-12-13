package rikkei.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rikkei.com.dto.StudentDTO;
import rikkei.com.entity.Student;
import rikkei.com.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<StudentDTO> findStudentList(){
        return studentService.findUserList();
    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }
//
//    @PutMapping("/{id}")
//    public StudentDTO getStudentById(@PathVariable Integer studentId){
//        return studentService.getStudentById(studentId);
//    }
//
//    @GetMapping("/{id}")
//    public StudentDTO getStudentById(@PathVariable Integer studentId){
//        return studentService.getStudentById(studentId);
//    }
//
//    @GetMapping("/{id}")
//    public StudentDTO getStudentById(@PathVariable Integer studentId){
//        return studentService.getStudentById(studentId);
//    }
}
