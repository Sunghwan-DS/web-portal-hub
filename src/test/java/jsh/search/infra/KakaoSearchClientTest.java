package jsh.search.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class KakaoSearchClientTest {

    @Autowired
    private KakaoSearchClient kakaoSearchClient;

    @Test
    @DisplayName("카카오 블로그 검색 API 테스트")
    void searchBlogTest() {
        var result = kakaoSearchClient.searchBlog("개발", "accuracy", 1, 10);

        assertNotNull(result);
    }
}
