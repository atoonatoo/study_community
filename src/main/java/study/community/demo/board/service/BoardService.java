package study.community.demo.board.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import study.community.demo.board.entity.Board;
import study.community.demo.board.repository.BoardRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public Map<String, String> postCreation(Board board) {
        Map<String, String> result = new HashMap<>();
        Board boardBy = boardRepository.save(board);
        Optional<Board> by = boardRepository.findById(boardBy.getBoardId());
        result.put("title", Optional.ofNullable(boardBy.getBoardTitle()).orElse("제목을 입력해주세요."));
        result.put("content", Optional.ofNullable(boardBy.getBoardContent()).orElse("내용을 입력해주세요."));

        return result;
    }

    public List<Board> postList() {
        return boardRepository.findAll();
    }

        public Board findBoardById(Long id) {
            return boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("게시물이 존재하지 않습니다."));
        }
}
