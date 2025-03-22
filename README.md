# DemoBlaze Automation Project

This project automates the testing of the **DemoBlaze** website (https://www.demoblaze.com/) using Selenium WebDriver with Java. It includes test cases for the cart functionality, such as navigating to the cart page, verifying items, and placing orders.

---

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Running the Tests](#running-the-tests)
5. [Test Cases](#test-cases)
6. [Project Structure](#project-structure)
7. [Contributing](#contributing)
8. [License](#license)

---

## **Project Overview**
This project is designed to automate the testing of the **DemoBlaze** website's cart functionality. It uses Selenium WebDriver with Java to perform actions such as:
- Navigating to the cart page.
- Verifying if the cart is empty or contains items.
- Placing an order and handling the confirmation.

The project is built using Maven for dependency management and follows a structured approach for test automation.

---

## **Prerequisites**
Before running the project, ensure you have the following installed:
1. **Java Development Kit (JDK)**: Version 8 or higher.
2. **Maven**: For dependency management and build automation.
3. **ChromeDriver**: Download the version compatible with your Chrome browser.
4. **IDE**: IntelliJ IDEA.

---

## **Setup Instructions**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/HabibaRagab/GIZ2_SWD6_G1_GRAD_Demo-Blaze.git
   cd GIZ2_SWD6_G1_GRAD_Demo-Blaze
   ```

2. **Set Up ChromeDriver**:
   - Download ChromeDriver from [here](https://sites.google.com/chromium.org/driver/).
   - Add the path to ChromeDriver in the `System.setProperty` line in the `DemoBlazeCartAutomation.java` file:
     ```java
     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
     ```

3. **Install Dependencies**:
   - Run the following command to install Maven dependencies:
     ```bash
     mvn clean install
     ```

---

## **Running the Tests**
To run the tests, use the following Maven command:
```bash
mvn clean test
```

This will:
1. Clean the project.
2. Compile the code.
3. Execute the test cases.

---

## **Test Cases**
The following test cases are covered in this project:
1. **Navigate to Cart Page**:
   - Verify the cart page loads successfully.
2. **Check Cart Contents**:
   - Verify if the cart is empty or contains items.
3. **Place Order**:
   - Fill out the order form and submit the order.
   - Handle the confirmation alert.

---

## **Project Structure**
```
demoBlaze_homepage
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───org
    │   │   │       └───example
    │   │   └───resources
    │   └───test
    │       └───java
    └───target
        ├───classes
        │   └───org
        │       └───example
        ├───generated-sources
        │   └───annotations
        ├───generated-test-sources
        │   └───test-annotations
        ├───maven-status
        │   └───maven-compiler-plugin
        │       └───compile
        │           └───default-compile
        └───test-classes
```

- **`src/main/java`**: Contains the main Java class for automation.
- **`pom.xml`**: Maven configuration file with dependencies.
- **`README.md`**: Project documentation.

---

## **Contributing**
Contributions are welcome! If you'd like to contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes.
4. Submit a pull request.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Acknowledgments**
- [Selenium](https://www.selenium.dev/) for providing the automation framework.
- [DemoBlaze](https://www.demoblaze.com/) for the demo website.
