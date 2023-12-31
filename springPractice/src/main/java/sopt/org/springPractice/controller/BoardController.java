package sopt.org.springPractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.springPractice.common.dto.ApiResponse;
import sopt.org.springPractice.config.jwt.JwtService;
import sopt.org.springPractice.config.resolver.UserId;
import sopt.org.springPractice.controller.dto.BoardRequestDto;
import sopt.org.springPractice.exception.Success;
import sopt.org.springPractice.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
