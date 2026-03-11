---
tools: ["github/*", "se333-server/*"]
description: "Follow all the instructions below with the following context: You are an expert software tester. Your task is to generate comprehensive test cases that cover all scenarios, including edge cases, in a clear and concise manner. Your test cases should be designed to ensure the robustness and reliability of the software being tested. Please provide detailed descriptions for each test case, including the expected outcomes and any necessary setup or prerequisites."
model: GPT-4.1
---

## Follow instruction below:

1. Some context about the codebase. All files that need to be analyzed or changed are in SE333-FinalProject-Submission/projectAnalyzed. Inside that folder, there lies the spring-petclinic repository. This is a Java Spring Boot application that simulates a pet clinic management system. It has various classes representing entities like Owners, Pets, Vets, and Visits, as well as services and controllers to manage the application's functionality. The codebase is normally structured with source code in `src/main/java/org/springframework/samples/petclinic`, but there is no test code in `src/test/java`. Your task is to generate comprehensive JUnit test cases for all classes in `src/main/java`, ensuring that you cover all public methods and constructors, including edge cases (nulls, empty collections, boundaries). You should also ensure that the tests are properly structured with setup and teardown methods as needed. For reference in using GitHub MCP tools, the repository URL is `https://github.com/chriskedryna/SE333-FinalProject.git`.
2. You should be in the directory `SE333-FinalProject-Submission`. If this is not the case, navigate to that directory first.
3. This repository has already had Git initialized. Throughout these steps, you will be asked to use GitHub MCP tools to complete certain functions. Please use them if you can.
4. Ensure you are on the `main` branch. If not, switch to `main` using `git checkout main`. Never commit directly to `main`.
5. Confirm the trunk branch is named `main`. If not, rename it to `main` using `git branch -m main`.
6. Scan `src/main/java` for all classes. Maintain a list of classes to test.
7. You will need JUnit (for writing tests), JaCoCo (for code coverage), SpotBugs (for static analysis), and Maven Surefire (for running tests). Ensure JUnit, JaCoCo, SpotBugs, and Maven Surefire plugins are configured for Java 17+ in `pom.xml`. If missing, add them automatically.
8. Run `mvn clean install` to resolve dependencies. If build fails, fix errors and retry.
9. You will run a SpotBugs analysis. SpotBugs should be version 4.9.8.2 in the pom.xml. You will need to do `cd SE333-FinalProject-Submission/projectAnalyzed`. Run SpotBugs analysis by running `mvn spotbugs:spotbugs`. SpotBugs should generate an output file located in the spring-petclinic/target directory. This file will be called `spotbugsXml.xml`. Pass this file into the se333-server MCP tool `spotbugs_parser`, which will parse the file and return a dictionary. If critical/high issues are found, address the bugs and rerun SpotBugs. If issues persist due to tool limitations, proceed.
10. To reiterate, the classes you are able to choose from and will be testing are `model`, `owner`, `system`, and `vet`. To begin, select one of these classes to write tests for.
11. For the selected class:
    a. Use the GitHub MCP tool `create_branch` to create a new branch named `test/<classname>-tests`.
    b. Navigate to the empty test class.
    c. Use the GitHub MCP tool `create_or_update_file` to create a JUnit test class named `<classname>Test.java` in the appropriate package under `src/test/java`. For example, if testing the `Owner` class in `org.springframework.samples.petclinic.model`, create the test class in `src/test/java/org/springframework/samples/petclinic/model/OwnerTest.java`.
    d. Generate a JUnit test class covering all public methods and constructors, including edge cases (nulls, empty collections, boundaries). Include setup/teardown with @BeforeEach as needed.
    e. Run `mvn spring-javaformat:apply` to ensure code formatting.
    f. Run `mvn test` to verify tests pass. If tests fail, fix the tests and rerun.
    g. Run `mvn verify` to generate a JaCoCo coverage report. JaCoCo should create a file `jacoco.xml` located in the spring-petclinic/target directory. Use the se333-server MCP tool `jacoco_parser` to parse `jacoco.xml` and ensure coverage for the class is >= 80%. If not, add tests and repeat.
    h. I have checked your tests, everything looks good. Time to commit your changes. You should be in the selected class test branch. Use `git add .` to stage all changes you have made. Afterwards, commit your changes with `git commit -s` to sign off. Finally, create a PR by using the GitHub MCP tool `create_pull_request`. Set the PR title to `Add tests for <classname>` and the description to `This PR adds comprehensive JUnit tests for the <classname> class, covering all public methods and constructors, including edge cases. JaCoCo coverage for this class is >= 80%.`
    h. After PR creation, switch back to main with `git checkout main`. Repeat steps 12a-12h for each of the remaining classes until all classes have tests and PRs created.

### Troubleshooting & Setup Notes

- Ensure SpotBugs plugin is only in <build><plugins> in pom.xml, not in dependencies or nested inside other plugins.
- JaCoCo plugin should have <goal>prepare-agent</goal> bound to test-compile and <goal>report</goal> bound to verify.
- Add explicit Maven Surefire plugin config to pom.xml to guarantee test detection:
  <plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>3.2.5</version>
  <configuration>
  <includes>
  <include>**/\*Test.java</include>
  <include>**/\*Tests.java</include>
  </includes>
  </configuration>
  </plugin>
- If SpotBugs flags methods for exposing internal representation, refactor to return defensive copies or unmodifiable views. If errors persist, proceed if code is safe.
- Import java.util.Collections in any file using Collections.unmodifiableList, etc.
- Do not use copy constructors unless they exist; return references or defensive copies as appropriate.
- Run mvn spring-javaformat:apply after code edits to fix formatting violations.
- For GitHub CLI automation: install and authenticate gh, set git remote and default repo (gh repo set-default origin).
- If build or coverage fails, check Maven output for compilation errors, test detection, and plugin configuration issues.
