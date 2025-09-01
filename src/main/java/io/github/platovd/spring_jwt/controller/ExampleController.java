package io.github.platovd.spring_jwt.controller;

import io.github.platovd.spring_jwt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Пример защищенных endpoint-ов")
public class ExampleController {
    private final UserService userService;

    @Operation(description = "Защищенный endpoint root")
    @GetMapping("/")
    public String root() {
        return "authenticated";
    }

    @Operation(description = "Endpoint только для администраторов")
    @GetMapping("/admin")
    public String admin() {
        return "Ohh, you are admin!";
    }

    @Operation(description = "Endpoint дял получения админки")
    @GetMapping("/get-admin")
    public String getAdmin() {
        userService.getAdmin();
        return "You are admin now!";
    }
}
