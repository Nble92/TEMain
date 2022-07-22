let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function markItemComplete() {
  const li = document.querySelector('li')
  li.classList.add('completed')

}

//Where the magic happens

document.addEventListener('DOMContentLoaded', (event) => {

  //Sets page title
  setPageTitle()

  displayGroceries()

  //Marks one item complete and incomplete
  const list = document.querySelectorAll('li');
  list.forEach((item) => {
    // when you click on an item mark it completed
    item.addEventListener('click', () => {
      if (!item.classList.contains('completed')) {
        item.classList.add('completed');

      }
    })
  })

      // when you click on a item mark it incomplete
      const list2 = document.querySelectorAll('li');
      list2.forEach((item) => {
      item.addEventListener('dblclick', () => {
       if (item.classList.contains('completed')){
        item.classList.remove('completed');
       
      }
      
    });

  })

    //Mark all complete/incomplete

    const button = document.getElementById('toggleAll');
    button.addEventListener('click', () => {
      const allItems = document.querySelectorAll('li')
      allItems.forEach((item) => {
        if (!item.classList.contains('completed')){

        item.classList.add('completed');
        button.innerText =('Mark All Incomplete')
        }
        else {item.classList.remove('completed');
        button.innerText =('Mark All Complete')}

      })

    });

  

})









