package com.viepovsky.student;

import org.springframework.data.mongodb.repository.MongoRepository;

interface StudentRepository extends MongoRepository<Student, String> {

}
