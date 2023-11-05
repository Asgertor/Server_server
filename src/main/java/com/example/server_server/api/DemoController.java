package com.example.server_server.api;

import com.example.server_server.RemoteApiTester;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final int SLEEP_TIME = 1000*3;
    private RemoteApiTester remoteApiTester;
    public DemoController(RemoteApiTester remoteApiTester) {
        this.remoteApiTester = remoteApiTester;
    }

    @GetMapping(value = "/random-string-slow")
    public String slowEndpoint() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @GetMapping(value = "/{name}")
    public String helloEndpoint(@PathVariable String name) {
        var res = remoteApiTester.getGenderForName("Asger").block().getGender();
        return "Gender: " + res;
    }

}
