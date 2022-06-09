package com.example.demo.repository;


import com.example.demo.entity.EQUIPMENT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EQUIPMENT,String> {

}
