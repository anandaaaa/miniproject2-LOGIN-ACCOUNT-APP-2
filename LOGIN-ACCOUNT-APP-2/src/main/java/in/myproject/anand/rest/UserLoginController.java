package in.myproject.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.myproject.anand.bindings.LoginRequest;
import in.myproject.anand.service.UserLoginServiceImpl;

@RestController
public class UserLoginController {
	
	@Autowired
	public UserLoginServiceImpl service;
	
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginRequest request)
	{
		String checkUserlogin = service.CheckUserlogin(request);
		return checkUserlogin;
	}

}
