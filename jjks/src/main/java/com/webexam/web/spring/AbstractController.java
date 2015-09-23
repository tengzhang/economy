package com.webexam.web.spring;

import com.pandawork.core.bean.StaticAutoWire;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.web.spring.controller.Base;
import com.webexam.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AbstractController extends Base{
	
	public Integer pageSize = 20;
    public  static final int TOUCH_PAGE_SIZE = 5;

    protected static final String UID = "uid";
    protected static final String TGT = "TGT";

    /*
	 * 是否已经登录
	 */
    private ThreadLocal<Boolean> logined = new ThreadLocal<Boolean>();

    public void init(HttpServletRequest request, HttpServletResponse response) {
	super.init(request, response); // 执行父类的初始化

    }

    // 发送ajax错误信息
    public JSONObject sendErrMsgAndErrCode(SSException e){
        JSONObject json=new JSONObject();
        json.put("errMsg", e.getMessage());
        json.put("code", e.getCode());
        return json;
    }

    @StaticAutoWire
    protected static AdminService adminService;

    @StaticAutoWire
    protected static MajorService majorService;

    @StaticAutoWire
    protected static SubjectService subjectService;

    @StaticAutoWire
    protected static MajorSubjectService majorSubjectService;

    @StaticAutoWire
    protected static StudentService studentService;

    @StaticAutoWire
    protected static WebExamService webExamService;

    @StaticAutoWire
    protected static ProblemService problemService;

    @StaticAutoWire
    protected static WebLessonService webLessonService;
}
