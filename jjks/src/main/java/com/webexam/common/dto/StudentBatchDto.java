package com.webexam.common.dto;

/**
 * 学生批量操作Dto
 *
 * @author: zhangteng
 * @time: 14-1-31 下午11:19
 */
public class StudentBatchDto {

    /**
     * 准考证号
     */
    private String examNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 学校/机构
     */
    private String schoolName;

    /**
     * 专业代码
     */
    private String majorCode;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 科目代码
     */
    private String subjectCode;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 是否缴费
     */
    private Integer isPay;

    /**
     * 缴费时间
     */
    private String payTime;

    /**
     * 成绩
     */
    private Integer score;

    /**
     * 是否显示成绩
     */
    private Integer isShowScore;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
