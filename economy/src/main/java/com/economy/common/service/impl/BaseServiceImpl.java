package com.economy.common.service.impl;

import com.economy.common.exception.EconomyException;
import com.pandawork.core.dao.CommonDao;
import com.pandawork.core.dao.impl.CommonDaoUtil;
import com.pandawork.core.dao.impl.KeyValuePair;
import com.pandawork.core.dao.repository.EntityRepositries;
import com.pandawork.core.entity.AbstractEntity;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.fileUpload.FileUploadProcessor;
import com.pandawork.core.fileUpload.UploadFile;
import com.pandawork.core.log.LogClerk;
import com.economy.common.service.BaseService;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * BaseServiceImpl
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:49
 */
public class BaseServiceImpl implements BaseService {

    @Autowired
    protected CommonDao commonDao;

    @Autowired
    @Qualifier("defaultFileUpload")
    protected FileUploadProcessor defaultFileUpload;

    private static final int BATCH_SIZE = 20;

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> T insert(T t) throws SSException {
        try {
            return commonDao.insert(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> void insertAll(Collection<T> objs) throws SSException {
        try {
            commonDao.insertAll(objs);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> void update(T t) throws SSException {
        try {
            commonDao.update(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.UpdateFail);
        }
    }

    @Override
    public <T extends AbstractEntity> void delete(T t) throws SSException {
        try {
            commonDao.delete(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.DeleteFail);
        }
    }

    @Override
    public <T extends AbstractEntity> T queryById(Class clazz, Integer id) throws SSException {
        try {
            return (T) commonDao.queryById(clazz, id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public String uploadFile(PandaworkMultipartFile file, String fileFolder, HttpServletRequest request) throws SSException {
        try {
            String filename = file.getOriginalFilename();
            String basePath = request.getSession().getServletContext().getRealPath("/resources/");
            UploadFile uploadFile = new UploadFile(file.getFile(), basePath, fileFolder, filename, request);
            String path = defaultFileUpload.uploadOneFile(uploadFile);
            return path;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.SystemException);
        }
    }

    @Override
    public void downloadFile(String filename, String path, HttpServletResponse response) throws SSException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            String contentType = "application/octet-stream";
            long fileLength = new File(path).length();

            response.setContentType(contentType);
            response.setHeader("Content-disposition", "attachment; filename=" +
                                new String(filename.getBytes("gbk"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(path));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while(-1 != (bytesRead = bis.read(buff, 0, 2048))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.SystemException);
        } finally {
            if(bis != null) {
                try {
                    bis.close();
                } catch (Exception e) {
                    LogClerk.errLog.error(e);
                    throw SSException.get(EconomyException.SystemException);
                }
            }
            if(bos != null) {
                try{
                   bos.close();
                } catch (Exception e) {
                    LogClerk.errLog.error(e);
                    throw SSException.get(EconomyException.SystemException);
                }
            }
        }
    }
}
