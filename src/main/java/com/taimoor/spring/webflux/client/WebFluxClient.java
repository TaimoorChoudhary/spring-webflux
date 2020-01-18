package com.taimoor.spring.webflux.client;

import com.taimoor.spring.webflux.model.Resource;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Taimoor Choudhary
 */
public class WebFluxClient {

    WebClient client;

    /**
     * Open connection to server
     * @param url
     * @return
     */
    public WebClient openConnection(String url) {
        client = WebClient.create(url);
        return client;
    }

    /**
     * Request single resource
     * @param id
     */
    public void getResourceById(String id){
        Mono<Resource> result = client.get()
                .uri("/resource/{id}", "1")
                .retrieve()
                .bodyToMono(Resource.class);

        result.subscribe(System.out::println);
    }

    /**
     * Request a collection
     */
    public void getAllResources(){
        Flux<Resource> result = client.get()
                .uri("/resource")
                .retrieve()
                .bodyToFlux(Resource.class);

        result.subscribe(System.out::println);
    }
}
