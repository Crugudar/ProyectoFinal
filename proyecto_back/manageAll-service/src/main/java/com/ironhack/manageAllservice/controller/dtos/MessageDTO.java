package com.ironhack.manageAllservice.controller.dtos;

import javax.validation.constraints.*;
import java.util.*;

public class MessageDTO {

    private Integer messageId;
    @NotEmpty
    private String clientName;
    @NotEmpty
    private String clientEmail;
    private Integer phone;
    private String messageBody;
    private Boolean isRead;
    private Date createdAt;

    public MessageDTO() {
    }

    public MessageDTO(@NotEmpty String clientName, @NotEmpty String clientEmail, Integer phone, String messageBody) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.phone = phone;
        this.isRead=false;
        this.messageBody = messageBody;
        this.createdAt=new Date();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
