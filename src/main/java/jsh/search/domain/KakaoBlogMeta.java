package jsh.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KakaoBlogMeta(
    @JsonProperty("is_end") boolean isEnd,
    @JsonProperty("pageable_count") int pageableCount,
    @JsonProperty("total_count") int totalCount
) {
}
