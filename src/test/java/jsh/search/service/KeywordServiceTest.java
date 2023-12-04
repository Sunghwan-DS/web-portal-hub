package jsh.search.service;

import jsh.search.domain.KeywordStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class KeywordServiceTest {

    @Autowired
    KeywordService keywordService;

    @Test
    @DisplayName("검색 카운트 증가")
    void increaseSearchCntTest() {
        var keyword = "개발";
        var result = keywordService.increaseSearchCnt(keyword);

        assertEquals(result, KeywordStatus.SUCCESS);
    }

    @Test
    @DisplayName("인기검색어 10개 조회 테스트")
    void getPopularKeywordsTest() {
        var popularKeywords = keywordService.getPopularKeywords();

        assertNotNull(popularKeywords);
    }
}
