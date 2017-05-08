package bookiemarker.api.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskProducerConfiguration extends RabbitMqConfiguration
{
    protected final String TASKS_QUEUE = "tasks.queue";

    @Bean
    public RabbitTemplate rabbitTemplate()
    {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.TASKS_QUEUE);
        template.setQueue(this.TASKS_QUEUE);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public Queue tasksQueue()
    {
        return new Queue(this.TASKS_QUEUE);
    }
}
