package com.economy.common.service;

import com.pandawork.core.entity.AbstractEntity;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * BaseService
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:47
 */
public interface BaseService {

    /**
     * 插入一条记录
     *
     * @param t
     * @param <T>
     * @return
     * @throws SSException
     */
    public <T extends AbstractEntity> T insert(T t) throws SSException;

    /**
     * 批量添加
     *
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void insertAll(Collection<T> objs) throws SSException;
    /**
     * 更新一条记录
     *
     * @param t
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void update(T t) throws SSException;

    /**
     * 删除一条记录
     *
     * @param t
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void delete(T t) throws SSException;

    /**
     * 根据id进行查询
     *
     * @param clazz
     * @param id
     * @param <T>
     * @return
     * @throws SSException
     */
    public <T extends AbstractEntity> T queryById(Class clazz, Integer id) throws SSException;

    /**
     * 上传文件
     *
     * @param file       要上传的文件
     * @param fileFolder 文件保存的文件夹
     * @param request
     * @return           文件的保存路径
     * @throws SSException
     */
    public String uploadFile(PandaworkMultipartFile file, String fileFolder, HttpServletRequest request) throws SSException;

    /**
     * 下载文件
     *
     * @param filename 下载文件名
     * @param path     下载文件在服务器上的路径
     * @throws SSException
     */
    public void downloadFile(String filename, String path, HttpServletResponse response) throws SSException;
}
