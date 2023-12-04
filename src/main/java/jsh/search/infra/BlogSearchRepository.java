package jsh.search.infra;

import jsh.search.domain.PopularKeyword;
import jsh.search.domain.entity.SearchKeywordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogSearchRepository extends JpaRepository<SearchKeywordsEntity, Long> {

    SearchKeywordsEntity findByKeyword(String keyword);
    List<PopularKeyword> findTop10ByOrderBySearchCountDesc();
}
