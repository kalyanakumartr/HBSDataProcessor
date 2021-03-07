package org.hbs.v7.dao;

import java.util.List;

import org.hbs.v7.beans.model.dataprocess.OperationalTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalTaskDao extends JpaRepository<OperationalTask, String>
{
	@Query("From OperationalTask where taskTeam.teamId = :teamId AND operationalData.dataId = :dataId")
	List<OperationalTask> searchOperationalTask(@Param("teamId") String teamId, @Param("dataId") String dataId);
}
