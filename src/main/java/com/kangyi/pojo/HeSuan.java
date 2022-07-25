package com.kangyi.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class HeSuan {

    private String handelRemark;

    public String getHandelRemark() {
        return handelRemark;
    }

    public void setHandelRemark(String handelRemark) {
        this.handelRemark = handelRemark;
    }

    private Integer status;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date processTime;

    public Integer getStatus() {
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

    private Long hesuanId;

    private BigDecimal jindu;

    private BigDecimal weidu;

    private String hesuanName;

    private String hesuanPosition;

    private String starttime;

    private String endtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date enddate;

    private String area;

    private Long userId;

    private Long orderId;

    private String renshu;

    public Long getHesuanId() {
        return hesuanId;
    }

    public void setHesuanId(Long hesuanId) {
        this.hesuanId = hesuanId;
    }

    public BigDecimal getJindu() {
        return jindu;
    }

    @JSONField(name = "jingdu")
    public void setJindu(BigDecimal jindu) {
        this.jindu = jindu;
    }

    public BigDecimal getWeidu() {
        return weidu;
    }

    public void setWeidu(BigDecimal weidu) {
        this.weidu = weidu;
    }

    public String getHesuanName() {
        return hesuanName;
    }

    public void setHesuanName(String hesuanName) {
        this.hesuanName = hesuanName == null ? null : hesuanName.trim();
    }

    public String getHesuanPosition() {
        return hesuanPosition;
    }

    public void setHesuanPosition(String hesuanPosition) {
        this.hesuanPosition = hesuanPosition == null ? null : hesuanPosition.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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

    public String getRenshu() {
        return renshu;
    }

    public void setRenshu(String renshu) {
        this.renshu = renshu == null ? null : renshu.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hesuanId=").append(hesuanId);
        sb.append(", jindu=").append(jindu);
        sb.append(", weidu=").append(weidu);
        sb.append(", hesuanName=").append(hesuanName);
        sb.append(", hesuanPosition=").append(hesuanPosition);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", area=").append(area);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", renshu=").append(renshu);
        sb.append("]");
        return sb.toString();
    }
}