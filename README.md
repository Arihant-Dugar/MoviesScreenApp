# MoviesScreenApp
### This is a Single Screen Static Movies App developed in Jetpack Compose




https://user-images.githubusercontent.com/95081683/226189483-d6128abe-8341-4400-aec6-728dce77af01.mp4






# Tech stack & Open-source libraries

* Minimum SDK level 24

* Kotlin based, Coroutines + Flow for asynchronous.

* Jetpack Compose and Dependencies :

    * Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
    * ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
    * Dagger-Hilt: for dependency injection.
    * ExoPlayer: For Playing Videos.
    * Coil: for Thumbnail download and projection.
    
* Architecture :

    * Clean Architecture (Ui or Presentation - Domain - Data).
        * :exclamation: No Remote Api or Local Databse is used so Data Layer is Empty.
        
        
