# Project_LookAt_Movie
디자인패턴 FrontController, Command를 사용한 영화예매 프로젝트 <br>
<br>
<br>
## 프로젝트 소개
### 프로젝트 목적
- CGV, 롯데시네마와 같이 온라인으로 영화, 영화관 정보와 예매 조회, 수정이 가능한 서비스
### 주요기능
1. 고객이 원하는 영화, 영화관, 일자, 시간 단계별로 선택 예매
2. 선택영화에 인원 및 좌석 선택
3. 예매한 영화 조회, 취소, 수정
4. 회원가입 및 정보 수정
5. 결제단계 생일쿠폰, 포인트 사용
<br>

## 폴더 구조
### /src/com
1. /lookat
   * command (비즈니스 로직)
   * common (공통 예외 페이지처리)
   * controller (FrontController)
   * DTO 
   * DAO (DB 접근)
   * mybatis (mapper, config, Datasource)
   * VO
<br>

## 기술 스택
- **FrontEnd** HTML, CSS, Javascript, Jquery, JSTL, JSP
- **BackEnd** Java 8, JDBC, Mybatis
- **Database** Oracle
- **Tools** Eclipse
<br>

## 담당 기능 샘플 사진
### 영화선택 단계 페이지
![Image](https://github.com/user-attachments/assets/d5a93c4d-c712-4e55-b231-e6f826bc55d0)
### 좌석선택 단계 페이지
![Image](https://github.com/user-attachments/assets/8d170382-a05b-4792-874a-1808f7bb35c2)
### 결제 페이지
![Image](https://github.com/user-attachments/assets/05dd9e6b-fe8e-4cfc-8c3b-32038aa67ffb)
