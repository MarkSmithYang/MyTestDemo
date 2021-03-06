package com.yb.demo.neo4j;

import java.net.InetAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.ddb.demo.neo4j.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		InetAddress ia = null;
		String localname = null;
		String localip = null;
		try {
			ia = InetAddress.getLocalHost();
			localname = ia.getHostName();
			localip = ia.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ApiInfoBuilder().title("demo测试").description("自创服务平台@" + localname)
				.termsOfServiceUrl("http://" + localip + "/swagger-ui.html").contact("自创服务平台").version("1.0").build();
	}

}