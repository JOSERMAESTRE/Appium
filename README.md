# Mobile Automation Testing Project

## 📱 Project Overview
This is an automated testing project for Android applications using Appium with WebDriverIO. The project implements Page Object Model (POM) architecture and follows Object-Oriented Programming principles.

## 🛠 Tech Stack
- Java
- Maven
- Appium
- WebDriverIO
- TestNG
- IntelliJ IDEA

## 📋 Prerequisites
- Java JDK 11 or higher
- Maven 3.8.x or higher
- Android Studio (for emulator)
- Appium Server 2.x
- Node.js 14 or higher
- IntelliJ IDEA

## 🔧 Configuration
Update the `config.properties` file with your device details:
```properties
platformName=Android
deviceName=your_emulator_name
appPackage=com.example.app
appActivity=com.example.app.MainActivity
```

## 🚀 Running Tests
1. Start the Appium server:
```bash
appium
```

2. Run tests using Maven:
```bash
mvn compile
mvn clean test
```

## 📊 Test Reports
- Coverage Reports are saved in Allure-results directory
- Screenshots are captured for failed tests in `/resources`
- Video recordings are saved in `/videos`

## 🎥 Video Recording
The project includes automatic video recording of test executions. 

## 📸 Screenshots
Screenshots are automatically captured:
- At specific checkpoints during test execution

