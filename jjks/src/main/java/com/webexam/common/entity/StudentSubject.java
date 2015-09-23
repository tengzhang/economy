package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生-科目实体
 *
 * @author: zhangteng
 * @time: 14-1-28 下午11:19
 */
@Entity
@Table(name = "t_student_subject")
public class StudentSubject extends AbstractEntity {

    private static final long serialVersionUID = 1172962767237771685L;

    @Id
    private Integer id;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "is_pay")
    private Integer isPay;

    @Column(name = "pay_time")
    private String payTime;

    private Integer score;

    @Column(name = "is_show_score")
    private Integer isShowScore;

    /**
     * 默认构造函数
     */
    public StudentSubject() {
    }

    public StudentSubject(String subjectCode, String subjectName, Integer isPay, String payTime, Integer score, Integer isShowScore) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.isPay = isPay;
        this.payTime = payTime;
        this.score = score;
        this.isShowScore = isShowScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIsShowScore() {
        return isShowScore;
    }

    public void setIsShowScore(Integer isShowScore) {
        this.isShowScore = isShowScore;
    }
}
