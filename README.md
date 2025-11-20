# ☀️ Sunlighting Company Website

> **조명 시공 전문 업체 “㈜썬라이팅(선라이팅)”의 공식 웹사이트 개발 프로젝트**
> Java 기반 백엔드와 Railway MySQL을 연동하여 실제 기업 사이트를 구축한 프로젝트입니다.

---

## 📌 프로젝트 소개 (Description)

Sunlighting 회사 사이트는

* 회사 소개
* 서비스 안내
* 시공 사례
* 고객 연락
  을 제공하는 **기업 홍보용 웹사이트**입니다.

프론트엔드는 정적 페이지로 Render에 배포하고,
백엔드는 Java 서버로 API를 구성하여 **Railway MySQL 데이터베이스와 연동**하여 운영됩니다.

👉 **배포 링크:** [https://sunlighting.onrender.com/](https://sunlighting.onrender.com/)

---

## 🛠️ 기술 스택 (Tech Stack)

### **Frontend**

* HTML
* CSS
* JavaScript

### **Backend**

* **Java (JDK)**
* **JSP / Servlet (Tomcat 기반)**
* JDBC를 통한 MySQL 연결
* REST API 구성

### **Database**

* **MySQL (Hosted on Railway)**

### **Deployment**

* **Render**

  * Frontend: Static Site Hosting
  * Backend: Web Service (Java 배포)
* **Railway**

  * MySQL Cloud Database

---

## ✨ 주요 기능 (Features)

### 🔹 메인 페이지(Home)

* 회사 대표 문구 및 배너 이미지 표시
* 조명 시공 업체라는 브랜드 이미지를 강조하는 UI 구성

### 🔹 회사 소개(About)

* 회사 개요, 사업자 정보, 주소, 연락처 제공

### 🔹 포트폴리오(Portfolio)

* 시공 사례 이미지 갤러리
* 추후 실제 시공 사례 추가 가능하도록 구조 설계

### 🔹 고객 문의(Contact)

* 전화번호, 이메일, 주소 제공
* API를 통한 DB 저장 기능 확장 가능

 ### 🔹 관리자 페이지(Admin)

* 관리자 로그인창으로 로그인
* 사용자가 문의한 내용 답변 기능능

---

## 📁 프로젝트 구조 (Project Structure)

```
/frontend
   /assets
      /images
   /css
   /js
   index.html
   about.html
   services.html
   portfolio.html
   contact.html

/backend
   /src
      /main
         /java
            /controller
            /service
            /dao
         /webapp
            /WEB-INF
               views/*.jsp
   pom.xml

/database
   schema.sql
```

---

## 🔐 백엔드 – Railway MySQL 연동

```env
DB_HOST=containers-us-west-###.railway.app
DB_PORT=xxxx
DB_USER=root
DB_PASSWORD=******
DB_NAME=railway
```

### Java (JDBC) 연결 코드 예시

```java
Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = DriverManager.getConnection(
    "jdbc:mysql://" + host + ":" + port + "/" + dbName,
    user,
    password
);
```

---

## 🚀 배포 방식 (Deployment)

### **Frontend (Render – Static Site Hosting)**

* Build Command: 없음
* Publish Directory: `/`
* Push 시 자동 배포

### **Backend (Render – Web Service)**

* Java 서버(Tomcat)로 구동
* Railway MySQL과 연결
* `.env` 파일로 민감 정보 관리

### **Database (Railway MySQL)**

* 클라우드 MySQL 인스턴스 사용
* Render 백엔드 서버에서 직접 접근

---

## 🔧 설치 및 실행 방법 (Installation)

### 1️⃣ 저장소 클론

```bash
git clone https://github.com/your-repo/sunlighting.git
```

### 2️⃣ 백엔드 환경 변수 설정

`.env` 생성

```env
DB_HOST=...
DB_PORT=...
DB_USER=root
DB_PASSWORD=...
DB_NAME=railway
```

### 3️⃣ 백엔드 실행

(Tomcat 또는 IDE 실행)

```bash
mvn clean package
```

### 4️⃣ 프론트엔드 로컬 실행

브라우저에서 `/frontend/index.html` 열기

---

## 🧩 향후 개선 계획 (Future Work)

* 실제 시공 사례 이미지 추가
* 관리자 페이지 구축
* 문의 양식(DB 저장) 기능 구현
* 모바일 반응형 디자인 강화
* 지도 API 연동

