package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生实体
 *
 * @author: zhangteng
 * @time: 14-1-28 下午11:14
 */
@Entity
@Table(name = "t_student")
public class Student extends AbstractEntity {

    private static final long serialVersionUID = -2446487043470395636L;

    @Id
    private Integer id;

    /**
     * 准考证号
     */
    @Column(name = "exam_no")
    private String examNo;

    /**
     * 身份证号
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 姓名
     */
    private String name;

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
     * 学校/机构
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 默认构造函数
     */
    public Student() {
    }

    public Student(String examNo, String idNo, String name, String majorCode, String majorName, String schoolName) {
        this.examNo = examNo;
        this.idNo = idNo;
        this.name = name;
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.schoolName = schoolName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
