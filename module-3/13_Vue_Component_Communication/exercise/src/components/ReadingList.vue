<template>
  <div class="book-container">
    <!-- created bookcards with v-for -->
<book-card 

v-for="currentBook in $store.state.books"
v-bind:key="currentBook.isbn"
v-bind:book="currentBook"
/>
  </div>
</template>

<script>
import BookCard from "./BookCard"

export default {
    name: 'reading-list',
    components: { 
      BookCard
},

}

</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>