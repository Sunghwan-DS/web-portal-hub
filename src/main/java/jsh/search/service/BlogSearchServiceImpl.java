package jsh.search.service;

import jsh.search.domain.BlogsDTO;
import jsh.search.domain.SearchRequest;
import jsh.search.infra.KakaoSearchClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogSearchServiceImpl implements BlogSearchService {

    private final KakaoSearchClient kakaoSearchClient;

    @Override
    public BlogsDTO search(SearchRequest request) {
        var result = kakaoSearchClient.searchBlog(request.keyword(),
                                                  request.sortType().getCode(),
                                                  request.page(),
                                                  request.size());
        return BlogsDTO.of(result);
    }
}
