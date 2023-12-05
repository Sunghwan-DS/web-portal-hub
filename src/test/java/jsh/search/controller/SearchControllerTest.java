package jsh.search.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class SearchControllerTest {

    @Autowired
    private SearchController searchController;

    @Test
    @DisplayName("블로그 검색 테스트")
    void searchBlogTest() {
        var result = searchController.searchBlog("개발",
                                                 "accuracy",
                                                 1,
                                                 10);

        assertNotNull(result);
    }
}
