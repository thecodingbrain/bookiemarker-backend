package bookiemarker.api.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScrapingResultConsumerConfiguration extends RabbitMqConfiguration
{
	private final static String SCRAPING_RESULT_QUEUE = "scrapingresult.queue";

    @Autowired
    private ScrapingResultConsumer scrapingResultConsumer;

    @Bean
	public Queue scrapingResultQueue() {
		return new Queue(SCRAPING_RESULT_QUEUE);
	}

	@Bean
	public SimpleMessageListenerContainer listenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueueNames(SCRAPING_RESULT_QUEUE);
		container.setMessageListener(messageListenerAdapter());

		return container;
	}

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(scrapingResultConsumer, jsonMessageConverter());
    }
}
