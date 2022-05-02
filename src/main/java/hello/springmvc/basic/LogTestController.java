package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    //    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("log-test")
    public String logTest() {
        String name = "my";
        System.out.println("name = " + name);
        log.info("name = {}", name);

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "ok";
    }
}
