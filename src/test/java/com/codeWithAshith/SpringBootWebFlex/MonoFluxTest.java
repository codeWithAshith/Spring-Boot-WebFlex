package com.codeWithAshith.SpringBootWebFlex;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
//        Mono<?> monoString = Mono.just("codeWithAshith");
//        monoString.subscribe(System.out::println);

//        Mono<?> monoString = Mono.just("codeWithAshith").log();
//        monoString.subscribe(System.out::println);

        Mono<?> monoString = Mono.just("codeWithAshith")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){

//        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice");
//        fluxString.subscribe(System.out::println);

//        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice").log();
//        fluxString.subscribe(System.out::println);

//        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
//                .concatWithValues("AWS")
//                .log();
//        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

//        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
//                .concatWithValues("AWS")
//                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
//                .log();
//        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
