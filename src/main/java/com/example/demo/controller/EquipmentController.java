package com.example.demo.controller;

import com.example.demo.entity.EQUIPMENT;
import com.example.demo.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/findAll")
    //查询所有体育器材
    public List<EQUIPMENT> findAll(){
        return equipmentRepository.findAll();
    }

    @PostMapping("/addEquipment")
    //增加器材
    public String save(@RequestBody Map map){

        List<EQUIPMENT>equipmentList = equipmentRepository.findAll();

        for (int i = 0;i < equipmentList.size();i++){
            if(equipmentList.get(i).getEID().equals(map.get("eid").toString())){
                //器材ID重复
                return "fail";
            }
        }

        EQUIPMENT equipment = new EQUIPMENT();
        equipment.setEID(map.get("eid").toString());
        equipment.setEQUIPMENTNAME(map.get("equipmentname").toString());
        EQUIPMENT result = equipmentRepository.save(equipment);
        if (result != null){
            return "success";
        }else {
            return "fail";
        }
    }
    @PostMapping("/deleteEquipment")
    public void deleteEquipment(@RequestBody Map map){
        equipmentRepository.deleteById(map.get("id").toString());
    }
}
