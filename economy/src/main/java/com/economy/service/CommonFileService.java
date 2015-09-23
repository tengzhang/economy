package com.economy.service;

import com.economy.common.entity.CommonFile;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 常用文件Service
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:37
 */
public interface CommonFileService extends BaseService {

    /**
     * 根据条件查询记录数
     *
     * @param search
     * @return
     * @throws SSException
     */
    public int queryCountByCondition(String search) throws SSException;

    /**
     * 条件查询
     *
     * @param page
     * @param search
     * @return
     * @throws SSException
     */
    public List<CommonFile> queryByCondition(Pagination page, String search) throws SSException;

    /**
     * 添加
     *
     * @param indexModuleId
     * @param file
     * @throws SSException
     */
    public void insertCommonFile(Integer indexModuleId,
                                 PandaworkMultipartFile file,
                                 HttpServletRequest request) throws SSException;

    /**
     * 更新
     *
     * @param commonFile
     * @param file
     * @throws SSException
     */
    public void updateCommonFile(CommonFile commonFile,
                                 PandaworkMultipartFile file,
                                 HttpServletRequest request) throws SSException;

    /**
     * 下载
     *
     * @param id
     * @param request
     * @param response
     * @throws SSException
     */
    public void downloadById(Integer id, HttpServletRequest request, HttpServletResponse response) throws SSException;
}
