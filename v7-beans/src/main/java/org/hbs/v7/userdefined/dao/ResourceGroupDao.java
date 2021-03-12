package org.hbs.v7.userdefined.dao;

import java.util.List;

import org.hbs.v7.userdefined.model.ResourceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceGroupDao extends JpaRepository<ResourceGroup, String>
{
	@Query("From ResourceGroup where status = :status")
	List<ResourceGroup> getResourceGroup(@Param("status") boolean status);
}
