package org.hbs.v7.userdefined.dao;

import java.util.List;

import org.hbs.v7.userdefined.model.OperationalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalStatusDao extends JpaRepository<OperationalStatus, String>
{
	@Query("From OperationalStatus where status = :status")
	List<OperationalStatus> getOperationalStatus(@Param("status") boolean status);
}
