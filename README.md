## Kracken Store

[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://github.com/ReSwift/ReSwift/blob/master/LICENSE.md)

Kraken is a spin off of a [project](https://github.com/ReSwift/ReSwift) that is a spin off of [another project](https://github.com/xorum-io/ReKamp). This is a Redux style state management store for 
[Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html). This project essentally just makes threading not crash
your app with multithreaded coroutines on native platforms. We use AtomicRef type 
to store the store data in order to allow the store to mutate state. 

### How to Add Kracken to Your Project

```kotlin 
repositories {
    ... 
    maven("https://repos.awhb.dev")
    ...
}
```

add following in your commonMain source set
```kotlin
sourceSets {
  val commonMain by getting {
    dependencies {
      ...
      implementation("com.blackstone:Kracken:0.1.0")
        ...
    }
  }
}
  ...
```


If you have things you'd like to see improved send me a PR or create an issue. 