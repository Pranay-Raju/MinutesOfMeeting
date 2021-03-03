package com.example.MoM.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoM.entity.OrganizationMemberEntity;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMemberEntity, Integer> {

	Optional<OrganizationMemberEntity> findByLoginIdAndPassword(String loginId, String password);

}
