/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  


  let myText = 'Hello "World"';

  myText = "Hello 'Text'";

  let MyOtherVariable;

  MyOtherVariable = 'something';



 // console.log('foo =' + foo);

  let foo;
  console.log('foo = ' + foo);


  foo = null;

  console.log('foo = ' + foo);


  foo = 1;

  console.log('1) foo = ' + foo);

  foo = "one";

  foo = null;


  console.log(null == false)

  if (undefined == false) {
    console.log('!!true')
  }else {
    console.log('!!false')
  }

  console.log('2) foo = ' + foo);

  foo = undefined;
  console.log('foo = ' + foo);


// some code ...


  //let foo = 7;








  // Declares a variable where the value cannot be changed
  const DAYS_PER_WEEK = 7;
  console.log(`There are ${DAYS_PER_WEEK} days in a week`);


  //const NOT_ALLOWED;


  // Declares a variable those value can be changed
  let daysPerMonth = 30;
  console.log('There are ' + daysPerMonth + ' days in a month.');





  // Declares a variable that will always be an array

  let weekdays = [
    "Monday",
    2,
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  ]


  console.log(weekdays);
  //console.table(WEEKDAYS);

  console.log('length=' + weekdays.length)



  weekdays.push('Newday');
  console.log(weekdays);

  let popped = weekdays.pop();
  console.log(weekdays);
  console.log('popped=' + popped);




  weekdays.unshift('Newday');
  console.log(weekdays);

  let shifted = weekdays.shift();
  console.log(weekdays);
  console.log('shifted=' + shifted);


  let fridayIndex = weekdays.indexOf('Friday');
  console.log('fridayIndex = ' + fridayIndex);




  // for (let i = 0;i < 10; ++i) {

  //   if (i === 3) {
  //     let i = 10;


  //     console.log("i=" + i);


  //   }



  // }

}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    toString: function() {
      return `${this.lastName}, ${this.firstName}`; 
    }

  };

  // Log the object

  console.log(person.toString());
  //console.table(person);

  // Log the first and last name

  console.log(`${person.firstName} ${person.lastName}`);


  // Log each employee

  // for (let i = 0; i < person.employees.length; i++) {
  //     console.log(person.employees[i]);
  // }

  person.employees.forEach(employee => console.log(employee));

}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
