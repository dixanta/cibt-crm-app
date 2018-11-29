/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.entity;

/**
 *
 * @author USER
 */
public class Contact {
    private int id;
    private String name,email,subject,message;
    private boolean sendMe;

    public Contact() {
    }

    public Contact(int id, String name, String email, String subject, String message, boolean sendMe) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.sendMe = sendMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSendMe() {
        return sendMe;
    }

    public void setSendMe(boolean sendMe) {
        this.sendMe = sendMe;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message + ", sendMe=" + sendMe + '}';
    }
    
    
}
