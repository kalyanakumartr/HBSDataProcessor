package org.hbs.sender.bo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.hbs.rezoom.bean.MessageFormBean;
import org.hbs.rezoom.bean.SMSResponseBean;
import org.hbs.rezoom.bean.model.IMessages;
import org.hbs.rezoom.bean.model.Users;
import org.hbs.rezoom.bean.model.channel.ChannelMessages;
import org.hbs.rezoom.bean.model.channel.IChannelMessages;
import org.hbs.rezoom.bean.model.clickatell.SMSCallBackFormBean;
import org.hbs.rezoom.util.CommonValidator;
import org.hbs.rezoom.util.CustomException;
import org.hbs.rezoom.util.IConstProperty;
import org.hbs.sender.ISMSGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SMSSenderBoImpl extends BaseSenderBoImpl implements SMSSenderBo, IConstProperty
{

	private static final long	serialVersionUID	= -6778462377354165468L;

	@Autowired
	ISMSGateway					iSMSGateway;

	public SMSSenderBoImpl()
	{
		super();
	}

	private ChannelMessages getFabricatedMessage(String key, MessageFormBean messageFormBean, Users user) throws CloneNotSupportedException, InvalidKeyException, CustomException
	{
		if (user == null)
			user = messageFormBean.get(key).user;

		if (CommonValidator.isNotNullNotEmpty(user))
		{
			ChannelMessages message = (ChannelMessages) messageFormBean.message; // s.clone();
			// message.setUserId(user.getUserId());
			// message.setUserName(user.getUserName());
			// message.setMobileNumber(key);
			// message.setSource(messageFormBean.get(key).contact);
			// message.setType(messageFormBean.get(key).type);

			return message;
		}
		throw new CustomException("User data found.");
	}

	@Override
	public SMSResponseBean sendSMSByMessage(Authentication auth, IChannelMessages message) throws CustomException, IOException, ClassNotFoundException
	{
		if (CommonValidator.isNotNullNotEmpty(message))
		{
			if (CommonValidator.isNullOrEmpty(message.getConfiguration())) // Need for NULL
				message.setConfiguration(configurationBo.getConfigurationByType(auth, EMedia.SMS, EMediaType.Primary, EMediaMode.Internal));

			if (CommonValidator.isNotNullNotEmpty(message.getConfiguration()))
			{
				if (CommonValidator.isNotNullNotEmpty(message.getMessageId()))
				{
					List<IMessages> templateList = messageDao.getByMessageId(EAuth.User.getProducerId(auth), message.getMessageId());
					message.setMessage(templateList.iterator().next().getMessage());
					message.setMessage(message.generateVTLMessage()); // Generating Dynamic SMS
				}

				return iSMSGateway.sendSMSMessages(new MessageFormBean(message));
			}

			throw new CustomException("SMS Configuration NOT found for given id : ");
		}
		throw new CustomException("Authentication Token Or ChannelMessages may be NULL.");

	}

	@Override
	public EReturn sendSMSToUserOrGroup(Authentication auth, String token, MessageFormBean messageFormBean) throws Exception
	{
		return EReturn.Success;

	}

	@Override
	public void updateSMSStatus(SMSCallBackFormBean callBackFormBean)
	{
	}
}