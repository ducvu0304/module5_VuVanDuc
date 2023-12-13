package rikkei.com.service;

import rikkei.com.dto.StudentDTO;
import rikkei.com.entity.Mark;
import rikkei.com.entity.Student;

import java.util.List;
import java.util.Set;

public interface IStudentService {
    List<StudentDTO> findUserList();
    Set<Mark> findListMarkOfStudentById(Integer studentId);
    StudentDTO getStudentById(Integer studentId);
    void updateStudent(StudentDTO studentDTO);
    void deleteStudentById(Integer studentId);
    void saveStudent(StudentDTO studentDTO);
}
