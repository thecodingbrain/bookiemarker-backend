package bookiemarker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import bookiemarker.api.domain.BookmarkEventHandler;
import bookiemarker.api.filter.CORSFilter;

@SpringBootApplication
public class BookieMarkerApiApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BookieMarkerApiApplication.class, args);
    }

    @Bean
    BookmarkEventHandler bookmarkEventHandler()
    {
        return new BookmarkEventHandler();
    }

    @Bean
    public FilterRegistrationBean commonsRequestLoggingFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CORSFilter());
        return registrationBean;
    }
}
