package org.hbs.v7.userdefined.dao;

import org.hbs.v7.dao.ICoreBaseDao;
import org.hbs.v7.userdefined.model.OperationalProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalProcessDao extends JpaRepository<OperationalProcess, String>, ICoreBaseDao
{
}
