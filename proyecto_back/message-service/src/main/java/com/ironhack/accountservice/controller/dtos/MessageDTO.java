package com.ironhack.accountservice.controller.dtos;

import org.hibernate.annotations.*;

import java.util.*;

public class MessageDTO {


    private String clientName;
    private String clientEmail;
    private Integer phone;
    @Type(type = "text")
    private String messageBody;
    private Boolean isRead;
    private Date createAt;

    public MessageDTO(String clientName, String clientEmail, Integer phone, String messageBody, Boolean isRead, Date createAt) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.phone = phone;
        this.messageBody = messageBody;
        this.isRead = isRead;
        this.createAt = createAt;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
