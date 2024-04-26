package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMemberId(Long member_Id);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
