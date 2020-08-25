package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.db.TransportDB;

import javax.sql.DataSource;

@SpringBootApplication
public class RozliczeniePojazduRestJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RozliczeniePojazduRestJdbcApplication.class, args);
	}

	@Bean
	public TransportDB transportDB(NamedParameterJdbcTemplate template){
		return new TransportDB(template);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}

}
