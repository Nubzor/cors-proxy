package services;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProxyService {

    public String getWebsite(String url) throws InvalidMediaTypeException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = prepareHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (!response.getHeaders().getContentType().equals(MediaType.APPLICATION_JSON)) {
            throw new InvalidMediaTypeException(response.getHeaders().getContentType().getType(), "\"App is able to proxy application/json pages\"");
        }

        return response.getBody();
    }

    private HttpHeaders prepareHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }
}
