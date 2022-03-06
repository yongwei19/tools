package com.test.tools.vo;

public class JsonResult {
    private int code;
    private Object data;
    private String msg;

    public JsonResult() {
    }

    public JsonResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonResult buildSuccess(Object data){
        return new JsonResult(200,data);
    }

    public static JsonResult warn(String msg){
        return new JsonResult(-1,"",msg);
    }

    public static JsonResult fail(String msg){
        return new JsonResult(-1,"",msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
