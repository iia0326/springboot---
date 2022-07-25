package com.kangyi.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class YiMiao {

    private String handelRemark;

    public String getHandelRemark() {
        return handelRemark;
    }

    public void setHandelRemark(String handelRemark) {
        this.handelRemark = handelRemark;
    }

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


    private Long yimiaoId;

    private String yimaioName;

    private String yimiaoPosition;

    private BigDecimal jindu;

    private BigDecimal weidu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date enddate;

    private String starttime;

    private String endtime;

    private String orgType;

    private String batch;

    private String renshu;

    private String area;

    private Long userId;

    private Long orderId;

    public Long getYimiaoId() {
        return yimiaoId;
    }

    public void setYimiaoId(Long yimiaoId) {
        this.yimiaoId = yimiaoId;
    }

    public String getYimaioName() {
        return yimaioName;
    }

    public void setYimaioName(String yimaioName) {
        this.yimaioName = yimaioName == null ? null : yimaioName.trim();
    }

    public String getYimiaoPosition() {
        return yimiaoPosition;
    }

    public void setYimiaoPosition(String yimiaoPosition) {
        this.yimiaoPosition = yimiaoPosition == null ? null : yimiaoPosition.trim();
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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getRenshu() {
        return renshu;
    }

    public void setRenshu(String renshu) {
        this.renshu = renshu == null ? null : renshu.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yimiaoId=").append(yimiaoId);
        sb.append(", yimaioName=").append(yimaioName);
        sb.append(", yimiaoPosition=").append(yimiaoPosition);
        sb.append(", jindu=").append(jindu);
        sb.append(", weidu=").append(weidu);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", orgType=").append(orgType);
        sb.append(", batch=").append(batch);
        sb.append(", renshu=").append(renshu);
        sb.append(", area=").append(area);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}