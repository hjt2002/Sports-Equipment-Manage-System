package com.example.demo.controller;

import com.example.demo.entity.EQUIPMENTSTATE;
import com.example.demo.entity.RETURN;
import com.example.demo.repository.EqStRepository;
import com.example.demo.repository.ReturneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipmentstate")
public class EqStController {

    @Autowired
    private EqStRepository eqStRepository;
    @GetMapping("/findAll")
    public List<EQUIPMENTSTATE>findAll(){
        return eqStRepository.findAll();
    }

    @PostMapping ("/stateFind")
    public EQUIPMENTSTATE stateFind(@RequestBody Map map){
//        EQUIPMENTSTATE equipmentstate = eqStRepository.getReferenceById(map.get("id").toString());
          return eqStRepository.getReferenceById(map.get("id").toString());
    }


    @Autowired
    public ReturneRepository returnRepository;
    @PostMapping ("/return")
    public String return_e(@RequestBody Map map) throws ParseException {

        //归还时更新equipmentstate表的estate
        EQUIPMENTSTATE equipmentstate = eqStRepository.getReferenceById(map.get("eid").toString());
        equipmentstate.setESTATE("IN");
        eqStRepository.save(equipmentstate);

        //转换时间
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String returnStr=map.get("return_time").toString();
        Date returnTime=formatter.parse(returnStr);

        //borrow表更新

        //将归还记录插入return_e
        RETURN RETURN = new RETURN();
        RETURN.setUSERID(map.get("userid").toString());
        RETURN.setEID(map.get("eid").toString());
        RETURN.setRE(returnTime);
        RETURN result = returnRepository.save(RETURN);//照着写的，不知道行不行

        if(result==null){
            return "false";
        }
        return "success";
    }
}
