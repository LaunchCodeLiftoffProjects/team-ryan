//let appName = "Recipe App";
//
//
//
//async function search(searchTerm) {
//  // building our url
//  var apiKey = '3057efc6229646c8b0bda8fd922322a6';
//  var api = 'https://api.spoonacular.com/recipes/complexSearch?apiKey=' + apiKey + '&instructionsRequired=true&includeIngredients=' + searchTerm;
//  // retrieving data
//  const response = await fetch(api);
//  const data = await response.json();
//  // using data
//  console.log(api);
//  console.log(data);
//  displayResults(data);
//}
//
//searchByIngredient.addEventListener('click', function (e) {
//  var searchTerm = document.getElementById("ingredientToSearch").value;
//
//  if(typeof(searchTerm) != 'string') {
//      e.preventDefault();
//      console.log("if statement " + searchTerm);
//
//  } else {
//    //grabbing user input
//    (console.log("else statement " + searchTerm));
//    search(searchTerm);
//  }
//});
//
//function displayResults (results) {
//  const displayData = document.getElementById("results");
//  for(let i = 0; i < results.results.length; i++) {
//  var apiRecipeId = ((results.results[i].id).toString());
//console.log(apiRecipeId);
// displayData.innerHTML += `
//    <div>
//      <a href="/recipes/external?id=${apiRecipeId}">${results.results[i].title} </a>
//        <img src="${results.results[i].image}"/>
//    </div>
//  `;
//}
//}
