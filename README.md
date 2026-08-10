# (주)썬라이팅 공식 웹사이트

경관 조명 시공 전문 기업 (주)썬라이팅의 기업 홈페이지입니다. 시공 사례를 보여주는 포트폴리오, 고객 문의 게시판, 관리자 답변 시스템으로 구성했습니다.

배포 URL: https://sunlighting.onrender.com

---

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
      <img src="https://github.com/user-attachments/assets/c7ff39ae-e861-4358-86ad-5d7c7502fe26" width="100%" />
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

---

## 주요 기능

### 1. 홈페이지 `/`
- 이미지 슬라이더가 3초마다 자동으로 넘어갑니다. 좌우 버튼으로 직접 넘기는 것도 가능합니다.
- 조명 종류를 소개합니다. 경관 조명, 드롭형 조명, 라인 조명, 외벽 연출 조명, 조명 조형물, 크리스마스 트리까지 다룹니다.
- 회사 소개 섹션에서 경관 조명 전문성, 안전 시공, 맞춤형 디자인이라는 강점을 보여줍니다.

### 2. 포트폴리오 `/portfolio`
- 지금까지 진행한 시공 사례 16건을 카드 형태로 보여줍니다.
- 상세 페이지에 들어가면 프로젝트별 이미지가 최대 10장까지 자동으로 불러와집니다.
- 이미지를 클릭하면 확대해서 볼 수 있습니다.

### 3. 문의 게시판 `/contact`
- 문의는 최신순으로 정렬되고, 키워드로 검색할 수 있습니다. 답변이 달렸는지 여부도 목록에서 바로 보입니다.
- 문의 작성 시 제목, 작성자, 전화번호, 이메일, 비밀번호, 내용을 입력받습니다.
- 본인이 작성한 문의는 비밀번호를 입력해야 내용을 볼 수 있습니다.
- 관리자가 답변을 등록하면 작성자 이메일로 알림이 자동 발송됩니다. Naver SMTP를 사용했습니다.

### 4. 관리자 페이지
- JWT로 인증하고, 토큰은 HttpOnly 쿠키에 저장합니다.
- 로그인을 여러 번 실패하면 일정 시간 동안 접근을 막습니다.
- 전체 문의를 검색하고 상세 내용을 확인할 수 있습니다.
- 답변을 등록하거나 문의를 삭제할 수 있고, 답변 등록 시 이메일이 자동으로 나갑니다.

---

## 기술 스택

| 구분 | 기술 |
| --- | --- |
| Backend | Spring Boot 3.2.7, Spring Data JPA, Spring Security, Spring Validation, Spring Mail, JWT (jjwt 0.12.5), Lombok |
| Frontend | Thymeleaf, HTML5, CSS3, JavaScript |
| Database | PostgreSQL (운영), H2 (로컬) |
| 빌드/배포 | Maven, Docker, Render |

---

## 프로젝트 구조

```
sunlighting/
├── src/main/java/com/company/site/
│   ├── config/          # Security, JWT, 인터셉터, 보안 헤더
│   ├── controller/      # Home / Portfolio / Contact / Admin
│   ├── model/           # Contact, Admin
│   ├── repository/
│   └── service/         # Contact, Admin, Email, LoginAttempt
└── src/main/resources/
    ├── templates/       # Thymeleaf 뷰
    └── static/          # css / js / img
```

---

## DB 구조

### Contact (문의)

| 컬럼 | 타입 | 설명 |
| --- | --- | --- |
| id | Long (PK) | 자동 증가 |
| title | String | 문의 제목 |
| name | String | 작성자 이름 |
| phone | String | 전화번호 |
| email | String | 이메일 |
| password | String | 문의 열람용 비밀번호 |
| message | TEXT | 문의 내용 |
| createdAt | LocalDateTime | 작성일 |
| adminReply | TEXT | 관리자 답변 |
| replyAt | LocalDateTime | 답변 등록일 |

### Admin (관리자)

| 컬럼 | 타입 | 설명 |
| --- | --- | --- |
| username | String (PK) | 관리자 아이디 |
| password | String | 비밀번호 |

---

## 로컬 실행 방법

```bash
git clone https://github.com/dangerouswomanlee/sunlighting.git
cd sunlighting
./mvnw spring-boot:run
```

로컬에서 실행하면 H2 인메모리 DB가 자동으로 사용됩니다.

| URL | 설명 |
| --- | --- |
| `http://localhost:10000` | 홈페이지 |
| `http://localhost:10000/portfolio` | 포트폴리오 |
| `http://localhost:10000/contact` | 문의 게시판 |

---

## 트러블슈팅


### 1. 로컬에서는 정상 작동하지만 배포 후 서버 오류 발생

* **문제**: 로컬 환경에서는 정상적으로 작동했지만, 실제 서버에 배포한 후 여러 오류가 발생했습니다.
* **해결**: 배포 서버의 에러 로그를 확인하면서 오류가 발생한 부분을 하나씩 수정했습니다. 이 과정에서 서버에 직접 프로젝트를 배포하는 방법과 로컬 환경과 배포 환경의 차이를 익혔습니다. 또한 배포하면서 환경 변수와 같은 보안 설정의 중요성도 처음 알게 되어, DB 정보나 API 키 등을 코드에 직접 작성하지 않도록 수정했습니다.

### 2. MySQL → PostgreSQL 변경

* **문제**: 개발 단계에서는 MySQL을 사용했지만, 배포 과정에서 PostgreSQL을 사용하게 되면서 DB 환경을 변경해야 했습니다.
* **해결**: PostgreSQL을 처음 사용해보면서 기존 DB 설정과 쿼리를 확인하고, PostgreSQL 환경에 맞게 수정했습니다. MySQL과 문법 및 설정이 다른 부분이 있어 관련 내용을 찾아보며 적용했습니다.

### 3. 무료 DB 삭제로 인한 DB 재연결

* **문제**: 사용하던 무료 DB의 데이터 보관 정책을 미리 확인하지 않아, 일정 기간이 지난 후 DB가 삭제되면서 연결이 끊겼습니다.
* **해결**: 새로운 DB를 생성한 후 배포된 애플리케이션의 DB 설정을 다시 변경하고 연결했습니다. 이후 무료 서비스를 사용할 때는 사용 기간이나 데이터 삭제 정책을 먼저 확인하도록 했습니다.

### 4. 디자인 경험 부족

* **문제**: 기능 구현은 어느 정도 경험이 있었지만 직접 웹사이트 디자인을 구성해본 경험이 부족해 초기 레이아웃과 색상 선정에 어려움이 있었습니다.
* **해결**: 여러 웹사이트를 참고해 레이아웃과 색상 조합을 정하고, 실제 화면에 적용하면서 수정하는 방식으로 디자인을 구성했습니다.

---

## 느낀 점

처음부터 끝까지 혼자 배포까지 해본 프로젝트라 부딪히는 문제도 많았습니다. 특히 DB를 두 번이나 새로 설정해야 했던 건 예상하지 못한 일이었습니다. 다음에는 배포 환경의 제약사항을 먼저 확인하고 시작하려고 합니다. 그래도 기획부터 배포까지 전체 과정을 직접 경험하면서 각 단계에서 어떤 문제가 생길 수 있는지 감을 잡을 수 있었습니다.

---

## 보안 구조

- 관리자 URL 난독화 — 추측하기 어려운 경로로 관리자 페이지 접근 차단
- JWT 인증 — 로그인 성공 시 JWT를 HttpOnly 쿠키에 저장, 인터셉터로 매 요청 검증
- Brute-force 방어 — 로그인 실패 횟수 추적 후 초과 시 일정 시간 차단
- 세션 고정 공격 방지 — 로그인 시 기존 세션 무효화 후 새 세션 발급
- CSRF 보호 적용
- 보안 헤더 필터 — X-Frame-Options 등 추가
- 에러 정보 차단 — stacktrace, 상세 에러 메시지 노출 비활성화
