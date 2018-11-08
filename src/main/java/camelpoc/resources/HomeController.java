package camelpoc.resources;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private CamelContext camelContext;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/fire")
    public String fire() {
        try {
            this.camelContext.createProducerTemplate().sendBody("direct:start", "hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Complete";
    }
}
