package rikkei.com.mapper;

import org.mapstruct.Mapper;
import rikkei.com.dto.StudentDTO;
import rikkei.com.entity.Student;

@Mapper
public interface StudentMapper {
    StudentDTO studentDTO(Student student);
    Student student(StudentDTO studentDTO);
}
