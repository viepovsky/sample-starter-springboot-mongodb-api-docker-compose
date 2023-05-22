package com.viepovsky.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
class Config {
    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address(
                    "awda",
                    "awdawdawdw",
                    "awdawdad",
                    "wwdawdwdwwdw"
            );
            Student student = new Student(
                    "Okey",
                    "awdawdsss",
                    Student.Gender.MALE,
                    12124L,
                    address,
                    List.of(new Subject()),
                    LocalDateTime.now()
            );
            repository.insert(student);
        };
    }
}
