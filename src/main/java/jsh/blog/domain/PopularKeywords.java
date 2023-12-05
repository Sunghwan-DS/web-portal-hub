package jsh.blog.domain;

import lombok.Builder;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Builder
public record PopularKeywords(List<PopularKeyword> list) {

    public static PopularKeywords emptyOf() {
        return PopularKeywords.builder()
                              .build();
    }

    public static PopularKeywords of(List<PopularKeyword> list) {
        return CollectionUtils.isEmpty(list)
               ? emptyOf()
               : PopularKeywords.builder()
                                .list(List.copyOf(list))
                                .build();
    }

    public boolean isEmpty() {
        return list().isEmpty();
    }
}
