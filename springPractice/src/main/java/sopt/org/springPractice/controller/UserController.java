package sopt.org.springPractice.controller;

import com.mysql.cj.log.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.springPractice.common.dto.ApiResponse;
import sopt.org.springPractice.config.jwt.JwtService;
import sopt.org.springPractice.controller.dto.UserLoginRequestDto;
import sopt.org.springPractice.controller.dto.UserLoginResponseDto;
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
    private final JwtService jwtService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }
}
