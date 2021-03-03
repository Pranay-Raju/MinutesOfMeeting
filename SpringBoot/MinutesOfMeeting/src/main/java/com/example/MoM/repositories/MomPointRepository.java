package com.example.MoM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoM.entity.MomPointEntity;

public interface MomPointRepository extends JpaRepository<MomPointEntity, Integer> {

}
