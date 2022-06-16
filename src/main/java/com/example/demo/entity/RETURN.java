package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class RETURN {

    @Id
    private String USERID;
    private String EID;
    private Date returntime;

    public RETURN() {
    }

    public RETURN(String UID, String EID, Date returntime) {
        this.USERID = UID;
        this.EID = EID;
        this.returntime = returntime;
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
    public void setRE(Date time) {
        this.returntime = time;
    }
}
