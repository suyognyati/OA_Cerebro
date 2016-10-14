package com.web.session;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan({ "config.data" })
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
    private DataSource dataSource;

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
        return "select username,password, UserId from users where username=?";
    }

    private String getAuthoritiesQuery() {
        return "select username, role from user_roles where username=?";
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	    .antMatchers("/login", "/static/**").permitAll()
	    .antMatchers("/", "/home").access("hasAuthority('USER')").anyRequest().authenticated()
	  	.antMatchers("/personalDetail/**").access("hasAuthority('USER')").anyRequest().authenticated()
	  	.antMatchers("/admin/**").access("hasAuthority('ADMIN')").anyRequest().authenticated()
	  	.antMatchers("/db/**").access("hasAuthority('ADMIN') and hasAuthority('DBA')").anyRequest().authenticated()
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().csrf()
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
		/*http.authorizeRequests()
		.antMatchers("/", "/home").access("hasRole('USER')")
	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")  
		  .anyRequest().permitAll()
		  .and()
		    .formLogin().loginPage("/login")
		    .usernameParameter("ssoId").passwordParameter("password")
		  .and()
		    .logout().logoutSuccessUrl("/login?logout") 
		   .and()
		   .exceptionHandling().accessDeniedPage("/Access_Denied")
		  .and()
		    .csrf();*/
	}

}