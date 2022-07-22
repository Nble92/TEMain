
const PROBLEMS_PER_SET = 10
let problemSet = [];
let currentProblem = 1;
let score = 0;

function generateProblemSet() {
    for (let i = 0; i < PROBLEMS_PER_SET; i++) {

        const problem = {
            left: getRandomNumber(10),
            right: getRandomNumber(10),
            operator: 'multiply'
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


    // create new problem set
    // display current problem
    // display answer set
    // display current problem number
    // display score
    // add event listeners to the li's in the DOM - click events
    // add event listener to the start over button
    // toggle on show-hide class when complete


})