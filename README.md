# SouthGeeksChallenge

This repository contains a set of API test cases developed using **RestAssured** and **JUnit**, managed with **Maven**. 

## Features

- Automate GET requests to users and posts and do assertions.
- Maven Surefire reports auto generated
- [Github Actions](https://github.com/erissonbreno/SouthGeeksChallenge/actions) on each pull to master branch

---

## Prerequisites

To run the tests locally, ensure you have the following installed:

- **Java**: Version 11 or higher.
- **Maven**: Latest version (minimum 3.0.0).
- **IDE**: Any Java-supported IDE (e.g., IntelliJ IDEA, Eclipse).

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/erissonbreno/SouthGeeksChallenge.git
   cd SouthGeeksChallenge
   ```
2. Open the IDE
3. Right click on the **pom.xml** to download the dependencies.

## Project Structure
- src/test/java/core: Contains the core of the application.
- src/test/java/endpoints: Contains endpoints to be tested.
- src/test/java/tests: Contains the tests written in RestAssured with Junit.
pom.xml: Manages dependencies for the project.

---

## Running Tests
```bash
   mvn test
   ```

--- 

## Report
- Built in maven surefire report is being generated under the folder **target/surefire-reports**, see TEST-tests.PostsTest.xml and TEST-tests.UsersTest.xml files
