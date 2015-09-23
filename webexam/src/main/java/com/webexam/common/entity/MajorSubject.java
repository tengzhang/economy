package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专业科目关联表实体
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:38
 */
@Entity
@Table(name = "t_major_subject")
public class MajorSubject extends AbstractEntity {

    private static final long serialVersionUID = 5694753745879500941L;

    @Id
    private Integer id;

    @Column(name = "major_id")
    private Integer majorId;

    @Column(name = "subject_id")
    private Integer subjectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
