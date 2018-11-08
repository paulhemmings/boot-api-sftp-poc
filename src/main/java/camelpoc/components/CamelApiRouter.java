package camelpoc.components;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class CamelApiRouter extends RouteBuilder {

  private CamelContext context = new DefaultCamelContext();

  @Override
  public void configure() {
    from("direct:start")
        .setHeader(Exchange.HTTP_URI, simple("http://cloud.feedly.com/v3/search/feeds?query=iot"))
//        .to("file://target/subfolder")
        .log("{body}");
  }
}
