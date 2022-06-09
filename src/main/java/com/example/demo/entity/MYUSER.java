package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Entity
@Data
//@SequenceGenerator(name="mseq",sequenceName="shopping_product_seq",allocationSize=1)
public class MYUSER {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mseq")
//    @GeneratedValue(generator="system_uuid")
//    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String USERID;
    private String  USERNAME;
    private String USERPASSWORD;
    private String USERTYPE;

    public MYUSER(){
    }
    public MYUSER(String USERID, String UName, String UPassword, String UType) {
        this.USERID = USERID;
        this.USERNAME = UName;
        this.USERPASSWORD = UPassword;
        this.USERTYPE = UType;
    }
    public void setUSERID(String  USERID) {
        this.USERID = USERID;
    }
    public String getUSERID() {
        return USERID;
    }
    public String getUSERNAME() {
        return USERNAME;
    }
    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }
    public String getUSERPASSWORD() {
        return USERPASSWORD;
    }
    public void setUSERPASSWORD(String USERPASSWORD) {
        this.USERPASSWORD = USERPASSWORD;
    }
    public String getUSERTYPE() {
        return USERTYPE;
    }
    public void setUSERTYPE(String USERTYPE) {
        this.USERTYPE = USERTYPE;
    }

    @Override
    public String toString() {
        return "MYUSER{" +
                "USERID='" + USERID + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", USERPASSWORD='" + USERPASSWORD + '\'' +
                ", USERTYPE='" + USERTYPE + '\'' +
                '}';
    }
}
