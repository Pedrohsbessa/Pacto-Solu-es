package br.com.pacto.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class VacancyApplication {

  public static void main(String[] args) {
    SpringApplication.run(VacancyApplication.class, args);
  }
}
