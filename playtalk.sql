-- 계정설정

CREATE TABLE `users` (
	`user_id` VARCHAR(255) PRIMARY KEY COMMENT '사용자 아이디',
	`pw`			VARCHAR(255) NOT NULL COMMENT '비밀번호',
	`nkname`  VARCHAR(255) UNIQUE NOT NULL COMMENT '닉네임',
	`email`   VARCHAR(255) UNIQUE NOT NULL COMMENT '이메일',
	`phone_number` VARCHAR(20) UNIQUE NOT NULL COMMENT '핸드폰 번호',  
	`signup_date`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일',
	`profile_img`  VARCHAR(255) COMMENT '프로필 이미지',
	`status`       ENUM('SIGNUP', 'EMAIL_CHECK', 'BLOCK', 'LEAVE', 'REPORT') NOT NULL DEFAULT 'SIGNUP' COMMENT '계정상태',
	`email_check_code` VARCHAR(8) COMMENT '이메일 확인 코드'
)

CREATE TABLE `community` (
	`comm_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 번호',
	`user_id` VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
	`title`   VARCHAR(255) NOT NULL COMMENT '제목',
	`content` VARCHAR(255) NOT NULL COMMENT '내용',
	`view_count` INT UNSIGNED DEFAULT 0 COMMENT '조회수',
	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `comm_replies` (
	`comm_reply_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '댓글 번호',
	`comm_id` 			INT UNSIGNED NOT NULL COMMENT '게시글 번호',
	`user_id`  			VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
	`content`       TEXT NOT NULL COMMENT '내용',
	`post_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜'
	`parent_cr_id`  INT UNSIGNED COMMENT '부모 댓글 아이디(대댓글)',
	FOREIGN KEY (comm_id) REFERENCES community (comm_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (parent_cr_id) REFERENCES comm_replies (comm_reply_id) ON DELETE CASCADE ON UPDATE CASCADE 
)
-- 대댓글 테이블은 없어도 되는 듯 하다.

CREATE TABLE `comm_imgs` (
	`comm_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '이미지 번호',
	`comm_id`     INT UNSIGNED NOT NULL COMMENT '게시글 번호',
	`img_path`    VARCHAR(255) COMMENT '이미지 주소',
	`img_main`    BOOLEAN COMMENT '대표 이미지',
	FOREIGN KEY (comm_id) REFERENCES community (comm_id) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `comm_reply_img` (
	`comm_reply_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '댓글이미지 번호',
	`comm_reply_id` INT UNSIGNED NOT NULL COMMENT '댓글 번호',
	`img_path`  VARCHAR(255) COMMENT '이미지 주소',
	FOREIGN KEY (comm_reply_id) REFERENCES comm_replies (comm_reply_id) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `notice` (
	`notice_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '공지글 번호',
	`user_id`   VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
	`title`     VARCHAR(255) NOT NULL COMMENT '제목',
	`content`   VARCHAR(255) NOT NULL COMMENT '내용',
	`view_count` INT UNSIGNED DEFAULT 0 COMMENT '조회수',
	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `notice_img` (
	`notice_img_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '공지글 이미지 번호',
	`notice_id`     INT UNSIGNED NOT NULL COMMENT '공지글 번호',
	`img_path`      VARCHAR(255) COMMENT '이미지 주소',
	FOREIGN KEY (notice_id) REFERENCES notice (notice_id) ON DELETE CASCADE ON UPDATE CASCADE
) 

CREATE TABLE `assign` (
	`assign_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '양도글 번호',
	`user_id`   INT UNSIGNED NOT NULL COMMENT '사용자 아이디',
	`title`     VARCHAR(255) NOT NULL COMMENT '제목',
	`play_area` VARCHAR(255) NOT NULL COMMENT '공연장소',
	`play_date` TIMESTAMP NOT NULL COMMENT '공연시간',
	`seat_grade` ENUM ('VIP', 'R', 'S', 'A') NOT NULL COMMENT '공연좌석 등급',
	`seat`       VARCHAR(255) NOT NULL COMMENT '공연좌석',
	`cast`       VARCHAR(255) NOT NULL COMMENT '공연캐스팅',
	`sale_code`  VARCHAR(255) NOT NULL COMMENT '할인권종',
	`price`      INT NOT NULL COMMENT '가격',
	`etc`        VARCHAR(255) NOT NULL COMMENT '비고',
	`assign_YN`  BOOLEAN NOT NULL COMMENT '양도 확인여부',
	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
	`img_path`   VARCHAR(255) COMMENT '이미지 주소'
)
-- sale_code ?
-- seat 좌석등급 VIP, R, S, A / 좌석 객석 1층-21열-27

CREATE TABLE `assign_reply` (
	`assign_reply_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '양도글 댓글번호'
	`user_id`         INT UNSIGNED NOT NULL COMMENT '사용자 아이디', 
	`assign_id`       INT UNSIGNED NOT NULL COMMENT '양도글 번호'
	`post_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜',
	FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (assign_id) REFERENCES assign (assign_id) ON DELETE CASCADE ON UPDATE CASCADE
)
