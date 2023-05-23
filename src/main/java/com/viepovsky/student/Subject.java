package com.viepovsky.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Subject {
    private String name;
    private String classNumber;
    private String leadingTeacher;
    private int studentsNumber;
}
