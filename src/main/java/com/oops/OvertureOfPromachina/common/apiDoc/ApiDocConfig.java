package com.oops.OvertureOfPromachina.common.apiDoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class ApiDocConfig {
    //접속주소:http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Overture-Of-Promachina")
                .description("배팅 시스템")
                .version("1.0.0");
        return new OpenAPI().info(info);
    }
}
