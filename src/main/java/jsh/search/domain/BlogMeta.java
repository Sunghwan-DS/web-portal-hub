package jsh.search.domain;

import lombok.Builder;

@Builder
public record BlogMeta(
    boolean isEnd,
    int pageableCount,
    int totalCount
) {
    public static BlogMeta of(KakaoBlogMeta meta) {
        return BlogMeta.builder()
                       .isEnd(meta.isEnd())
                       .pageableCount(meta.pageableCount())
                       .totalCount(meta.totalCount())
                       .build();
    }
}
