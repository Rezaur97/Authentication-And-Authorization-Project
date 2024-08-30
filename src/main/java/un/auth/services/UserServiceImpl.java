package un.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import un.auth.entity.Users;
import un.auth.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Users createNewUser(Users u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return repo.save(u);
	}

}
