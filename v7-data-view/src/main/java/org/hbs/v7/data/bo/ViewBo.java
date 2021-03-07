package org.hbs.v7.data.bo;

import java.io.Serializable;
import java.util.List;

import org.hbs.core.util.EnumInterface;
import org.hbs.v7.beans.model.IncomingData;
import org.hbs.v7.beans.model.dataprocess.OperationalData;
import org.hbs.v7.beans.model.dataprocess.OperationalRoadType;
import org.hbs.v7.beans.model.dataprocess.OperationalStatus;
import org.hbs.v7.beans.model.dataprocess.OperationalStatusReason;
import org.hbs.v7.beans.model.dataprocess.OperationalTask;
import org.hbs.v7.beans.model.dataprocess.ResourceDeployment;
import org.hbs.v7.beans.model.dataprocess.ResourceGroup;
import org.hbs.v7.data.view.ViewFormBean;
import org.springframework.security.core.Authentication;

public interface ViewBo extends Serializable
{

	List<OperationalData> searchOperationalData(Authentication auth, ViewFormBean vfBean);

	List<IncomingData> searchIncomingData(Authentication auth, ViewFormBean vfBean);

	List<OperationalTask> searchOperationalTask(Authentication auth, ViewFormBean vfBean);

	List<OperationalTask> searchOperationalTaskAudit(Authentication auth, ViewFormBean vfBean);

	EnumInterface updateTask(Authentication auth, ViewFormBean vfBean);

	List<OperationalRoadType> getRoadType(Authentication auth);

	List<OperationalStatus> getOperationalStatus(Authentication auth);

	List<OperationalStatusReason> getStatusReason(Authentication auth, String statusId);

	List<ResourceGroup> getResourceGroup();

	List<ResourceDeployment> getResourceDeployment();
}
