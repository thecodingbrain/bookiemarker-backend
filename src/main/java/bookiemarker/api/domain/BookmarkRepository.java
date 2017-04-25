package bookiemarker.api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface BookmarkRepository extends PagingAndSortingRepository<Bookmark, Long> {
    @RestResource(path = "url")
    List<Bookmark> findByUrlContainingIgnoreCase(@Param("url") String url);
}
