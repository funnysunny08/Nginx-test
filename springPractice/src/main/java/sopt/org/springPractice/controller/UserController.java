package sopt.org.springPractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.springPractice.common.dto.ApiResponse;
import sopt.org.springPractice.controller.dto.UserRequestDto;
import sopt.org.springPractice.controller.dto.UserResponseDto;
import sopt.org.springPractice.exception.Success;
import sopt.org.springPractice.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }
}
