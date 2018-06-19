# TODO-Components

### Summary

This sample is based on the TODO-MVP-RXJAVA project.

So far, I have ported the `AddEditTaskActivity` to the component architecture. It is complete with unit tests and espresso tests.

For data storage and retrieval, it uses the repository pattern found in the parent project.

### Dependencies

* [RxJava 2.x](https://github.com/ReactiveX/RxJava)
* [RxAndroid 2.x](https://github.com/ReactiveX/RxAndroid)
* [SqlBrite 2.x](https://github.com/square/sqlbrite)
* [Robolectric](http://robolectric.org/)

### Java 8 Compatibility

This project uses [lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) extensively, one of the features of [Java 8](https://developer.android.com/guide/platform/j8-jack.html). To check out how the translation to lambdas was made, check out [this commit](https://github.com/googlesamples/android-architecture/pull/240/commits/929f63e3657be8705679c46c75e2625dc44a5b28), where lambdas and the Jack compiler were enabled.

## Features

### Complexity - understandability

#### Use of architectural frameworks/libraries/tools:

Building an app with RxJava is not trivial as it uses new concepts.

Components themselves are very intuitive and relatively easy to get started with.

#### Conceptual complexity

Developers need to be familiar with RxJava, which is not trivial.

### Testability

#### Unit testing

Very High. Given that the RxJava ``Flowable``s are highly unit testable, unit tests are easy to implement.

#### UI testing

Similar with TODO-MVP

### Code metrics

Compared to TODO-MVP, new classes were added for handing the ``Schedulers`` that provide the working threads.

```
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            48           1118           1422           3639 (3450 in MVP)
XML                             35             97            337            952
-------------------------------------------------------------------------------
SUM:                            83           1215           1759           4591

```
### Maintainability

#### Ease of amending or adding a feature

High.

#### Learning cost

Medium as RxJava is not trivial.
