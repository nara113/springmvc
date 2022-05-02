package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("hello basic");
        return "ok";
    }

    @GetMapping("/hello/{userId}")
    public String path(@PathVariable String userId) {
        return userId;
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("param mapping");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mapping header");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume() {
        return "ok";
    }

    @GetMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduce() {
        return "ok";
    }
}
