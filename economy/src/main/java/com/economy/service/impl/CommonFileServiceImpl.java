package com.economy.service.impl;

import com.economy.common.entity.CommonFile;
import com.economy.common.entity.IndexModule;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.common.utils.WebConstants;
import com.economy.mapper.CommonFileMapper;
import com.economy.service.CommonFileService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommonFileServiceImpl
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:38
 */
@Service("commonFileService")
public class CommonFileServiceImpl extends BaseServiceImpl implements CommonFileService {

    @Autowired
    private CommonFileMapper commonFileMapper;

    @Override
    public int queryCountByCondition(String search) throws SSException {
        try {
            return commonFileMapper.queryCountByCondition(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<CommonFile> queryByCondition(Pagination page, String search) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            params.put("search", search);
            List<CommonFile> commonFileList = commonFileMapper.queryByCondition(params);
            return commonFileList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public void insertCommonFile(Integer indexModuleId, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            CommonFile commonFile = new CommonFile();
            // 上传文件
            String path = "";
            if(file.getFile()!=null && file.getFile().length()!=0) {
                path = this.uploadFile(file, WebConstants.ATTACHMENT_FOLDER, request);
                commonFile.setPath(path);
                commonFile.setName(file.getOriginalFilename());
                commonFile.setIndexModuleId(indexModuleId);
                IndexModule indexModule = this.queryById(IndexModule.class, indexModuleId);
                commonFile.setIndexModuleName(indexModule.getName());

                this.insert(commonFile);
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    public void updateCommonFile(CommonFile commonFile, PandaworkMultipartFile file, HttpServletRequest request) throws SSException {
        try {
            if(file.getFile()!=null && file.getFile().length()!=0) {
                String path = this.uploadFile(file, WebConstants.ATTACHMENT_FOLDER, request);
                commonFile.setPath(path);
            }
            IndexModule indexModule = this.queryById(IndexModule.class, commonFile.getIndexModuleId());
            commonFile.setIndexModuleName(indexModule.getName());
            this.update(commonFile);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.UpdateFail);
        }
    }

    @Override
    public void downloadById(Integer id, HttpServletRequest request, HttpServletResponse response) throws SSException {
        try {
            CommonFile commonFile = this.queryById(CommonFile.class, id);
            String filename = commonFile.getName();
            String path = request.getSession().getServletContext().getRealPath("/resources/") + commonFile.getPath();
            this.downloadFile(filename, path, response);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.SystemException);
        }
    }
}
