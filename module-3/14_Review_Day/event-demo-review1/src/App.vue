<template>
  <div id="app">
    <fun-table :row-count="3" :col-count="5" :table-id="1"/>
  </div>
</template>

<script>
import FunTable from './components/FunTable.vue';

export default {
  name: 'app',
  components: {
    FunTable
  }
}
</script>


<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
