package com.example.demo.repository;

import com.example.demo.entity.MYUSER;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository ur;
    @Test
    void findAll(){
        System.out.println(ur.findAll());
    }

    @Test
    void save(){
        MYUSER myuser = new MYUSER();
        myuser.setUSERID("20200202");
        myuser.setUSERNAME("20200202");
        myuser.setUSERPASSWORD("20200202");
        myuser.setUSERTYPE("user");
        ur.save(myuser);
    }

}