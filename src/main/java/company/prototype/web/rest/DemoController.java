package company.prototype.web.rest;

import com.microsoft.applicationinsights.TelemetryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    private final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    TelemetryClient telemetryClient;

    @GetMapping(value = "/demo")
    public ResponseEntity getHealthCheckOk() {
        log.info("Custom: got request for Demo /demo");
        telemetryClient.trackEvent("Custom: got request for Demo /demo");
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity getRoot() {
        log.info("Custom: got request for Root /root");
        telemetryClient.trackEvent("Custom: got request for Root /");
        return ResponseEntity.ok().build();
    }
}
