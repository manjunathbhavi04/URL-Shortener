# 🔗 URL Shortener

A simple and functional URL Shortener web application built with **Spring Boot**, **Thymeleaf**, **JPA**, and **H2/MySQL** database. This tool allows users to shorten long URLs and redirect using custom short links.

## 🚀 Features

- Generate a short link from a long URL
- Redirect to original URL when short link is accessed
- View all shortened URLs (admin or user view)
- Web UI using Thymeleaf and Bootstrap
- Persistent storage with JPA (H2 or MySQL)

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- H2 / MySQL (configurable)
- Maven

## 🖥️ Screenshots
![image](https://github.com/user-attachments/assets/0d057364-54f0-4016-8030-bd60e8185c61)
![image](https://github.com/user-attachments/assets/60260bf5-5b71-4d3b-bd37-9d03762261d4)


## ⚙️ How It Works

1. Enter a long URL in the form.
2. The app generates a unique short URL (e.g., `http://localhost:8080/abc123`)
3. Visiting the short URL redirects to the original one.
4. All mappings are stored in the database.

## 📂 Project Structure

src/
├── main/
│ ├── java/
│ │ └── com.example.urlshortener/
│ │ ├── controller/
│ │ ├── entity/
│ │ ├── repository/
│ │ ├── service/
│ │ └── UrlShortenerApplication.java
│ └── resources/
│ ├── templates/
│ ├── static/
│ └── application.properties


## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener.


**Configure Database**

spring.datasource.url=jdbc:mysql://localhost:3306/url_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=



