package spring.db.com.mysqlmongo.config;


import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Getter
    private MongoClient client;

    @Bean
    public void mongoDbClient() {
        String connectionString = "mongodb+srv://" + this.mongoHost + "/?retryWrites=true&w=majority";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        this.client =MongoClients.create(settings);
    }

    public MongoDatabase newDatabase(String database) {
        try {
            return this.client.getDatabase(database);
        } catch (MongoException e) {
            e.printStackTrace();
            return null;
        }
    }

}
