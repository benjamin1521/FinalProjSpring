package ua.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.training.entities.Report;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JsonRestController {
    private static final String template = "Your report: %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/report")
    public Report reported(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Report(counter.incrementAndGet(),
                String.format(template, name));
    }
}
