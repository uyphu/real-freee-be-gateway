package com.rfr.gateway.service;

import com.rfr.gateway.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CacheService {

    private final List<Item> cachedItems = new ArrayList<>();

    public CacheService() {
        // Sample static data, you can update dynamically from real service later
        cachedItems.add(new Item("🪑 Chair", "Gently used wooden chair"));
        cachedItems.add(new Item("📚 Books", "Stack of novels and study guides"));
        cachedItems.add(new Item("🧥 Jacket", "Winter jacket, size M"));
    }

    public List<Item> getCachedItems() {
        return cachedItems;
    }

    // Optional: Let you refresh cache manually
    public void updateItems(List<Item> items) {
        cachedItems.clear();
        cachedItems.addAll(items);
    }
}
