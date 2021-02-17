# Exchange Rate
## Overview

This application shows the history of the exchange rate of different currencies, the graph that contains shows some of the most common currencies, which you can filter by predefined dates, also below it a list of other currencies that will be updated at the same time time the graph is filtered

## Screens
<img src="https://user-images.githubusercontent.com/27383308/108161491-cbc25e00-70b0-11eb-81af-14f872868faa.jpeg" width="200"> <img src="https://user-images.githubusercontent.com/27383308/108161576-f01e3a80-70b0-11eb-8708-182fef535197.jpeg" width="200">

## Architecture
For this project Clean Architecture was used with the following modules

`:app` Being this module container of the presentation layer and everything that involves the Android framework

`:domain` This module contains all the business logic of the application

`:data` This other module contains the data sources of the application, in this case it will be a remote source, from an API 

<img src="https://koenig-media.raywenderlich.com/uploads/2019/06/Android-Clean-Architecture-509x500.png" width="200">

## Libs
* [Retrofit](https://github.com/square/retrofit)
* [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
* [Dagger2](https://github.com/google/dagger)
* [Lottie](https://github.com/airbnb/lottie)
* [Mockito](https://github.com/mockito/mockito)

## API

[Fixer.io](https://fixer.io/)

## Download and Install

[APK](https://drive.google.com/file/d/10R4OByrBeIhgsyLi3OqIb-WEhl7YAd9X/view?usp=sharing)
