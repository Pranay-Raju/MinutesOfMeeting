package com.example.MoM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoM.entity.OrganizationMemberEntity;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMemberEntity, Integer> {

}

