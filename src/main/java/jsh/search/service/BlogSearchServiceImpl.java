package jsh.search.service;

import jsh.blog.domain.BlogsDTO;
import jsh.search.domain.SearchRequest;
import jsh.search.infra.KakaoSearchClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogSearchServiceImpl implements BlogSearchService {

    private final KakaoSearchClient kakaoSearchClient;
    private final KeywordService keywordService;

    @Override
    public BlogsDTO search(SearchRequest request) {
        var result = kakaoSearchClient.searchBlog(request.keyword(),
                                                  request.sortType().getCode(),
                                                  request.page(),
                                                  request.size());
        keywordService.increaseSearchCnt(request.keyword());
        return BlogsDTO.of(result);
    }
}
