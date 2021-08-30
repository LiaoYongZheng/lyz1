package com.lyz.domain.response;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private Boolean flag;
    private Object data;
    private String msg;

    public ResultInfo(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
    public ResultInfo(Boolean flag,  String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
