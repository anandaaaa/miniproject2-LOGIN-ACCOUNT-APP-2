package in.myproject.anand.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myproject.anand.bindings.LoginRequest;
import in.myproject.anand.constants.MyAppConstants;
import in.myproject.anand.entities.UserEntity;
import in.myproject.anand.prop.AppProperties;
import in.myproject.anand.repositires.UserRepository;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private  AppProperties appprop;
	
	@Override
	public String CheckUserlogin(LoginRequest request) {
		
		Map<String, String> messages = appprop.getMessages();
		UserEntity findByUserEmailAndUserPwd = repo.findByUserEmailAndUserPwd(request.getEmail(),request.getPass());
		if(findByUserEmailAndUserPwd==null)
		{
			
			return messages.get(MyAppConstants.INVALID_PWD_MSG);
		}
		else if(findByUserEmailAndUserPwd.getUserAccStatus()==MyAppConstants.LOCKED)
		{
			return messages.get(MyAppConstants.ACC_STS_MSG);

		}
		
		return messages.get(MyAppConstants.SUCC_MSG);
	}

}
