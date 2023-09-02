package spring.db.com.mysqlmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MysqlMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlMongoApplication.class, args);
	}

}
