const express = require('express');
const app = express();
const pool = require('./db');

//middleware
app.use(express.json());

//get a user
app.get('/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const user = await pool.query('SELECT * FROM users WHERE user_id = $1', [
      id,
    ]);
    res.json(user.rows[0]);
  } catch (err) {
    console.error(err.message);
  }
});

//post a rating
app.post('/rating', async (req, res) => {
  try {
    const { user_id, book_id, rating } = req.body;

    // Check if a rating already exists for the user and book
    const checkRating = await pool.query(
      'SELECT * FROM reviews WHERE user_id = $1 AND book_id = $2',
      [user_id, book_id]
    );

    let postRating;

    if (checkRating.rows.length > 0) {
      // If rating exists, update the existing review
      postRating = await pool.query(
        'UPDATE reviews SET rating = $3 WHERE user_id = $1 AND book_id = $2 RETURNING *',
        [user_id, book_id, rating]
      );
    } else {
      // If no rating exists, insert a new review
      postRating = await pool.query(
        'INSERT INTO reviews (user_id, book_id, rating) VALUES ($1, $2, $3) RETURNING *',
        [user_id, book_id, rating]
      );
    }

    // Send the newly created or updated rating back in response
    res.json({
      user_id: postRating.rows[0].user_id,
      book_id: postRating.rows[0].book_id,
      rating: postRating.rows[0].rating,
    });
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Server error' });
  }
});

//post a comment
app.post('/comment', async (req, res) => {
  try {
    const { user_id, book_id, comment } = req.body;

    // Check if a rating already exists for the user and book
    const checkRating = await pool.query(
      'SELECT * FROM reviews WHERE user_id = $1 AND book_id = $2',
      [user_id, book_id]
    );

    let postRating;

    if (checkRating.rows.length > 0) {
      // If comment exists, update the existing review
      postRating = await pool.query(
        'UPDATE reviews SET rating = $3 WHERE user_id = $1 AND book_id = $2 RETURNING *',
        [user_id, book_id, comment]
      );
    } else {
      // If no comment  exists, insert a new review
      postRating = await pool.query(
        'INSERT INTO reviews (user_id, book_id, comment) VALUES ($1, $2, $3) RETURNING *',
        [user_id, book_id, comment]
      );
    }

    // Send the newly created or updated rating back in response
    res.json({
      user_id: postRating.rows[0].user_id,
      book_id: postRating.rows[0].book_id,
      comment: postRating.rows[0].comment,
    });
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Server error' });
  }
});

const PORT = process.env.PORT || 8000;
app.listen(PORT, () => console.log(`Server started on port ${PORT}`));
