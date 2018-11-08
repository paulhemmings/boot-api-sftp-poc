package camelpoc;

import camelpoc.components.CamelApiRouter;
import camelpoc.components.CamelFtpClientRouter;
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

  @Autowired
  CamelFtpClientRouter ftpClientRouter;

  @Bean
  public CamelContext camelContext() throws Exception {
    CamelContext camelContext = new DefaultCamelContext();
    camelContext.addRoutes(apiRouter);
    camelContext.addRoutes(ftpClientRouter);
    camelContext.start();
    return camelContext;
  }

}
