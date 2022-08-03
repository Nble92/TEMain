<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>


    <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else >
     <comments-list v-bind:comments="card.comments" />


      <router-link :to="{ name: 'Board', params: {id: $route.params.boardID }}">
          Back to Board

      </router-link>
    </div>
 


  </div>
</template>

<script>
import boardService from '@/services/BoardService.js'
import CommentsList from '@/components/CommentsList'

export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data(){
    return {
      card: {
        title: '',
        description: '',
        status: '',
        comments:[]
      },
      isLoading: true
    }
  },
  created() {
    boardService.getCard(this.$route.params.boardID, this.$route.params.cardID).then( (foundCard) => { 
      this.card = foundCard
      this.isLoading = false
    })
  }
};
</script>
