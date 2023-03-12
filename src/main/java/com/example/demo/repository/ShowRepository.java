package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShowEntity;
@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long>{

}
