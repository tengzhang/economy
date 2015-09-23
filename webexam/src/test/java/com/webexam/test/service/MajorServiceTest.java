package com.webexam.test.service;

import com.pandawork.core.exception.SSException;
import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.Major;
import com.webexam.service.MajorService;
import com.webexam.service.MajorSubjectService;
import com.webexam.test.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * MajorServiceTest
 *
 * @author: zhangteng
 * @time: 14-1-15 下午5:13
 */
public class MajorServiceTest extends AbstractTestCase {

    @Autowired
    private MajorService majorService;

    @Autowired
    private MajorSubjectService majorSubjectService;

    @Test
    public void insert() throws SSException {
        Major major = new Major();
        major.setId(2);
        major.setCode("020177");
        major.setName("投资理财");
        majorService.update(major);
    }

    @Test
    public void queryAll() throws SSException {
        List<Major> majorList = majorService.queryAll();
        System.out.println(majorList);
    }

    @Test
    public void qureyById() throws SSException {
        Major major = majorService.queryById(Major.class, 1);
        System.out.println(major);
    }

    @Test
    public void queryAllMS() throws SSException {
        List<MajorSubjectDto> list = majorSubjectService.queryAll();
        System.out.println(list);
    }
}
