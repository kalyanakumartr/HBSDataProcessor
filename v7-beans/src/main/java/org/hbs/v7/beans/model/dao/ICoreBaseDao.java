package org.hbs.v7.beans.model.dao;

import java.io.Serializable;
import java.util.Optional;

public interface ICoreBaseDao extends Serializable
{
	Optional<?> findById(String dataURN);
}
