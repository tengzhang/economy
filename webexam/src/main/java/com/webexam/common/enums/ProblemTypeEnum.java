package com.webexam.common.enums;

import com.webexam.common.entity.Problem;

/**
 * ProblemTypeEnum
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:45
 */
public enum ProblemTypeEnum {
    SingleChoose(1, "单选"),
    MultiChoose(2, "多选"),
    Judge(3, "判断");

    private Integer type;

    private String descprition;

    ProblemTypeEnum(Integer type, String descprition) {
        this.type = type;
        this.descprition = descprition;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescprition() {
        return descprition;
    }

    public void setDescprition(String descprition) {
        this.descprition = descprition;
    }
}
