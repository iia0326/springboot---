package com.kangyi.util;

public class Result {

    private int code;
    private int pno;
    private int psize;

    private Object data;

    private String msg;

    private long count;

    public Result(int code, Object data, String msg,long count) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.count = count;
    }

    public static Result end(int code, Object data, String msg,long count){

        return new Result(code,data,msg,count);
    }
//    public static Result upload(int pno, Object data,int psize,int pno,long count){
//        return new Result(count,data,psize,count);
//    }

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
