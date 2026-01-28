package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String searchString) {
        return storageService.getAllSearchable().stream()
                .filter(s -> s.getSearchName().toLowerCase().equals(searchString.toLowerCase()))
                .map(s -> SearchResult.fromSearchable(s))
                .collect(Collectors.toList());
    }
}