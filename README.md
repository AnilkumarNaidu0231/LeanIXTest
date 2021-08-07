# LeanIXTest

Sample Android App Using Kotlin

This is a sample Android App that uses the GraphQL API and Android SDK to get the details of list of space missions.
Building the Sample App

First, clone the repo:

git clone https://github.com/AnilkumarNaidu0231/LeanIXTest.git

Building the sample then depends on your build tools.
Android Studio (Recommended)

(These instructions were tested with Android Studio version 
Android Studio Arctic Fox | 2020.3.1
Build #AI-203.7717.56.2031.7583922, built on July 27, 2021
Runtime version: 11.0.10+0-b96-7249189 amd64)

    Open Android Studio and select File->Open... or from the Android Launcher select Import project ( Gradle, etc.) and navigate to the root directory of your project.
    Select the directory or drill in and select the file build.gradle in the cloned repo.
    Click 'OK' to open the the project in Android Studio.
    A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

Gradle (command line)

    Build the APK: ./gradlew build


Running the Sample App

Connect an Android device to your development machine.
Android Studio

    Select Run -> Run 'app' (or Debug 'app') from the menu bar
    Select the device you wish to run the app on and click 'OK'

Gradle

    Install the debug APK on your device ./gradlew installDebug

Using the Sample App

You should able to see the list of missions and details of mission 
1. List Screen
2. Detail Screen 
