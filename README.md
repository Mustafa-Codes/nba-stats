# NBA Player Stats REST API

## Overview
The **NBA Player Stats REST API** is a Spring Boot-based application that provides statistics for NBA players. The API allows users to retrieve player information, career stats, and season performance data.

## Features
- Fetch player details by name or team
- Retrieve career and season statistics
- Filter players based on different criteria
- RESTful API design for easy integration

## Technologies Used
- **Java** (Spring Boot)
- **Spring Web** (for REST API development)
- **Spring Data JPA** (for database interactions)
- **H2/PostgreSQL** (or any other database)
- **Lombok** (for reducing boilerplate code)
- **Swagger** (for API documentation)

## Installation
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- Git
- A database (H2, PostgreSQL, or MySQL)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/nba-stats-api.git
   cd nba-stats-api
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the API at:
   ```
   http://localhost:8080/api/players
   ```

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|--------------|
| GET | `/api/players` | Retrieve all players |
| GET | `/api/players/{id}` | Get player details by ID |
| GET | `/api/players/search?name={name}` | Search players by name |
| GET | `/api/stats/{playerId}` | Get player stats |

## License
This project is licensed under the MIT License.

## Author
Developed by [Mustafa](https://github.com/mustafa-codes). Contributions are welcome!

