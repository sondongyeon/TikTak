package project.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.project.config.jwt.TokenProvider;
import project.project.domain.Member;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getMemberId();
        Member member = userService.findById(userId);

        return tokenProvider.generateToken(member, Duration.ofHours(2));
    }
}
