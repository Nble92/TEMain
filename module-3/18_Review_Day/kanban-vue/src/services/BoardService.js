import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000",
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    let meow
    if (card.cat) {
      meow = "true"
      return http.post('/cards', card, { params: { meow }});
    } else {
      return http.post('/cards', card);
    }
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  },

  addBoard(board) {
    return http.post('/boards', board)
  },

  deleteBoard(boardID) {
    const authStr = 'Bearer ' + localStorage.getItem('token'); 
    return http.delete(`/boards/${boardID}`, { headers: { Authorization: authStr } })
  }
}
