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
public enum SortType {

    ACCURACY("accuracy", "정확도순"),
    RECENCY("recency", "최신순");

    private final String code;
    private final String codeName;

    private static final Map<String, SortType> map = Arrays.stream(values())
                                                             .collect(Collectors.toMap(SortType::getCode, Function.identity()));

    public static SortType getType(String code) {
        if (StringUtils.isEmpty(code)) {
            return ACCURACY;
        }
        return map.getOrDefault(code, ACCURACY);
    }
}
