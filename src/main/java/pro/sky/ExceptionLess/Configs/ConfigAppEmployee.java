package pro.sky.ExceptionLess.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.ExceptionLess.Data.Employee;

@Configuration
public class ConfigAppEmployee {

    public class ConfigAppBasket {
        @Bean
        @SessionScope
        public Employee createEmployee(){
            return  new Employee();
        }
    }
}
