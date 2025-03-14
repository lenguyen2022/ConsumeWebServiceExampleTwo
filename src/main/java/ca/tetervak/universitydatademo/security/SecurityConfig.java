package ca.tetervak.universitydatademo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //set up an admin user with an admin role
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user);
    }
    //Set up the Security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Disable these protection will allow access to H2-Console.
        http.csrf().disable(); //disable csrf protection
        http.headers().frameOptions().disable(); // prevent header added to response

        http.authorizeHttpRequests(authorizeRequests
                        -> authorizeRequests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
    //set up the Password Encoder
    @Bean
    public PasswordEncoder getPasswordEncoder() { return new BCryptPasswordEncoder();}

    @Bean(name = "funBean")
    public String funBean(){
        return "funBean Example";
    }
}
