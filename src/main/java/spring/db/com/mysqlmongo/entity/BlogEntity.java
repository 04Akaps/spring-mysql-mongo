package spring.db.com.mysqlmongo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BlogEntity {
    @Id
    private Long id;

}
