package camelpoc.components;

import camelpoc.utilities.FtpTestUtility;
import org.apache.camel.Endpoint;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CamelFtpClientRouterTest extends CamelTestSupport {

  private FtpTestUtility ftpTestUtility = new FtpTestUtility();

  @Override
  protected RoutesBuilder createRouteBuilder() throws Exception {
    return new CamelFtpClientRouter();
  }

  @Before
  public void setUp() {
    try {
      super.setUp();
      this.ftpTestUtility.setUp();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @After
  public void tearDown() throws Exception {
    super.tearDown();
    this.ftpTestUtility.tearDown();
  }

  @Test
  public void testRoute() {
    Endpoint endpoint = context.getEndpoint("file://content/output");
    template.setDefaultEndpoint(endpoint);
    template.sendBody("Test");
  }
}
