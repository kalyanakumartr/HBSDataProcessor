package org.hbs.v7.dao;

import org.hbs.v7.beans.model.dao.ICoreBaseDao;
import org.hbs.v7.beans.model.dataprocess.OperationalProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalProcessDao extends JpaRepository<OperationalProcess, String>, ICoreBaseDao
{
}
