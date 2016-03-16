package com.senacor.springboot;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Schmitz
 */

@RestController
@RequestMapping(
    path = "helloworld",
    produces = APPLICATION_JSON_UTF8_VALUE)
public class HelloWorldController {
    @Inject
    private HelloWorldRepository helloWorldRepository;

    @RequestMapping(method = GET)
    public List<HelloWorld> findAll() {
        return
            stream(helloWorldRepository.findAll().spliterator(), false)
                .collect(toList());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public HelloWorld fetchOne(@PathVariable String id) {
        return helloWorldRepository.findOne(id);
    }

    @RequestMapping(method = POST)
    public
    ResponseEntity<HelloWorld>
    createGreeting(@RequestBody String greeting) {
        HelloWorld world
            = helloWorldRepository.save(new HelloWorld(greeting));
        return new ResponseEntity<>(world, HttpStatus.CREATED);
    }



}
