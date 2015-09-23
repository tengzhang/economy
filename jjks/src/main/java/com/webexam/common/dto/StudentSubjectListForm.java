package com.webexam.common.dto;

import com.webexam.common.entity.StudentSubject;

import java.util.List;

/**
 * StudentSubjectListForm
 *
 * @author: zhangteng
 * @time: 14-2-2 下午12:09
 */
public class StudentSubjectListForm {

    private List<StudentSubject> studentSubjectList;

    public List<StudentSubject> getStudentSubjectList() {
        return studentSubjectList;
    }

    public void setStudentSubjectList(List<StudentSubject> studentSubjectList) {
        this.studentSubjectList = studentSubjectList;
    }
}
