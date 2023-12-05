package jsh.search.domain;

import lombok.Builder;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Builder
public record Blogs(List<Blog> list) {

    public static Blogs emptyOf() {
        return Blogs.builder()
                    .build();
    }

    public static Blogs of(List<Blog> list) {
        return CollectionUtils.isEmpty(list)
               ? emptyOf()
               : Blogs.builder().list(List.copyOf(list)).build();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
