-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)

SELECT title
FROM MOVIE
JOIN Person ON movie.director_id = person.person_id
WHERE collection_id = 10 AND person_name != 'George Lucas';