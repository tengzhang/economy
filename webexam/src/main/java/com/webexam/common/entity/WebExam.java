package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 网络测试
 *
 * @author: zhangteng
 * @time: 14-2-3 上午11:40
 */
@Entity
@Table(name = "t_web_exam")
public class WebExam extends AbstractEntity {

    private static final long serialVersionUID = -1360553211218709175L;

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 科目代码
     */
    @Column(name = "subject_code")
    private String subjectCode;

    /**
     * 科目名称
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 专业代码
     */
    @Column(name = "major_code")
    private String majorCode;

    /**
     * 专业名称
     */
    @Column(name = "major_name")
    private String majorName;

    /**
     * 考试开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 考试持续时间
     */
    @Column(name = "exam_time")
    private Integer examTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }
}
