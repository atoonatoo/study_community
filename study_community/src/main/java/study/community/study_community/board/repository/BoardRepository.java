package study.community.study_community.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.community.demo.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {


}
