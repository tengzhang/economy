package com.webexam.common.dto;

import java.util.List;

/**
 * ExamAnswerListForm
 *
 * @author: zhangteng
 * @time: 14-2-15 下午9:13
 */
public class ExamAnswerListForm {

    List<Integer> ids;

    List<String[]> answers;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String[]> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String[]> answers) {
        this.answers = answers;
    }
}
