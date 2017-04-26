package bookiemarker.api.domain;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RepositoryEventHandler
public class BookmarkEventHandler {

    @HandleBeforeCreate
    public void handleBookmarkCreate(Bookmark bookmark){
        bookmark.setCreated(new Date());
    }
}
