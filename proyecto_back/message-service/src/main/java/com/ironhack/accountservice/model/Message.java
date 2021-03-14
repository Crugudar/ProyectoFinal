package com.ironhack.accountservice.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    @NotEmpty
    private String clientName;
    @NotEmpty
    private String clientEmail;
    @Column(name = "client_phone")
    private Integer phone;
    @Type(type = "text")
    private String messageBody;
    private Boolean isRead;
    private Date createdAt;


    public Message() {
    }

    public Message(@NotEmpty String clientName, @NotEmpty String clientEmail, Integer phone, String messageBody) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.phone = phone;
        this.messageBody = messageBody;
        this.isRead=false;
        this.createdAt = new Date();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
