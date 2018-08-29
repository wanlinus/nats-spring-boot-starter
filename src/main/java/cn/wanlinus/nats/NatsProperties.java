package cn.wanlinus.nats;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Nats配置文件， 从application.propertise(.yml)中获取
 *
 * @author wanli
 * @date 2018-08-29
 */
@ConfigurationProperties(prefix = "spring.nats")
public class NatsProperties {
    /**
     * Nats链接url,默认链接本地
     */
    private String[] urls = {"nats://127.0.0.1:4222"};

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
}
