package es.w2m.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class W2mSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(W2mSpringBootApplication.class, args);
  }

}
