package bookiemarker.api;

import bookiemarker.api.domain.BookmarkEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookieMarkerApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BookieMarkerApiApplication.class, args);
    }

    @Bean
    public BookmarkEventHandler bookmarkEventHandler(){
        return new BookmarkEventHandler();
    }
}
