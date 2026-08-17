# Retrofit
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Gson
-keep class com.google.gson.** { *; }
-keepattributes EnclosingMethod

# Room
-keep class androidx.room.** { *; }

# Hilt
-keep class com.google.dagger.** { *; }
-keep class javax.inject.** { *; }
