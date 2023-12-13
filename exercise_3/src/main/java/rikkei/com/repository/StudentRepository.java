package rikkei.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.com.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
