
const PROBLEMS_PER_SET = 10
let problemSet = [];


let currentProblem = 1;
let score = 0; 

function generateProblemSet() {

    for(let i = 0; i < PROBLEMS_PER_SET; i++){
        

        // create new problem set

const problem = {
        left: getRandomNumber(10),
        right: getRandomNumber(10),
        operator: 'X'

    }


    problemSet.push(problem)
}
}

/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
 function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }


document.addEventListener("DOMContentLoaded", (event) => {

     generateProblemSet()

//display current problem
const display = document.querySelector('div')
display.append(problemSet[0].left + " " + problemSet[0].operator + " " + problemSet[0].right)
//display answer set
const answers = document.querySelectorAll('li')
answers.forEach( (ans) => {

ans.append(getRandomNumber(10))

})
//display current problem number
//display score
const currentScore = document.querySelector(".currentScore > span")
//event listeners to 'li's in the DOM - clicks
answers.forEach((ans) => {
    ans.addEventListener('click', generateProblemSet)

    currentScore.append('1')

})
//click event listener for 'Start over'

//toggle on show-hide class

})