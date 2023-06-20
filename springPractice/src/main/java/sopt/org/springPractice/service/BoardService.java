package sopt.org.springPractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.springPractice.controller.dto.BoardRequestDto;
import sopt.org.springPractice.domain.Board;
import sopt.org.springPractice.domain.User;
import sopt.org.springPractice.exception.Error;
import sopt.org.springPractice.exception.model.NotFoundException;
import sopt.org.springPractice.infrastructure.BoardRepository;
import sopt.org.springPractice.infrastructure.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(Long userId, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}
