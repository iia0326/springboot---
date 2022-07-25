package com.kangyi.util;

public class PageResult {
    private int pageNo;

    private int pageSize;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private Object data;
//总页数
    private int pageCount;
    private Long count;
////总数
    private long pageTotal;

    public PageResult(int pageNo, int pageSize, int pageCount, int pageTotal) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.pageTotal = pageTotal;
    }

    public PageResult(Object data,int pageNo,  int pageSize, long count) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.data = data;
    }

    public static PageResult upload(Object data,int pageNo, int psize,Long count){
        return new PageResult(data,pageNo,psize,count);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                ", count=" + pageTotal +
                "pno=" + pageNo +
                ", psize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
