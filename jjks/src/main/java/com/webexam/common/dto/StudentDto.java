package com.webexam.common.dto;

import com.webexam.common.entity.Student;
import com.webexam.common.entity.StudentSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentDto
 *
 * @author: zhangteng
 * @time: 14-1-31 下午6:50
 */
public class StudentDto {

    /**
     * 学生主键
     */
    private Integer id;

    /**
     * 学生
     */
    private Student student;

    /**
     * 科目列表
     */
    private List<StudentSubject> subjectList = new ArrayList<StudentSubject>();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<StudentSubject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addSubject(StudentSubject studentSubject) {
        this.subjectList.add(studentSubject);
    }
}
