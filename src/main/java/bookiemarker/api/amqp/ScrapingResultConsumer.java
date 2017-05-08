package bookiemarker.api.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bookiemarker.api.domain.Bookmark;
import bookiemarker.api.domain.BookmarkRepository;

import java.util.List;

@Component
public class ScrapingResultConsumer
{
    public void handleMessage(ScrapingResultMessage scrapingResultMessage)
    {
        System.out.println("Received summary: " + scrapingResultMessage.getSummary());
    }
}
