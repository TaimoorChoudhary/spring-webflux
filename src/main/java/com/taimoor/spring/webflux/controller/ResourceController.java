package com.taimoor.spring.webflux.controller;

import com.taimoor.spring.webflux.model.Resource;
import com.taimoor.spring.webflux.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Taimoor Choudhary
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceRepository resourceRepository;

    @GetMapping("/{id}")
    public Mono<Resource> getResource(@PathVariable String id) {
        return resourceRepository.findById(id);
    }

    @GetMapping()
    public Flux<Resource> getResources() {
        return resourceRepository.findAll();
    }
}
