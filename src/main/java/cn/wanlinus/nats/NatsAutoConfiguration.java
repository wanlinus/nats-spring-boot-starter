package cn.wanlinus.nats;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Nats自动配置
 *
 * @author wanli
 * @date 2018-08-29
 */
@Configuration
@EnableConfigurationProperties(NatsProperties.class)
@ConditionalOnClass(Nats.class)
public class NatsAutoConfiguration {

    /**
     * Spring Boot的自动配置机制依靠@ConditionalOnMissingBean注解判断是否执行初始化代码,
     * 即如果用户已经创建了bean,则相关的初始化代码不再执行
     *
     * @param properties Nats配置信息
     * @return Nats Client
     */
    @Bean
    @ConditionalOnClass(Nats.class)
    public Connection nats(NatsProperties properties) throws IOException, InterruptedException {
        Options opts = new Options.Builder()
                .servers(properties.getUrls())
                .maxReconnects(-1)
                .build();
        return Nats.connect(opts);
    }
}
