🛒 Flipkart End-to-End Automation Testing Framework


📌 Project Overview

This repository contains a scalable, CI/CD-ready end-to-end test automation framework built for the Flipkart e-commerce platform.

The framework automates critical user journeys such as:

Product search

Product details validation (PDP)

Image carousel & zoom

Add to cart

Checkout flow validation

Login / Address / Payment screen verification

The project is designed to mirror real-world SDET practices, making it suitable for:

Enterprise regression testing

CI/CD pipelines

Interview demonstrations

Portfolio showcasing

🎯 Key Highlights

✅ Page Object Model (POM)
✅ Selenide-based stable UI automation
✅ TestNG test orchestration
✅ Allure rich reporting with screenshots
✅ GitHub Actions CI/CD integration
✅ Email notifications with execution summary
✅ Headless & local execution support
✅ Failure screenshots attached to reports

🧱 Tech Stack
Layer	Technology
Language	Java 17
UI Automation	Selenium + Selenide
Test Framework	TestNG
Build Tool	Maven
Reporting	Allure
CI/CD	GitHub Actions
Version Control	GitHub
🗂️ Project Structure
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

🧪 Automated Test Scenarios Covered
🔹 Product Discovery

Search product from homepage

Validate search results

Open product details page (PDP)

🔹 Product Details Page (PDP)

Verify product title & price

Validate image carousel

Hover-based image zoom (environment aware)

🔹 Cart & Checkout

Add product to cart

Verify correct product & price in cart

Validate “Place Order” CTA

Verify checkout screens:

Login / Signup

Delivery Address

Order Summary

Payment Options

📊 Allure Reporting

The framework integrates Allure Reports to provide:

Test execution summary

Step-wise execution logs

Screenshots on failure

Pie chart visualization of results

📌 Sample Allure Dashboard

(Attach screenshot here)

<img width="1919" height="861" alt="image" src="https://github.com/user-attachments/assets/65bfa33e-989f-442d-8787-e218715d705f" />
📷 

📌 Failure Screenshot Attachment

(Attached automatically when a test fails)

📷 failure-screenshot.png

📈 Test Result Visualization

The CI pipeline generates pictorial test result representation, including:

Pass / Fail / Skip ratio

Execution trends

Failure screenshots embedded in Allure

📌 Pie Chart Example

(Attach screenshot here)

<img width="832" height="301" alt="image" src="https://github.com/user-attachments/assets/79e80266-cf0b-468c-b705-73fee7a102ed" />
📷 

🔁 CI/CD Pipeline (GitHub Actions)

This project is fully CI/CD enabled using GitHub Actions.

🔹 Pipeline Capabilities

Triggered on:

Manual workflow dispatch

Scheduled cron runs

Executes tests in headless mode

Generates Allure reports

Sends email notifications with execution details

📌 Workflow Diagram

(Optional visual to add)

Code Push / Schedule
        ↓
GitHub Actions Runner
        ↓
Run TestNG Suite
        ↓
Generate Allure Report
        ↓
Email Notification

📧 Email Notification (CI Execution)

After execution, an automated email is sent containing:

Execution status

Total / Passed / Failed tests

Allure report link

Failure screenshots (if any)

📌 Sample Email Screenshot

📷
<img width="1159" height="731" alt="image" src="https://github.com/user-attachments/assets/13dee4e1-be50-47ed-b6f3-4bed50767077" />


🏃 How to Run Tests Locally
Prerequisites

Java 17+

Maven

Chrome browser

Run all tests
mvn clean test

Generate Allure report
allure serve target/allure-results

⚙️ Environment Handling

The framework intelligently handles:

Local execution (full UI features)

CI execution (headless limitations)

Hover-based features (like image zoom) are environment-aware to avoid false CI failures.

🧠 Design Decisions & Best Practices

Selenide chosen for stability and auto-waits

Conditional UI validation to support headless CI

Page Object Model for maintainability

Non-flaky assertions for real-world reliability

Failure screenshots for faster debugging

🚀 Future Enhancements

Cross-browser execution

Parallel test execution

Dockerized test runs

API + UI hybrid flows

Test data externalization

👤 Author

Dhiman Dasgupta
SDET | Automation Engineer

🔗 GitHub: [Your GitHub Profile]
🔗 LinkedIn: [Your LinkedIn Profile]

⭐ Why This Project Stands Out

This framework is built not just to pass tests, but to demonstrate real SDET engineering practices, CI/CD maturity, and production-grade automation design.
