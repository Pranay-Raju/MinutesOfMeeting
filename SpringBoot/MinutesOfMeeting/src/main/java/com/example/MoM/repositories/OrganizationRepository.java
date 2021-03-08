package com.example.MoM.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoM.entity.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer>{

	Optional<OrganizationEntity> findByOrganizationName(String organizationName);
	
	

}
