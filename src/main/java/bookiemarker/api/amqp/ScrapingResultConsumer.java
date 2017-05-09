package bookiemarker.api.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bookiemarker.api.domain.Bookmark;
import bookiemarker.api.domain.BookmarkRepository;

import java.awt.print.Book;
import java.util.List;

@Component
public class ScrapingResultConsumer
{
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public void handleMessage(ScrapingResultMessage scrapingResultMessage)
    {
        System.out.println("Received summary: " + scrapingResultMessage.getSummary());
        final String url = scrapingResultMessage.getUrl();
        List<Bookmark> bookmarks = bookmarkRepository.findByUrl(url);
        for(Bookmark bookmark : bookmarks)
        {
            bookmark.setTitle(scrapingResultMessage.getTitle());
            bookmark.setThumbnail(scrapingResultMessage.getThumbnail());
            bookmark.setSummary(scrapingResultMessage.getSummary());
            bookmarkRepository.save(bookmark);
            System.out.println("Updated bookmark: " + url);
        }
    }
}
