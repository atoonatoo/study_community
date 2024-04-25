package study.community.study_community.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.community.demo.board.entity.Board;
import study.community.demo.board.service.BoardService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    //메인 화면
    @GetMapping("/")
    public String index() {
        return "home";
    }


    //게시판 글쓰기 화면 보기
    @GetMapping("/write")
    public ModelAndView postCreationView() {
        return new ModelAndView("/board/write");
    }


    //게시판 조회
    @GetMapping("/list")
    public List<Board> postList() {
        return boardService.postList();
    }

    //글 읽기
    @GetMapping("/read/{id}")
    public ResponseEntity<Board> PostReading(@PathVariable Long id) {
        Optional<Board> board = boardService.findBoardById(id);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
