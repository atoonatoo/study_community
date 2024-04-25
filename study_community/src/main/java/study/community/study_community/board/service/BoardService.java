package study.community.study_community.board.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.community.demo.board.entity.Board;
import study.community.demo.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public String postCreation(Board board) {
        Board boardBy = boardRepository.save(board);
        Optional<Board> by = boardRepository.findById(boardBy.getBoardId());
        String title = Optional.ofNullable(boardBy.getBoardTitle()).orElse("제목을 입력해주세요.");
        String content = Optional.ofNullable(boardBy.getBoardContent()).orElse("내용을 입력해주세요.");
        return title + content;
    }

    public List<Board> postList() {
        return boardRepository.findAll();
    }

    public Optional<Board> findBoardById(Long id){
        return boardRepository.findById(id);
    }
}
