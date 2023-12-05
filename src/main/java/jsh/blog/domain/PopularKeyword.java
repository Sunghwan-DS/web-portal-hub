package jsh.blog.domain;

public record PopularKeyword(
    String keyword,
    long searchCount
) {
}
