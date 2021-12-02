package converters.BerlinClockTimeConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("converters")
@EnableAsync
public class BerlinClockTimeConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BerlinClockTimeConverterApplication.class, args);
	}

}
