package in.priya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((request)->request.requestMatchers("/welcome","/swagger-ui.html")
			              .permitAll()
			              .anyRequest().authenticated())  .formLogin();
	   
		
		return http.build();
	}
	
	
	
	// In-Memory Authontication is not recommended for production
	@Bean
	public InMemoryUserDetailsManager inMemoryUser()
	{
		UserDetails priyaUser=User.withDefaultPasswordEncoder().username("priya")
				                                                .password("Priya@123")
				                                                .authorities("ADMIN")
				                                                .build();
		
		UserDetails snehalUser=User.withDefaultPasswordEncoder().username("snehal")
				                                                 .password("Snehal@123")
				                                                 .authorities("USER")
				                                                 .build();
		                                                          
		
		return new InMemoryUserDetailsManager(priyaUser,snehalUser);
	}

}
