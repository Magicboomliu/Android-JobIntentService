# Android-JobIntentService
### After Android 8.0, Background Service is limited, This project show you show to use JobIntent Service together with Broadcast and Alarm Manager to complish the startup service when booted and service restart when it was kill by system or manually.    

#### Provide intermittent services for developers, especially those developers who don’t want to use the foreground service   

Since Andriod 8.0, Google has restricted the background service limitations. For detail, Please refer to :
https://developer.android.com/about/versions/oreo/background.html   
In order to start Service when device boots even although user do not open the app, Use BOOT_COMPLETE broadcast together with a JobIntentService is a good solution.  For tutorials, You can see below videos for basic use of JonIntentService:  
https://www.youtube.com/watch?v=B4gFbWnNpac  


This project show you show to use JobIntent Service together with Broadcast and Alarm Manager to complish the startup service when booted and service restart when it was kill by system or manually.    


## This is in Kotlin, Since Google announce in 2018 that Kotlin is the  offical first pick for Android Development. 
