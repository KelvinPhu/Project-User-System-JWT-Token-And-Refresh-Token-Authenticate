
<br />
<div align="center">

  <h1 align="center">Project User System JWT Token And Refresh Token Authenticate</h1>

  <p align="center">
    An application designed to manage employee data effectively
    <br />
    <a href="https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="">View Demo</a>
    ·
    <a href="">Report Bug</a>
    ·
    <a href="">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">Testing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

"Project User System JWT Token And Refresh Token Authenticate" is a Java Spring Framework backend application designed for secure user authentication. It encompasses a comprehensive set of features including user signup and login functionalities. 
Utilizing JSON Web Tokens (JWT), the system ensures secure communication between the client and server, while also implementing token refresh mechanisms to maintain user sessions. 
This project further illustrates the configuration of Spring Security to seamlessly integrate JWT authentication, define data models for user management, and handle token expiration and renewal efficiently. 
Through these implementations, the project showcases best practices for building robust and secure authentication systems in Java Spring applications.

The main functionalities of the "Project User System JWT Token And Refresh Token Authenticate" project include:

- User Signup: Allows users to register for an account by providing necessary information such as username, email, and password.

- User Login with JWT Authentication: Provides users with the ability to securely authenticate themselves using their registered credentials. Upon successful authentication, the server issues a JSON Web Token (JWT) to the client.

- Configuration of Spring Security with JWT: Integrates Spring Security framework to handle user authentication and authorization using JWT tokens.

- Data Models and Associations: Defines data models and their associations to manage user authentication and authorization data effectively.

- JWT Token Generation: Generates JWT tokens upon successful user authentication, containing relevant user information and expiration time.

- JWT Refresh Token: Implements a mechanism to issue refresh tokens along with JWT tokens, allowing users to obtain new access tokens without re-authenticating after the expiration of the current token.

- Token Expiration and Renewal: Manages token expiration by implementing mechanisms to renew access tokens using refresh tokens and HttpOnly cookies, ensuring uninterrupted user sessions and enhanced security.


<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

This section should list any major frameworks/libraries used to bootstrap to this project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

<p style="display: inline-block;" align="center">
  <kbd>
    <kbd>Programming Languages</kbd>
    <br>
    <br>
    <img width="30px" alt="java" src="https://raw.githubusercontent.com/devicons/devicon/55609aa5bd817ff167afce0d965585c92040787a/icons/java/java-original.svg" />
    <img width="30px" alt="spring" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />
    <img width="30px" alt="MySQL" src="https://github.com/KelvinPhu/icon/assets/102346766/eafba208-2b4d-46ce-81a9-309cc737b57f" />
  </kbd>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This guide will help you set up and run the "Project User System JWT Token And Refresh Token Authenticate" project locally.

### Prerequisites

- JDK (Java Development Kit) installed on your system
- Maven build tool installed
- MySQL database installed and running
- Your favorite code editor or IDE (Integrated Development Environment)

### Spring Framework setup
* Clone the Repository:
  Clone the project repository from GitHub using the following command:
  ```sh
  git clone <repository_url>
  ```

* Navigate to Project Directory:
  Move into the project directory using the cd command:
  ```sh
  cd <project_directory>
  ```

* Configure MySQL Database:
  Set up your MySQL database and configure the database properties in the `$ application.properties` file located in the `$ src/main/resources ` directory.
  
* Build the Project:
  Use Maven to build the project:
    ```sh
  mvn clean install
  ```

* Run the Application:
  Execute the generated JAR file to run the application:
    ```sh
  java -jar target/<generated_jar_file>.jar
  ```

* Access the Application:
  Once the application is running, you can access the endpoints for user signup and login using tools like Postman or cURL.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Troubleshooting

* Database Connection: If the backend can't connect to the database, check your MySQL service and ensure the credentials in `$ application.properties` are correct.
* Port Conflicts: If you encounter port conflicts (e.g., if port 8080 or 3000 is already in use), you can change the port in the backend's `$ application.properties` file `$ (server.port=yourNewPort)` and the frontend's `$ .env` file, if applicable.
* Dependencies: If you face issues with missing or incompatible npm packages, ensure you've run `$ npm install` from within the frontend directory and that your `$ package.json` file is correctly set up.

<!-- USAGE EXAMPLES -->
## Usage

- Use the provided endpoints for user signup and login to authenticate users and obtain JWT tokens.
- Test the token expiration and renewal mechanisms to ensure seamless user sessions.

### Additional Configuration
- Customize the application properties in the `$ application.properties` file to suit your environment and requirements.
- Explore and modify the source code to extend the functionality or integrate additional features.

```
# Set up DataBase Connection - mongoDB
spring:
  datasource:
    url: jdbc:sqlserver://THIEN-PHU:1433;databaseName=ProjectJWTTokenAndRefreshToken;encrypt=false
    driverClassName: com.microsoft.sqlserver.jdbc.SQLServerDriver
    username: sa
    password: 123456789Thien_Phu

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.SQLServerDialect
    show-sql: true

---
# Set up JWT Token
Kelvin:
  app:
    jwtSecret: "7NNdHNWWbyUK0AjbPCovcFEmzTcnC9CUwzCBZvrXl7irVN2zijJCVrJHEHhzvoZpCExEwEMj9w3r1ADrzbGFGZsULb3gsSk0n7Rp2vH1MjF3VdGIlhcN0WJSGbWJ5jyp"
    jwtExpirationMs: 3600000
    jwtRefreshExpirationMs: 86400000
```

### Setting Up Controllers

Start by creating controllers for user signup and login functionalities.
Define endpoints to handle user requests, such as `$ /api/auth/signup` for user registration and `$ /api/auth/login` for user authentication.

```
@PostMapping("/signup")
public ResponseEntity<?> registeruser(@Valid @RequestBody SignupDto signupDto){
		...
}

@PostMapping("/signin")
public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninDto signinDto){
    ...		
}
```


### Configuration

Configure Spring Security to work with JWT tokens by creating a `$ SecurityConfig` class.
Define security rules and access permissions for different endpoints using annotations like `$ @EnableWebSecurity` and `$ @EnableGlobalMethodSecurity`.

```
@Bean
public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
	   
    return authProvider;
}

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> 
	          auth.requestMatchers("/api/auth/**").permitAll()
	              .requestMatchers("/api/test/**").permitAll()
	              .anyRequest().authenticated()
	        );
	    
	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
}
```

### Setting Up JWT Token and Refresh Token
- Implement JWT token generation and validation logic in the `$ JwtUtils class` .
- Generate a JWT token upon successful user authentication, including user details and expiration time.
- Implement a mechanism to generate and store refresh tokens securely.

```
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration.ms}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Other methods for token validation, extraction, etc.
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ROADMAP -->
## Roadmap

Roadmap for Project User System JWT Token And Refresh Token Authenticate

1. **Setup Project Structure:**
   - Define project directory structure.
   - Initialize Git repository.
   - Set up Maven for dependency management.

2. **Implement User Authentication:**
   - Create user entity and repository.
   - Implement user signup and login functionality.
   - Configure Spring Security for basic authentication.

3. **Integrate JWT Authentication:**
   - Add dependencies for JWT token generation.
   - Configure JWT token provider and authentication filter.
   - Implement token generation and validation logic.

4. **Implement Refresh Token Mechanism:**
   - Define refresh token entity and repository.
   - Implement refresh token generation and storage.
   - Integrate refresh token with JWT authentication.

5. **Configure Security with JWT:**
   - Secure endpoints using JWT token authentication.
   - Customize security configurations for different endpoints.
   - Implement role-based access control using JWT claims.

6. **Handle Token Expiration and Renewal:**
   - Implement token expiration mechanism.
   - Configure token renewal using refresh tokens.
   - Test token expiration and renewal scenarios.

7. **Enhance Error Handling and Logging:**
   - Implement error handling for authentication failures.
   - Add logging for authentication and authorization events.
   - Customize error responses for better user feedback.

8. **Implement User Management Features:**
   - Add endpoints for user profile management.
   - Implement password reset functionality.
   - Develop user role management features.

9. **Testing and Validation:**
   - Write unit tests for authentication and authorization logic.
   - Conduct integration tests for API endpoints.
   - Validate token generation, expiration, and renewal processes.

10. **Documentation and Deployment:**
    - Document API endpoints and usage examples.
    - Provide instructions for setting up and configuring the project.
    - Prepare the application for deployment to production environment.

11. **Review and Optimization:**
    - Perform code review and refactor where necessary.
    - Optimize performance of authentication and token management.
    - Ensure compliance with best practices and security standards.

12. **Future Enhancements:**
    - Explore additional security measures such as two-factor authentication.
    - Implement audit logging for user activities.
    - Integrate with external authentication providers like OAuth.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- TESTING -->
## Testing with Postman

1. **User Signup Endpoint:**
   - Create a new request in Postman to the signup endpoint (`/api/auth/signup`).
   - Send a POST request with the user's details (e.g., username, email, password) in the request body.
     
     ![1](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/f10c4680-5b4e-43af-b966-cccc587078ab)
     
   - Verify that the user is successfully created and receives a response with a status code of 200 or 201.

     ![3](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/cc540013-dd6e-41eb-9caf-8d3216d9e6bf)

2. **User Login Endpoint:**
   - Create another request in Postman to the login endpoint (`/api/auth/login`).
   - Send a POST request with the user's credentials (e.g., username/email and password) in the request body.
     
     ![2](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/c3e65b45-1e71-4718-92c0-3bc0c51b18a0)

   - Verify that the user is authenticated and receives a response containing the JWT access token.
  
     ![4](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/3ddeb223-f503-4feb-adc5-7f000472751e)


3. **Access Protected Resources:**
   - Use the access token obtained from the login response to access protected resources (e.g., `/api/users/profile`).
  
     ![5](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/32356563-2c06-48a6-954e-0e6214e0272b)

   - Add the token to the request headers with the key `Authorization` and value `Bearer <access_token>`.
  
     ![6](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/5e86ee36-a423-4f07-9b06-65065f4697ac)

   - Send a GET request to the protected endpoint and verify that the user's profile information is returned.

4. **Token Expiration and Refresh:**
   - Test token expiration by waiting for the access token to expire (based on the token expiration time).
   - Attempt to access a protected resource with the expired token and verify that it results in a 401 Unauthorized error.
   - Test token refresh by sending a POST request to the refresh token endpoint (`/api/auth/refresh`) with the expired access token.
   - Verify that a new access token is generated and returned in the response.

     ![7](https://github.com/KelvinPhu/Project-User-System-JWT-Token-And-Refresh-Token-Authenticate/assets/102346766/ebe84372-2e9f-4808-8555-ef36039681be)


5. **Invalid Token Handling:**
   - Test invalid token handling by sending requests with an invalid or tampered access token.
   - Verify that the server responds with a 401 Unauthorized error and prompts the user to log in again.

6. **Logout Endpoint:**
   - Test the logout functionality by sending a POST request to the logout endpoint (`/api/auth/logout`).
   - Verify that the user's session is invalidated, and the access token is no longer accepted for authentication.

7. **Error Handling:**
   - Test various error scenarios (e.g., invalid input, server errors) and verify that the API returns appropriate error responses with descriptive error messages.

8. **Additional Testing:**
   - Perform additional testing based on specific use cases and edge cases relevant to your application's requirements.
   - Test different user roles and permissions to ensure proper access control and authorization.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

### How to Contribute

1. **Fork** the repository.
2. **Clone** the forked repository to your local machine.
    ```bash
    git clone https://github.com/your-username/Project-FullStack-Employee-System-CRUD.git
    ```
3. **Create a new branch** for your feature or bug fix.
    ```bash
    git checkout -b feature/your-feature-name
    ```
4. **Make changes** to the codebase.
5. **Test** your changes thoroughly.
6. **Commit** your changes.
    ```bash
    git commit -m "Add your commit message here"
    ```
7. **Push** your changes to your fork.
    ```bash
    git push origin feature/your-feature-name
    ```
8. Create a new **Pull Request** from your forked repository to the original repository.
9. Provide a descriptive title and detailed description for your Pull Request.
10. Wait for maintainers to review your Pull Request and address any feedback if necessary.
11. Once approved, your changes will be merged into the main project.

### Guidelines

- Follow the project's coding style and guidelines.
- Ensure your code is well-tested.
- Provide detailed and clear commit messages.
- Be respectful to others and their contributions.
- If you're unsure about something, don't hesitate to ask for clarification or guidance.

### Found a Bug or Have a Feature Request?

If you encounter any bugs or have suggestions for new features, please [open an issue](https://github.com/your-username/Project-FullStack-Employee-System-CRUD/issues) on GitHub. Provide detailed information about the problem or feature request, including steps to reproduce for bugs.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Huynh Thien Phu - [@kelvin_hnh](https://twitter.com/kelvin_hnh) - phuhuynh197@gmail.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

We would like to express our gratitude to the following individuals and organizations for their contributions to this project:

- [Open Source Community](https://opensource.org/): For providing a wealth of knowledge and resources to the community.
- [Stack Overflow](https://stackoverflow.com/): For being an invaluable resource for troubleshooting and problem-solving.
- [GitHub](https://github.com/): For providing an excellent platform for collaboration and version control.
- [ReactJS Documentation](https://reactjs.org/): For comprehensive documentation and tutorials on ReactJS.
- [Spring Framework Documentation](https://spring.io/): For extensive documentation and guides on the Spring Framework.
- [Bootstrap Documentation](https://getbootstrap.com/): For clear and concise documentation on Bootstrap.
- [Axios Documentation](https://axios-http.com/): For detailed documentation and examples on Axios.
- [MySQL Documentation](https://dev.mysql.com/doc/): For comprehensive documentation on MySQL.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
