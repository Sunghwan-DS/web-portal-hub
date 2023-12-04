package jsh.search.controller;

import jsh.search.domain.PopularKeywordsDTO;
import jsh.search.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping("/popular")
    public PopularKeywordsDTO getPopularKeywords() {
        return PopularKeywordsDTO.of(keywordService.getPopularKeywords());
    }
}
