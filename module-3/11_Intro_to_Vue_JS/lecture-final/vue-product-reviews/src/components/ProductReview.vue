<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class='well-display'>

        <div class='well'>
            <span class='amount'>{{ averageRating }}</span>
            Average Rating
        </div>

        <div class='well'>
            <span class='amount'>{{numberOfOneStarReviews}}</span>
            1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
        </div>

        <div class='well'>
            <span class='amount'>{{numberOfTwoStarReviews}}</span>
            2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
        </div>
        <div class='well'>
            <span class='amount'>{{numberOfThreeStarReviews}}</span>
            3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
        </div>
        <div class='well'>
            <span class='amount'>{{numberOfFourStarReviews}}</span>
            4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
        </div>
        <div class='well'>
            <span class='amount'>{{numberOfFiveStarReviews}}</span>
            5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
        </div>

    </div>



    <div class="review" v-bind:class="{ favorited: review.favorited }" v-for="review in reviews" v-bind:key="review.id">
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>

      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>Favorite? <input type="checkbox" v-model="review.favorited"></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all your squirrelly friends.",
      reviews: [
        {
          id: 1,
          reviewer: "Tom",
          title: "A great book!",
          review: "The best book I've ever read!",
          rating: 5,
          favorited: false
        },
        {
          id: 2,
          reviewer: "Jim",
          title: "A great book!",
          review: "The best book I've ever read!",
          rating: 3,
          favorited: false
        },
        {
          id: 3,
          reviewer: "Mary",
          title: "A book!",
          review: "The shortest book I've ever read!",
          rating: 3,
          favorited: false
        },
        {
          id: 4,
          reviewer: "Joe",
          title: "A so so book!",
          review: "Just okay",
          rating: 2,
          favorited: false
        },
        {
          id: 5,
          reviewer: "Nancy",
          title: "A bad book!",
          review: "The worst book I've ever read!",
          rating: 1,
          favorited: false
        },
      ],
    };
  },
  computed: {
      averageRating() {
         let sum = this.reviews.reduce( (currentSum, review) => {
                return currentSum + review.rating;
         }, 0)   

        return sum / this.reviews.length;
      },

      numberOfOneStarReviews() {
          let count = this.reviews.reduce( (currentCount, review) => {
              if (review.rating === 1) {
                  currentCount++
              }
              return currentCount;
          }, 0)
            
        return count
      },

    numberOfTwoStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 2);
      }, 0);
    },
    numberOfThreeStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 3);
      }, 0);
    },
    numberOfFourStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 4);
      }, 0);
    },
    numberOfFiveStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 5);
      }, 0);
    }



  }



};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.main div.review.favorited {
    background-color: lightyellow;
}

</style>