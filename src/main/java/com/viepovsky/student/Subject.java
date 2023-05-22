package com.viepovsky.student;

import lombok.Data;

@Data
class Subject {
    private String name;
    private String classNumber;
    private String leadingTeacher;
    private int studentsNumber;
}
