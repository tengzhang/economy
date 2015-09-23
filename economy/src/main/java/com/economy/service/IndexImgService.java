package com.economy.service;

import com.economy.common.entity.IndexImg;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页图片service
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:49
 */
public interface IndexImgService extends BaseService {

    /**
     * 查询记录数
     *
     * @return
     * @throws SSException
     */
    public int queryCount() throws SSException;

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<IndexImg> queryAll() throws SSException;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     * @throws SSException
     */
    public IndexImg queryById(Integer id) throws SSException;

    /**
     * 添加首页图片
     *
     * @param indexImg
     * @param file
     * @param request
     * @throws SSException
     */
    public void insertIndexImg(IndexImg indexImg, PandaworkMultipartFile file, HttpServletRequest request) throws SSException;

    /**
     * 更新首页图片
     *
     * @param indexImg
     * @param file
     * @param request
     * @throws SSException
     */
    public void updateIndexImg(IndexImg indexImg, PandaworkMultipartFile file, HttpServletRequest request) throws SSException;
}
