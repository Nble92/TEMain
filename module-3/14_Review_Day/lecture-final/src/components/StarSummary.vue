<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ starRating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["starRating"],
  methods: {
    updateFilter() {
      this.$store.commit('UPDATE_FILTER', parseInt(this.starRating))
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.starRating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

