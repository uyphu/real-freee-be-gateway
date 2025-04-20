package com.rfr.gateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class FallbackController {

    // private CacheService cacheService;

    // public FallbackController(CacheService cacheService) {
    //     this.cacheService = cacheService;
    // }

    // @GetMapping("/fallback/item")
    // public ResponseEntity<?> fallbackItem() {
    //     List<Item> cachedItems = cacheService.getCachedItems(); // e.g., from Map or Redis
    //     if (cachedItems != null) {
    //         return ResponseEntity.ok(cachedItems);
    //     }
    //     return ResponseEntity.status(503).body("🚨 Item service is currently unavailable.");
    // }

    @GetMapping("/fallback/item")
    public Mono<String> fallbackItem() {
        return Mono.just("🚨 Item service is unavailable. Please try again later.");
    }

    @GetMapping("/fallback/media")
    public Mono<String> fallbackMediaService() {
        return Mono.just("🚨 Media service is unavailable.");
    }
}
