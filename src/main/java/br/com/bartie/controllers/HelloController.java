package br.com.bartie.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Hello {

    public final long id;
    public final String content;

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
}

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello Say(
            @RequestParam(value = "name", defaultValue = "Word") String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }

}
