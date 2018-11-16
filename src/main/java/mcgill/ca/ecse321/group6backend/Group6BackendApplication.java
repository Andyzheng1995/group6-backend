package mcgill.ca.ecse321.group6backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class Group6BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group6BackendApplication.class, args);
	}

  @RequestMapping("/")
  public String greeting(){
    return "Hello world!";
  }
}
