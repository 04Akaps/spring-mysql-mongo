package spring.db.com.mysqlmongo.dto;


import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "write")
    private String writer;
    @NotBlank(message = "title")
    private String title;
    @NotBlank(message = "board")
    private String board;
    @NotBlank(message = "content")
    private String content;

    private int hits;
    private String pass;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
