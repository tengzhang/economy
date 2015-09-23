package com.economy.service.impl;

import com.economy.common.entity.IndexImg;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.common.utils.WebConstants;
import com.economy.mapper.IndexImgMapper;
import com.economy.service.IndexImgService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页图片service实现
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:49
 */
@Service("indexImgService")
public class IndexImgServiceImpl extends BaseServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(IndexImg.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<IndexImg> queryAll() throws SSException {
        try {
            return indexImgMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public IndexImg queryById(Integer id) throws SSException {
        try {
            return indexImgMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void insertIndexImg(IndexImg indexImg, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            String imgPath = "";
            if(file.getFile()!=null && file.getFile().length()!=0) {
                imgPath = this.uploadFile(file, WebConstants.INDEX_IMG_FOLDER, request);
            }
            indexImg.setImgPath(imgPath);
            this.insert(indexImg);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void updateIndexImg(IndexImg indexImg, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            if(file.getFile()!=null && file.getFile().length()!=0) {
                String imgPath = this.uploadFile(file, WebConstants.INDEX_IMG_FOLDER, request);
                indexImg.setImgPath(imgPath);
            }
            this.update(indexImg);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.UpdateFail);
        }
    }
}
