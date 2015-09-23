package com.economy.common.exception;

import com.pandawork.core.exception.IBizExceptionMes;

/**
 * EconomyException
 *
 * @author: zhangteng
 * @time: 14-3-30 下午8:03
 */
public enum EconomyException implements IBizExceptionMes {

    SystemException("系统异常", 1000),
    InserFail("添加失败", 1001),
    QueryFail("查询失败", 1002),
    UpdateFail("修改失败", 1003),
    DeleteFail("删除失败", 1004),;

    private final static int SMSEXCPTIONCODE = 1005;

    private String mes;
    private int code;

    EconomyException(String mes, int code) {
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
