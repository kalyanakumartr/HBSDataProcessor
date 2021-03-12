package org.hbs.v7.data.bo;

import java.sql.Timestamp;
import java.util.List;

import org.hbs.core.security.resource.IPath.EAuth;
import org.hbs.core.security.resource.IPathBase.EReturn;
import org.hbs.core.util.CommonValidator;
import org.hbs.core.util.EnumInterface;
import org.hbs.v7.beans.model.IncomingData;
import org.hbs.v7.dao.IncomingDao;
import org.hbs.v7.data.view.ViewFormBean;
import org.hbs.v7.data.view.ViewFormBean.EViewAction;
import org.hbs.v7.userdefined.dao.OperationalDataDao;
import org.hbs.v7.userdefined.dao.OperationalRoadTypeDao;
import org.hbs.v7.userdefined.dao.OperationalStatusDao;
import org.hbs.v7.userdefined.dao.OperationalStatusReasonDao;
import org.hbs.v7.userdefined.dao.OperationalTaskDao;
import org.hbs.v7.userdefined.dao.ResourceDeploymentDao;
import org.hbs.v7.userdefined.dao.ResourceGroupDao;
import org.hbs.v7.userdefined.model.OperationalData;
import org.hbs.v7.userdefined.model.OperationalEmployee;
import org.hbs.v7.userdefined.model.OperationalRoadType;
import org.hbs.v7.userdefined.model.OperationalStatus;
import org.hbs.v7.userdefined.model.OperationalStatusReason;
import org.hbs.v7.userdefined.model.OperationalTask;
import org.hbs.v7.userdefined.model.ResourceDeployment;
import org.hbs.v7.userdefined.model.ResourceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ViewBoImpl implements ViewBo
{
	@Autowired
	ResourceGroupDao			resourceGroupDao;
	@Autowired
	ResourceDeploymentDao		resourceDeploymentDao;
	@Autowired
	OperationalStatusDao		statusDao;
	@Autowired
	OperationalStatusReasonDao	statusReasonDao;
	@Autowired
	OperationalRoadTypeDao		roadTypeDao;
	@Autowired
	IncomingDao					incomingDao;
	@Autowired
	OperationalDataDao			operDataDao;
	@Autowired
	OperationalTaskDao			operTaskDao;

	private static final long	serialVersionUID	= 8948024277489998968L;

	@Override
	public List<OperationalData> searchOperationalData(Authentication auth, ViewFormBean vfBean)
	{
		vfBean.dataId = CommonValidator.isNotNullNotEmpty(vfBean.dataId) ? vfBean.dataId : "";
		return operDataDao.searchOperationalData(vfBean.dataId);
	}

	@Override
	public List<IncomingData> searchIncomingData(Authentication auth,ViewFormBean vfBean)
	{
		String producerId = EAuth.User.getProducerId(auth);
		vfBean.incomingId = CommonValidator.isNotNullNotEmpty(vfBean.incomingId) ? vfBean.incomingId : "";

		return incomingDao.searchIncomingData(producerId, vfBean.incomingId);
	}

	@Override
	public List<OperationalTask> searchOperationalTask(Authentication auth, ViewFormBean vfBean)
	{
		String producerId = EAuth.User.getProducerId(auth);

		return operTaskDao.searchOperationalTask(producerId, vfBean.taskId);
	}

	@Override
	public List<OperationalTask> searchOperationalTaskAudit(Authentication auth, ViewFormBean vfBean)
	{

		String producerId = EAuth.User.getProducerId(auth);

		return operTaskDao.searchOperationalTask(producerId, vfBean.taskId);
	}

	@Override
	public EnumInterface updateTask(Authentication auth, ViewFormBean vfBean)
	{
		
		OperationalTask oTask = operTaskDao.getOne(vfBean.taskId);

		if (vfBean.eAction == EViewAction.Start)
		{
			oTask.setStartTime(new Timestamp(System.currentTimeMillis()));
			oTask.setEndTime(null);
		}
		else
		{
			oTask.setStartTime(new Timestamp(System.currentTimeMillis()));
			if("Hold".equalsIgnoreCase(vfBean.status))
			{
				oTask.setTaskStatus(vfBean.status);
				oTask.setReason(vfBean.statusReason);
			}
		}
		
		oTask.setRoadType(vfBean.roadTypeId);
		oTask.setRemarks(vfBean.remarks);
		oTask.setTaskEmployee((OperationalEmployee) EAuth.User.getUser(auth));
		
		operTaskDao.save(oTask);
		
		return EReturn.Success;
	}

	@Override
	public List<OperationalRoadType> getRoadType(Authentication auth)
	{

		return roadTypeDao.getOperationalRoadType(true);
	}

	@Override
	public List<OperationalStatus> getOperationalStatus(Authentication auth)
	{

		return statusDao.getOperationalStatus(true);
	}

	@Override
	public List<OperationalStatusReason> getStatusReason(Authentication auth, String statusId)
	{

		return statusReasonDao.getOperationalStatusReason(statusId, true);
	}

	@Override
	public List<ResourceGroup> getResourceGroup()
	{

		return resourceGroupDao.getResourceGroup(true);
	}

	@Override
	public List<ResourceDeployment> getResourceDeployment()
	{

		return resourceDeploymentDao.getResourceDeployment(true);
	}

}
