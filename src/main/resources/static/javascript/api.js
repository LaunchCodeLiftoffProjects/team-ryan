async function start() {
const response = await fetch("https://api.spoonacular.com/recipes/complexSearch?apiKey=3057efc6229646c8b0bda8fd922322a6&includeNutrition=true&cusine=true")
//("https://api.spoonacular.com/recipes/716429/information?apiKey=3057efc6229646c8b0bda8fd922322a6&includeNutrition=true.")
const data = await response.json()
console.log(data)
//returns title
console.log(data.results[0].title);
//returns image
console.log(data.results[0].image)
//need to return type of cuisine
//may need to change parameter once added to other files
createRecipeList(data)
}

start()
function createRecipeList(recipeList){
  document.getElementById("recipe").innerHTML = `
  <select>
      <option>Choose a Dish</option>
      ${Object.keys(recipeList).map(function(recipe){
        //modify to table?
        return `<option>${recipe[0[0["title"]]]}</option>`
        //removes commas
      })
      //.join('')
      }
    </select>
  `

}