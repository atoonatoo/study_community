package study.community.demo.board.dto;

import jakarta.persistence.Column;

public class ListDto {

    private Long boardId;
    @Column(nullable = false, length = 25)
    private String boardTitle;
    @Column(nullable = false, length = 300)
    private String boardContent;
}
