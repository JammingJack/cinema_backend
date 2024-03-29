/*
package security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("user3").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //.formLogin().loginPage("/authentication");
        http.formLogin();
        http.authorizeRequests().antMatchers("/images/**","/payerTickets/**"
                ).hasRole("ADMIN");
        //http.authorizeRequests().anyRequest().authenticated();
        http.csrf();
        http.exceptionHandling().accessDeniedPage("/notAuthorized");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/