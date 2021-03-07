package org.hbs.v7.dao;

import java.util.List;

import org.hbs.v7.beans.model.dataprocess.OperationalRoadType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalRoadTypeDao extends JpaRepository<OperationalRoadType, String>
{
	@Query("From OperationalRoadType where status = :status")
	List<OperationalRoadType> getOperationalRoadType(@Param("status") boolean status);
}
