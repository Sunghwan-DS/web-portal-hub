package jsh.search.domain;

import lombok.Builder;

@Builder
public record SearchResponse() {
    public static SearchResponse of() {
        return SearchResponse.builder()
                             .build();
    }
}
