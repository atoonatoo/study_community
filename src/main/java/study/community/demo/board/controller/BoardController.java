package study.community.demo.board.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.community.demo.board.entity.Board;
import study.community.demo.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    //메인 화면

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/write")
    public ModelAndView GetBoardWrite() {
        return new ModelAndView("/board/write");
    }

    //글쓰기
    @PostMapping("/write")
    public ModelAndView BoardWrite(Board board) {
        Board boardData = boardRepository.save(board);
        Optional<Board> by = boardRepository.findById(boardData.getBoardId());

        return new ModelAndView("redirect:/board/list")
                .addObject("boardTitle", boardData.getBoardTitle())
                .addObject("boardContent", boardData.getBoardContent());
    }


    @GetMapping("/list")
    public List<Board> BoardList() {
        List<Board> ListFindAll = boardRepository.findAll();
        return ListFindAll;
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Board> BoardRead(@PathVariable Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


//    @GetMapping("/write")
//    public String writeGet(){
//        return "write";
//    }
//
//    @PostMapping("/write")
//    public String writePost(Board board){
//        boardService.boardWrite(board);
//        return "redirect:/board/list";
//    }


//    @GetMapping("/list")
//    public List<Board> BoardList() {
//        return boardRepository.findAll();
//    }

//    @PostMapping("/write")
//    public String BoardWrite(Board board) {
//        Board boardData = boardRepository.save(board);
//        Optional<Board> by = boardRepository.findById(boardData.getBoardId());
//
//        Long testNo = boardData.getBoardId();
//        System.out.println(testNo);
//        return "글번호 : " + boardData.getBoardId();
//    }


}
