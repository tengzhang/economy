package com.webexam.common.exception;

import com.pandawork.core.exception.IBizExceptionMes;

/**
 * 网络测试异常枚举
 *
 * @author: zhangteng
 * @time: 14-1-15 下午5:04
 */
public enum WebexamException implements IBizExceptionMes {

    SystemException("系统异常", 1000),
    InserFail("添加失败", 1001),
    QueryFail("查询失败", 1002),
    UpdateFail("修改失败", 1003),
    DeleteFail("删除失败", 1004),
    FileNotNull("上传文件不能为空", 1005),
    FileNotXls("文件格式必须为xls格式", 1006),
    ExportFail("导出失败", 1007),
    StudentExist("添加失败,考号已存在,请重新添加！", 1008);

    private final static int SMSEXCPTIONCODE = 1005;

    private String mes;
    private int code;

    WebexamException(String mes, int code) {
        this.mes = mes;
        this.code = code;
    }

    @Override
    public String getMes() {
        return mes;
    }

    @Override
    public int getCode() {
        return code;
    }
}
