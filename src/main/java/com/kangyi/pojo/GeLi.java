package com.kangyi.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GeLi {


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


    private Long geliId;

    private BigDecimal jindu;

    private BigDecimal weidu;

    private String gelidianName;

    private String gelidianPosition;

    private Integer grlirenshu;

    private String contact;

    private String geliOrg;

    private String area;

    private Long userId;

    private Long orderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date enddate;

    public Long getGeliId() {
        return geliId;
    }

    public void setGeliId(Long geliId) {
        this.geliId = geliId;
    }

    @JSONField(name = "jingdu")
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

    public String getGelidianName() {
        return gelidianName;
    }

    public void setGelidianName(String gelidianName) {
        this.gelidianName = gelidianName == null ? null : gelidianName.trim();
    }

    public String getGelidianPosition() {
        return gelidianPosition;
    }

    public void setGelidianPosition(String gelidianPosition) {
        this.gelidianPosition = gelidianPosition == null ? null : gelidianPosition.trim();
    }

    public Integer getGrlirenshu() {
        return grlirenshu;
    }

    public void setGrlirenshu(Integer grlirenshu) {
        this.grlirenshu = grlirenshu;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getGeliOrg() {
        return geliOrg;
    }

    public void setGeliOrg(String geliOrg) {
        this.geliOrg = geliOrg == null ? null : geliOrg.trim();
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

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", geliId=").append(geliId);
        sb.append(", jindu=").append(jindu);
        sb.append(", weidu=").append(weidu);
        sb.append(", gelidianName=").append(gelidianName);
        sb.append(", gelidianPosition=").append(gelidianPosition);
        sb.append(", grlirenshu=").append(grlirenshu);
        sb.append(", contact=").append(contact);
        sb.append(", geliOrg=").append(geliOrg);
        sb.append(", area=").append(area);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", enddate=").append(enddate);
        sb.append("]");
        return sb.toString();
    }
}