package com.ssp.web;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SuppressWarnings("deprecation")
@ComponentScan(basePackages = {"com.ssp.web"})
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
//@PropertySource("classpath:application.properties")
//@EnableTransactionManagement
//@EnableCaching
public class Application {

	protected static Logger log = LoggerFactory.getLogger(Application.class);

    private static ApplicationContext theApplicationContext;
	
    public static void main(String[] args) {
		Application.start(args);
    }
	
	public static void start(String[] args) {
        //Application.applicationContext = SpringApplication.run Application, args
        //ApplicationContext ctx = SpringApplication.run(Application.class, args);

        log.info("Starting Application with Spring Boot!");

		SpringApplication springApp = new SpringApplication(
			Application.class
			//,AppServices.class
			//,Client.class
			//Package.getPackage("com.ssp.web")
			//,Package.getPackage("com.ssp.")
			);
		//springApp.setWebEnvironment(true);
		Application.theApplicationContext = springApp.run(args);
		log.info("Completed Application startup: " + 
			new ToStringBuilder(theApplicationContext)
				.append("Application Id", theApplicationContext.getId())
				.append("Application Name", theApplicationContext.getApplicationName())
				.append("Display Name", theApplicationContext.getDisplayName())
				.append("Environment", theApplicationContext.getEnvironment())
				.append("StartupDate", theApplicationContext.getStartupDate())
				.toString()
		);
		
        String[] beanNames = theApplicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.info("Found bean: " + beanName);
        }

        log.info("Application started...");
	}
	
	public static void start() {
		Application.start(new String[] {});
	}
	
	public static Object getBean(String name) {
		log.warn("Looking up bean for name: " + name);
		return Application.theApplicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		log.warn("Looking up bean for class: " + clazz.getName());
		return Application.theApplicationContext.getBean(clazz);
	}

	public static ApplicationContext getApplicationContext() {
		return Application.theApplicationContext;
	}
	
//	@Bean(name="dataSource")
//	@Primary
//	@ConfigurationProperties(prefix="spring.datasource")
//	public DataSource dataSource() {
//		DataSourceBuilder dsb = new DataSourceBuilder(null) {
//			public java.lang.Class<? extends DataSource> findType() {
//				return BasicDataSource.class;
//			};
//		};
//		return dsb.build();
//	}


}