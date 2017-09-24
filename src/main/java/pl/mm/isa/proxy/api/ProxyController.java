package pl.mm.isa.proxy.api;

import org.springframework.web.bind.annotation.*;
import services.ProxyService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/v1/proxy", produces="application/json")
public class ProxyController {

    @GetMapping
    public String proxyUrl(@RequestParam String url) {
        ProxyService proxy = new ProxyService();

        return proxy.getWebsite(url);
    }
}
