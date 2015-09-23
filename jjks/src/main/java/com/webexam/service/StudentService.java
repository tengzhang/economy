package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.dto.StudentDto;
import com.webexam.common.entity.Student;
import com.webexam.common.entity.StudentSubject;
import com.webexam.common.entity.WebExam;
import com.webexam.common.service.BaseService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * StudentService
 *
 * @author: zhangteng
 * @time: 14-1-27 下午12:07
 */
public interface StudentService extends BaseService {

    public void insertForList(List list) throws SSException;

    /**
     * 查询学生条数
     *
     * @return
     * @throws SSException
     */
    public int queryCount() throws SSException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SSException
     */
    public List<Student> queryByPage(Pagination page) throws SSException;

    /**
     * 添加学生
     *
     * @param student
     * @return
     * @throws SSException
     */
    public Student insertStudent(Student student) throws SSException;

    /**
     * 批量添加
     *
     * @param file
     * @throws SSException
     */
    public void batchInsert(File file) throws SSException;

    /**
     * 批量导出
     *
     * @param majorCode
     * @param response
     * @throws SSException
     */
    public void batchExportByMajor(String majorCode, HttpServletResponse response) throws SSException;

    /**
     * 根据学生id查询学生详细信息
     *
     * @param id
     * @throws SSException
     */
    public StudentDto queryDtoById(Integer id) throws SSException;

    /**
     * 根据准考证号查询学生
     *
     * @param search
     * @return
     * @throws SSException
     */
    public List<Student> queryBySearch(String search) throws SSException;

    public List<Student> queryByMajor(String majorCode) throws SSException;
    /**
     * 根据学生id删除科目
     *
     * @param sid
     * @throws SSException
     */
    public void deleteSubjectByStudentId(Integer sid) throws SSException;

    /**
     * 根据学生id更新科目
     *
     * @param studentDto
     * @throws SSException
     */
    public void updateStudentSubject(StudentDto studentDto) throws SSException;

    /**
     * 根据准考证号查询学生
     *
     * @param examNo
     * @return
     * @throws SSException
     */
    public Student queryStudentByExamNo(String examNo) throws SSException;

    /* ------ 以下方法只用于前端考试页面 ------- */

    /**
     * 学生登陆
     *
     * @param examNo
     * @param name
     * @param majorCode
     * @return
     * @throws SSException
     */
    public Student login(String examNo, String name, String majorCode) throws SSException;

    /**
     * 根据学生id查询学生现在可以参加的考试
     *
     * @param id
     * @return
     * @throws SSException
     */
    public List<WebExam> queryExamById(Integer id) throws SSException;

    /**
     * 根据学生id和科目代码查询学生-科目信息
     *
     * @param sid
     * @param subjectCode
     * @return
     * @throws SSException
     */
    public StudentSubject querySubjectBySidAndSubject(Integer sid, String subjectCode) throws SSException;

    /**
     * 算出学生成绩
     *
     * @param id
     * @param problemIds
     * @param answers
     * @param majorCode
     * @param subjectCode
     * @throws SSException
     */
    public void calculateScore(Integer id,
                               List<Integer> problemIds,
                               List<String[]> answers,
                               String majorCode,
                               String subjectCode) throws SSException;
}
