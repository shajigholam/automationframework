//*** we need this class to scan our framework for components and will create some instances of the components in order to inject them further in the classes
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("automation")
public class AutomationFrameworkConfiguration {
    public AutomationFrameworkConfiguration(){}
}
