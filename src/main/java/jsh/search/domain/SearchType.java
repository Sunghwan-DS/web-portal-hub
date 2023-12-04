package jsh.search.domain;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum SearchType {
    NONE("", ""),
    ALL("00", "통합"),
    BLOG("01", "블로그");

    private final String code;
    private final String codeName;

    private static final Map<String, SearchType> map = Arrays.stream(values())
                                                             .collect(Collectors.toMap(SearchType::getCode, Function.identity()));

    public static SearchType getType(String code) {
        if (StringUtils.isEmpty(code)) {
            return NONE;
        }
        return map.getOrDefault(code, NONE);
    }
}
