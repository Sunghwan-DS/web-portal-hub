package jsh.search.service;

import jsh.search.domain.KeywordStatus;
import jsh.search.domain.PopularKeywords;

public interface KeywordService {
    KeywordStatus increaseSearchCnt(String keyword);
    PopularKeywords getPopularKeywords();
}
