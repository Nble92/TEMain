import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000",
});
  
export default {

  login(user) {
    return http.post('/token', user)
  },

  register(user) {
    return http.post('/users', user)
  }

}
