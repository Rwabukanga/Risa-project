package com.Requestproject.RequestProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
/*import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;*/
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableResourceServer
@RestController
@Order(20)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/*
	 * private static final String RESOURCE_ID = "resource_id";
	 * 
	 * private static final String RESOURCE_ID = "http://localhost:2021";
	 * 
	 * @Override public void configure(ResourceServerSecurityConfigurer resources) {
	 * resources.resourceId(RESOURCE_ID).stateless(false); }
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception { http.
	 * anonymous().disable() .authorizeRequests() .antMatchers("/users/**")
	 * .antMatchers("/","/login","/oauth/authorize") .authenticated()
	 * .and().exceptionHandling().accessDeniedHandler(new
	 * OAuth2AccessDeniedHandler()); }
	 */
	
	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.cors();
	        http.csrf().disable().authorizeRequests().antMatchers("/oauth/**", "/auth/**", "/registr/**").permitAll()
			.and() 
			.httpBasic() 
			.and() 
			.authorizeRequests()	 
	        .anyRequest()
	        .authenticated();
	    }
}
