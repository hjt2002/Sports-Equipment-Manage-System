package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class BORROW {

    @Id
    private String USERID;
    private String EID;
    private Date returntime;
    private Date borrowtime;

    public BORROW() {
    }

    public BORROW(String UID, String EID, Date returntime,Date borrowtime) {
        this.USERID = UID;
        this.EID = EID;
        this.returntime = returntime;
        this.borrowtime = borrowtime;
    }
    public String getUSERID() {
        return USERID;
    }
    public void setUSERID(String UID) {
        this.USERID = UID;
    }
    public String getEID() {
        return EID;
    }
    public void setEID(String EID) {
        this.EID = EID;
    }
    public Date getRE() {
        return returntime;
    }
    public void setRE(Date returntime) {
        this.returntime = returntime;
    }
    public Date getBO() {
        return returntime;
    }
    public void setBO(Date borrowtime) {
        this.borrowtime = borrowtime;
    }
}
