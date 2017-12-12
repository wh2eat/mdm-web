package com.idata.mdm.web.service;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    public ServiceException() {

    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServiceException [code=" + code + ", msg=" + msg + "]";
    }

}
