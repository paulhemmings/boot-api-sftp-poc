package camelpoc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import camelpoc.components.CamelApiRouter;

@RestController
public class HomeController {

    @Autowired
    private CamelApiRouter router;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/fire")
    public String fire() {
        return "Do something!";
    }
}
