package rikkei.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.com.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
