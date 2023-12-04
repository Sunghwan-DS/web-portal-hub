package jsh.search.infra;

import jsh.support.config.KakaoApiHeaderFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="kakao-search", url="https://dapi.kakao.com/v2/search", configuration = KakaoApiHeaderFeignConfiguration.class)
public interface KakaoSearchClient {

    @GetMapping("/blog")
    Object searchBlog(@RequestParam("query") String query,
                     @RequestParam("sort") String sort,
                     @RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size);
}
