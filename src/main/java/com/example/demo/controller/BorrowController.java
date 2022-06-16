package com.example.demo.controller;

import com.example.demo.entity.BORROW;
import com.example.demo.entity.EQUIPMENTSTATE;
import com.example.demo.repository.BorrowRepository;
import com.example.demo.repository.EqStRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private EqStRepository eqStRepository;
    @PostMapping("/equipmentBorrow")
    public String equipmentBorrow(@RequestBody Map map) throws ParseException {

        //修改equipmentState的状态
        EQUIPMENTSTATE equipmentstate = eqStRepository.getReferenceById(map.get("eid").toString());
        if (equipmentstate.getEID().equals("OUT")){
            //器材处于借出状态
            return "false";
        }else {

            equipmentstate.setESTATE("OUT");
            eqStRepository.save(equipmentstate);

            BORROW borrow = new BORROW();
            borrow.setUSERID(map.get("userid").toString());
            borrow.setEID(map.get("eid").toString());

            //时间转换
            SimpleDateFormat formatter0=new SimpleDateFormat("yyyy-MM-dd");
            String  borrowStr=map.get("borrow_time").toString();
            Date borrowTime = formatter0.parse(borrowStr);

            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            String returnStr=map.get("return_time").toString();
            Date returnTime=formatter.parse(returnStr);

            borrow.setBorrowtime(borrowTime);
            borrow.setReturntime(returnTime);
            borrowRepository.save(borrow);

            return "success";
        }
    }
}
