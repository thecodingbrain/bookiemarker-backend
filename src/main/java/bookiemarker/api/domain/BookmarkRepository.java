package bookiemarker.api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long>{
    @RestResource(path = "url")
    List<Bookmark> findByUrlContainingIgnoreCase(@Param("url") String url);
}
