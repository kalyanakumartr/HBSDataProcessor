package org.hbs.v7.dao;

import java.util.List;

import org.hbs.v7.beans.model.dataprocess.OperationalStatusReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalStatusReasonDao extends JpaRepository<OperationalStatusReason, String>
{
	@Query("From OperationalStatusReason where operationalStatus.statusId Like %:statusId% AND status = :status")
	List<OperationalStatusReason> getOperationalStatusReason(@Param("statusId") String statusId, @Param("status") boolean status);
}
