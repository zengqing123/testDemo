package com.example.testDemo.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//参考：http://blog.csdn.net/catoop/article/details/50668896
//swagger-ui.html
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.basePackage("com.example.testDemo.api")按照包路径创建接口文档 
                //.withMethodAnnotation(ApiOperation.class) 按照注解创建接口文档 
                .paths(PathSelectors.any())
                .build();
    }

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试Demo API")
                //.description("官网：http://chinaunicom.com.cn")
                //.termsOfServiceUrl("http://chinaunicom.com.cn")
                .contact("CRM")
                .version("1.0")
                .build();
    }

}