package jsh.search.service;

import jsh.blog.domain.BlogsDTO;
import jsh.search.domain.SearchRequest;

public interface BlogSearchService {
    BlogsDTO search(SearchRequest request);
}
