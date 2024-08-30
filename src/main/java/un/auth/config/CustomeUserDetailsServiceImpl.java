package un.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import un.auth.entity.Users;
import un.auth.repo.UserRepo;

@Service
public class CustomeUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.getUserByEmail(username);
		System.out.println(user);
		if(user == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		
		return user;
		
	}

}
