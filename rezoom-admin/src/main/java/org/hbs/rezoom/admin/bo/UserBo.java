package org.hbs.rezoom.admin.bo;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.util.Collection;
import java.util.List;

import org.apache.kafka.common.errors.InvalidRequestException;
import org.hbs.rezoom.bean.UserFormBean;
import org.hbs.rezoom.bean.model.Users;
import org.hbs.rezoom.util.EnumInterface;
import org.hbs.rezoom.util.LabelValueBean;
import org.springframework.security.core.Authentication;

public interface UserBo extends Serializable
{
	EnumInterface blockUser(Authentication auth, UserFormBean ufBean) throws InvalidRequestException;

	EnumInterface deleteUser(Authentication auth, UserFormBean ufBean) throws InvalidRequestException;

	List<LabelValueBean> getCityList(Authentication auth, UserFormBean userFormBean);

	List<LabelValueBean> getCountryList(Authentication auth, UserFormBean userFormBean);

	List<LabelValueBean> getStateList(Authentication auth, UserFormBean userFormBean);

	Users getUser(UserFormBean ufBean) throws InvalidRequestException;

	List<Users> getUserByProducer(Authentication auth);

	Collection<LabelValueBean> getUsersBySearchParam(Authentication auth, UserFormBean gmfBean);

	EnumInterface resendActivationLink(Authentication auth, UserFormBean userFormBean);

	EnumInterface saveUser(Authentication auth, UserFormBean ufBean) throws InvalidRequestException, InvalidKeyException;

	List<Users> searchUser(Authentication auth, UserFormBean ufBean) throws InvalidRequestException;

	EnumInterface updateUser(Authentication auth, UserFormBean ufBean) throws InvalidRequestException;

	UserFormBean validateUser(String token) throws InvalidKeyException;

}
