package com.kangyi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Jiaru {
    private Long jiaruId;

    private Long orderId;

    private Long fromUserId;

    private Long toUserId;

    private String permission;

    private String type;

    private Long typeId;

    private String adminRemark;

    private String userRemark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date handleTime;

    private String status;

    private Byte jiaru;

    private String remark;

    private String typeName;

    private String parentRead;

    private Byte messageType;

    public Long getJiaruId() {
        return jiaruId;
    }

    public void setJiaruId(Long jiaruId) {
        this.jiaruId = jiaruId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
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

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark == null ? null : adminRemark.trim();
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
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

    public Byte getJiaru() {
        return jiaru;
    }

    public void setJiaru(Byte jiaru) {
        this.jiaru = jiaru;
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

    public String getParentRead() {
        return parentRead;
    }

    public void setParentRead(String parentRead) {
        this.parentRead = parentRead == null ? null : parentRead.trim();
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jiaruId=").append(jiaruId);
        sb.append(", orderId=").append(orderId);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", permission=").append(permission);
        sb.append(", type=").append(type);
        sb.append(", typeId=").append(typeId);
        sb.append(", adminRemark=").append(adminRemark);
        sb.append(", userRemark=").append(userRemark);
        sb.append(", createTime=").append(createTime);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", status=").append(status);
        sb.append(", jiaru=").append(jiaru);
        sb.append(", remark=").append(remark);
        sb.append(", typeName=").append(typeName);
        sb.append(", parentRead=").append(parentRead);
        sb.append(", messageType=").append(messageType);
        sb.append("]");
        return sb.toString();
    }
}