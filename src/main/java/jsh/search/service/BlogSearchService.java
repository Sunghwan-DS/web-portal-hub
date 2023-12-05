package jsh.search.service;

import jsh.search.domain.BlogsDTO;
import jsh.search.domain.SearchRequest;

public interface BlogSearchService {
    BlogsDTO search(SearchRequest request);
}
