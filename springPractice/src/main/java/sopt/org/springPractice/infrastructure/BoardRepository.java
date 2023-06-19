package sopt.org.springPractice.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.springPractice.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ

    // UPDATE

    // DELETE
}
