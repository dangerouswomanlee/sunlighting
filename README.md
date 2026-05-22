# (주)썬라이팅 공식 웹사이트

경관 조명 시공 전문 기업 **(주)썬라이팅**의 기업 홈페이지 프로젝트입니다.
Spring Boot 기반으로 구축되었으며, 포트폴리오 전시, 고객 문의, 관리자 답변 기능을 제공합니다.

배포 링크: https://sunlighting.onrender.com/

---

## 기술 스택

| 분류 | 사용 기술 |
|---|---|
| Backend | Spring Boot 3.2.7, Spring Data JPA |
| Frontend | Thymeleaf, HTML5, CSS3, JavaScript |
| Database | H2 (로컬 개발), MySQL (운영) |
| Build | Maven |
| 기타 | Lombok |

---

## 주요 기능

### 홈페이지 (`/`)
- 이미지 자동 슬라이더 (3초 간격, 수동 전환 가능)
- 조명 종류: 경관 조명, 드롭형 조명, 라인 조명, 외벽 연출 조명, 조명 조형물, 크리스마스 트리
- 회사 소개 섹션 (경관 조명 전문, 안전 시공, 맞춤형 디자인)

### 포트폴리오 (`/portfolio`)
- 시공 사례 갤러리 (16개 프로젝트)
- 프로젝트 상세 페이지: 이미지 최대 10장 자동 로드 (`1.jpg ~ 10.jpg`)
- 이미지 클릭 시 팝업 확대 보기

**등록된 시공 사례**
- 강남 데이터센터, 강원랜드 하이원 리조트, 과천 계룡건설
- 금성백조, 금성백조 예미지, 대구 중앙로역 푸르지오
- 대전 SBS 아카데미, 대전 코오롱건설, 대전 현대아울렛
- 발왕산 용평리조트, 부산 덕천 포레나, 소공동 롯데백화점
- 소공동 영프라자, 왕길역 푸르지오, 정동진 리조트, 힐스테이트 푸르지오 주안

### 문의 게시판 (`/contact`)
- 문의 목록 조회 (최신순 정렬)
- 문의 작성: 제목, 작성자, 전화번호, 이메일, 비밀번호, 내용
- 비밀번호 인증 후 상세 내용 확인
- 관리자 답변 여부 표시 (미답변 / 답변 완료)

### 관리자 (`/admin`)
- 세션 기반 로그인/로그아웃
- 전체 문의 목록 관리
- 문의 상세 조회 및 답변 등록

---

## 프로젝트 구조

```
src/
└── main/
    ├── java/com/company/site/
    │   ├── SunlightingApplication.java
    │   ├── controller/
    │   │   ├── HomeController.java          # 홈, 문의하기 페이지
    │   │   ├── PortfolioController.java     # 포트폴리오 목록/상세
    │   │   ├── ContactController.java       # 문의 CRUD, 비밀번호 인증
    │   │   └── AdminController.java         # 관리자 로그인, 답변 관리
    │   ├── model/
    │   │   ├── Contact.java
    │   │   └── Admin.java
    │   ├── repository/
    │   │   ├── ContactRepository.java
    │   │   └── AdminRepository.java
    │   └── service/
    │       ├── ContactService.java
    │       └── AdminService.java
    └── resources/
        ├── application.properties
        ├── templates/
        │   ├── index.html
        │   ├── portfolio.html
        │   ├── portfolio_detail.html
        │   ├── contact-list.html
        │   ├── contact-write.html
        │   ├── contact-password.html
        │   ├── contact-detail.html
        │   ├── admin-login.html
        │   ├── admin-contact-list.html
        │   └── admin-contact-detail.html
        └── static/
            ├── css/
            │   ├── style.css
            │   ├── contact.css
            │   ├── password.css
            │   └── admin-login.css
            ├── js/
            │   └── main.js
            └── img/
```

---

## DB 구조

### Contact (문의)

| 컬럼 | 타입 | 설명 |
|---|---|---|
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
|---|---|---|
| username | String (PK) | 관리자 아이디 |
| password | String | 비밀번호 |

---

## 로컬 실행 방법

### 1. 저장소 클론

```bash
git clone https://github.com/dangerouswomanlee/sunlighting.git
cd sunlighting
```

### 2. 서버 실행

```bash
./mvnw spring-boot:run
```

### 3. 브라우저에서 확인

| URL | 설명 |
|---|---|
| `http://localhost:10000` | 홈페이지 |
| `http://localhost:10000/portfolio` | 포트폴리오 |
| `http://localhost:10000/contact` | 문의 게시판 |
| `http://localhost:10000/admin/login` | 관리자 로그인 |
| `http://localhost:10000/h2-console` | H2 DB 콘솔 (로컬 전용) |

#### H2 콘솔 접속 정보

```
JDBC URL  : jdbc:h2:mem:testdb
Username  : sa
Password  : (없음)
```

---

## 환경 변수

| 변수명 | 설명 | 기본값 |
|---|---|---|
| `PORT` | 서버 포트 | `10000` |

---

## 회사 정보

| 항목 | 내용 |
|---|---|
| 상호 | 주식회사 썬라이팅 |
| 사업자등록번호 | 134211-0291627 |
| 주소 | 경기도 광주시 초월읍 선장동길 61-29, 1층 |
| 전화 | 010-9124-7815 |
| 이메일 | sunlig2030@naver.com |
