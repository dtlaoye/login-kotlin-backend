# GraphQL Login Backend

This is a backend service for user authentication using GraphQL, developed with Kotlin and MongoDB.

## Features
- User authentication with login and signup
- GraphQL API with queries and mutations
- MongoDB integration for storing user data
- Configurable via `application.yml`

## Prerequisites
Ensure you have the following installed:
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/)
- [MongoDB](https://www.mongodb.com/)
- [Java 17+](https://adoptium.net/)

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd login-kotlin-backend
   ```
2. Configure the database settings in `src/main/resources/application.yml`.
3. Build and run the application:
   ```sh
   ./gradlew bootRun
   ```
4. Access the GraphQL Playground at `http://localhost:8080/graphql`.

## API Usage
Example GraphQL query to fetch user data:
```graphql
query {
  getUser(id: "123") {
    id
    name
    email
  }
}
```

## Running Tests
Run the test suite with:
```sh
./gradlew test
```

## Contributing
Feel free to submit issues and pull requests.

## License
This project is licensed under the MIT License.
