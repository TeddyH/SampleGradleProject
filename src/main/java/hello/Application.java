package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2014-12-29.
 */

@SpringBootApplication
public class Application {
//    extends SpringBootServletInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    //    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
//    @Bean
//    protected ServletContextListener listener() {
//        return new ServletContextListener() {
//            @Override
//            public void contextInitialized(ServletContextEvent sce) {
//                logger.info("================================== ServletContext initialized");
//            }
//
//            @Override
//            public void contextDestroyed(ServletContextEvent sce) {
//                logger.info("================================== ServletContext destroyed");
//            }
//        };
//    }

    // 결과를 출력시 강제로 UTF-8로 설정
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    // POST 요청시 한글이 깨지는 문제를 보완
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
