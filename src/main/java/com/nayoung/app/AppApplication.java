package com.nayoung.app;

import com.nayoung.app.domain.Lesson;
import com.nayoung.app.domain.Student;
import com.nayoung.app.repository.LessonRepository;
import com.nayoung.app.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository studentRepository,
									LessonRepository lessonRepository){
		return (args) -> {
			studentRepository.save(Student.builder().name("1").email("1@1.com").build());
			studentRepository.save(Student.builder().name("2").email("2@2.com").build());
			lessonRepository.save(Lesson.builder().name("L1").quota(15).build());
			lessonRepository.save(Lesson.builder().name("L2").quota(15).build());
		};
	}
}
