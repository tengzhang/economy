package com.economy.common.enums;

/**
 * ArticleEnum
 *
 * @author: zhangteng
 * @time: 2014/4/29 18:06
 */
public enum ArticleTypeEnum {
    Brochure(1, "招生简章"),
    Subject(2, "课程"),
    Cooperation(3, "合作助学单位"),
    Notice(4, "通知");

    private Integer type;
    private String description;

    ArticleTypeEnum(Integer type, String description) {
       this.type = type;
       this.description = description;
   }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
