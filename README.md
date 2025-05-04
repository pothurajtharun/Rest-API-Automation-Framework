# Rest API Automation Framework

A scalable and modular REST API automation framework built using Java, TestNG, and Rest Assured. This framework is designed for testing RESTful APIs effectively with minimal configuration and high code reusability.

## 🚀 Features

- ✅ Java-based test development
- 🧪 TestNG for test orchestration and reporting
- 🌐 Rest Assured for fluent and readable HTTP requests
- ♻️ Modular and reusable test components
- 📄 Easy-to-maintain test data and configuration files
- 📊 TestNG default reporting support

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- Java JDK 21
- Maven 3.x or above
- IntelliJ IDEA

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/pothurajtharun/Rest-API-Automation-Framework.git
cd Rest-API-Automation-Framework
```

### 2. Import as a Maven Project

Open your IDE and import the project as a Maven project to resolve dependencies.

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run TestNG Tests

You can run tests by executing the `testng.xml` file or directly through Maven:

```bash
mvn test
```

## 🧪 Writing Tests

- Use `@Test`, `@BeforeClass`, `@AfterClass`, etc. from TestNG to structure your tests.
- Use Rest Assured to write HTTP calls:
  ```java
  given()
      .header("Content-Type", "application/json")
      .body(requestBody)
  .when()
      .post("/api/endpoint")
  .then()
      .statusCode(201)
      .body("id", notNullValue());
  ```

## 📊 Reporting

TestNG provides HTML and XML reports by default after test execution. Reports can be found under the `test-output` directory.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to fork the repository and submit a pull request.