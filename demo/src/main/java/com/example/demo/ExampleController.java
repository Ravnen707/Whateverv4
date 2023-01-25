package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {
    @Autowired
    ExampleRepository exampleRepository;

    @PostMapping("/person")
    public Person createExample(@RequestBody Person person) {
        return exampleRepository.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getExample(@PathVariable long id) {
        return exampleRepository.findById(id).orElse(null);
    }
    @GetMapping("/person")
public List<Person> getAllExamples() {
    return exampleRepository.findAll();
}

}

