package com.webexam.service.impl;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.MajorSubject;
import com.webexam.common.entity.Subject;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.MajorSubjectMapper;
import com.webexam.service.MajorSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MajorSubjectServiceImpl
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:41
 */
@Service("majorSubjectService")
public class MajorSubjectServiceImpl extends BaseServiceImpl implements MajorSubjectService {

    @Autowired
    private MajorSubjectMapper majorSubjectMapper;

    @Override
    public List<MajorSubjectDto> queryAll() throws SSException {
        try {
            return majorSubjectMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(MajorSubject.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<MajorSubjectDto> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            return majorSubjectMapper.queryByPage(params);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Subject> querySubjectByMajor(Integer majorId) throws SSException {
        try {
            return majorSubjectMapper.querySubjectByMajor(majorId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }
}
