package jsh.search.service;

import jsh.search.domain.KeywordStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
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
    @DisplayName("검색 카운트 증가 동시성 테스트")
    void increaseSearchCntConcurrentTest() throws InterruptedException {
        int numberOfThreads = 10; // 동시에 실행할 스레드 수
        int numberOfIncrements = 100; // 각 스레드당 실행할 증가 횟수

        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        var before = keywordService.getSearchCount("개발");

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < numberOfIncrements; j++) {
                        keywordService.increaseSearchCnt("개발");
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 모든 스레드가 완료될 때까지 대기
        executorService.shutdown();

        // 테스트에서 예상되는 최종 검색 횟수 확인
        long expectedSearchCount = numberOfThreads * numberOfIncrements;
        var after = keywordService.getSearchCount("개발");

        assertEquals(after, before + expectedSearchCount);
    }

    @Test
    @DisplayName("인기검색어 10개 조회 테스트")
    void getPopularKeywordsTest() {
        var popularKeywords = keywordService.getPopularKeywords();

        assertNotNull(popularKeywords);
    }
}
