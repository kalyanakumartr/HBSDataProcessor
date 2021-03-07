package org.hbs.v7.dao.base;

import java.io.Serializable;

import org.hbs.v7.beans.model.dao.ICoreBaseDao;
import org.hbs.v7.beans.model.dao.ICoreDataDao;

public interface DynaRepo extends Serializable
{
	public ICoreDataDao getCoreDataDao();

	public ICoreBaseDao getCoreDao();
}
