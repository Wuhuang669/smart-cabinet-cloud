package com.smartcabinet.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 接口文档配置，各业务服务引入 common-core 后可复用该 OpenAPI 基础信息。
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI smartCabinetOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("智能无人货柜系统接口文档")
                        .description("Spring Cloud 微服务接口文档")
                        .version("0.0.1"));
    }
}
