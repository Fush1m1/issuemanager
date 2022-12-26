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
public class PositionController {

    private final PositionRepository repository;

    PositionController(PositionRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/positions")
    List<Position> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/positions")
    Position newPosition(@RequestBody Position newPosition) {
        return repository.save(newPosition);
    }

    // Single item
    @GetMapping("/positions/{code}")
    Position one(@PathVariable String code) {

        return repository.findById(code)
                .orElseThrow(() -> new PositionNotFoundException(code));
    }

    @PutMapping("/positions/{code}")
    Position replacePosition(@RequestBody Position newPosition, @PathVariable String code) {

        return repository.findById(code)
                .map(Position -> {
                    Position.setQuantity(newPosition.getQuantity());
                    Position.setBookValue(newPosition.getBookValue());
                    Position.setProfitOrLossFromValuation(newPosition.getProfitOrLossFromValuation());
                    return repository.save(Position);
                })
                .orElseGet(() -> {
                    newPosition.setCode(code);
                    return repository.save(newPosition);
                });
    }

    @DeleteMapping("/positions/{code}")
    void deletePosition(@PathVariable String code) {
        repository.deleteById(code);
    }

}



