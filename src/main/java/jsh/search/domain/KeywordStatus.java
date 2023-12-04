package jsh.search.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum KeywordStatus {
    SUCCESS("01", "성공"),
    FAIL("02", "실패");

    private final String code;
    private final String codeName;
}
