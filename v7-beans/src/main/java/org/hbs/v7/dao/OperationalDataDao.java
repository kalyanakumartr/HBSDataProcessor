package org.hbs.v7.dao;

import org.hbs.v7.beans.model.dataprocess.OperationalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationalDataDao extends JpaRepository<OperationalData, String>
{

}
