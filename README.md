# 🍽️ Welcome to BatiCuisine! 🍽️

Hello, Kitchen Renovation Pros! 👋

Welcome to **BatiCuisine**, a robust Java-based application developed to assist professionals in kitchen renovations. **BatiCuisine** streamlines client management, helps create detailed quotes, and keeps track of the financial and operational aspects of your kitchen projects.

## 🚀What is BatiCuisine?

**BatiCuisine** is a tool designed to streamline your kitchen renovation business. It helps manage clients, generate accurate quotes, and monitor the financial and logistical aspects of your projects. With BatiCuisine, you can estimate labor costs by the hour, keep track of materials used, and create more precise project forecasts.

## 📁 Project Structure

Here's an overview of the project structure for **BatiCuisine**:

- **config**: Handles configuration settings for the application: `DatabaseConnection`
- **dto**: Includes Data Transfer Objects (DTOs) for passing data between layers.
- **models**: Defines the models representing clients, projects, quotes, materials, components, and workforce.
- **repositories**: Contains repository classes for database operations.
- **services**: Business logic layer for managing core functionalities such as projects, clients, and materials.
- **ui**: Contains the `ConsoleUI` class, which manages user interactions through a console-based interface.
- **utils**: Utility classes that handle additional helper functions and validations.
- **resources**: Stores application properties and SQL scripts.
    - `app.properties`: Contains the application's configuration settings such as database details.
    - `batiCuisine.sql`: SQL file for creating the necessary database schema.

## 🧩 Key Features

- 🛠 **Manage Projects**: Create, view, and manage renovation projects for clients.
- 📑 **Personalized Quotes**: Generate detailed quotes based on materials and hourly labor costs.
- 👥 **Client Management**: Manage client details, including retrieving their associated projects.
- 🧱 **Component Management**: Add, update, delete, or view project components.
- 📊 **Financial Tracking**: Track the costs associated with each project, including materials and labor.


## 🛠️ How to Set Up BatiCuisine

### Requirements

Ensure you have the following installed on your machine:

- **Java 8** or later
- **PostgreSQL** database with the necessary tables and schema (setup instructions below)
- **JDBC Driver** for PostgreSQL
- A console or terminal to run the application

### Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/SpangorBen/BatiCuisine.git
   cd BatiCuisine

2. Create a PostgreSQL database and run the SQL script to set up the necessary tables:
    ```bash
    psql -U yourusername -d yourdatabase -f resources/batiCuisine.sql
    ```
   Replace `yourusername` and `yourdatabase` with your PostgreSQL username and the name of the database you want to create.

3. Update the `app.properties` file in the `resources` directory with your database connection details.

### Running the JAR File
To run the application, execute the following command:
```bash
     cd out/artifacts/batiCuisine_jar
     java -jar batiCuisine.jar
```


For any questions, feedback, or suggestions, feel free to reach out to us. I'd love to hear from you! 📧
