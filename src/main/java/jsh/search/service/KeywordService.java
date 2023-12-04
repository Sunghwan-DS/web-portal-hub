package jsh.search.service;

import jsh.search.domain.KeywordStatus;

public interface KeywordService {
    KeywordStatus increaseSearchCnt(String keyword);
}
