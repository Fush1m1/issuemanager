package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IssueController {

    private final IssueRepository repository;

    IssueController(IssueRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/issues")
    List<Issue> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/issues")
    Issue newIssue(@RequestBody Issue newIssue) {
        return repository.save(newIssue);
    }

    // Single item
    @GetMapping("/issues/{code}")
    Issue one(@PathVariable String code) {

        return repository.findById(code)
                .orElseThrow(() -> new IssueNotFoundException(code));
    }

    @PutMapping("/issues/{code}")
    Issue replaceIssue(@RequestBody Issue newIssue, @PathVariable String code) {

        return repository.findById(code)
                .map(Issue -> {
                    Issue.setName(newIssue.getName());
                    Issue.setMaturityDate(newIssue.getMaturityDate());
                    Issue.setRate(newIssue.getRate());
                    Issue.setCouponPaymentsNumber(newIssue.getCouponPaymentsNumber());
                    return repository.save(Issue);
                })
                .orElseGet(() -> {
                    newIssue.setCode(code);
                    return repository.save(newIssue);
                });
    }

    @DeleteMapping("/issues/{code}")
    void deleteIssue(@PathVariable String code) {
        repository.deleteById(code);
    }

}

    

 