//*** we need this class to scan our framework for components and will create some instances of the components
// in order to inject them further in the classes
package automation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("main")
public class AutomationFrameworkConfiguration {
    public AutomationFrameworkConfiguration(){}
}
