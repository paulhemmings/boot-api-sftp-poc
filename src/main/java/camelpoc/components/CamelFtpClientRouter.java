package camelpoc.components;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.springframework.stereotype.Component;

/**
 *
 * Taken From this Camel example
 * https://github.com/apache/camel/blob/master/examples/camel-example-ftp/src/main/java/org/apache/camel/example/ftp/MyFtpClientRouteBuilder.java
 *
 */

@Component
public class CamelFtpClientRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    PropertiesComponent pc = getContext().getComponent("properties", PropertiesComponent.class);
    pc.setLocation("classpath:ftp.properties");

    getContext().getShutdownStrategy().setTimeout(10);

    from("file://content/output?moveFailed=../error")
        .log("Uploading file ${file:name}")
        .to("{{ftp.client}}")
        .log("Uploaded file ${file:name} complete.");

  }
}
