<template>
  <div class="book-container">

    <!-- created bookcards with v-for -->
<book-card></book-card>
  </div>
</template>

<script>

export default {
    name: 'reading-list'
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>