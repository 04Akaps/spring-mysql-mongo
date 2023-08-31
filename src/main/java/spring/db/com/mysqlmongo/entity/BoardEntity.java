package spring.db.com.mysqlmongo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@Entity
@Table(name = "board")
@EntityListeners({AuditingEntityListener.class, LoggingApplicationListener.class})
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Getter
@Setter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "write")
    private String writer;
    @NotBlank(message = "title")
    private String title;
    @NotBlank(message = "board")
    private String board;
    @NotBlank(message = "content")
    private String content;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    @PrePersist
    public void onPrePersist() {
        // 데이터 삽입 전에 실행
        System.out.println("Entity is being created: " + this.toString());
    }
    @PreUpdate
    public void onPreUpdate() {
        // 업데이트 전에 실행될 로깅 로직
        System.out.println("Entity is being updated: " + this.toString());
    }

    @PreRemove
    public void onPreRemove() {
        // 삭제 전에 실행될 로깅 로직
        System.out.println("Entity is being deleted: " + this.toString());
    }

}
