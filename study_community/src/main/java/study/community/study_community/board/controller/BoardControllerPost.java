package study.community.study_community.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.community.demo.board.entity.Board;
import study.community.demo.board.service.BoardService;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardControllerPost {

    private final BoardService boardService;

    //글쓰기
    @PostMapping("/write")
    public ModelAndView postCreation(Board board) {
        boardService.postCreation(board);
        return new ModelAndView("redirect:/board/list")
                .addObject("boardTitle", board.getBoardTitle())
                .addObject("boardContent", board.getBoardContent());
    }

}
