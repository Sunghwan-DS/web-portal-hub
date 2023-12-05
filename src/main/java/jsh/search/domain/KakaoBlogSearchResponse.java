package jsh.search.domain;

import java.util.List;

public record KakaoBlogSearchResponse(
    List<KakaoBlogDocument> documents,
    KakaoBlogMeta meta
) {
}
