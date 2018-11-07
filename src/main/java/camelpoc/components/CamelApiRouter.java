package camelpoc.components;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class CamelApiRouter extends RouteBuilder {

  private CamelContext context = new DefaultCamelContext();

  @Override
  public void configure() {
//    from("direct:start")
//        .to("velocity:MailBody.vm");
  }
}
