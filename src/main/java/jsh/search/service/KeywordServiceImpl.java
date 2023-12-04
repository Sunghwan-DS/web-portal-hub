package jsh.search.service;

import jsh.search.domain.KeywordStatus;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {
    @Override
    public KeywordStatus increaseSearchCnt(String keyword) {
        return KeywordStatus.SUCCESS;
    }
}
