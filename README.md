# 📝 Todo Task Management Application

A full-stack web application to manage and track tasks with user assignment and action history.

## 📂 Project Structure


---

## 💡 Features

### ✅ Backend (Spring Boot)
- Create, update, delete todos
- Assign users to tasks
- Log history of all actions (create, assign, update, delete)
- Relational structure with entities:
  - `Todo`, `User`, `UserTodo`, `TodoHistory`
- RESTful APIs using Spring Boot
- MySQL database integration

### 🎯 Frontend (React.js)
- User-friendly task dashboard
- Create, edit, assign, and track todos
- View complete history of todo actions
- REST API integration using Axios

---

## 🛠️ Tech Stack

| Layer     | Technology                      |
|----------|----------------------------------|
| Frontend | React.js, JavaScript, Axios      |
| Backend  | Java, Spring Boot, Spring Data JPA|
| Database | MySQL                            |
| Tools    | Postman, Maven, Git              |

---

## 🚀 Getting Started

### 🔧 Prerequisites
- Node.js & npm
- Java 17+
- Maven
- MySQL

### 📦 Backend Setup
```bash
cd backend
# Update MySQL config in application.properties
mvn spring-boot:run


cd frontend
npm install
npm start
