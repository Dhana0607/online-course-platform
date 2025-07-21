# 🎓 Online Learning Platform

A full-stack **Online Learning Platform** built using **Spring Boot**, **JWT Authentication**, **MySQL**, and **Postman for API testing**. This platform allows user registration, login, course creation, and course enrollment.

---

## 🚀 Features

- ✅ User Registration & Login with JWT Authentication
- ✅ Role-based Access Control (Admin/User)
- ✅ Add, View, Update, Delete Courses
- ✅ Enroll Users to Courses
- ✅ Secure APIs using JWT
- ✅ MySQL Database Integration

---

## 🛠️ Tech Stack

**Backend:**
- Java 17
- Spring Boot
- Spring Security + JWT
- JPA + Hibernate
- MySQL

**Testing:**
- Postman

**Version Control:**
- Git & GitHub

---

## 📦 How to Run the Project

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/online-learning-platform.git
   cd online-learning-platform
2. **Start MySQL and Create DataBase**
   CREATE DATABASE onlinelearning;
3. **Update application.properties with your MySQL credentials**
4. **Run the Spring Boot application**
     In IntelliJ or with:
     ```bash
     mvn spring-boot:run
5. **Use Postman to test the APIs (Login, Add Course, Enroll, etc.)**

**API Endpoints**

**User**

POST /api/auth/register – Register user

POST /api/auth/login – Login and get JWT Tokens

📘 Courses

POST /api/courses/add – Add course (Admin only)

GET /api/courses/all – View all courses

GET /api/courses/{id} – View course by ID

PUT /api/courses/{id} – Update course

DELETE /api/courses/{id} – Delete course

📝 Enrollment

POST /api/enroll/{courseId}/user/{userId} – Enroll user to course

🧑‍💻 Author

Dhanalakshmi Raja

Aspiring Software Developer | Java Full Stack Developer

LinkedIn : www.linkedin.com/in/dhanalakshmiraja  
GitHub : https://github.com/Dhana0607

**Project Status**

✅ Day 1 – User Registration

✅ Day 2 – JWT Login

✅ Day 3 – Course Module

✅ Day 4 – Enrollment Feature

✅ Day 5 – DB Integration & Testing
