package org.hbs.v7.userdefined.dao;

import org.hbs.v7.dao.ICoreBaseDao;
import org.hbs.v7.userdefined.model.OperationalProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreBaseDao extends JpaRepository<OperationalProcess, String>, ICoreBaseDao
{

}
