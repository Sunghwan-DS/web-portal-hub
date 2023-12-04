package jsh.search.domain;

import lombok.Builder;

@Builder
public record SearchRequest(
    String keyword,
    SearchType searchType
) {
    public static SearchRequest of(String keyword, SearchType searchType) {
        return SearchRequest.builder()
                            .keyword(keyword)
                            .searchType(searchType)
                            .build();
    }
}
