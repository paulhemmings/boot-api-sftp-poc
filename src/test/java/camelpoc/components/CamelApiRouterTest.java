package camelpoc.components;

import org.apache.camel.Endpoint;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelApiRouterTest extends CamelTestSupport {

  @Override
  protected RoutesBuilder createRouteBuilder() throws Exception {
    return new CamelApiRouter();
  }

  @Test
  public void testRoute() {
    Endpoint endpoint = context.getEndpoint("direct:start");
    template.setDefaultEndpoint(endpoint);
    template.sendBody("Test");
  }

}
