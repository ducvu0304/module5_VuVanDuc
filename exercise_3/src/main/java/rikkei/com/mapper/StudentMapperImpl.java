package rikkei.com.mapper;

import org.springframework.stereotype.Service;
import rikkei.com.dto.StudentDTO;
import rikkei.com.entity.Student;

@Service
public class StudentMapperImpl implements StudentMapper {
    @Override
    public StudentDTO studentDTO(Student student) {
        if(student != null) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentName(student.getStudentName());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setBirthday(student.getBirthday());
            studentDTO.setPhoneNumber(student.getPhoneNumber());
            studentDTO.setGender(student.getGender());

            return studentDTO;
        }

        return null;
    }

    @Override
    public Student student(StudentDTO studentDTO) {
        return null;
    }
}
