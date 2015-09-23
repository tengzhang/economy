package com.economy.service.impl;

import com.economy.common.entity.Certificate;
import com.economy.common.entity.IndexModule;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.common.utils.WebConstants;
import com.economy.mapper.CertificateMapper;
import com.economy.service.CertificateService;
import com.economy.service.IndexImgService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * CertificateServiceImpl
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:17
 */
@Service("certificateService")
public class CertificateServiceImpl extends BaseServiceImpl implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    @Override
    public List<Certificate> queryByIndexModuleId(Integer indexModuleId) throws SSException {
        try {
            return certificateMapper.queryByIndexModuleId(indexModuleId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Certificate> queryAll() throws SSException {
        try {
            return certificateMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void insertCertificate(Certificate certificate, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            String imgPath = "";
            if(file.getFile()!=null && file.getFile().length()!=0) {
                imgPath = this.uploadFile(file, WebConstants.INDEX_IMG_FOLDER, request);
            }
            certificate.setImgPath(imgPath);
            IndexModule indexModule = this.queryById(IndexModule.class, certificate.getIndexModuleId());
            certificate.setIndexModuleName(indexModule.getName());
            certificate.setPublicTime(new Date());
            this.insert(certificate);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    public void updateCertificate(Certificate certificate, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            if(file.getFile()!=null && file.getFile().length()!=0) {
                String imgPath = this.uploadFile(file, WebConstants.INDEX_IMG_FOLDER, request);
                certificate.setImgPath(imgPath);
            }
            IndexModule indexModule = this.queryById(IndexModule.class, certificate.getIndexModuleId());
            certificate.setIndexModuleName(indexModule.getName());
            certificate.setPublicTime(new Date());
            this.update(certificate);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.UpdateFail);
        }
    }
}
