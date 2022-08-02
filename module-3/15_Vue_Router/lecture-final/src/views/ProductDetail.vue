<template>
  <div class='main' id='app'>

      <h1>{{ product.name }}</h1>
      <p class='description'>{{ product.description }} </p>

      <div class='actions'>
          <!-- <a href="#">Back to Products</a> -->
          <router-link :to="{ name: 'products'}">Back to Products</router-link>
          |
          <!-- <router-link to="/">Back to Products</router-link> -->
          <!-- <a href="#">Add Review</a> -->
          <router-link :to="{ name: 'add-review', params: {id: product.id} }">Add Review</router-link>
      </div>

      <div class='well-display'>
          <average-summary />
          <star-summary rating='1' />
          <star-summary rating='2' />
          <star-summary rating='3' />
          <star-summary rating='4' />
          <star-summary rating='5' />
      </div>
      <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'

export default {
    name: 'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    created() {
        const activeProductID = this.$route.params.id
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductID)
    },
    computed: {
        product() {
            return this.$store.state.products.find((product) => {
                return product.id == this.$store.state.activeProduct
            })
        }
    }
}
</script>

<style>

</style>