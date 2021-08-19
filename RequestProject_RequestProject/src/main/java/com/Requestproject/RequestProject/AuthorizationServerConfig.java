package com.Requestproject.RequestProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.Requestproject.RequestProject.Service.AuthuserService;


@Configuration
@EnableAuthorizationServer
@Order(5)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/*
	 * static final String CLIEN_ID =
	 * "784595065444-eat80ksodbv3pvh0j6cc8ndv88i7bo75.apps.googleusercontent.com";
	 * static final String CLIENT_SECRET = "wK0i_ZZTL7So3sHPJSJkw-Yp"; static final
	 * String GRANT_TYPE = "password"; static final String AUTHORIZATION_CODE =
	 * "authorization_code"; static final String REFRESH_TOKEN = "refresh_token";
	 * static final String IMPLICIT = "implicit"; static final String SCOPE_READ =
	 * "read"; static final String SCOPE_WRITE = "write"; static final String TRUST
	 * = "trust"; static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60; static
	 * final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
	 * 
	 * 
	 * @Autowired private TokenStore tokenStore;
	 * 
	 * @Autowired private AuthenticationManager authenticationManager;
	 * 
	 * 
	 * 
	 * @Override public void configure(ClientDetailsServiceConfigurer configurer)
	 * throws Exception {
	 * 
	 * configurer .inMemory() .withClient(CLIEN_ID) .secret(CLIENT_SECRET)
	 * .authorizedGrantTypes(GRANT_TYPE, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT
	 * ) .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
	 * .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
	 * refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS); }
	 * 
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) throws Exception { endpoints.tokenStore(tokenStore)
	 * .authenticationManager(authenticationManager); }
	 */
	

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
    private AuthuserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .scopes("read", "write").autoApprove(true).secret(passwordEncoder().encode("password"))
                .accessTokenValiditySeconds(3600);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore);
        endpoints.userDetailsService(userService);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		 oauthServer.checkTokenAccess("isAuthenticated()"); 
    	
		/* oauthServer.allowFormAuthenticationForClients(); */
    }


}
