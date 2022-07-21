// add pageTitle
const title = "My Shopping List"
// add groceries
const groceries = ['Ice Cream', 'Popcorn', 'Milk', 'Chips','Veggies','Medicine','Protein','Banana',"Cherries","Toothpaste"]
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  // const heading = document.createElement('h1');
  // heading.innerText = title;

pageTitle = document.getElementById('title');
pageTitle.innerText = title
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  

groceries.forEach( (item) =>{
  let newItem = document.createElement('li');
  newItem.innerText = item;
  let grocList = document.getElementById('groceries');
  grocList.insertAdjacentElement('beforeend', newItem);

}
)


}
/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const completed = document.querySelectorAll('#groceries > li')
  completed.forEach( (item) => {
  item.classList.add('completed');
})
  }


setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
