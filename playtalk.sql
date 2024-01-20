# -- 계정설정
#
# CREATE TABLE `users` (
# 	`user_id` VARCHAR(255) PRIMARY KEY COMMENT '사용자 아이디',
# 	`pw`			VARCHAR(255) NOT NULL COMMENT '비밀번호',
# 	`nkname`  VARCHAR(255) UNIQUE NOT NULL COMMENT '닉네임',
# 	`email`   VARCHAR(255) UNIQUE NOT NULL COMMENT '이메일',
# 	`phone_number` VARCHAR(20) UNIQUE NOT NULL COMMENT '핸드폰 번호',
# 	`signup_date`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일',
# 	`profile_img`  VARCHAR(255) COMMENT '프로필 이미지',
# 	`status`       ENUM('SIGNUP', 'EMAIL_CHECK', 'BLOCK', 'LEAVE', 'REPORT') NOT NULL DEFAULT 'SIGNUP' COMMENT '계정상태',
# 	`email_check_code` VARCHAR(8) COMMENT '이메일 확인 코드'
# )
#
# CREATE TABLE `community` (
# 	`comm_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 번호',
# 	`user_id` VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
# 	`title`   VARCHAR(255) NOT NULL COMMENT '제목',
# 	`content` VARCHAR(255) NOT NULL COMMENT '내용',
# 	`view_count` INT UNSIGNED DEFAULT 0 COMMENT '조회수',
# 	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
# 	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
#
# CREATE TABLE `comm_replies` (
# 	`comm_reply_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '댓글 번호',
# 	`comm_id` 			INT UNSIGNED NOT NULL COMMENT '게시글 번호',
# 	`user_id`  			VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
# 	`content`       TEXT NOT NULL COMMENT '내용',
# 	`post_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜'
# 	`parent_cr_id`  INT UNSIGNED COMMENT '부모 댓글 아이디(대댓글)',
# 	FOREIGN KEY (comm_id) REFERENCES community (comm_id) ON DELETE CASCADE ON UPDATE CASCADE,
# 	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
# 	FOREIGN KEY (parent_cr_id) REFERENCES comm_replies (comm_reply_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
# -- 대댓글 테이블은 없어도 되는 듯 하다.
#
# CREATE TABLE `comm_imgs` (
# 	`comm_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '이미지 번호',
# 	`comm_id`     INT UNSIGNED NOT NULL COMMENT '게시글 번호',
# 	`img_path`    VARCHAR(255) COMMENT '이미지 주소',
# 	`img_main`    BOOLEAN COMMENT '대표 이미지',
# 	FOREIGN KEY (comm_id) REFERENCES community (comm_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
#
# CREATE TABLE `comm_reply_img` (
# 	`comm_reply_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '댓글이미지 번호',
# 	`comm_reply_id` INT UNSIGNED NOT NULL COMMENT '댓글 번호',
# 	`img_path`  VARCHAR(255) COMMENT '이미지 주소',
# 	FOREIGN KEY (comm_reply_id) REFERENCES comm_replies (comm_reply_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
#
# CREATE TABLE `notice` (
# 	`notice_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '공지글 번호',
# 	`user_id`   VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
# 	`title`     VARCHAR(255) NOT NULL COMMENT '제목',
# 	`content`   VARCHAR(255) NOT NULL COMMENT '내용',
# 	`view_count` INT UNSIGNED DEFAULT 0 COMMENT '조회수',
# 	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
# 	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
#
# CREATE TABLE `notice_img` (
# 	`notice_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '공지글 이미지 번호',
# 	`notice_id`     INT UNSIGNED NOT NULL COMMENT '공지글 번호',
# 	`img_path`      VARCHAR(255) COMMENT '이미지 주소',
# 	FOREIGN KEY (notice_id) REFERENCES notice (notice_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
#
# CREATE TABLE `assign` (
# 	`assign_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '양도글 번호',
# 	`user_id`   INT UNSIGNED NOT NULL COMMENT '사용자 아이디',
# 	`title`     VARCHAR(255) NOT NULL COMMENT '제목',
# 	`play_area` VARCHAR(255) NOT NULL COMMENT '공연장소',
# 	`play_date` TIMESTAMP NOT NULL COMMENT '공연시간',
# 	`seat_grade` ENUM ('VIP', 'R', 'S', 'A') NOT NULL COMMENT '공연좌석 등급',
# 	`seat`       VARCHAR(255) NOT NULL COMMENT '공연좌석',
# 	`cast`       VARCHAR(255) NOT NULL COMMENT '공연캐스팅',
# 	`sale_code`  VARCHAR(255) NOT NULL COMMENT '할인권종',
# 	`price`      INT NOT NULL COMMENT '가격',
# 	`etc`        VARCHAR(255) NOT NULL COMMENT '비고',
# 	`assign_YN`  BOOLEAN NOT NULL COMMENT '양도 확인여부',
# 	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
# 	`img_path`   VARCHAR(255) COMMENT '이미지 주소'
# )
# -- sale_code ?
# -- seat 좌석등급 VIP, R, S, A / 좌석 객석 1층-21열-27
#
# CREATE TABLE `assign_reply` (
# 	`assign_reply_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '양도글 댓글번호'
# 	`user_id`         INT UNSIGNED NOT NULL COMMENT '사용자 아이디',
# 	`assign_id`       INT UNSIGNED NOT NULL COMMENT '양도글 번호'
# 	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
# 	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
# 	FOREIGN KEY (assign_id) REFERENCES assign (assign_id) ON DELETE CASCADE ON UPDATE CASCADE
# )
-- User 테이블에 더미 사용자 데이터 10개 삽입
USE playtalkdb;
INSERT INTO users (user_id, pw, nkname, email, phone_number, signup_date, grade, email_check_code) VALUES
                                                                                                    ('user1', 'password1', '닉네임1', 'user1@example.com', '010-1111-1111', '2024-01-06T12:30:00', 'User', 'code1'),
                                                                                                    ('user2', 'password2', '닉네임2', 'user2@example.com', '010-2222-2222', '2024-01-06T13:45:00', 'User', 'code2'),
                                                                                                    ('user3', 'password3', '닉네임3', 'user3@example.com', '010-3333-3333', '2024-01-06T14:15:00', 'User', 'code3'),
                                                                                                    ('user4', 'password4', '닉네임4', 'user4@example.com', '010-4444-4444', '2024-01-06T15:00:00', 'User', 'code4'),
                                                                                                    ('user5', 'password5', '닉네임5', 'user5@example.com', '010-5555-5555', '2024-01-06T16:30:00', 'User', 'code5'),
                                                                                                    ('user6', 'password6', '닉네임6', 'user6@example.com', '010-6666-6666', '2024-01-06T17:45:00', 'User', 'code6'),
                                                                                                    ('user7', 'password7', '닉네임7', 'user7@example.com', '010-7777-7777', '2024-01-06T18:15:00', 'User', 'code7'),
                                                                                                    ('user8', 'password8', '닉네임8', 'user8@example.com', '010-8888-8888', '2024-01-06T19:00:00', 'User', 'code8'),
                                                                                                    ('user9', 'password9', '닉네임9', 'user9@example.com', '010-9999-9999', '2024-01-06T20:30:00', 'User', 'code9'),
                                                                                                    ('user10', 'password10', '닉네임10', 'user10@example.com', '010-1010-1010', '2024-01-06T21:45:00', 'User', 'code10');

-- Community 테이블에 더미 데이터 10개 삽입
INSERT INTO Community(comm_id, title, content, view_count, post_time, category, user_id) VALUES
                                                                                              (1, '연극 소식 공유', '오늘 공연에서 놀라운 연기가 펼쳐졌어요!', 100, '2024-01-06T12:30:00', '정보', 'user1'),
                                                                                              (2, '공연 후기 모음', '지난 주말에 관람한 연극 후기를 공유해주세요.', 150, '2024-01-06T13:45:00', '후기', 'user2'),
                                                                                              (3, '연극 관련 질문', '연극에 대한 궁금증이 있어서 여쭤봅니다.', 120, '2024-01-06T14:15:00', '나눔', 'user3'),
                                                                                              (4, '연극 소개', '현재 상영중인 연극 중에서 추천해주시는 작품이 있나요?', 200, '2024-01-06T15:00:00', '잡담', 'user3'),
                                                                                              (5, '최애 배우 토론', '가장 좋아하는 연극 배우에 대해 이야기해봐요!', 80, '2024-01-06T16:30:00', '정보','user4'),
                                                                                              (6, '연극 작품 분석', '특정 연극 작품에 대한 깊은 분석을 해보려고 합니다.', 300, '2024-01-06T17:45:00', '후기', 'user4'),
                                                                                              (7, '연극 티켓 정보', '다가오는 연극 티켓 예매 관련 정보를 알려주세요.', 180, '2024-01-06T18:15:00', '나눔', 'user5'),
                                                                                              (8, '지역별 연극 소식', '내 지역에서 개최되는 연극 소식을 공유해주세요.', 250, '2024-01-06T19:00:00', '잡담','user5'),
                                                                                              (9, '연극 배우 인터뷰', '최근에 인터뷰한 연극 배우의 이야기를 듣고 싶어요.', 160, '2024-01-06T20:30:00', '정보','user6'),
                                                                                              (10, '연극 음악 특집', '연극에서 사용된 음악에 대한 특집을 진행해보려고 합니다.', 220, '2024-01-06T21:45:00', '후기', 'user7');


