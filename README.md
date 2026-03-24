# 🌿 PlantX Backend API

AI-powered plant identification backend built with **Spring Boot**.
This service processes plant images, identifies species using AI APIs, and returns detailed plant information including description, uses, and classification.

---

## 🚀 Features

* 🌱 Plant Identification using AI (PlantNet API)
* ☁️ Image Upload via Cloudinary
* 📚 Wikipedia Integration (Plant description + image)
* 🧠 Clean API response (Production-ready structure)
* 🔐 Secure API key management (Environment Variables)
* ⚡ Fast & scalable REST APIs

---

## 🏗️ Tech Stack

* **Backend Framework:** Spring Boot
* **Language:** Java
* **Image Storage:** Cloudinary
* **Plant Identification API:** PlantNet
* **Plant Info Source:** Wikipedia API
* **Build Tool:** Maven

---

## 📂 Project Structure

```
plantx-backend/
│── src/main/java/com/plant/plantX
│   ├── controller/
│   ├── service/
│   ├── config/
│   ├── model/
│── src/main/resources/
│   ├── application.properties
│── pom.xml
│── README.md
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone [https://github.com/Vivek-Tilekar/plantx-backend.git](https://github.com/Vivek-Tilekar/plantX-backend.git)
cd plantx-backend
```

---

### 2️⃣ Set Environment Variables

> ⚠️ Never hardcode API keys in code

#### 💻 Windows

```bash
setx PLANTNET_API_KEY your_api_key
setx WIKIPEDIA_EMAIL your_email
setx CLOUDINARY_API_KEY your_key
setx CLOUDINARY_API_SECRET your_secret
setx CLOUDINARY_CLOUD_NAME your_cloud
```

#### 🍎 Mac/Linux

```bash
export PLANTNET_API_KEY=your_api_key
export WIKIPEDIA_EMAIL=your_email
```

---

### 3️⃣ Configure application.properties

```properties
plantnet.api_key=${PLANTNET_API_KEY}
wikipedia.mail=${WIKIPEDIA_EMAIL}

cloudinary.cloud_name=${CLOUDINARY_CLOUD_NAME}
cloudinary.api_key=${CLOUDINARY_API_KEY}
cloudinary.api_secret=${CLOUDINARY_API_SECRET}
```

---

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

Server runs on:

```
http://localhost:5000
```

---

## 📡 API Endpoints

### 🔍 Identify Plant

```
POST /api/plant/identify
```

### 📤 Request

* Content-Type: `multipart/form-data`
* Body:

  * `image` → Plant image file

---

### 📥 Response (Example)

```json
{
  "plantName": "Croton",
  "scientificName": "Codiaeum variegatum",
  "confidence": 0.98,
  "description": "Croton is a tropical plant known for its colorful leaves...",
  "imageUrlWiki": "https://...",
  "uses": [
    "Ornamental plant",
    "Indoor decoration",
    "Air purification"
  ],
  "classification": {
    "family": "Euphorbiaceae",
    "genus": "Codiaeum"
  }
}
```

---

## ☁️ Deployment (Render)

This project is deployed using **Render**.

### Steps:

1. Push code to GitHub
2. Create new Web Service on Render
3. Set build & start commands:

```
Build Command: mvn clean install
Start Command: java -jar target/plantX.jar
```

4. Add environment variables in Render dashboard

---

## 🔐 Security Best Practices

* ❌ Do NOT store API keys in code
* ✅ Use environment variables
* ✅ Add `.env` to `.gitignore`
* ✅ Use different configs for dev & production

---

## 🧪 Testing

You can test API using:

* Postman
* React Native frontend
* Curl

---

## 📌 Future Enhancements

* 🌍 Multi-language plant info
* 🔊 Voice-based plant explanation
* ❤️ Save favorite plants
* 📊 Analytics dashboard
* 🤖 Offline AI model integration

---

## 👨‍💻 Author

**Vivek Tilekar**

* GitHub: [https://github.com/Vivek-Tilekar](https://github.com/Vivek-Tilekar/)
* LinkedIn: [https://linkedin.com/in/vivek-tilekar-596865225/](https://www.linkedin.com/in/vivek-tilekar-596865225/)

---
