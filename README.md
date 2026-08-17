# Sibtain - News Summary App

A modern Android app that provides concise news summaries using Jetpack Compose and MVVM architecture.

## Features
- Browse latest news summaries
- Clean, modern UI with Jetpack Compose
- MVVM architecture pattern
- Real-time data updates
- News categories filter
- Share news articles

## Tech Stack
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** MVVM (Model-View-ViewModel)
- **Database:** Room
- **Networking:** Retrofit + OkHttp
- **Dependency Injection:** Hilt
- **Async:** Coroutines + Flow
- **Image Loading:** Coil

## Project Structure
```
app/
├── data/
│   ├── api/              # Network API definitions
│   ├── repository/       # Repository implementations
│   └── local/            # Local database (Room)
├── domain/
│   ├── model/            # Domain models
│   └── usecase/          # Business logic
├── ui/
│   ├── screen/           # Composable screens
│   ├── viewmodel/        # ViewModels
│   ├── component/        # Reusable components
│   └── theme/            # App theming
└── di/                   # Dependency injection modules
```

## Getting Started

### Prerequisites
- Android Studio (latest)
- Kotlin 1.9+
- Android SDK 31+

### Setup
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or device

## Building

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease

# Run tests
./gradlew test
```

## API Configuration
Create a `local.properties` file in the project root:
```properties
NEWS_API_KEY=your_api_key_here
NEWS_API_BASE_URL=https://api.example.com
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first.
