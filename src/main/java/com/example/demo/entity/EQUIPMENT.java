package com.example.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class EQUIPMENT {

    @Id
    private String EID;
    private String EQUIPMENTNAME;

    public EQUIPMENT() {
    }

    public EQUIPMENT(String EID, String EName) {
        this.EID = EID;
        this.EQUIPMENTNAME = EName;
    }

    public String getEID() {
        return EID;
    }
    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getEQUIPMENTNAME() {
        return EQUIPMENTNAME;
    }
    public void setEQUIPMENTNAME(String EName) {
        this.EQUIPMENTNAME = EName;
    }
}
