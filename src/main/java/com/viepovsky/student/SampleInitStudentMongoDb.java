package com.viepovsky.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
class SampleInitStudentMongoDb {
    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            long studentNumber = 12124;
            Address address = new Address(
                    "Poland",
                    "Poznań",
                    "61-397",
                    "Jastrzębia 13"
            );
            Subject subject = new Subject(
                    "Math",
                    "14F",
                    "Monica Monroe",
                    16
            );
            Student student = new Student(
                    "Mark",
                    "Martens",
                    Student.Gender.MALE,
                    studentNumber,
                    address,
                    List.of(subject),
                    LocalDateTime.now()
            );
            //usageMongoTemplateAndQuery(repository, mongoTemplate, studentNumber, student);
            if (repository.findByStudentNumber(studentNumber).isEmpty()) {
                repository.insert(student);
            }
        };
    }

    private void usageMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, long studentNumber, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("studentNumber").is(studentNumber));

        List<Student> students = mongoTemplate.find(query, Student.class);

        if (students.size() > 1) {
            throw new IllegalStateException("found students with same number: " + studentNumber);
        }
        if (students.isEmpty()) {
            repository.insert(student);
        }
    }
}
