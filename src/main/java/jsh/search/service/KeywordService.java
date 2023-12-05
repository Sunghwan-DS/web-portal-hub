package jsh.search.service;

import jsh.search.domain.KeywordStatus;
import jsh.blog.domain.PopularKeywords;

public interface KeywordService {
    KeywordStatus increaseSearchCnt(String keyword);
    PopularKeywords getPopularKeywords();
}
