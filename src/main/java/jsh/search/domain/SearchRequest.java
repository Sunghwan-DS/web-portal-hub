package jsh.search.domain;

import lombok.Builder;

@Builder
public record SearchRequest(
    String keyword,
    SortType sortType,
    SearchType searchType,
    int page,
    int size
) {
    public static SearchRequest of(String keyword,
                                   String sortType,
                                   SearchType searchType,
                                   int page,
                                   int size) {
        return SearchRequest.builder()
                            .keyword(keyword)
                            .sortType(SortType.getType(sortType))
                            .searchType(searchType)
                            .page(page).
                            size(size)
                            .build();
    }
}
