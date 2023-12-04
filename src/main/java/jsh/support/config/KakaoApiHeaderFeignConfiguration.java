package jsh.support.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KakaoApiHeaderFeignConfiguration {

    @Value("${kakao.rest-api-key}")
    private String KAKAO_REST_API_KEY;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", getAuthorization());
        };
    }

    private String getAuthorization() {
        return "KakaoAK " + KAKAO_REST_API_KEY;
    }
}
