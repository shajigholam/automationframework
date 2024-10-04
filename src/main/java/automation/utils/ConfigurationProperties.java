package automation.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
// by using spring boot, for config managements instead of framework properties in the utils we can use the spring annotation
@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

    @Value("${browser}")
    private String browser;

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    @Value("${user}")
    private String userName;

    public String getBrowser() {
        return browser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
}
