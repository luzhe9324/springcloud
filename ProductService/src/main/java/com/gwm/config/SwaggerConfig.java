package com.gwm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration/*配置到springboot配置里*/
@EnableSwagger2/*开启swagger2*/
public class SwaggerConfig {

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.deme.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("luzhe大标题")
                .description("springboot swagger2")
                .termsOfServiceUrl("http://baidu.com")
                .contact(new Contact("luzhe", "http://baidu.com", "1105266393@qq.com"))
                .build();

    }



}
