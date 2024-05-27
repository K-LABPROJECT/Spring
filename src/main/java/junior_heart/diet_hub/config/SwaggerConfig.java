package junior_heart.diet_hub.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "DietHub 백엔드 API 명세",
                description = "케이랩 프로젝트 diethub 백엔드 API 명세",
                version = "1.0",
                contact = @Contact(
                        name = "springdoc 공식문서",
                        url = "https://springdoc.org/"
                )
        )
)
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components());
    }
}
