package io.github.platovd.spring_jwt.controller;

import io.github.platovd.spring_jwt.dto.JWTAuthenticationResponse;
import io.github.platovd.spring_jwt.dto.RefreshRequest;
import io.github.platovd.spring_jwt.dto.SignInRequest;
import io.github.platovd.spring_jwt.dto.SignUpRequest;
import io.github.platovd.spring_jwt.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JWTAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JWTAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @Operation(summary = "Обновление токенов доступа")
    @PostMapping("/refresh")
    private JWTAuthenticationResponse refresh(@RequestBody @Valid RefreshRequest request) {
        return authenticationService.refresh(request);
    }
}
