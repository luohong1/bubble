package org.bubble.swagger.config;

import com.google.common.base.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"org.bubble.*"})
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket customDocket() {
        //
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact("luohong", "https://www.baidu.com", "949525910@qq.com");
        return new ApiInfoBuilder().title("bubble-deplat前台API接口")//大标题 title
                .description("bubble-deplat v1.0.0")//小标题
                .version("1.0.0")//版本
                .termsOfServiceUrl("www.baidu.com")//termsOfServiceUrl
                .contact(contact)//作者
               .build();
    }
}