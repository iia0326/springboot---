package com.kangyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步配置
 *
 * @author ywy
 * @date 2020-07-13 1:41
 */
@EnableAsync
@Configuration
public class AsyncConfig {
    @Bean(name = "MyThreadPool")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setQueueCapacity(250);
        executor.setMaxPoolSize(500);
        executor.setThreadNamePrefix( "页的线程" );
        return executor;
    }
}
