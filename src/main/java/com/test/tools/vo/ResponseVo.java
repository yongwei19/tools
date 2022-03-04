package com.test.tools.vo;

public class ResponseVo {
    private int code;
    private Object data;
    private String msg;

    public ResponseVo() {
    }

    public ResponseVo(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseVo(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static ResponseVo buildSuccess(Object data){
        return new ResponseVo(200,data);
    }

    public static ResponseVo buildError(String msg){
        return new ResponseVo(-1,"",msg);
    }

    public static ResponseVo buildError(int code, String msg){
        return new ResponseVo(code,"",msg);
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
