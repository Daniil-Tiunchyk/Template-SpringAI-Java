# Spring AI Project

## Overview
The Spring AI project is a Spring Boot application designed to demonstrate integration with OpenAI's API using the Spring framework. It features a simple RESTful API that interacts with OpenAI to perform tasks like translating phrases and generating text based on prompts.

## Features
- **Hello World Translation:** Translate "Hello World" into Chinese.
- **Custom Prompt Processing:** Send custom prompts to OpenAI and receive generated responses.
- **Learning Mode:** Ask OpenAI to explain concepts in simple terms.

## Prerequisites
- Java 21
- Maven 3.6 or higher
- An OpenAI API key

## Setup
1. **Clone the Repository:**
   ```shell
   git clone https://github.com/Daniil-Tsiunchyk/Java-SpringAI.git
   cd spring-ai
   ```

2. **Configure OpenAI API Key:**
   Add your OpenAI API key to `application.properties` file:
   ```properties
   spring.ai.openai.api-key=[YOUR_API_KEY]
   ```

3. **Build the Project:**
   Use Maven to build the project:
   ```shell
   mvn clean install
   ```

4. **Run the Application:**
   ```shell
   mvn spring-boot:run
   ```

## Usage
The application exposes several endpoints:

- **Hello World Translation:**
  ```
  GET /ai/hello
  ```

- **Send Custom Prompt:**
  ```
  GET /ai/{prompt}
  ```
  Replace `{prompt}` with your custom prompt.

- **Learning Mode:**
  ```
  GET /ai/learn/{message}
  ```
  Replace `{message}` with the concept you want explained.

## API Reference
- **/ai/hello**
  - Method: GET
  - Description: Translates "Hello World" into Chinese using OpenAI.
  - Response: Translated text or error message.

- **/ai/{prompt}**
  - Method: GET
  - Path Variable: `prompt` - The custom prompt to send to OpenAI.
  - Description: Sends a custom prompt to OpenAI and returns the response.
  - Response: Generated text or error message.

- **/ai/learn/{message}**
  - Method: GET
  - Path Variable: `message` - The concept to be explained.
  - Description: Asks OpenAI to explain the specified concept in simple terms.
  - Response: Explanation or error message.

## Logging
The application logs important information and errors, which can be found in the application's log files.

## Dependencies
- Spring Boot Starter Web
- Project Lombok (optional)
- Spring Boot Starter Test (for testing purposes)
- Spring AI OpenAI Spring Boot Starter

## Repository Configuration
Maven repository configuration is provided in the `pom.xml` file to ensure the necessary dependencies are fetched properly.

## Contributing
Contributions to the Spring AI project are welcome. Please follow the standard procedures for submitting issues or pull requests.

## License
The project is licensed under the MIT License. For more details, see the [LICENSE.md](LICENSE.md) file.

## Contact
For any inquiries or to discuss contributions, you can reach out to me via email at [fcad.td@gmail.com](mailto:fcad.td@gmail.com), on [LinkedIn](https://linkedin.com/in/daniil-tsiunchyk/en), or on [Telegram](https://t.me/fcad_daniil).

## Star the Project
If you find this project useful, please consider giving it a star on GitHub. Your support is greatly appreciated!

---
