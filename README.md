# (주)썬라이팅 공식 웹사이트

경관 조명 시공 전문 기업 (주)썬라이팅의 기업 홈페이지입니다. 시공 사례 포트폴리오, 고객 문의 게시판, 관리자 답변 시스템으로 구성되어 있습니다.

배포 URL: https://sunlighting.onrender.com

## 스크린샷

<table>
  <tr>
    <th colspan="2" align="left">홈페이지 — 이미지 슬라이더 & 회사 소개</th>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/3fd6cbb1-676f-4caf-a19d-08f1c4fb96a1" width="100%" />
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/8697687e-8124-4348-b2e0-1b658b684deb" width="100%" />
    </td>
  </tr>
  <tr>
    <th align="center">포트폴리오 목록</th>
    <th align="center">포트폴리오 상세</th>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img width="1179" height="2016" alt="image" src="https://github.com/user-attachments/assets/c7ff39ae-e861-4358-86ad-5d7c7502fe26" />
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/833aacaa-145f-47f5-816d-d8fff3226ace" width="100%" />
      <img src="https://github.com/user-attachments/assets/f861c30b-8d64-4aa7-881f-58e01ac09b97" width="100%" />
    </td>
  </tr>
  <tr>
    <th align="center">문의 게시판</th>
    <th align="center">문의 작성 폼</th>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/db8fdacc-2da6-4da7-bad3-294d5f4bfc74" width="100%" />
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/531c703c-8377-4de4-abc2-0941bb7e26f8" width="100%" />
    </td>
  </tr>
  <tr>
    <th colspan="2" align="left">답변 이메일 알림</th>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <img src="https://github.com/user-attachments/assets/25bf9334-39fc-432c-ae99-a2a66e090075" width="40%" />
    </td>
  </tr>
</table>

<table>
  <tr>
    <th colspan="2" align="left">관리자 페이지</th>
  </tr>
  <tr>
    <th align="center">관리자 로그인</th>
    <th align="center">문의 목록 관리</th>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/dce87dbf-1ff6-4470-b60d-176c28e15093" width="100%" />
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/bf82919e-ccf5-4eb1-b3b7-f5637fc7513b" width="100%" />
    </td>
  </tr>
  <tr>
    <th align="center">문의 상세 조회</th>
    <th align="center">답변 등록</th>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/9f5577b5-6faa-4fb3-9f64-f6deaef3baea" width="100%" />
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/ceb7a345-2fe3-4ab6-b26c-9b7eb46004b2" width="100%" />
    </td>
  </tr>
</table>

## 주요 기능

### 1. 홈페이지 (`/`)

메인 배너는 3초 간격으로 자동 전환되고, 좌우 버튼으로 수동 전환도 가능합니다. 경관 조명, 드롭형 조명, 라인 조명, 외벽 연출 조명, 조명 조형물, 크리스마스 트리 등 조명 종류를 소개하고, 회사 소개 섹션에서는 경관 조명 전문성, 안전 시공, 맞춤형 디자인 세 가지를 강점으로 내세우고 있습니다.

### 2. 포트폴리오 (`/portfolio`)

시공 사례 16건을 카드 목록으로 보여주고, 상세 페이지에서는 프로젝트별 이미지를 `1.jpg`부터 `10.jpg`까지 자동으로 불러옵니다. 클릭하면 이미지가 확대되어 보입니다.

등록된 시공 사례: 강남 데이터센터, 강원랜드 하이원 리조트, 과천 계룡건설, 금성백조, 금성백조 예미지, 대구 중앙로역 푸르지오, 대전 SBS 아카데미, 대전 코오롱건설, 대전 현대아울렛, 발왕산 용평리조트, 부산 덕천 포레나, 소공동 롯데백화점, 소공동 영프라자, 왕길역 푸르지오, 정동진 리조트, 힐스테이트 푸르지오 주안

### 3. 문의 게시판 (`/contact`)

최신순으로 정렬되고 키워드 검색과 답변 여부(미답변/답변 완료) 표시가 됩니다. 문의 작성 시 제목, 작성자, 전화번호, 이메일, 비밀번호, 내용을 입력하며, 본인이 작성한 문의는 비밀번호를 입력해야 내용을 열람할 수 있습니다. 관리자가 답변을 등록하면 작성자 이메일로 알림이 자동 발송됩니다 (Naver SMTP).

### 4. 관리자 페이지

JWT를 HttpOnly 쿠키에 저장해 인증하고, 세션 고정 공격을 막기 위한 처리도 되어 있습니다. 로그인 실패가 일정 횟수를 넘으면 10분간 차단되고(Brute-force 방어), 전체 문의 목록 검색·상세 조회와 답변 등록·삭제가 가능합니다. 답변 등록 시 이메일도 자동으로 발송됩니다.

## 기술 스택

| 구분 | 기술 | 버전 |
|------|------|------|
| Backend | Spring Boot | 3.2.7 |
| | Spring Data JPA | - |
| | Spring Security | - |
| | Spring Validation | - |
| | Spring Mail | - |
| | JWT (jjwt) | 0.12.5 |
| | Lombok | 1.18.32 |
| Frontend | Thymeleaf | - |
| | HTML5 / CSS3 / JavaScript | - |
| Database | PostgreSQL (운영) / H2 (로컬) | - |
| 빌드 | Maven | - |
| 배포 | Docker / Render | - |

## 프로젝트 구조

```
sunlighting/
├── src/main/java/com/company/site/
│   ├── SunlightingApplication.java
│   ├── config/
│   │   ├── SecurityConfig.java          # Spring Security / CSRF 설정
│   │   ├── WebConfig.java               # MVC 설정
│   │   ├── AppConfig.java
│   │   ├── JwtUtil.java                 # JWT 생성 / 검증 / 쿠키
│   │   ├── AdminAuthInterceptor.java    # 관리자 인증 인터셉터
│   │   └── SecurityHeaderFilter.java   # 보안 헤더 필터
│   ├── controller/
│   │   ├── HomeController.java          # 홈 페이지
│   │   ├── PortfolioController.java     # 포트폴리오 목록 / 상세
│   │   ├── ContactController.java       # 문의 CRUD, 비밀번호 인증
│   │   ├── AdminController.java         # 관리자 로그인, 답변 관리
│   │   └── GlobalExceptionHandler.java  # 전역 예외 처리
│   ├── model/
│   │   ├── Contact.java
│   │   └── Admin.java
│   ├── repository/
│   │   ├── ContactRepository.java
│   │   └── AdminRepository.java
│   └── service/
│       ├── ContactService.java
│       ├── AdminService.java
│       ├── EmailService.java            # Naver SMTP 이메일 발송
│       └── LoginAttemptService.java     # 로그인 시도 횟수 관리
│
└── src/main/resources/
    ├── application.properties
    ├── templates/
    │   ├── index.html
    │   ├── portfolio.html
    │   ├── portfolio_detail.html
    │   ├── contact.html
    │   ├── contact-list.html
    │   ├── contact-write.html
    │   ├── contact-password.html
    │   ├── contact-detail.html
    │   ├── admin-login.html
    │   ├── admin-contact-list.html
    │   ├── admin-contact-detail.html
    │   ├── success.html
    │   └── error/
    │       ├── 403.html
    │       ├── 404.html
    │       └── 500.html
    └── static/
        ├── css/
        │   ├── style.css
        │   ├── contact.css
        │   ├── password.css
        │   └── admin-login.css
        ├── js/
        │   ├── main.js
        │   ├── admin.js
        │   └── portfolio-detail.js
        └── img/
            ├── 홈/
            └── {프로젝트명}/
```

## 로컬 실행 방법

Java 17 이상과 Maven이 필요합니다.

```bash
git clone https://github.com/dangerouswomanlee/sunlighting.git
cd sunlighting
./mvnw spring-boot:run
```

로컬에서는 H2 인메모리 DB가 자동으로 사용됩니다. 실행 후 아래 주소에서 확인할 수 있습니다.

| URL | 설명 |
|-----|------|
| `http://localhost:10000` | 홈페이지 |
| `http://localhost:10000/portfolio` | 포트폴리오 |
| `http://localhost:10000/contact` | 문의 게시판 |
| `http://localhost:10000/h2-console` | H2 DB 콘솔 (로컬 전용) |

H2 콘솔 접속 정보는 다음과 같습니다.

```
JDBC URL  : jdbc:h2:mem:testdb
Username  : sa
Password  : (없음)
```

## 환경 변수

운영 배포 시 아래 환경변수를 설정해야 합니다.

| 변수명 | 설명 | 기본값 |
|--------|------|--------|
| `DB_URL` | PostgreSQL JDBC URL | - |
| `DB_USERNAME` | DB 사용자명 | - |
| `DB_PASSWORD` | DB 비밀번호 | - |
| `PORT` | 서버 포트 | `10000` |
| `MAIL_HOST` | SMTP 호스트 | `smtp.naver.com` |
| `MAIL_PORT` | SMTP 포트 | `465` |
| `MAIL_USERNAME` | 발신 이메일 계정 | - |
| `MAIL_PASSWORD` | 이메일 앱 비밀번호 | - |
| `JWT_SECRET` | JWT 서명 키 | 기본값 있음 (운영 시 반드시 변경) |
| `JWT_COOKIE_SECURE` | HTTPS 쿠키 보안 | `false` |

## DB 스키마

### Contact (문의)

| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | Long (PK) | 자동 증가 |
| title | String | 문의 제목 |
| name | String | 작성자 이름 |
| phone | String | 전화번호 |
| email | String | 이메일 |
| password | String | 비밀번호 |
| message | TEXT | 문의 내용 |
| createdAt | LocalDateTime | 작성일 |
| adminReply | TEXT | 관리자 답변 |
| replyAt | LocalDateTime | 답변 등록일 |

### Admin (관리자)

| 컬럼 | 타입 | 설명 |
|------|------|------|
| username | String (PK) | 관리자 아이디 |
| password | String | 비밀번호 |

## 보안 구조

관리자 페이지는 추측하기 어려운 경로로 접근 경로를 숨겨두었습니다. 로그인에 성공하면 JWT를 HttpOnly 쿠키에 저장하고, `AdminAuthInterceptor`가 매 요청마다 검증합니다. `LoginAttemptService`로 로그인 실패 횟수를 추적해 일정 횟수를 넘기면 10분간 차단하고(Brute-force 방어), 로그인 시 기존 세션을 무효화한 뒤 새 세션을 발급해 세션 고정 공격을 막습니다. 이 밖에 `HttpSessionCsrfTokenRepository`로 CSRF를 방어하고, `SecurityHeaderFilter`로 X-Frame-Options 등 보안 헤더를 추가했으며, stacktrace나 에러 메시지가 노출되지 않도록 처리했습니다.

## 회사 정보

| 항목 | 내용 |
|------|------|
| 상호 | 주식회사 썬라이팅 |
| 사업자등록번호 | 134211-0291627 |
| 주소 | 경기도 광주시 초월읍 선장동길 61-29, 1층 |
| 전화 | 010-9124-7815 |
| 이메일 | sunlig2030@naver.com |
