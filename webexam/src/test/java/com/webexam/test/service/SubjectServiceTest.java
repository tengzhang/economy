package com.webexam.test.service;

import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.Subject;
import com.webexam.service.SubjectService;
import com.webexam.test.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * SubjectServiceTest
 *
 * @author: zhangteng
 * @time: 14-1-21 下午3:06
 */
public class SubjectServiceTest extends AbstractTestCase {

    @Autowired
    private SubjectService subjectService;

    @Test
    public void batchInsert() throws SSException {
        File file = new File("E:\\webexam\\subject-template.xls");
        subjectService.batchInsert(file);
    }

    @Test
    public void batchOutput() throws SSException {
        subjectService.batchOutput();
    }
}
