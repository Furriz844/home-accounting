package ru.vdmitriy.homeaccounting;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic() // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                .antMatchers( "/payment").permitAll() // /index will be accessible directly no need of any authentication
                .anyRequest().authenticated(); // it's indicate all request will be secure

        http.csrf().disable();

    }
}
