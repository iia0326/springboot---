package com.kangyi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Guanzhu {
    private Long guanzhuId;

    private Long orderId;

    private Long userId;

    private String type;

    private Long typeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date handleTime;

    private String status;

    private Byte guanzhu;

    private String remark;

    private String typeName;

    public Long getGuanzhuId() {
        return guanzhuId;
    }

    public void setGuanzhuId(Long guanzhuId) {
        this.guanzhuId = guanzhuId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Byte getGuanzhu() {
        return guanzhu;
    }

    public void setGuanzhu(Byte guanzhu) {
        this.guanzhu = guanzhu;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guanzhuId=").append(guanzhuId);
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", typeId=").append(typeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", status=").append(status);
        sb.append(", guanzhu=").append(guanzhu);
        sb.append(", remark=").append(remark);
        sb.append(", typeName=").append(typeName);
        sb.append("]");
        return sb.toString();
    }
}