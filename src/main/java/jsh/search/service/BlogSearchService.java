package jsh.search.service;

import jsh.search.domain.SearchRequest;
import jsh.search.domain.SearchResponse;

public interface BlogSearchService {
    SearchResponse search(SearchRequest request);
}
