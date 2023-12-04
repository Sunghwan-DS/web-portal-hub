package jsh.search.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "SEARCH_KEYWORDS")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SearchKeywordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KEYWORD")
    private String keyword;
    @Column(name = "SEARCH_COUNT")
    private Long searchCount;

    public static SearchKeywordsEntity create(String keyword) {
        return SearchKeywordsEntity.builder()
                                   .keyword(keyword)
                                   .searchCount(1L)
                                   .build();
    }

    public static SearchKeywordsEntity increasedOf(SearchKeywordsEntity searchKeywordsEntity) {
        return SearchKeywordsEntity.builder()
                                   .id(searchKeywordsEntity.id)
                                   .keyword(searchKeywordsEntity.keyword)
                                   .searchCount(searchKeywordsEntity.searchCount + 1)
                                   .build();
    }
}
