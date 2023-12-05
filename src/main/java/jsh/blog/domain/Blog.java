package jsh.blog.domain;

import jsh.search.domain.KakaoBlogDocument;
import lombok.Builder;

@Builder
public record Blog(
    String blogname,
    String contents,
    String thumbnail,
    String title,
    String url
) {
    public static Blog of(KakaoBlogDocument document) {
        return Blog.builder()
                   .blogname(document.blogname())
                   .contents(document.contents())
                   .thumbnail(document.thumbnail())
                   .url(document.url())
                   .build();
    }
}
