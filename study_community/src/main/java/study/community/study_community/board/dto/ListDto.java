package study.community.study_community.board.dto;

import jakarta.persistence.Column;

public class ListDto {

    public static class BoardList{
        private Long boardId;
        @Column(nullable = false, length = 25)
        private String boardTitle;
        @Column(nullable = false, length = 300)
        private String boardContent;
    }
}
