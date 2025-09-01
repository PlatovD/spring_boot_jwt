package io.github.platovd.spring_jwt.repository;

import io.github.platovd.spring_jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<RefreshToken, Long> {
}
