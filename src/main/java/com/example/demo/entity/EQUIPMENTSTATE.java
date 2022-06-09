package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class EQUIPMENTSTATE {

    @Id
    private String EID;
    private String ESTATE;

    public EQUIPMENTSTATE() {
    }
    public EQUIPMENTSTATE(String EID, String ESTATE) {
        this.EID = EID;
        this.ESTATE = ESTATE;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getESTATE() {
        return ESTATE;
    }

    public void setESTATE(String ESTATE) {
        this.ESTATE = ESTATE;
    }
}
