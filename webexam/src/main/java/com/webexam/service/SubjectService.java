package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.Subject;
import com.webexam.common.service.BaseService;

import java.io.File;
import java.util.List;

/**
 * SubjectService
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:40
 */
public interface SubjectService extends BaseService {

    /**
     * 查询全部科目
     *
     * @return
     * @throws SSException
     */
    public List<Subject> queryAll() throws SSException;

    /**
     * 查询科目条数
     *
     * @return
     * @throws SSException
     */
    public int queryCount() throws SSException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SSException
     */
    public List<Subject> queryByPage(Pagination page) throws SSException;

    /**
     * 批量添加科目
     *
     * @param file
     * @throws SSException
     */
    public void batchInsert(File file) throws SSException;

    /**
     * 批量导出科目
     *
     * @throws SSException
     */
    public void batchOutput() throws SSException;
}
