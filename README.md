# UI Selenium Framework

This repository contains a Java-based Selenium UI test framework scaffold.

Structure
- pom.xml — Maven configuration
- src/test/java — Test classes, page objects, utilities
- testng.xml — TestNG suite configuration
- .github/workflows/ci.yml — GitHub Actions workflow to run tests
- CHANGELOG.md — Change log

Quick start
1. Build and run tests locally:
   - mvn -B test

2. To run tests with a specific browser:
   - mvn -Dbrowser=chrome -B test

Notes
- WebDriverManager is used to manage browser drivers automatically.
- Tests run in headless mode by default when executed in CI (can be toggled via system properties).
