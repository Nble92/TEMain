-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent to earliest (9 rows)
SELECT title
FROM MOVIE
WHERE collection_id = 10
ORDER BY release_date DESC;

