package org.hbs.v7.dao;

import java.util.List;

import org.hbs.v7.beans.model.dataprocess.ResourceDeployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDeploymentDao extends JpaRepository<ResourceDeployment, String>
{
	@Query("From ResourceDeployment where status = :status")
	List<ResourceDeployment> getResourceDeployment(@Param("status") boolean status);
}
