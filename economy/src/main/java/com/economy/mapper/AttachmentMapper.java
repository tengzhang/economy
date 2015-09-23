package com.economy.mapper;

import com.economy.common.entity.Attachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 附件mapper
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:43
 */
public interface AttachmentMapper {

    /**
     * 根据通知id查询
     *
     * @param articleId
     * @return
     */
    public List<Attachment> queryByArticleId(@Param("articleId") Integer articleId);

    /**
     * 根据通知id删除
     *
     * @param articleId
     */
    public void deleteByArticleId(@Param("articleId") Integer articleId);
}
