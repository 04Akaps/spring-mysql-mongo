package spring.db.com.mysqlmongo.dto;

import lombok.*;

import java.io.Writer;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 변수를 받아야 하느 생성자
public class BoardDTO {
    private Long id;

    private String writer;

    private String title;

    private String board;

    private String content;

    private int hits;
    private String pass;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
