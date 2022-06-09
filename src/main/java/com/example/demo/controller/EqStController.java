package com.example.demo.controller;

import com.example.demo.entity.EQUIPMENT;
import com.example.demo.entity.EQUIPMENTSTATE;
import com.example.demo.repository.EqStRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
