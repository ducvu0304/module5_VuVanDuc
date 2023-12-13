package rikkei.com.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    @Column(name = "subject_name")
    private String subjectName;
    private Integer priority;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    Set<Mark> points;

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Set<Mark> getPoints() {
        return points;
    }

    public void setPoints(Set<Mark> points) {
        this.points = points;
    }
}
