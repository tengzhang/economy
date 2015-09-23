package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.Subject;
import com.webexam.common.service.BaseService;

import java.util.List;

/**
 * MajorSubjectService
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:41
 */
public interface MajorSubjectService extends BaseService {

    /**
     * 查询全部专业科目
     *
     * @return
     * @throws SSException
     */
    public List<MajorSubjectDto> queryAll() throws SSException;

    /**
     * 查询记录数
     *
     * @return
     */
    public int queryCount() throws SSException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SSException
     */
    public List<MajorSubjectDto> queryByPage(Pagination page) throws SSException;

    /**
     * 根据专业id查询科目
     *
     * @param majorId
     * @return
     * @throws SSException
     */
    public List<Subject> querySubjectByMajor(Integer majorId) throws SSException;
}
