package study.community.demo.board.dto;

import jakarta.persistence.Column;

public class BoardDto {


    public static class BoardWrite {
        private Long boardId;
        @Column(nullable = false, length = 25)
        private String boardTitle;
        @Column(nullable = false, length = 300)
        private String boardContent;

    }

    public static class BoardList{
        private Long boardId;
        @Column(nullable = false, length = 25)
        private String boardTitle;
        @Column(nullable = false, length = 300)
        private String boardContent;
    }
}
