package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import com.webexam.common.dto.StudentDto;
import com.webexam.common.dto.StudentSubjectListForm;
import com.webexam.common.entity.Major;
import com.webexam.common.entity.Student;
import com.webexam.common.entity.StudentSubject;
import com.webexam.common.entity.Subject;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentController
 *
 * @author: zhangteng
 * @time: 14-1-31 下午5:35
 */
@Controller
@RequestMapping(value = "admin/student")
public class StudentController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("sutdentMenuActived", true);
    }

    /**
     * 去学生列表页面
     *
     * @param pageNo
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = studentService.queryCount();
            Pagination page = new Pagination(dataCount, pageSize, pageNo);
            List<Student> studentList = studentService.queryByPage(page);
            model.addAttribute("studentList", studentList);
            model.addAttribute("page", page);
            return "admin/student/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 搜索
     *
     * @param search
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@RequestParam String search,
                         Model model) {
        try {
            List<Student> studentList = studentService.queryBySearch(search);
            model.addAttribute("studentList", studentList);
            model.addAttribute("search", search);
            return "admin/student/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) {
        try {
            List<Major> majorList = majorService.queryAll();
            model.addAttribute("majorList", majorList);
            return "admin/student/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Student student,
                         @RequestParam Integer majorId,
                         Model model) {
        try {
            Major major = majorService.queryById(Major.class, majorId);
            student.setMajorName(major.getName());
            student.setMajorCode(major.getCode());
            student = studentService.insertStudent(student);

            List<Subject> subjectList = majorSubjectService.querySubjectByMajor(majorId);
            List<StudentSubject> studentSubjectList = new ArrayList<StudentSubject>();
            for(Subject subject : subjectList) {
                StudentSubject studentSubject = new StudentSubject();
                studentSubject.setStudentId(student.getId());
                studentSubject.setSubjectCode(subject.getCode());
                studentSubject.setSubjectName(subject.getName());
                studentSubjectList.add(studentSubject);
            }
            model.addAttribute("studentSubjectList", studentSubjectList);
            return "admin/student/insertSubject";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insertSubject", method = RequestMethod.POST)
    public String insertSubject(StudentSubjectListForm studentSubjectListForm) {
        try {
            List<StudentSubject> list = new ArrayList<StudentSubject>();
            for(StudentSubject s : studentSubjectListForm.getStudentSubjectList()) {
                if(s.getStudentId() != null) {
                    list.add(s);
                }
            }
            studentService.insertAll(list);
            return "redirect:/admin/student";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 批量添加
     *
     * @return
     */
    @RequestMapping(value = "batch/insert", method = RequestMethod.GET)
    public String toBatchInsert() {
        return "admin/student/batchInsert";
    }
    @RequestMapping(value = "batch/insert", method = RequestMethod.POST)
    public String batchInsert(@RequestParam("studentFile") PandaworkMultipartFile studentFile,
                              Model model) {
        try {
            if(studentFile.isEmpty()) {
                model.addAttribute("msgCode", WebexamException.FileNotNull.getCode());
                model.addAttribute("msg", WebexamException.FileNotNull.getMes());
            } else {
                String fileName = studentFile.getOriginalFilename();
                if(!fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
                    model.addAttribute("msgCode", WebexamException.FileNotXls);
                    model.addAttribute("msg", WebexamException.FileNotXls.getMes());
                } else {
                    studentService.batchInsert(studentFile.getFile());
                    model.addAttribute("msgCode", 0);
                    model.addAttribute("msg", "添加成功！");
                }
            }
            return "admin/student/batchInsert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 查看详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id,
                       Model model) {
        try {
            StudentDto studentDto = studentService.queryDtoById(id);
            model.addAttribute("studentDto", studentDto);
            return "admin/student/detail";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 更新
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            StudentDto studentDto = studentService.queryDtoById(id);
            List<Major> majorList = majorService.queryAll();
            model.addAttribute("majorList", majorList);
            model.addAttribute("studentDto", studentDto);
            model.addAttribute("subCount", studentDto.getSubjectList().size());
            return "admin/student/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(StudentDto studentDto,
                         Integer majorId) {
        try {
            Student student = studentDto.getStudent();
            Major major = majorService.queryById(Major.class, majorId);
            student.setMajorCode(major.getCode());
            student.setMajorName(major.getName());

            List<StudentSubject> list = new ArrayList<StudentSubject>();
            for(StudentSubject s : studentDto.getSubjectList()) {
                if(s.getStudentId() != null) {
                    list.add(s);
                }
            }
            studentDto.setSubjectList(list);
            studentService.updateStudentSubject(studentDto);
            return "redirect:/admin/student/view/" + student.getId();
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 批量导出
     *
     * @return
     */
    @RequestMapping(value = "batch/toExport", method = RequestMethod.GET)
    public String toBatchExport(Model model) {
        try {
            List<Major> majorList = majorService.queryAll();
            model.addAttribute("majorList", majorList);
            return "admin/student/batchExport";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "batch/export", method = RequestMethod.GET)
    public void batchExport(@RequestParam String majorCode) {
        try {
            studentService.batchExportByMajor(majorCode, getResponse());
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            Student student = studentService.queryById(Student.class, id);
            studentService.delete(student);
            return "redirect:/admin/student";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 批量删除学生
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "batch/del", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject batchDel(@RequestParam String ids) {
        try {
            String[] idsStr = ids.split(",");
            for(String id : idsStr) {
                if(id != null && !("").equals(id)) {
                    Student student = studentService.queryById(Student.class, Integer.parseInt(id));
                    studentService.delete(student);
                }
            }
            JSONObject json = new JSONObject();
            json.put("code", 0);
            return json;
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return sendErrMsgAndErrCode(e);
        }
    }
}
