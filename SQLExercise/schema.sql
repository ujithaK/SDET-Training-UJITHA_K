CREATE DATABASE Social_media_db;
USE Social_media_db;

-- USERS TABLE
CREATE TABLE tUser (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    date_of_birth DATE,
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP
);

-- FRIENDS TABLE 
CREATE TABLE tFriends (
    friendship_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    friend_id INT,
    status ENUM('pending', 'accepted', 'blocked'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES tUser(user_id) ON DELETE CASCADE,
    FOREIGN KEY (friend_id) REFERENCES tUser(user_id) ON DELETE CASCADE
);

-- POSTS TABLE 
CREATE TABLE tPosts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    content TEXT NOT NULL,
    image_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    likes_count INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES tUser(user_id) ON DELETE CASCADE
);

-- COMMENTS TABLE 
CREATE TABLE tComments (
    comment_id INT PRIMARY KEY AUTO_INCREMENT,
    post_id INT,
    user_id INT,
    comment_text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES tPosts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES tUser(user_id) ON DELETE CASCADE
);

-- INSERT USER DATA
INSERT INTO tUser (username, email, password_hash, full_name, date_of_birth, phone, last_login)
VALUES
('ujitha', 'ujitha@gmail.com', 'uji321', 'Ujitha Reddy', '2003-10-14', '9876543210', NOW()),
('manasa', 'manasa@gmail.com', 'manu234', 'Manasa Devi', '2002-10-04', '9876500011', NOW()),
('archana', 'archana@gmail.com', 'archu345', 'Archana', '2003-11-10', '9876522233', NOW()),
('haripriya', 'haripriya@gmail.com', 'hari456', 'Haripriya', '2003-08-24', '9876599999', NOW()),
('padma', 'padma@gmail.com', 'pass567', 'Padmapadhu', '2002-05-09', '9976512345', NOW()),
('gayathri', 'gayathri@gmail.com', 'gayi765', 'Gayathri', '2004-02-12', '9676534567', NOW());

-- FRIEND RELATIONSHIPS
INSERT INTO tFriends (user_id, friend_id, status)
VALUES
(1, 2, 'accepted'),
(1, 3, 'accepted'),
(2, 3, 'pending'),
(3, 4, 'accepted'),
(4, 5, 'blocked'),
(5, 6, 'accepted'),
(6, 1, 'accepted');

-- POSTS
INSERT INTO tPosts (user_id, content, image_url, likes_count)
VALUES
(1, 'Exploring new places while travelling!', NULL, 15),
(2, 'Visited ancient temples today 🛕', 'temple1.jpg', 9),
(3, 'Had an amazing party with friends 🎉', NULL, 22),
(4, 'Fun day out at the beach 😎', 'fun_day.png', 11),
(5, 'Being a true foodie today 🍜', NULL, 8),
(6, 'Another travelling adventure begins 🌍', 'travel2.jpg', 18);

-- COMMENTS
INSERT INTO tComments (post_id, user_id, comment_text)
VALUES
(1, 2, 'That’s awesome, Ujitha!'),
(1, 3, 'Keep it up!'),
(2, 1, 'Beautiful temple, Manasa!'),
(3, 4, 'Looks like fun, Archana!'),
(4, 5, 'So cool, Haripriya!'),
(5, 6, 'Yummy!'),
(6, 1, 'Safe travels, Gayathri!');
