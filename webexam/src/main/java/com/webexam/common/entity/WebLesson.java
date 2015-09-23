package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 网络课堂实体
 *
 * @author: zhangteng
 * @time: 14-2-11 下午4:48
 */
@Entity
@Table(name = "t_web_lesson")
public class WebLesson extends AbstractEntity {

    private static final long serialVersionUID = -1820100394047135215L;

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 课程名称
     */
    @Column(name = "lesson_name")
    private String lessonName;

    /**
     * 课程地址
     */
    @Column(name = "lesson_url")
    private String lessonUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonUrl() {
        return lessonUrl;
    }

    public void setLessonUrl(String lessonUrl) {
        this.lessonUrl = lessonUrl;
    }
}
