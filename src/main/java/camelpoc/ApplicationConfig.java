package camelpoc;

import camelpoc.components.CamelApiRouter;
import camelpoc.domain.ResultsTransformer;
import org.apache.camel.CamelContext;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = {"camelpoc"})
public class ApplicationConfig {

  @Value("${camelpoc.api.path}")
  String contextPath;

  @Autowired
  CamelApiRouter apiRouter;

  @Bean
  public CamelContext camelContext() throws Exception {
    CamelContext camelContext = new DefaultCamelContext();
    camelContext.addRoutes(apiRouter);
    camelContext.start();
    return camelContext;
  }

  @Bean
  public ResultsTransformer transformer() {
    return new ResultsTransformer();
  }

  @Bean
  ServletRegistrationBean servletRegistrationBean() {
    ServletRegistrationBean servlet =
        new ServletRegistrationBean(new CamelHttpTransportServlet(), contextPath + "/*");
    servlet.setName("CamelServlet");
    return servlet;
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }
}
