package pl.mm.isa.proxy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class IndexController {

    private static final ApplicationName applicationName = new ApplicationName("rest-proxy-service");

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ApplicationName get() {
        return applicationName;
    }

    @GetMapping("/swagger")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        return new RedirectView("/swagger-ui.html");
    }

    private static final class ApplicationName {
        private final String applicationName;

        public ApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }

        public String getApplicationName() {
            return applicationName;
        }
    }
}
