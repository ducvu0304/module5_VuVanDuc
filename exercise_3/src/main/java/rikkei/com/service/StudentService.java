package rikkei.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.com.dto.StudentDTO;
import rikkei.com.entity.Mark;
import rikkei.com.entity.Student;
import rikkei.com.mapper.StudentMapper;
import rikkei.com.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentDTOMapper;

    @Override
    public List<StudentDTO> findUserList() {
        return studentRepository.findAll()
                .stream()
                .map(student -> studentDTOMapper.studentDTO(student)).collect(Collectors.toList());
    }

    @Override
    public Set<Mark> findListMarkOfStudentById(Integer studentId) {


        return null;
    }

    @Override
    public StudentDTO getStudentById(Integer studentId) {
        return studentDTOMapper.studentDTO(studentRepository.findById(studentId).orElse(null)) ;
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {

}

    @Override
    public void deleteStudentById(Integer studentId) {

    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {

    }
}
