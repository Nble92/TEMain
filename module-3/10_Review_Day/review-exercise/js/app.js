
const PROBLEMS_PER_SET = 10
let problemSet = [];
const currentScore = document.querySelector(".currentScore")
let newScore = 1

let currentProblem = 0;
let displayProb = currentProblem + 1
const choices = document.querySelectorAll('li')



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
let answer = problemSet[currentProblem].left * problemSet[currentProblem].right;


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
newProb(currentProblem);
//display answer set

//targets the list
 getAnswers()


//display current problem number
//display score


//event listeners to 'li's in the DOM - clicks
choices.forEach((ans) => {
    ans.addEventListener('click', () => {
    displayProb += 1
    document.querySelector('.currentProblem').innerText = displayProb
    currentScore.innerText = newScore;
    newScore += 1
    currentProblem += 1;

newProb(currentProblem)
getAnswers()
})
})

function newProb(val){
    
    const display = document.querySelector('div')

display.innerText = ""
display.append(problemSet[val].left + " " + problemSet[val].operator + " " + problemSet[val].right)
}

//click event listener for 'Start over'

//toggle on show-hide class
function getAnswers() {
   let ansArr = ['A', 'B', 'C', 'D']
   let ansArr2 = ansArr.map((choice) =>  { 
       
    if(choice == 'A'){

        return answer
    }
    else {
        
        return getRandomNumber(81)

}
})


    choices.forEach( (ans) => {
    ans.innerText = ""
    if
    ans.append(ansArr2[getRandomNumber(4)])
    })
}
}

)

