# [WEB] 2023년 다우기술 개발센터 경력직 채용 기술과제
## 구현과제 : 웹 쇼핑몰 상품 주문

---
## 🚩 서버 개발 환경
- JDK 11버전 권장
- Springboot : 2.7.7v
- Build : Maven
- Database : H2
- Swagger : version 2

### ✔ 프로젝트 구동 방법
1. IDE에서 프로젝트를 Import (backend 디렉토리가 최상위에 위치해야 합니다.)
    - 권장 IDE : IntelliJ IDEA
2. QueryDSL 컴파일
   - Maven -> Generate Sources and Update Folders
3. 서버 구동 및 정상 여부 확인

<br />

### ✔ H2 Database 브라우저 콘솔 접근 방법 
- 경로 : http://localhost:8080/h2-console/
- JDBC URL 설정
  - jdbc:h2:mem:recruitTest

### ✔ Swagger API Web Document
- 경로 : http://localhost/swagger-ui.html

<br />

---
## 🚩 클라이언트 개발 환경

### ✔ 사용스택
- Javascript ES6

### ✔ 프레임워크
- Vue.js 3.x

### ✔ 라이브러리
- axios 1.2.x
- moment 2.29.x
- Vue Router 4.x
- Vuex 4.x

### ✔ 프로젝트 구동 방법
1. **node 설치 ( <span style="color:red">version 16</span> 이상 필수 )**
2. npm install
3. npm run dev

### ✔ 기능목록
1. 상품 리스트 화면 (홈)
2. 상품 상세설명
3. 주문 결제
4. 주문 완료