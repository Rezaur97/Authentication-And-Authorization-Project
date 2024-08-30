package un.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import un.auth.entity.Users;
import un.auth.services.UserServiceImpl;

@RestController
@RequestMapping("/new")
public class NewUserController {
	
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("createUser")
	public Users createNewUsers(@RequestBody Users u) {
		return userService.createNewUser(u);
	}
}
