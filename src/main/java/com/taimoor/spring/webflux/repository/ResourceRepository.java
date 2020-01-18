package com.taimoor.spring.webflux.repository;

import com.taimoor.spring.webflux.model.Resource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Taimoor Choudhary
 */
public interface ResourceRepository extends ReactiveCrudRepository<Resource, String> {
}
