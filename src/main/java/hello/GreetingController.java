package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject("http://localhost:8081/greeting", Greeting.class);

        model.addAttribute("apiCallCount", greeting.getId());

        return "greeting";
    }

}
