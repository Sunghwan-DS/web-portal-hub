package jsh.search.controller;

import jsh.blog.domain.BlogsDTO;
import jsh.search.domain.SearchRequest;
import jsh.search.domain.SearchType;
import jsh.search.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/search")
public class SearchController {

    private final BlogSearchService blogSearchService;

    @GetMapping("/blog")
    public BlogsDTO searchBlog(@RequestParam("keyword") String keyword,
                             @RequestParam("sortType") String sortType,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {

        return blogSearchService.search(SearchRequest.of(keyword,
                                                         sortType,
                                                         SearchType.BLOG,
                                                         page,
                                                         size));
    }
}
