-- queries --
-- Fetching all information for a user by username
SELECT * 
FROM tUser
WHERE username = 'manasa';

-- Getting all posts by a specific user  --
SELECT 
    p.post_id, 
    u.username, 
    p.content, 
    p.image_url, 
    p.created_at, 
    p.likes_count
FROM tPosts p
JOIN tUser u ON p.user_id = u.user_id
WHERE u.username = 'ujitha'
ORDER BY p.created_at DESC;

-- Getting all posts with more than 10 likes

SELECT * from tPosts 
where likes_count>10;

-- Fetching all friends of a user with status = 'accepted'
SELECT 
    f.friendship_id,
    u.username AS user_name,
    u2.username AS friend_name,
    f.status,
    f.created_at
FROM tFriends f
JOIN tUser u ON f.user_id = u.user_id
JOIN tUser u2 ON f.friend_id = u2.user_id
WHERE u.username = 'ujitha' AND f.status = 'accepted';

-- Finding users who have not posted in the last 30 days
SELECT 
    u.user_id,
    u.username,
    u.full_name
FROM tUser u
WHERE u.user_id NOT IN (
    SELECT DISTINCT p.user_id
    FROM tPosts p
    WHERE p.created_at >= NOW() - INTERVAL 30 DAY
);

-- Calculating average number of posts per user
SELECT 
    ROUND(COUNT(p.post_id) / COUNT(DISTINCT u.user_id), 2) AS avg_posts_per_user
FROM tUser u
LEFT JOIN tPosts p ON u.user_id = p.user_id;


-- Top 5 users with the most friends
SELECT 
    u.username,
    COUNT(f.friend_id) AS total_friends
FROM tUser u
JOIN tFriends f ON u.user_id = f.user_id
WHERE f.status = 'accepted'
GROUP BY u.user_id, u.username
ORDER BY total_friends DESC
LIMIT 5;


-- Get all comments for a post with user details
SELECT 
    c.comment_id,
    u.username,
    u.full_name,
    c.comment_text,
    c.created_at
FROM tComments c
JOIN tUser u ON c.user_id = u.user_id
WHERE c.post_id = 1
ORDER BY c.created_at ASC;


-- Finding  mutual friends between two users
SELECT 
    u.username AS mutual_friend
FROM tFriends f1
JOIN tFriends f2 ON f1.friend_id = f2.friend_id
JOIN tUser u ON f1.friend_id = u.user_id
WHERE f1.user_id = (SELECT user_id FROM tUser WHERE username = 'ujitha')
  AND f2.user_id = (SELECT user_id FROM tUser WHERE username = 'archana')
  AND f1.status = 'accepted'
  AND f2.status = 'accepted';

-- Deleting posts older than 1 year
DELETE FROM tPosts
WHERE created_at < NOW() - INTERVAL 1 YEAR;