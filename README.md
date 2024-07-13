# Products App

This project is an Android application that displays a list of products. The app follows Clean Architecture principles and uses Retrofit for network operations, Hilt for dependency injection, and includes unit tests. The UI is built using Fragments and XML layouts.

## Table of Contents

- [Architecture](#architecture)
- [Libraries Used](#libraries-used)
- [Setup](#setup)
- [Usage](#usage)
- [Features](#features)
- [Unit Testing](#unit-testing)
- [Video](#video)
- [Contributing](#contributing)
- [License](#license)

## Architecture

This project follows Clean Architecture, which separates the code into different layers:

1. **Domain Layer**: Contains business logic and use cases.
2. **Data Layer**: Handles data operations, including network calls and data caching.
3. **Presentation Layer**: Includes ViewModels, Fragments, and UI components.

## Libraries Used

- [Retrofit](https://square.github.io/retrofit/): For making network requests.
- [Hilt](https://dagger.dev/hilt/): For dependency injection.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): For observable data.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): For managing UI-related data.
- [Coroutines](https://developer.android.com/kotlin/coroutines): For asynchronous programming.
- [JUnit](https://junit.org/junit5/): For unit testing.
- [Mockito](https://site.mockito.org/): For mocking in tests.
- [Picasso](https://square.github.io/picasso/): For loading images.


## Setup

To run this project, follow these steps:

1. **Clone the repository:**

    ```sh
    git clone https://github.com/yourusername/products-app.git
    cd products-app
    ```

2. **Open the project in Android Studio:**

    ```sh
    open -a "Android Studio" .
    ```

3. **Sync the project with Gradle files** by clicking on the `Sync Now` button in the banner at the top of the IDE.

4. **Build and run the app** on an emulator or physical device by clicking the `Run` button.

## Usage

To use the app, follow these steps:

1. Launch the app on your device or emulator.
2. The app will display a splash screen followed by a list of products.
3. You can click on a product to view its details.

## Features

- **Display Products List**: Fetches and displays a list of products from a remote API.
- **Error Handling**: Displays appropriate messages for network errors.
- **Loading Indicators**: Shows a Shimmer Effect while data is being fetched.

## Unit Testing

The project includes unit tests for the ViewModel and use cases.

- **Running Tests:**
  
    1. Open the `test` directory in Android Studio.
    2. Right-click on the `com.example.route_task` package and select `Run Tests`.

## Video

https://github.com/user-attachments/assets/0117aa5b-6349-4d2b-8ab0-5f1dfb0e451c

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch with a descriptive name.
3. Make your changes.
4. Submit a pull request.

