package org.hbs.v7.dao;

import org.hbs.v7.beans.model.dao.ICoreBaseDao;
import org.hbs.v7.beans.model.dao.ICoreDataDao;
import org.hbs.v7.dao.base.DynaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynaRepoImpl implements DynaRepo
{

	private static final long	serialVersionUID	= 6680897343117376145L;

	@Autowired
	OperationalDataDao			coreDataDao;

	@Autowired
	OperationalProcessDao		coreDao;

	public ICoreDataDao getCoreDataDao()
	{
		return coreDataDao;
	}

	public ICoreBaseDao getCoreDao()
	{
		return coreDao;
	}

}
