package com.economy.service;

import com.economy.common.entity.Certificate;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 证书Service
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:16
 */
public interface CertificateService extends BaseService {

    /**
     * 根据首页模块id查询
     *
     * @param indexModuleId
     * @return
     * @throws SSException
     */
    public List<Certificate> queryByIndexModuleId(Integer indexModuleId) throws SSException;

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<Certificate> queryAll() throws SSException;

    /**
     * 添加证书
     *
     * @param certificate
     * @param file
     * @param request
     * @throws SSException
     */
    public void insertCertificate(Certificate certificate, PandaworkMultipartFile file, HttpServletRequest request) throws SSException;

    /**
     * 更新证书
     *
     * @param certificate
     * @param file
     * @param request
     * @throws SSException
     */
    public void updateCertificate(Certificate certificate, PandaworkMultipartFile file, HttpServletRequest request) throws SSException;
}
