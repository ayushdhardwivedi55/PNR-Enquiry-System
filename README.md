# 🧪 PNR Enquiry System - API Testing Framework

This project is an automated API testing framework built using **Java**, **Maven**, **TestNG**, and **RestAssured**. It is designed to test REST APIs running on a **local mock server** (e.g., JSON Server) by validating login functionality for user authentication.

---

## 📁 Project Structure

PNR_Enquiry_System/
├── src/test/java/
│ └── PNR Enquiry/
│ └── PNRTest.java
├── pom.xml
└── README.md


---

## 🧰 Tech Stack

- **Language:** Java  
- **Build Tool:** Maven  
- **Testing Framework:** TestNG  
- **API Testing Library:** RestAssured  
- **Mock API Server:** JSON Server (`http://localhost:3000`)

---

## 🚀 Getting Started

### 1. Start Local JSON Server

Install JSON Server if you haven't:

```bash
npm install -g json-server

for running the server write:
npx json-server filename.json or json-server --watch db.json --port 3000

2. Run Tests
Use Maven to run the tests:
mvn clean test

✅ Test Cases
✔️ ValidtestUserLogin
Sends a GET request with correct credentials (email, password)

Validates user existence

Asserts success

❌ InValidtestUserLogin
Sends a GET request with invalid credentials

Ensures no match found

Asserts failure

🙌 Author
Ayush Dhardwivedi
🔗 GitHub Profile: https://github.com/ayushdhardwivedi55
