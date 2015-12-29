package hello;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountServiceImpl implements CountService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public CountPojo getCountViaApiCall() {

        CountPojo countPojo = restTemplate.getForObject("http://localhost:8081/count", CountPojo.class);

        return countPojo;
    }
}
