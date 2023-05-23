package com.viepovsky.student;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByStudentNumber(Long number);

    boolean existsByStudentNumber(Long number);

}
