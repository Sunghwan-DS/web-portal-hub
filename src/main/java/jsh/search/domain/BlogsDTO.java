package jsh.search.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class BlogsDTO {

    List<Blog> list;
    BlogMeta meta;

    public static BlogsDTO emptyOf() {
        return BlogsDTO.builder()
                       .build();
    }

    public static BlogsDTO of(KakaoBlogSearchResponse response) {
        return BlogsDTO.builder()
                       .list(response.documents().stream()
                                     .map(Blog::of).toList())
                       .meta(BlogMeta.of(response.meta()))
                       .build();
    }
}
