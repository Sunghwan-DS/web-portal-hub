package jsh.search.service;

import jsh.search.domain.SearchRequest;
import jsh.search.domain.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogSearchServiceImpl implements BlogSearchService {
    @Override
    public SearchResponse search(SearchRequest request) {
        return SearchResponse.of();
    }
}
