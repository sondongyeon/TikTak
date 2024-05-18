# 짧은 영상 조회수에 따른 정산 시스템

## 1. 프로젝트 개요
- 짧은 영상을 업로드, 조회수에 따라 정산을 도와주는 시스템입니다.
- 유저는 짧은 영상을 업로드하고, 각 영상의 조회수에 따라 00:00 정각에 수익 정산을 진행합니다.
- 소셜 로그인을 통한 간편한 로그인 및 회원 가입을 진행합니다.

## 팀원 
<img src="https://github.com/sondongyeon/TikTak/assets/121774504/0441f2b2-1cf9-4127-a3f3-0a5fd4184db8" width='200' height='200'/>

- 손동연 / BE 및 프로젝트 기획, 설계

## 개발환경
- Back-end : Spring Boot
- DB : Mysql
- ORM : JPA
- 버전업 & 이슈관리 : github, notion
- 서비스 배포 환경 : docker

## ERD

<img src="https://github.com/sondongyeon/TikTak/assets/121774504/092d559e-5dd9-4869-8dd5-82456d4d96ec" width='600' height='400'/>


## 프로젝트 구조

<br>

```plain text
📦src
 ┣ 📂main
 ┃ ┣ 📂generated
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtProperties.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenProvider.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂oauth
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuth2AuthorizationRequestBasedOnCookieRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuth2SuccessHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OAuth2UserCustomService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SchedulerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenAuthenticationFilter.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WebOAuthSecurityConfig.java
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜StatisticController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenApiController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserApiController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserViewController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoApiController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜VideoViewController.java
 ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Advertisement.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Member.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PlayHistory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshToken.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Statistics.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Video.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜VideoAdvertisement.java
 ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CreateAccessTokenRequest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CreateAccessTokenResponse.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PlayHistoryDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜StatsDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜TopFiveVideoDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜TopFiveVideoInterface.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoListViewResponse.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoResponse.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜VideoViewResponse.java
 ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AdvertisementRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PlayHistoryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshTokenRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜StatisticsRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoAdvertisementRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜VideoRepository.java
 ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PlayHistoryService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshTokenService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜StatisticsService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜VideoAdvertisementService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜VideoService.java
 ┃ ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CookieUtil.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜RandomNumberGenerator.java
 ┃ ┃ ┃ ┃ ┗ 📜ProjectApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┗ 📜article.js
 ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┣ 📜login.html
 ┃ ┃ ┃ ┣ 📜signup.html
 ┃ ┃ ┃ ┗ 📜videoList.html
 ┃ ┃ ┗ 📜application.yml
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenApiController.java
 ┃ ┃ ┃ ┃ ┣ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtFactory.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenTest.java
 ┃ ┃ ┃ ┃ ┗ 📜ProjectApplicationTests.java

```

</br>

## 개발 기간

- 개발 기간 : 24.04.17 ~ 24.05.08

## 개발 일정
- 1주차 : ERD 설계, docker compose를 활용한 개발 환경 구축, 소셜 로그인 기능 구현
- 2주차 : 소셜 로그인 기능 구현, JWT 토큰을 활용한 로그인 기능 구현
- 3주차 : 

  
## 작업 관리
- 작업 관리 : git, notion을 통한 관리
- https://erratic-noodle-609.notion.site/e0eabd28ca30417f81d80de3cd0bdf8d?pvs=4
- 방식 : 매일 아침 프로젝트 정리를 통해 프로젝트 진행상황 확인 및 정리

## 트러블 슈팅

### 로그인시 인증 문제

- 문제점 : JWT토큰 생성시 member_id를 db에서 칼럼을 찾지 못해 오류 발생
- 해결 방안 : log 검색 결과 db에 JPA를 통한 칼럼 생성이 되지 않는 부분을 확인할 수 있었고, db에 먼저 칼럼 생성을 통해 오류 해결
<br>

```java
  private String makeToken(Date expiry, Member member) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setSubject(member.getEmail())
                .claim("member_id", member.getId())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

```


</br>

### OAuth2를 이용한 소셜 로그인 문제

- 문제점 : 현재 OAuth2라이브러리에 deprecated된 기능들이 많아 사용에 문제점 발생
- 해결 방안 : 현재는 bean 등록을 통해서 사용을 하는것을 공식 문서에서 권장하고 있음을 확인 

<br>

```java
 public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Member member = userService.findByEmail((String) oAuth2User.getAttributes().get("email"));

        String refreshToken = tokenProvider.generateToken(member, REFRESH_TOKEN_DURATION);
        saveRefreshToken(member.getId(), refreshToken);
        addRefreshTokenToCookie(request, response, refreshToken);

        String accessToken = tokenProvider.generateToken(member, ACCESS_TOKEN_DURATION);
        String targetUrl = getTargetUrl(accessToken);

        clearAuthenticationAttributes(request, response);

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
```

</br>

### 동영상 조회수 초기화 문제

- 문제점 : 정산시에 조회수가 0으로 초기화 되는 문제 발생
-  





