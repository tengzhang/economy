package com.economy.service;

import com.economy.common.dto.ArticleDto;
import com.economy.common.entity.Article;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 招生简章Service
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:22
 */
public interface ArticleService extends BaseService {

    /**
     * 根据类型查询记录数
     *
     * @param type
     * @param search
     * @return
     */
    public int queryCountByCondition(Integer type, String search) throws SSException;

    /**
     * 条件查询
     *
     * @param page
     * @param search
     * @param type
     * @return
     */
    public List<Article> queryByCondition(Pagination page, String search, Integer type) throws SSException;

    /**
     * 添加文章
     *
     * @param articleDto
     * @throws SSException
     */
    public void insertArticle(ArticleDto articleDto, HttpServletRequest request) throws SSException;

    /**
     * 更新文章
     *
     * @param articleDto
     * @param delAttachmentIds 需要删除的附件id
     * @param request
     * @throws SSException
     */
    public void updateArticle(ArticleDto articleDto, String delAttachmentIds, HttpServletRequest request) throws SSException;

    /**
     * 根据id删除
     *
     * @param id
     * @throws SSException
     */
    public void deleteById(Integer id) throws SSException;
}
