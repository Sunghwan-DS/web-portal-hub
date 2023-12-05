package jsh.search.domain;

import java.time.LocalDateTime;

public record KakaoBlogDocument(
    String blogname,
    String contents,
    LocalDateTime dateTime,
    String thumbnail,
    String title,
    String url
) {
}
