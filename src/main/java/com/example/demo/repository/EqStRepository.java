package com.example.demo.repository;

import com.example.demo.entity.EQUIPMENTSTATE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EqStRepository extends JpaRepository<EQUIPMENTSTATE,String> {
}
