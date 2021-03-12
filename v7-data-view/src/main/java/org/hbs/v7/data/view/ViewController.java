package org.hbs.v7.data.view;

import java.util.List;

import org.hbs.core.security.resource.IPathBase.EReturn;
import org.hbs.core.util.CommonValidator;
import org.hbs.core.util.EnumInterface;
import org.hbs.v7.beans.model.IncomingData;
import org.hbs.v7.userdefined.model.OperationalData;
import org.hbs.v7.userdefined.model.OperationalRoadType;
import org.hbs.v7.userdefined.model.OperationalStatus;
import org.hbs.v7.userdefined.model.OperationalStatusReason;
import org.hbs.v7.userdefined.model.OperationalTask;
import org.hbs.v7.userdefined.model.ResourceDeployment;
import org.hbs.v7.userdefined.model.ResourceGroup;
import org.hbs.v7.data.bo.ViewBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnanthMalBal
 */
@RestController
public class ViewController implements IViewController
{
	private static final long	serialVersionUID	= -1046242631792313825L;

	// private final Logger LOGGER = LoggerFactory.getLogger(ViewController.class);

	@Autowired
	ViewBo						viewBo;

	@Override
	public ResponseEntity<?> getIncomingData(Authentication auth, @RequestBody ViewFormBean vfBean)
	{
		try
		{
			return new ResponseEntity<List<IncomingData>>(viewBo.searchIncomingData(auth, vfBean), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			vfBean.clearForm();
			vfBean.messageCode = excep.getLocalizedMessage();
			return new ResponseEntity<>(vfBean, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getOperationalData(Authentication auth, @RequestBody ViewFormBean vfBean)
	{
		try
		{
			return new ResponseEntity<List<OperationalData>>(viewBo.searchOperationalData(auth, vfBean), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			vfBean.clearForm();
			vfBean.messageCode = excep.getLocalizedMessage();
			return new ResponseEntity<>(vfBean, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getOperationalTask(Authentication auth, ViewFormBean vfBean)
	{
		try
		{
			return new ResponseEntity<List<OperationalTask>>(viewBo.searchOperationalTask(auth, vfBean), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			vfBean.clearForm();
			vfBean.messageCode = excep.getLocalizedMessage();
			return new ResponseEntity<>(vfBean, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> updateTaskStatus(Authentication auth, ViewFormBean vfBean)
	{
		try
		{
			if (CommonValidator.isNotNullNotEmpty(vfBean))
			{
				return new ResponseEntity<EnumInterface>(viewBo.updateTask(auth, vfBean), HttpStatus.OK);
			}
			throw new InvalidRequestException(INVALID_REQUEST_PARAMETERS);
		}
		catch (Exception excep)
		{
			vfBean.clearForm();
			vfBean.messageCode = excep.getLocalizedMessage();
			return new ResponseEntity<>(vfBean, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> viewTaskAudit(Authentication auth, ViewFormBean vfBean)
	{
		try
		{
			return new ResponseEntity<List<OperationalTask>>(viewBo.searchOperationalTaskAudit(auth, vfBean), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			vfBean.clearForm();
			vfBean.messageCode = excep.getLocalizedMessage();
			return new ResponseEntity<>(vfBean, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> viewProgressGroup(Authentication auth, ViewFormBean vfBean)
	{
		return null;
	}

	@Override
	public ResponseEntity<?> viewProgressDeploy(Authentication auth, ViewFormBean vfBean)
	{
		return null;
	}

	@Override
	public ResponseEntity<?> getRoadTypeList(Authentication auth)
	{
		try
		{
			return new ResponseEntity<List<OperationalRoadType>>(viewBo.getRoadType(auth), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			return new ResponseEntity<>(EReturn.Failure, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getStatusList(Authentication auth)
	{
		try
		{
			return new ResponseEntity<List<OperationalStatus>>(viewBo.getOperationalStatus(auth), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			return new ResponseEntity<>(EReturn.Failure, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getReasonList(Authentication auth, String statusId)
	{
		try
		{
			return new ResponseEntity<List<OperationalStatusReason>>(viewBo.getStatusReason(auth, statusId), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			return new ResponseEntity<>(EReturn.Failure, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getGroupList()
	{
		try
		{
			return new ResponseEntity<List<ResourceGroup>>(viewBo.getResourceGroup(), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			return new ResponseEntity<>(EReturn.Failure, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getDeploymentsList()
	{
		try
		{
			return new ResponseEntity<List<ResourceDeployment>>(viewBo.getResourceDeployment(), HttpStatus.OK);
		}
		catch (Exception excep)
		{
			return new ResponseEntity<>(EReturn.Failure, HttpStatus.BAD_REQUEST);
		}
	}

}
