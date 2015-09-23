package com.webexam.common.dto;

import com.webexam.common.entity.Major;
import com.webexam.common.entity.Subject;

/**
 * MajorSubjectDto
 *
 * @author: zhangteng
 * @time: 14-1-21 下午4:16
 */
public class MajorSubjectDto {

    /**
     * MajorSubject主键
     */
    private Integer id;

    /**
     * 专业
     */
    private Major major;

    /**
     * 科目
     */
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
