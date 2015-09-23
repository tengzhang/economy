package com.economy.mapper;

import com.economy.common.entity.Certificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CertificateMapper
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:16
 */
public interface CertificateMapper {

    /**
     * 根据首页版块id查询
     *
     * @param indexModuleId
     * @return
     */
    public List<Certificate> queryByIndexModuleId(@Param("indexModuleId") Integer indexModuleId);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Certificate> queryAll();
}
