# Swag Labs E-commerce UI Automation

This repository contains a Java-based end-to-end UI automation project for the [Swag Labs demo store](https://www.saucedemo.com/). It uses Selenium WebDriver to drive Chrome and TestNG to run the browser scenario.

## Gherkin feature specification

The project’s feature list and Gherkin scenarios are documented in this Google Sheets file:

[Swag Labs features and Gherkin scenarios](https://docs.google.com/spreadsheets/d/1bazu8KMalSz4lszZFSKudr6WNSwv7rdc/edit?gid=1638743127#gid=1638743127)

## Automated scenario

The current end-to-end test is `src/test/java/Test/E2ETest.java`. It attempts this purchase flow:

1. Log in with the demo account `standard_user` / `secret_sauce`.
2. Open the Sauce Labs Backpack product page.
3. Add the product to the cart and open the cart.
4. Start checkout and enter generated first name, last name, and postal code values.
5. Continue to the order summary and finish the order.
6. Check for the order-complete message and return to the products page.
7. Log out through the navigation menu and check that the login page URL is shown.

The test uses a real Chrome browser. Its setup and teardown are in `src/test/java/Base/base.java`.

## Technology

- Java (the Maven compiler is configured for Java 16)
- Selenium Java 4.21.0
- TestNG 7.12.0
- Maven
- Google Chrome

## Run the test

Make sure a JDK, Maven, and Google Chrome are installed, then run from the project root:

```bash
mvn test
```

ChromeDriver is managed by Selenium when `ChromeDriver` is created. The browser is configured to run with a visible window; headless options are currently commented out.

## Project layout

```text
src/test/java/
├── Base/base.java          # WebDriver setup and teardown
├── Pages/                  # Page actions for login, products, cart, and checkout
└── Test/E2ETest.java       # End-to-end purchase scenario
```
