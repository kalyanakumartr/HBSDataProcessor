package org.hbs.v7.beans.model.dao;

import java.io.Serializable;

import org.hbs.v7.beans.model.ICoreData;

public interface ICoreDataDao extends Serializable
{
	void save(ICoreData coreData);
}
