package com.junming.spring_boot_crud_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class".
 * A single @SpringBootApplication annotation can be used to enable those three features
 *
 * //@Configuration: Annotating a class with the @Configuration indicates that the class has @Bean definition METHODS and that the class can be used by the Spring IoC container as a source of bean definitions.
 * //Spring IoC Container is the core of Spring Framework. It creates the objects, configures and assembles their dependencies, manages their entire life cycle. The Container uses Dependency Injection(DI) to manage the
 * //components that make up the application. It gets the information about the objects from a configuration file(XML) or Java Code or Java Annotations and Java POJO class. These objects are called Beans.
 * //Since the Controlling of Java objects and their lifecycle is not done by the developers, hence the name Inversion Of Control.
 *
 *
 * //The @EnableAutoConfiguration annotation enables Spring Boot to auto-configure the application context(ioc). Therefore, it automatically creates and registers beans based on both the included jar files
 *  in the classpath and the beans defined by us.
 * //For example, when we define the spring-boot-starter-web dependency in our classpath, Spring boot auto-configures Tomcat and Spring MVC. However, this auto-configuration has less precedence in case we define our own configurations.
 * //The package of the class declaring the @EnableAutoConfiguration annotation is considered as the default. Therefore, we should always apply the @EnableAutoConfiguration annotation in the root package so that every sub-packages and class can be examined:
 *
 * //@ComponentScan: @ComponentScan enables Spring to scan for things like configurations, controllers, services, and other components we define.
 * //In particular, the @ComponentScan annotation is used with @Configuration annotation to specify the package for Spring to scan for components:
 *
 * @EnableWebMvc: Flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
 */
@SpringBootApplication
public class SpringBootCrudExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudExampleApplication.class, args);
	}
}
//@Component vs @Bean
//@Component Preferable for component scanning and automatic wiring.
//When should you use @Bean?
//Sometimes automatic configuration is not an option. When? Let's imagine that you want to wire components from 3rd-party libraries (you don't have the source code so you can't annotate its classes with @Component), so automatic configuration is not possible.
//The @Bean annotation returns an object that spring should register as bean in application context. The body of the method bears the logic responsible for creating the instance.
//Creating beans from external jar https://stackoverflow.com/questions/29571304/how-can-i-autowire-a-spring-bean-that-was-created-from-an-external-jar

//JVM is specifically responsible for converting Java bytecode to machine-specific code and is necessary in both JDK and JRE.
//JVM also platform-dependent and performs many functions, including memory management and security. Java is platform-independent language
//In addition, JVM can run programs written in other programming languages that have been translated to Java bytecode.
//Java VM is available on different operating systems. Hence, it allows Java programs to run on any device or operating system
//Before Java, all program memory was managed by the programmer.
//In Java, program memory is managed by the JVM. The JVM manages memory through a process called garbage collection.
//which continuously identifies and eliminates unused memory in Java programs. Garbage collection happens inside a running JVM.
//What part of memory - Stack or Heap - is cleaned in garbage collection process?
//Heap

//Java Runtime Environment, or JRE, is a set of software tools responsible for execution of the Java program or application on your system.
//JRE uses heap space for dynamic memory allocation for Java objects.

//Java Development Kit, or JDK, is a software development kit often called a superset of JRE

//How does JVM, JRE and JDK work together?
//JVM converts bytecode to machine-specific code
//JRE executes Java program. It includes JVM
//JDK is a development kit that includes JRE(which in turns include JVM), a Java compiler, a debugger and more.

//JIT compiler.
//JIT stands for Just-In-Time and it is used for improving the performance during run time.
// It does the task of compiling parts of byte code having similar functionality at the same time thereby reducing the amount of compilation time for the code to run.
//The compiler is nothing but a translator of source code to machine-executable code. But what is special about the JIT compiler? Let us see how it works:
	//First, the Java source code (.java) conversion to byte code (.class) occurs with the help of the javac compiler.
	//Then, the .class files are loaded at run time by JVM and with the help of an interpreter, these are converted to machine understandable code.
	//JIT compiler is a part of JVM. When the JIT compiler is enabled, the JVM analyzes the method calls in the .class files and compiles them to get more efficient and native code.
    // It also ensures that the prioritized method calls are optimized.
	// Once the above step is done, the JVM executes the optimized code directly instead of interpreting the code again. This increases the performance and speed of the execution.

//At Compile time
// .java source code -> Compiler -> .class bytecode
//At run time
//.class bytecode -> JIT compiler -> Native code

//Why is Java platform independent?
//Whenever, a program is written in JAVA, the javac compiles it.
//The result of the JAVA compiler is the .class file or the bytecode and not the machine native code (unlike C compiler).
//The bytecode generated is a non-executable code and needs an interpreter to execute on a machine. This interpreter is the JVM and thus the Bytecode is executed by the JVM.
//And finally program runs to give the desired output.
//Since the JVM is platform dependent, it will translate the java bytecode to machine code that can be read by different operating system


//
//what is a classpath?
// https://stackoverflow.com/questions/2396493/what-is-a-classpath-and-how-do-i-set-it

//
//The @Bean annotation tells Spring that a METHOD annotated with @Bean will return an object that should be registered as a bean in the Spring application context.
//@Configuration
//@ComponentScan(basePackageClasses = Company.class)
//public class Config {
//	@Bean
//	public Address getAddress() {
//		return new Address("High Street", 1000);
//	}
//}

//
//@Component is an annotation that allows Spring to automatically detect our custom beans.
//In other words, without having to write any explicit code, Spring will:
//Scan our application for CLASSES annotated with @Component
//Instantiate them and inject any specified dependencies into them
//Inject them wherever needed
//However, most developers prefer to use the more specialized stereotype annotations to serve this function.
//Spring has provided a few specialized stereotype annotations: @Controller, @Service, and @Repository. They all provide the same function as @Component.

//
//What are spring beans?
//https://www.baeldung.com/spring-bean
//When a Spring IoC container constructs objects of those types, all the objects are called Spring beans, as they are managed by the IoC container.


/**
 * Pros of Spring Boot
 * 1. Ease of Dependency Management
 * To speed up the dependency management process, Spring Boot implicitly packages the required third-party dependencies for each type of Spring-based application and provides them through so-called starter packages (spring-boot-starter-web, spring-boot-starter-data-jpa, etc.).
 *
 * Starter packages are collections of handy dependency descriptors that you can include in your application. They allow you to get a universal solution for all Spring-related technologies, removing the necessity to search for code examples and load the required dependency descriptors from them.
 *
 * For instance, if you want to start using Spring Data JPA to access your database, just include the spring-boot-starter-data-jpa dependency in your project and you’ll be done (no need to look for compatible Hibernate database drivers and libraries).
 *
 * If you want to create a Spring web application, just add the spring-boot-starter-web dependency, which will pull all the libraries you need to develop Spring MVC applications into your project, such as spring-webmvc, jackson-json, validation-api, and Tomcat.
 *
 * To say in a few words what is Spring Boot used for, it collects all common dependencies and defines them in one place, which allows developers to get to work right away instead of reinventing the wheel every time they create a new application.
 *
 * Therefore, the pom.xml file contains much fewer lines when used in Spring Boot than in regular Spring.
 *
 * 2. Automatic Configuration
 * After choosing a suitable starter package, Spring Boot will try to automatically configure your Spring application based on the jar dependencies you added.
 *
 * For example, if you add Spring-boot-starter-web, Spring Boot will automatically configure registered beans such as DispatcherServlet, ResourceHandlers, and MessageSource.
 *
 * If you are using spring-boot-starter-jdbc, Spring Boot automatically registers the DataSource, EntityManagerFactory, and TransactionManager beans and reads the database connection information from the application.properties file.
 *
 * If you are not going to use a database and do not provide any details about connecting manually, Spring Boot will automatically configure the database in the memory without any additional configuration on your part (if you have H2 or HSQL libraries). Automatic configuration can be completely overridden at any time by using user preferences.
 *
 * 3. Native Support for Application Server – Servlet Container
 * Every Spring Boot application includes an embedded web server. Developers no longer have to worry about setting up a servlet container and deploying an application to it.
 * The application can now run itself as an executable jar file using the built-in server. If you need to use a separate HTTP server, simply exclude the default dependencies. Spring Boot provides separate starter packages for different HTTP servers.
 */

//Spring Boot is built on the top of the spring and contains all the features of spring. And is becoming a favorite of developers these days because it is a rapid production-ready environment (comes with embedded tomcat) that enables the developers to directly focus on the logic
//instead of struggling with the configuration and setup. Spring Boot is a microservice-based framework and making a production-ready application in it takes very little time. Here we will learn how to create a Spring Boot application that will
//consume external API.
            

//Stack and heap memory in java
//Both are stored in computer rams.
//Stack Memory in Java is used for static memory allocation and the execution of a thread.
//It contains primitive values that are specific to a method and references to objects referred from the method that are in a heap.
//Heap space is used for the dynamic memory allocation of Java objects and JRE classes at runtime.
// New objects are always created in heap space, and the references to these objects are stored in stack memory.
//Stack is used in parts, one at a time during execution of a thread. The entire application uses Heap space during runtime
//https://www.baeldung.com/java-stack-heap

//What is Stack Memory in Java?
//Stack memory is the space allocated for a process where all the function calls, primitive data types like int, double, etc., and local and reference variables of the functions are stored.
// Stack memory is always accessed in a Last-In-First-Out (LIFO) manner. In the stack memory, a new memory block is created for every method that is executed.
// All the primitive variables and references to objects inside the method are stored in this memory block. When the method completes its execution, the memory block is cleared from the stack memory and
// the stack memory is available for use. The values in the stack exist for as long as the function that created them is running. The size of the stack memory is fixed and cannot grow or shrink once created.

//What is memory leak? A memory leak is a situation where unused objects occupy unnecessary space in memory.

//Garbage collection in JAVA   https://www.dynatrace.com/resources/ebooks/javabook/how-garbage-collection-works/
//Automatic garbage collection is the process of looking at heap memory, identifying which objects are in use and deleting the unused objects. Live objects are tracked and everything else designated garbage.
// An in use object, or a referenced object, means that some part of your program still maintains a pointer to that object.
// An unused object, or unreferenced object, is no longer referenced by any part of your program. So the memory used by an unreferenced object can be reclaimed.
//When the Young Generation fills up, minor garbage collection is run, only removing the unused objects and objects that are not referenced anymore.
//Objects that survive the minor garbage collection are moved to other Survivor Space. Every time an object survives a minor garbage collection it is said to be aged — getting old.
//Often a threshold is set for the young generation to be considered old generation and moved to Tenured part of the heap memory.
//The old generation is used to store long-lived objects. Eventually, the old generation also needs to be garbage collected and this is called the major garbage collection.
//
//Why does garbage collection occur at the young generation first?
//Most allocated objects are not referenced (considered live) for long, that is, they die young.
//Young generation collections occur relatively frequently and are efficient and fast because the young generation space is usually small and likely to contain a lot of objects that are no longer referenced.
//Objects that survive some number of young generation collections are eventually promoted, or tenured, to the old generation.
//This generation is typically larger than the young generation and its occupancy grows more slowly. As a result, old generation collections are infrequent, but take significantly longer to complete.
//The garbage collection algorithm chosen for a young generation typically puts a premium on speed, since young generation collections are frequent.
//On the other hand, the old generation is typically managed by an algorithm that is more space efficient, because the old generation takes up most of the heap and old generation algorithms have to work well with low garbage densities.
//
//
//The Permanent generation is a special heap space separated from the main memory heap where objects are allocated in.
//This is a special space in java heap which is separated from the main memory where all the static content is stored in this section.
//Apart from that, this memory also stores the application metadata required by the JVM. Metadata is a data which is used to describe the data.
//Here, garbage collection also happens like any other part of the memory. String pool was also part of this memory before Java 7.
//Method Area is a part of space in the PermGen and it is used to store the class structure and the code for methods and constructors.

//In java 8 permanent generation is replaced with metaspace. Metaspace is part of Native memory and is not part of the heap. Heap is memory within the JVM process that is used to hold Java Objects and is maintained by the JVMs Garbage Collector.
//Native memory is part of the OS and is not cleaned up by garbage collection.
//The biggest disadvantage of PermGen is that it contains a limited size which leads to an OutOfMemoryError.
//The default size of PermGen memory is 64 MB on 32-bit JVM and 82 MB on the 64-bit version. Due to this, JVM had to change the size of this memory by frequently performing Garbage collection which is a costly operation.
//Java also allows to manually change the size of the PermGen memory. However, the PermGen space cannot be made to auto increase.
//Metaspace by default auto increases its size depending on the underlying OS.

//Why is String Pool part of the heap and not stack when it is static and immutable. This is because string are very frequently used.
// From memory allocation to its access and availability, a heap is the most suitable area to store the String constant pool.

//Full GC and consecutive Full GC
//https://blog.gceasy.io/2016/11/22/eliminate-consecutive-full-gcs/#:~:text=Full%20GC%20is%20an%20important,it%20runs%20across%20all%20generations.
//Full GC is an important event in the garbage collection process. During this full GC phase, garbage is collected from all the regions in the JVM heap (Young, Old, Perm, Metaspace). Full GC tends to evict more objects from memory,
// as it runs across all generations. A Full GC event has multiple phases. Certain phases of the Full GC event (like ‘initial-mark, ‘remark’, ‘cleanup’,..) pauses all the application threads that are running the JVM.
// During this period, no customer transactions will be processed. JVM will use all the CPU cycles to perform garbage collection. Due to that CPU consumption will be quite high. Thus in general full GCs aren’t desired.
// Needless to ask the desirability of consecutive full GCs.
//Consecutive Full GCs are caused because of one single reason: Under allocation of JVM heap size or Under allocation of Perm Gen/metaspace. It’s indicative of the fact that application needs more memory than what you have allocated.

//https://www.dynatrace.com/resources/ebooks/javabook/how-garbage-collection-works/
//Many people think garbage collection collects and discards dead objects. In reality, Java garbage collection is doing the opposite!
//Live objects are tracked and everything else designated garbage. As you'll see, this fundamental misunderstanding can lead to many performance problems.
//As long as an object is being referenced, the JVM considers it alive. Once an object is no longer referenced and therefore is not reachable by the application code, the garbage collector removes it and reclaims the unused memory
//and reuses it for future object allocation. This means there is no explicit deletion and no memory is given back to the operating system.

//Every object tree must have one or more root objects. As long as the application can reach those roots, the whole tree is reachable. But when are those root objects considered reachable?
//Special objects called garbage-collection roots are always reachable and so is any object that has a garbage-collection root at its own root. GC roots are objects that are themselves referenced by the JVM and thus keep every other object from being garbage-collected.
//To determine which objects are no longer in use, the JVM intermittently runs what is very aptly called a mark-and-sweep algorithm.
//two-step process:
//
//1. The algorithm traverses all object references, starting with the GC roots, and marks every object found as alive.
//2. All of the heap memory that is not occupied by marked objects is reclaimed. It is simply marked as free, essentially swept free of unused objects.

//As we've seen, the performance of the garbage collector is not determined by the number of dead objects, but rather by the number of live ones. The more objects die, the faster garbage collection is. If every object in the heap were to be garbage-collected, the GC cycle would be nearly instantaneous.
//Additionally, the garbage collector must suspend the execution of the application to ensure the integrity of the object trees. The more live objects are found, the longer the suspension, which has a direct impact on response time and throughput.