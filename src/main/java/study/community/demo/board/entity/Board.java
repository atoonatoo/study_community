package study.community.demo.board.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

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
//    private LocalDateTime boardDate;
//    private Integer boardParticipants;
//    //일정 게시물 필드 변수
//    private Long scheduleId;
//    private String scheduleTitle;
//    private String scheduleContent;
//    private LocalDateTime scheduleDate;
//    private String assignmentSubmissionUpload;

}
