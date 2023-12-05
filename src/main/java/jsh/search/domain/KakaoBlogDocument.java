package jsh.search.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record KakaoBlogDocument(
    String blogname,
    String contents,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    LocalDateTime datetime,
    String thumbnail,
    String title,
    String url
) {
}
