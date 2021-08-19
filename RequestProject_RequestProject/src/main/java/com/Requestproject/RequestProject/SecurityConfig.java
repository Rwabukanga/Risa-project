package com.Requestproject.RequestProject;

import org.springframework.beans.factory.annotation.Autowired;

/*import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;*/
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
*/
/*import com.Requestproject.RequestProject.Service.SystemuserService;*/

import com.Requestproject.RequestProject.Service.AuthuserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Resource(name = "SystemuserService") private UserDetailsService
	 * userDetailsService;
	 * 
	 * 
	 * 
	 * 
	 * @Override
	 * 
	 * @Bean public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 * 
	 * 
	 * @Autowired public void globalUserDetails(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.userDetailsService(userDetailsService)
	 * .passwordEncoder(encoder()); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf().disable() .anonymous().disable() .authorizeRequests()
	 * .antMatchers("/oauth/**").permitAll(); .antMatchers("/","/login")
	 * .permitAll(); }
	 * 
	 * @Bean public TokenStore tokenStore() { return new InMemoryTokenStore(); }
	 * 
	 * @Bean public BCryptPasswordEncoder encoder(){ return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public FilterRegistrationBean corsFilter() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * config.setAllowCredentials(false); config.addAllowedOrigin("*");
	 * config.addAllowedHeader("*"); config.addAllowedMethod("*");
	 * source.registerCorsConfiguration("/**", config); FilterRegistrationBean bean
	 * = new FilterRegistrationBean(new CorsFilter(source)); bean.setOrder(0);
	 * return bean; }
	 */
	/*
	 * @Autowired private AuthuserService userService;
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable().authorizeRequests().antMatchers("/oauth/**", "/auth/**","/registr/**").permitAll()
		.and() 
		.httpBasic() 
		.and() 
		.authorizeRequests()		 
        .anyRequest()
        .authenticated();
        
    }
	
	/*
	 * @Bean public AuthenticationProvider authprovider() {
	 * DaoAuthenticationProvider tt = new DaoAuthenticationProvider();
	 * tt.setUserDetailsService( userService); return tt; }
	 */

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
   

}
