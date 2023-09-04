package spring.db.com.mysqlmongo.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Blog")
public class Blog {
    @Id
    private Long id;

    private String Title;

    private String Content;

}
