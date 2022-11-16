package pl.dawid.springBootJPA_ProgramowanieSieciowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootJpaProgramowanieSiecioweApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProgramowanieSiecioweApplication.class, args);
	}

}
