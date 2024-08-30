package un.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
	
	@Autowired
	private CustomeUserDetailsServiceImpl customUser;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(customUser);
		daoAuthenticationProvider.setPasswordEncoder(encoder());
		
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf(csrf -> csrf.disable())
							.authorizeHttpRequests(authorize -> 
							authorize.
							requestMatchers("/new/**").permitAll().
							requestMatchers(HttpMethod.GET, "/billing/**").hasAnyAuthority("SALES","ACCOUNTANT").
							requestMatchers(HttpMethod.POST, "/billing/**").hasAuthority("SALES").
							requestMatchers(HttpMethod.POST, "/customer/**").hasAuthority("SALES").
							requestMatchers(HttpMethod.GET, "/customer/**").hasAuthority("SALES").
							requestMatchers(HttpMethod.GET, "/payroll/**").hasAnyAuthority("ACCOUNTANT","HR").
							requestMatchers(HttpMethod.POST, "/payroll/**").hasAuthority("HR").
							requestMatchers(HttpMethod.POST, "/user/**").hasAuthority("ADMIN").
							requestMatchers(HttpMethod.GET, "/user/**").hasAuthority("ADMIN").
							anyRequest().
							authenticated()
			).httpBasic(Customizer.withDefaults()).build();
	}
}
