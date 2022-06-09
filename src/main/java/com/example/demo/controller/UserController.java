package com.example.demo.controller;

import com.example.demo.entity.MYUSER;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myuser")
public class UserController {


    @Autowired
    private UserRepository ur;

    @GetMapping("/findAll")
    public List <MYUSER> findAll(){
        return ur.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Map map){
        //注册
        MYUSER myuser = new MYUSER();
        myuser.setUSERID(map.get("userid").toString());
        myuser.setUSERPASSWORD(map.get("userpassword").toString());
        myuser.setUSERNAME(map.get("username").toString());
        myuser.setUSERTYPE(map.get("usertype").toString());
        //判断账号是否已经存在
        List <MYUSER> myuserList = ur.findAll();
        for (int i = 0;i < myuserList.size();i++){
            if(myuserList.get(i).getUSERID().equals(myuser.getUSERID())){
                return "fail";
            }
        }

        MYUSER result = ur.save(myuser);
        if(result != null){
            return "success";
        }else {
            return "fail";
        }
    }

    @PostMapping("/matchingpwd")
    public int matchPwd(@RequestBody Map map) {
        //登录
        MYUSER myuser = ur.getReferenceById(map.get("userid").toString());

        if (myuser == null) {
            //账号不存在
            return 0;
        } else if (!myuser.getUSERPASSWORD().equals(map.get("userpassword").toString())) {
            //账号存在，密码错误
            return 0;
        } else {
            //账号存在密码正确
            if(myuser.getUSERTYPE().equals("admin")){
                //管理员
                return 11;
            }else {
                //用户
                return 10;
            }
        }
    }
}
