package com.example.MoM.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.entity.OrganizationMemberEntity;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMemberEntity, Integer> {

	Optional<OrganizationMemberEntity> findByLoginIdAndPassword(String loginId, String password);

	@Query(value = "select * from member where organization_id=?", nativeQuery = true)
	List<OrganizationMemberEntity> findAllByOrganizationId(int id);

	@Query(value = "select * from member where organization_id=? and organization_role=?", nativeQuery = true)
	List<OrganizationMemberEntity> findAllByOrganizationIdAndRole(int id, String string);

}
