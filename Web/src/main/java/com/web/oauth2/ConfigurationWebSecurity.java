package com.web.oauth2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan({ "config.data" })
public class ConfigurationWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
    private DataSource dataSource;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("user").password("root123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");*/
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(getUserQuery())
				.authoritiesByUsernameQuery(getAuthoritiesQuery());
	}

	private String getUserQuery() {
        //return "select username,password, enabled from usertable where username=?";
        return "select UserName,Password, Enabled from users where UserName=?";
        //return "select username,password, enabled from users_temp where username=?";
    }

    private String getAuthoritiesQuery() {
        return "select FK_UserId, Role from userroles where FK_UserId=(select UserId from users where UserName=?)";
    	//return "select username, role from user_temp_roles where username=?";
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  /*http.authorizeRequests()
	    .antMatchers("/login", "/static/**", "/login/**").permitAll()
	    .antMatchers("/user/").access("hasRole('USER')")
	  	.antMatchers("/basicDetail/**").access("hasRole('USER')")
	  	.antMatchers("/db/").access("hasRole('ADMIN') and hasRole('DBA')")
	  	.antMatchers("/admin/").access("hasRole('ADMIN')").anyRequest().authenticated()
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("username").passwordParameter("password")
	  	.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied/");*/
		
	  http
		.authorizeRequests()
		.antMatchers("/login", "/static/**", "/login/**").permitAll()
		.antMatchers("/oauth/confirm_access").permitAll()
		.antMatchers("/oauth/token").permitAll()
		.antMatchers("/oauth/authorize").permitAll()
		.antMatchers("/student/").access("hasRole('STUDENT')")
		.antMatchers("/studentview/").access("hasRole('STUDENT')")
		.antMatchers("/vendor/").access("hasRole('VENDOR')")
		.antMatchers("/collegeadmin/").access("hasRole('COLLEGEADMIN')")
		/*.antMatchers("/basicDetail/**").access("hasRole('USER')")*/
		.antMatchers("/db/").access("hasRole('ADMIN') and hasRole('DBA')")
		.antMatchers("/admin/").access("hasRole('ADMIN')").anyRequest().authenticated()
		.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
		.usernameParameter("username").passwordParameter("password")
		.and()
		
		.csrf()
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
		/*.disable()*/
		.and()
		.logout()
		.logoutUrl("/logout")
		.and().exceptionHandling().accessDeniedPage("/Access_Denied/")
		/*.and()
		.formLogin()
		.loginProcessingUrl("/login")*/;
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}
	
	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}

}
