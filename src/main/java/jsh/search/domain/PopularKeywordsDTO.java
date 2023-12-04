package jsh.search.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class PopularKeywordsDTO {

    List<PopularKeyword> list;

    public static PopularKeywordsDTO emptyOf() {
        return PopularKeywordsDTO.builder()
                                 .build();
    }

    public static PopularKeywordsDTO of(PopularKeywords popularKeywords) {
        return popularKeywords.isEmpty()
               ? emptyOf()
               : PopularKeywordsDTO.builder()
                                   .list(List.copyOf(popularKeywords.list()))
                                   .build();
    }
}
