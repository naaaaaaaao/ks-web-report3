package com.nayoung.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    public void setStudent(Student student) {
        this.student = student;
        this.student.getCourses().add(this);
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
        this.lesson.getCourses().add(this);
    }

    public static Course createCourse(Student student, Lesson... lessons) {
        Course course = new Course();
        course.setStudent(student);
        Arrays.stream(lessons).forEach(course::setLesson);
        return course;
    }
}
