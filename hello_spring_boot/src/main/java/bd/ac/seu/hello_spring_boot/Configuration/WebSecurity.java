package bd.ac.seu.hello_spring_boot.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) {
        try {
            builder.inMemoryAuthentication()
                    .withUser("bashar")
                    .password("web").authorities("Admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
