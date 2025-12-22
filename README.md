# 🛒 Flipkart End-to-End Automation Testing Framework


## 📌 Project Overview

This repository contains a **scalable, CI/CD-ready end-to-end test automation framework** built for the **Flipkart e-commerce web platform**.

The framework automates critical user journeys such as:
- **Product search**
- **Product details validation (PDP)**
- **Image carousel & zoom**
- **Add to cart**
- **Checkout flow validation**
- **Login / Address / Payment screen verification**

The project is designed to mirror real-world SDET practices, making it suitable for:
- **Enterprise regression testing**
- **CI/CD pipelines**

## 🎯 Key Highlights

**✅ Page Object Model (POM)**<br>
**✅ Selenide-based stable UI automation**<br>
**✅ TestNG test orchestration**<br>
**✅ Allure rich reporting with screenshots**<br>
**✅ GitHub Actions CI/CD integration**<br>
**✅ Email notifications with execution summary**<br>
**✅ Headless & local execution support**<br>
**✅ Failure screenshots attached to reports**<br>

## 🧱 Tech Stack

| **Layer**       | **Technology**      |
|-----------------|---------------------|
| Language        | Java 17             |
| UI Automation   | Selenium + Selenide |
| Test Framework  | TestNG              |
| Build Tool      | Maven               |
| Reporting       | Allure              |
| CI/CD           | GitHub Actions      |
| Version Control | GitHub              |


## 🗂️ Project Structure

```
flipkart-automation/
│
├── src/test/java
│   ├── pages/               # Page Object classes
│   ├── tests/               # TestNG test classes
│   ├── utils/               # Utilities & helpers
│   └── base/                # Base test & config
│
├── src/test/resources
│   ├── testng.xml
│   └── allure.properties
│
├── .github/workflows
│   └── regression-pipeline.yml
│
├── pom.xml
└── README.md
```

## 🧪 Automated Test Scenarios Covered

### 🔹 Product Discovery
- Search product from homepage
- Validate search results
- Open product details page (PDP)

### 🔹 Product Details Page (PDP)
- Verify product title & price
- Validate image carousel
- Hover-based image zoom (environment aware)

### 🔹 Cart & Checkout
- Add product to cart
- Verify correct product & price in cart
- Validate “Place Order” CTA
- Verify checkout screens:
  - Login / Signup
  - Delivery Address
  - Order Summary
  - Payment Options

## 📊 Allure Reporting

The framework integrates **Allure Reports** to provide:
- Test execution summary
- Step-wise execution logs
- Screenshots on failure
- Pie chart visualization of results

### 📌 Sample Allure Dashboard

![img_4.png](img_4.png)

### 📌 Failure Screenshot Attachment
![img_2.png](img_2.png)
(Attached automatically when a test fails)

### 📈 Test Result Visualization
The CI pipeline generates pictorial test result representation in the form of a Pie Chart, and also includes:

- Pass / Fail / Skip ratio
- Execution trends
- Failure screenshots embedded in Allure

### 📌 Pie Chart Example

![img_3.png](img_3.png)

## 🔁 CI/CD Pipeline (GitHub Actions)

This project is fully CI/CD enabled using GitHub Actions.

### 🔹 Pipeline Capabilities

Triggered on:

- Manual workflow dispatch
- Scheduled cron runs
- Executes tests in headless mode
- Generates Allure reports
- Sends email notifications with execution details

### 📌 Workflow Diagram
```
Code Push / Schedule
        ↓
GitHub Actions Runner
        ↓
Run TestNG Suite
        ↓
Generate Allure Report
        ↓
Email Notification
```

### 📧 Email Notification (CI Execution)

After execution, an automated email is sent containing:
- Execution status
- Total / Passed / Failed tests
- Allure report link
- GitHub action link
- Error messages for failed testcases

### 📌 Sample Email Screenshot

![img_5.png](img_5.png)

### 📌 Sample Error Messages for Failed Testcases

![img_1.png](img_1.png)

## 🏃 How to Run Tests Locally

### Prerequisites
- Java 17+
- Maven
- Chrome browser 

### Run all tests
```
mvn clean test
```

### Generate Allure report
```
allure serve target/allure-results
```

### ⚙️ Environment Handling

* The framework intelligently handles:
* Local execution (full UI features)
* CI execution (headless limitations)
* Hover-based features (like image zoom) are environment-aware to avoid false CI failures.

### 🧠 Design Decisions & Best Practices

* Selenide chosen for stability and auto-waits
* Conditional UI validation to support headless CI
* Page Object Model for maintainability
* Non-flaky assertions for real-world reliability
* Failure screenshots for faster debugging

### 🚀 Future Enhancements

* Cross-browser execution
* Parallel test execution
* Dockerized test runs
* API + UI hybrid flows
* Test data externalization

### 👤 Author

**Dhiman Dasgupta <br>
SDET | Automation Engineer**

🔗 GitHub: https://github.com/Dhiman07-create <br>
🔗 LinkedIn: https://www.linkedin.com/in/dhiman-dasgupta-aa3b21197/

### ⭐ Why This Project Stands Out

This framework is built not just to pass tests, but to demonstrate real **SDET engineering practices, CI/CD maturity, and production-grade automation design**.
