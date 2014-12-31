package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2014-12-29.
 */

@SpringBootApplication
public class Application {
//    extends SpringBootServletInitializer {

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
