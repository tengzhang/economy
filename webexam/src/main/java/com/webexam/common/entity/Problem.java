package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 题目实体
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:37
 */
@Entity
@Table(name = "t_problem")
public class Problem extends AbstractEntity {

    private static final long serialVersionUID = -3995624085560180694L;

    /**
     * 主键
     */
    @Id
    private Integer id;

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
     * 题目类型（1-单选，2-多选，3-判断）
     */
    private Integer type;

    /**
     * 题干
     */
    private String title;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 选项A
     */
    @Column(name = "choose_a")
    private String chooseA;

    /**
     * 选项B
     */
    @Column(name = "choose_b")
    private String chooseB;

    /**
     * 选项C
     */
    @Column(name = "choose_c")
    private String chooseC;

    /**
     * 选项D
     */
    @Column(name = "choose_d")
    private String chooseD;

    /**
     * 选项E
     */
    @Column(name = "choose_e")
    private String chooseE;

    /**
     * 答案
     */
    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getChooseA() {
        return chooseA;
    }

    public void setChooseA(String chooseA) {
        this.chooseA = chooseA;
    }

    public String getChooseB() {
        return chooseB;
    }

    public void setChooseB(String chooseB) {
        this.chooseB = chooseB;
    }

    public String getChooseC() {
        return chooseC;
    }

    public void setChooseC(String chooseC) {
        this.chooseC = chooseC;
    }

    public String getChooseD() {
        return chooseD;
    }

    public void setChooseD(String chooseD) {
        this.chooseD = chooseD;
    }

    public String getChooseE() {
        return chooseE;
    }

    public void setChooseE(String chooseE) {
        this.chooseE = chooseE;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
