package jsh.search.infra;

import jsh.search.domain.entity.SearchKeywordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogSearchRepository extends JpaRepository<SearchKeywordsEntity, Long> {

    SearchKeywordsEntity findByKeyword(String keyword);
}
