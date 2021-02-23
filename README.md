# CHABIT

공통-Sub PJT II 프로젝트를 위한 저장소 입니다.

## 팀소개

- 팀명 : 살찐개
- **참여자**
  - 팀장 : 김민혁
  - 팀원 : 윤지해, 이동훈, 백정현, 이아름
- **역할 분담**
  - **프론트**  
     이아름, 이동훈, 윤지해
  - **백엔드**  
     백정현, 김민혁
  - **QA**  
     백정현, 윤지해, 이동훈
  - **UI/UX 디자이너**  
     백정현
  - **테크리더**  
     김민혁
  - **기획**  
     이아름

## 주제

### CHABIT

- **Challenge to Habit - 새로운 습관에 도전하다.**

## 주요 기능

- 새로운 습관을 만들거나 꾸준함을 목표로 하는 사람들을 위해<br>다른 사람들과 함께 도전 할 수 있는 챌린지를 제공합니다.

- 챌린지 성공 시 인증서와 포인트를 통해 동기부여를 얻습니다.

- 리뷰를 통해 다른 유저들과의 소통과 취미 또는 습관에 대한 공유 기능을 제공합니다.

- 챌린지 인증을 하기 위해 랜덤으로 제시되는 손동작을 함께 올리도록 합니다.

## 실행 화면

![인트로](/산출물/동작GIF/1-인트로.gif)

처음 사이트 접속화면 입니다.

![로그인](/산출물/동작GIF/2-로그인.gif)

로그인입니다.

![랭킹](/산출물/동작GIF/5-랭킹.gif)

랭킹은 팔로우, 전체 / 카테고리 별/ 한달, 전체를 기준으로 정렬합니다.

![마이챌린지](/산출물/동작GIF/6-마이챌린지.gif)

마이리뷰에서 현재 진행중인 챌린지 별로 당일 달력에 표시됩니다.

![마이리뷰및댓글](/산출물/동작GIF/7-마이리뷰및댓글.gif)

챌린지가 끝나고 리뷰를 남긴 후 그것에 대한 댓글까지 입니다.

![팔로우팔로잉](/산출물/동작GIF/8-팔로우팔로잉.gif)

현재 팔로우 된 사람과 팔로잉 된 사람, 검색 입니다.

![타유저리뷰및업적](/산출물/동작GIF/9-타유저리뷰및업적.gif)

타 유저의 리뷰 및 업적을 봅니다.

![챌린지생성1](/산출물/동작GIF/10-챌린지생성1.gif)

챌린지 생성 과정입니다.

![챌린지생성4](/산출물/동작GIF/13-챌린지생성4.gif)

챌린지 생성 과정입니다.

![챌린지디테일및인증](/산출물/동작GIF/14-챌린지디테일및인증.gif)

챌린지에 대한 상세정보와 인증을 다룹니다.

## 개발환경

|   분류   |                                        정보                                         |
| :------: | :---------------------------------------------------------------------------------: |
| 운영체제 |                                     Windows 10                                      |
| 개발 툴  | Spring Tools 4.9.0 - WINDOWS 64-BIT<br>IntelliJ IDEA Ultimate<br>Visual Studio Code |
|   JDK    |                                     JAVA 8이상                                      |

## 기술 스택

|    분류    |                          기술                           |
| :--------: | :-----------------------------------------------------: |
| 프론트엔드 |           Vue.js, Vuex <br /> HTML5, CSS3, JS           |
|   백엔드   | Spring Boot <br /> H2 (개발, 테스트) <br /> MySQL(배포) |
|   DevOps   |    Jira, mattermost <br /> GitLab <br /> Docker, AWS    |

## 시스템 구성도

![시스템 구성](./산출물/최종시스템구성도_CHABIT.png)

### 디렉토리 구조

**Spring Boot**

```bash
backend
├─ .gitignore
├─ build.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │   └─ chabit
   │  │       ├─ controller
   │  │       ├─ service
   │  │       ├─ repository
   │  │       ├─ domain
   │  │       ├─ config
   │  │       ├─ exception
   │  │       └─ ChabitApplication.java
   │  └─ resources
   │     ├─ application.yml   설정 파일
   │     └─ ...
   └─ test                    테스트 파일

```

**Vue**

```bash
frontend
├─ README.md
├─ package.json
└─ src
   ├─ main.js
   ├─ App.vue
   ├─ components        컴포넌트
   │  ├─ common
   │  ├─ include
   │  └─ user
   │     └─ snsLogin
   │
   ├─ router            라우터
   │  └─ index.js
   │
   ├─ views             라우터 페이지
   │  ├─ challenge
   │  ├─ feed
   │  ├─ follow
   │  ├─ home
   │  ├─ ranking
   │  ├─ setting
   │  └─ user
   │
   ├─ vuex              상태 관리
   │  ├─ actions.js
   │  ├─ getter.js
   │  ├─ mutations.js
   │  └─ store.js
   │
   ├─ api               api 함수
   │  ├─ UserApi.js
   │  └─ ...
   │
   └─ assets            기타 자원
      ├─ css            스타일 시트
      │  ├─ common.css
      │  └─ ...
      ├─ img            이미지
      └─ ...
```

## 개발 규칙

### Git

**Commit message**

```
[Jira 이슈 번호] 타이틀: 설명
예시 : [S04P12B207-15]Docs: 커밋 메세지 규칙 수정
```

```
Feat : 코드나 테스트를 추가했을 때 + 라이브러리 추가하는 경우
Fix : 버그를 수정했을 때
Remove : 코드를 제거했을 때
Update : 코드를 수정하는 경우
Docs : 문서를 수정했을 때
Style : 코드 포맷팅에 대한 부분 변경, CSS 등
Rename : 이름을 변경했을 때
Move : 코드를 이동할 때
Refac : 기능 변화 없이 코드 내부 구조 변경하는 경우
```

**Branch**

- master
- develop
- feature
  ```
  예시) 로그인 기능의 경우 : feature/login
  ```
- hotfix  
   배포 후 발생한 버그 처리

### Code

- 파스칼 케이스  
   Vue 파일, 컴포넌트 이름
- 케밥 케이스  
   html id, class
- 카멜 케이스  
   method 이름

## 프로젝트 일정

### Gantt chart

**Project 2 ~ 3주차**

![img.png](/산출물/진행도.PNG)

**Project 4주차**

![img.png](/산출물/진행도2.PNG)

**Project 5주차**

![img.png](/산출물/진행도3.PNG)

**Project 6주차**

![img.png](/산출물/진행도4.PNG)


## 최종 산출물

<a href="https://youtu.be/TpePj0ehrXI">UCC</a>

<a href="https://github.com/junghyun100/CHABIT/blob/develop/%EC%82%B0%EC%B6%9C%EB%AC%BC/CHABIT%20%EC%B5%9C%EC%A2%85%20%EB%B0%9C%ED%91%9C.pdf">PDF</a>

<a href="https://www.notion.so/1-961ababbeced4693839e15be69c383d5">회고</a>