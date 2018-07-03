Overview
========

This project demonstrates how developers can use a Java annotations to specify AOP pointcuts.

This example code creates a new Java annotation and uses it to establish a pointcut on a method.  The code produces a [SpringBoot application](https://spring.io/projects/spring-boot).

Why AOP?
========

[Aspect Oriented Programming](https://en.wikipedia.org/wiki/Aspect-oriented_programming) is great when you want to add some cross-cutting behavior to your application.  AOP is useful when implementing behavior that is difficult to model with traditional object-oriented approaches: inheritance, composition, etc .  Features like securing endpoints, standardizing logging, performance profiling, etc are good candidates for AOP.  Once you see how easy it is to add this to your application, you're likely to notice additional uses for it.

AOP terminology is summed up well in this SO question/answer: [What's joinpoint, advice, and pointcut](https://stackoverflow.com/questions/15447397/spring-aop-whats-the-difference-between-joinpoint-and-pointcut)?

Why annotations?
================

Even though Aspect Oriented Programming can provide meaningful benefits to your application, developers tend to shy away from using Aspect Oriented Programming due to the risk of collateral damage.  Given the way AOP operates and how it's traditionally configured, it's possible and even likely that a pointcut will match and a piece of advice will get executed inadvertently producing undesired results.


In AOP, you must specify a pointcut.  The pointcut is an expression, like a regex.  AOP advice will execute anytime that pointcut expression evaluates to true.  If a developer specifies a pointcut too broadly, it's possible the advice will execute when it's not expected to.


You can mitigate this risk by using annotations as your pointcut.

Then the advice only executes when there's an annotation on a class, method, field, argument, etc.  It's also easy to write AOP advice this way and add to your codebase.  So if you're looking to add some behavior that's suitable to AOP, annotations are a good way to ensure the advice only gets executed when you want it to.

In addition to the technical benefit, it's also a self-documenting feature.  Developers can see the annotations in the code and realize some side-effecting happens there.

How to run
==========

Clone the project via git, do a maven clean install, and run the jar to see it in action.

```bash
git clone https://github.com/mikeleitz/annotation-example.git

mvn clean install

java -jar target/annotation-example-0.0.1-SNAPSHOT.jar
```


