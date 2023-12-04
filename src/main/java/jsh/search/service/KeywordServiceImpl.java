package jsh.search.service;

import jakarta.transaction.Transactional;
import jsh.search.domain.KeywordStatus;
import jsh.search.domain.entity.SearchKeywordsEntity;
import jsh.search.infra.BlogSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KeywordServiceImpl implements KeywordService {

    private final BlogSearchRepository blogSearchRepository;

    @Transactional
    @Override
    public KeywordStatus increaseSearchCnt(String keyword) {

        var searchKeywordsEntity = blogSearchRepository.findByKeyword(keyword);

        if (searchKeywordsEntity == null) {
            searchKeywordsEntity = SearchKeywordsEntity.create(keyword);
        } else {
            searchKeywordsEntity = SearchKeywordsEntity.increasedOf(searchKeywordsEntity);
        }

        try {
            blogSearchRepository.save(searchKeywordsEntity);
        } catch (Exception e) {
            log.error("BlogSearchRepository.save error: {}", e.getMessage());
            return KeywordStatus.FAIL;
        }
        return KeywordStatus.SUCCESS;
    }
}
