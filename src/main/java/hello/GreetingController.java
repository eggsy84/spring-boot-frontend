package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @Autowired
    protected CountService countService;

    @RequestMapping("/greeting")
    public String greeting(Model model) {

        CountPojo countPojo = countService.getCountViaApiCall();
        model.addAttribute("apiCallCount", countPojo.getCount());

        return "countPojo";
    }

}
