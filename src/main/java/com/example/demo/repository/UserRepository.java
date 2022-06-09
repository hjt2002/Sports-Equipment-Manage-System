package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.MYUSER;

public interface UserRepository extends JpaRepository<MYUSER,String> {

}
