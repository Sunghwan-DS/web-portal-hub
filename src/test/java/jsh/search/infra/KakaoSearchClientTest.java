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
    @DisplayName("")
    void searchBlogTest() {
        var result = kakaoSearchClient.searchBlog("개발", "accuracy", 1, 10);

        assertNotNull(result);
    }
}
