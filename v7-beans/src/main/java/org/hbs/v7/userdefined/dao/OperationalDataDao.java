package org.hbs.v7.userdefined.dao;

import java.util.List;

import org.hbs.v7.dao.ICoreDataDao;
import org.hbs.v7.userdefined.model.OperationalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalDataDao extends JpaRepository<OperationalData, String>, ICoreDataDao
{
	@Query("From OperationalData where dataId Like %:dataId%")
	List<OperationalData> searchOperationalData(@Param("dataId") String dataId);

}
