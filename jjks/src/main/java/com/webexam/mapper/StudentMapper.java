package com.webexam.mapper;

import com.webexam.common.dto.StudentBatchDto;
import com.webexam.common.dto.StudentDto;
import com.webexam.common.entity.Student;
import com.webexam.common.entity.StudentSubject;
import com.webexam.common.entity.WebExam;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * StudentMapper
 *
 * @author: zhangteng
 * @time: 14-1-27 下午12:09
 */
public interface StudentMapper {

    public void insertForList(List<StudentSubject> list);

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<Student> queryByPage(Map<String, Object> params);

    /**
     * 导出学生信息查询
     *
     * @return
     */
    public List<StudentBatchDto> queryExportByMajor(@Param("majorCode") String majorCode);

    /**
     * 根据学生id查询学生信息详情
     *
     * @param id
     * @return
     */
    public StudentDto queryDtoById(@Param("id") Integer id);

    /**
     * 根据准考证号查询学生
     *
     * @param search
     * @return
     */
    public List<Student> queryBySearch(@Param("search") String search);

    /**
     * 根据专业代码查询学生
     *
     * @param majorCode
     * @return
     */
    public List<Student> queryByMajor(@Param("majorCode") String majorCode);

    /**
     * 根据学生id删除科目
     *
     * @param sid
     */
    public void delSubjectByStudentId(@Param("sid") Integer sid);

    /**
     * 学生登录
     *
     * @param examNo
     * @param name
     * @return
     */
    public Student login(@Param("examNo") String examNo,
                         @Param("name") String name,
                         @Param("majorCode") String majorCode);

    /**
     * 根据学生id查询考试
     *
     * @param studentId
     * @return
     */
    public List<WebExam> queryExamById(@Param("studentId") Integer studentId,
                                       @Param("majorCode") String majorCode,
                                       @Param("time") Date time);

    /**
     * 根据学生id和科目代码查询学生科目
     *
     * @param studentId
     * @param subjectCode
     * @return
     */
    public StudentSubject querySubjectBySidAndSubject(@Param("studentId") Integer studentId,
                                                      @Param("subjectCode") String subjectCode);

    /**
     * 根据准考证号查询记录数
     *
     * @param examNo
     * @return
     */
    public int queryCountByExamNo(@Param("examNo") String examNo);

    /**
     * 根据准考证号查询学生
     *
     * @param examNo
     * @return
     */
    public Student queryStudentByExamNo(@Param("examNo") String examNo);
}
