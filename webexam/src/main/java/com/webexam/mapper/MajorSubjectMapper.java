package com.webexam.mapper;

import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MajorSubjectMapper
 *
 * @author: zhangteng
 * @time: 14-1-23 下午10:30
 */
public interface MajorSubjectMapper {

    /**
     * 查询全部专业科目
     *
     * @return
     */
    public List<MajorSubjectDto> queryAll();

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<MajorSubjectDto> queryByPage(Map<String, Object> params);

    /**
     * 根据专业id查询科目
     *
     * @param majorId
     * @return
     */
    public List<Subject> querySubjectByMajor(@Param("majorId") Integer majorId);
}
