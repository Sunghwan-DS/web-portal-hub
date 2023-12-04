package jsh.search.service;

import jsh.search.domain.SearchRequest;
import jsh.search.domain.SearchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BlogSearchServiceTest {

    @Autowired
    private BlogSearchService blogSearchService;

    @Test
    @DisplayName("블로그 검색 테스트")
    void searchTest() {
        var request = SearchRequest.of("개발", SearchType.BLOG);
        var result = blogSearchService.search(request);

        assertNotNull(result);
    }
}
