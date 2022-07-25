package com.kangyi.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GuiJi {



    public String qiekai;

    public String data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;



    private int status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date processTime;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }


    private Long guijiId;

    private String area;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endtime;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date enddate;

    private BigDecimal jindu;

    private BigDecimal weidu;

    private String guijiPosition;

    private Long userId;

    private Long orderId;

    public Long getGuijiId() {
        return guijiId;
    }


    public void setGuijiId(Long guijiId) {
        this.guijiId = guijiId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getStarttime() {
        return starttime;
    }


    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getEnddate() {
        return enddate;
    }


    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


    public BigDecimal getJindu() {
        return jindu;
    }

    @JSONField(name = "jingdu")
    public void setJindu(BigDecimal jindu) {
        this.jindu = jindu;
    }

    @JSONField(name = "weidu")
    public BigDecimal getWeidu() {
        return weidu;
    }

    public void setWeidu(BigDecimal weidu) {
        this.weidu = weidu;
    }

    public String getGuijiPosition() {
        return guijiPosition;
    }

    public void setGuijiPosition(String guijiPosition) {
        this.guijiPosition = guijiPosition == null ? null : guijiPosition.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guijiId=").append(guijiId);
        sb.append(", area=").append(area);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", enddate=").append(enddate);
        sb.append(", jindu=").append(jindu);
        sb.append(", weidu=").append(weidu);
        sb.append(", guijiPosition=").append(guijiPosition);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}