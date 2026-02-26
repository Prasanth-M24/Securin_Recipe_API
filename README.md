Code:
    1. Clone the repository "git clone repository_link"

DataBase setup:
    1. In application.property change the user_name and password.
    2. create the database using the given command "CREATE DATABASE recipedb"
    3. Table need not be create.
    4. (Optional) If you want manually to select the data use command "SELECT * FROM recipes"

API testing:
    1. To run the spring application use the command "mvn spring-boot:run"

    2. Use Postman to parse the JSON data/file : Open the Postman and go to the POST request and use the link to upload the JSON file "http://localhost:8080/upload". In body select the form-data and give Key = "file" and change the file type as Text -> File. Then click the send option
    
    3. Add a new Recipe 
        In postman change to POSt and use "http://localhost:8080/recipe". Select body and then choose "raw" then give the input as JSON.
        Eg: {"title":"Chocolate Cake","rating":3.5,"cuisine":"Dessert","prep_time":20,"cook_time":40,"description":"A rich chocolate cake...","nutrients":{"calories":"500 kcal","carbohydrateContent":"60 g","proteinContent":"6 g","fatContent":"25 g"},"serves":"6 servings"}

    4. To get the top rating food with limit value use the API "http://localhost:8080/recipes/top" and then in key = limit, value = "any number" or "http://localhost:8080/recipes/top?limit=2" use this link for top 2 according to the Rating.
