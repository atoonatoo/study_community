package study.community.study_community.board.entity;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Board {
    // 스터디 게시물 필드 변수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(name = "boardTitle", nullable = false, length = 25)
    private String boardTitle;

    @Column(name = "boardContent",nullable = false, length = 200)
    private String boardContent;


}
