# Spring Boot Weather API

A simple REST API that fetches weather data by integrating Open-Meteo Weather and Geocoding APIs. Demonstrates clean API integration and business logic patterns.

## 🚀 Technolgies
- **Spring Boot** - REST API framework
- **WebClient** - External API integration
- **Open-Meteo APIs** - Weather & Geocoding data


## 🔧 API Endpoints

**Get weather by city:**
```bash
GET /api/weather?name=chennai&language=en
```

**Get weather by coordinates:**
```bash
GET /api/weather/data?lat=13.0827&lon=80.2707
```

## 📁 Project Structure
```
src/main/java/com/weather/
├── controller/
│   └── WeatherapiController.java     # REST endpoints
├── service/
│   ├── Geocodingservice.java         # City → Coordinates
│   ├── Openmeteoservice.java         # Weather data fetching
│   └── ApiResponseManager.java       # Response merging
└── DTO/
    ├── RESPONSE.java                 # Final merged response
    ├── GeoCodingDTO.java             # Geocoding API mapping
    ├── OpenmeteoResponseDTO.java     # Weather API mapping
    ├── Results.java                  # Location details
    └── CurrentWeather.java           # Weather data
```

## 🔄 How It Works
1. User provides city name → Geocoding API → Get coordinates
2. Use coordinates → Weather API → Get weather data  
3. Merge both responses → Return unified JSON


## ⚠️ Note
Learning project focusing on API integration patterns - no security/error handling layers included.

## 📝 License
MIT License

---

