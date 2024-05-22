# 짧은 영상 조회수에 따른 정산 시스템

## 1. 프로젝트 개요
- 짧은 영상을 업로드, 조회수에 따라 정산을 도와주는 시스템입니다.
- 유저는 짧은 영상을 업로드하고, 각 영상의 조회수에 따라 00:00 정각에 수익 정산을 진행합니다.
- 소셜 로그인을 통한 간편한 로그인 및 회원 가입을 진행합니다.

## 팀원(BE 1명)

<img src="https://github.com/sondongyeon/TikTak/issues/4#issue-2309771449" width='200' height='200'/>

- 손동연 / BE 및 프로젝트 기획, 설계

## 개발환경
- Back-end : Spring Boot
- DB : Mysql
- ORM : JPA
- 버전업 & 이슈관리 : github, notion
- 서비스 배포 환경 : docker


## ERD

<details>
 
 <summary>ERD</summary>
 
 <div markdown = '1'>
  
<img src="https://github.com/sondongyeon/TikTak/assets/121774504/092d559e-5dd9-4869-8dd5-82456d4d96ec" width='600' height='400'/>

 </div>
 
</details>

## 프로젝트 구조

<details>
 
 <summary>프로젝트 구조 </summary>
 
 <div markdown = '2'>
  
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

</div>

</details>

## 트러블 슈팅

### 00:00 프로젝트 업데이트시 조회수가 0으로 업데이트 되는 문제
- 문제점 : Spring Schedule을 이용해 00:00에 프로젝트 업데이트 진행시 회원별 조회수가 0으로 모두 출력되는 현상 발생
- 원인 : docker-compose 사용시, docker container의 휘발성 때문에 이런 문제가 생길 수 있는 현상임을 확인
- 참고 url : https://simgee.tistory.com/44
- 참고 자료 : https://docs.docker.com/storage/volumes/#use-a-volume-with-docker-compose 
- 해결 방안 : docker 설정 파일에 volumes를 설정해 줌으로써 container가 삭제되더라도, 데이터를 영속화 할 수 있게 만들었음.

```compose.yaml
    volumes:
      - ./db/conf.d:/etc/mysql/conf.d
      - ./db/initdb.d:/docker-entry-point-initdb.d
```

### 일반 영상 조회수와 광고 영상 조회수가 분할되어 증가하지 않는 현상
- 문제점 : 일반 영상 시청시와 광고 영상 시청시 조회수가 분할되어 인식되게끔 만들었지만, timeout error발생 
- 원인 : 각각 영상 시청 시간 업데이트가 교착상태에 빠져 dead lock 현상 발생
- 참고 URL : https://velog.io/@gsuchoi/DB-Transaction-DeadLock%EA%B5%90%EC%B0%A9%EC%83%81%ED%83%9C
- 참고 자료 : https://www.postgresql.org/docs/9.4/explicit-locking.html,
             https://chanhuiseok.github.io/posts/cs-2/,
             https://myjamong.tistory.com/181,
             https://sosopro.tistory.com/55
- 해결 방안 : 일반 영상 길이 부분 @Transactional 어노테이션 삭제 후 서버 재시작을 통해 오류 해결

```java
    public int getLength(long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        return video.getLength();
    }
```

## 개선 방향

1. Spring Batch를 이용해 대용량 트래픽 처리가 가능하게 만들기 / 현재 진행중
2. 코드의 재사용 가능성을 높여 서버 응답 속도 높이기
  

