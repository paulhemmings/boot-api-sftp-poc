package camelpoc;

import camelpoc.components.CamelApiRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"camelpoc"})
public class ApplicationConfig {

  @Autowired
  CamelApiRouter apiRouter;

  @Bean
  public CamelContext camelContext() throws Exception {
    CamelContext camelContext = new DefaultCamelContext();
    camelContext.addRoutes(apiRouter);
    camelContext.start();
    return camelContext;
  }

}
