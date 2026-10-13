# Core Java & Object-Oriented Programming (OOP)

**Comprehensive Classroom Study Notes & Revision Guide**

_Compiled for Engineering Students, Technical Interviews, and Notebook Transcriptions_

## 1. The Architecture of Execution & Why Java Was Invented

### 1.1 The Legacy Execution Model (C / C++)

In traditional languages like C and C++, execution is tightly coupled to the underlying operating system and hardware architecture.

```
+-------------------------------------------------------------------------------+
|                        C / C++ EXECUTION PIPELINE                             |
+-------------------------------------------------------------------------------+
  [Source Code] (a.c)
        │
        ▼ (gcc on Linux / Turbo C on Windows)
   [Compiler]  ──> Performs Translation & Error Detection
        │
        ▼
  [Object File] (a.obj)
        │
        ▼
 [Linker & Loader] ──> Links external library routines & system calls
        │
        ▼
 [Executable File] ──> Loaded into Main Memory (RAM)
     ├── Windows: a.exe
     └── Linux:   a.out
+-------------------------------------------------------------------------------+
```

#### Core Limitations of C / C++

1. **Platform Dependency:** An executable generated on Windows (`a.exe`) cannot execute on Linux or macOS because object code and machine code contain OS-specific system calls and instruction sets.
    
2. **No Cross-Platform Portability:** Code compiled on one architecture cannot cross execution boundaries without complete recompilation using a platform-specific toolchain.
    

### 1.2 The Java Architectural Solution

Java resolves the platform dependency problem by decoupling source code compilation from host hardware instructions through a four-step execution architecture.


```
+-------------------------------------------------------------------------------+
|                          JAVA EXECUTION ARCHITECTURE                          |
+-------------------------------------------------------------------------------+
  [Java Source Code] (*.java)
        │
        ▼
   [javac Compiler] (Common Compiler across all platforms)
        │
        ▼
    [Bytecode] (*.class)  <── Common Intermediate Representation
        │
        ├──────────────────────┬──────────────────────┐
        ▼                      ▼                      ▼
  [Windows JVM/JRE]      [Linux JVM/JRE]       [macOS JVM/JRE]
        │                      │                      │
        ▼                      ▼                      ▼
   Windows (.exe)         Linux (.out)           macOS (.app)
+-------------------------------------------------------------------------------+
```

#### The 4-Step Resolution Mechanism

- **Step 1 — Create the JVM (Java Virtual Machine):** Build a virtual execution environment tailored for each operating system (Windows JVM, Linux JVM, macOS JVM).
    
    - _Architectural Rule:_ **JVM is Platform-Dependent** (written in C/C++ specifically for each operating system).
        
- **Step 2 — Create a Common Compiler (`javac`):** Develop a universal compiler that translates human-readable source code into intermediate virtual processor instructions rather than machine code.
    
- **Step 3 — Create a Common Intermediate File (Bytecode):** The compiler produces `.class` files containing **Bytecode**. Bytecode is universally understood by any standard JVM regardless of host hardware.
      
- **Step 4 — Create the JRE & Interpreter/Verifier (`java`):** Inside the Java Runtime Environment (JRE), the bytecode verifier ensures security and safety constraints, while the interpreter/JIT compiler executes instructions directly on the host OS.
    

#### Platform Independence vs. Platform Dependence

- **Java Language & Bytecode:** **Platform-Independent.** Write Once, Run Anywhere (WORA).
    
- **JVM and JRE:** **Platform-Dependent.** Each operating system requires its own specific JVM implementation.
    

## 2. Introduction to Java & Core Features

- **Year of Origin:** 1995
    
- **Original Developer:** James Gosling (Sun Microsystems; later acquired by Oracle)
    
- **Design Paradigm:** Object-Oriented, Class-Based, Concurrent
    

```
                          ┌── Object-Oriented
                          ├── Simple & Familiar
                          ├── Platform Independent (WORA)
   JAVA CORE FEATURES ────┼── Secured (Bytecode verification, no raw pointers)
                          ├── Robust (Strong memory management & Exception Handling)
                          ├── Portable (Neutral architectural footprint)
                          └── Multi-Threaded (Built-in concurrent processing)
```

### Robustness Illustrated: Java vs. C/C++ Runtime Safety

Consider an arithmetic fault such as integer division by zero:

```
Expression: int x = 10 / 0;

C / C++ Behavior:
├── Produces undefined behavior / garbage value
└── Causes program termination, core dump, or memory crash

Java Behavior:
├── Catches the invalid mathematical operation at runtime
└── Throws a managed runtime exception: java.lang.ArithmeticException: / by zero
```

## 3. Anatomy of a Java Program & Execution Lifecycle

Java

```
class HelloWorld {
    public static void main(String arg[]) {
        System.out.println("Hello");
    }
}
```

### Keyword-by-Keyword Dissection

- `class`: Reserved keyword used to declare a user-defined blueprint, type, or categorization.
    
- `HelloWorld`: Class identifier. By convention, class names use `PascalCase`.
    
- `public`: Access modifier with global scope. Allows the JVM to invoke the entry-point method from outside the class package.
    
- `static`: Class-level modifier. Allows the JVM to invoke `main()` directly without allocating heap memory or instantiating an object of the enclosing class.
    
- `void`: Return type indicating that the method returns no value to the calling runtime environment.
    
- `main`: Fixed signature identifier recognized by the JVM's execution subsystem as the application entry point.
    
- `String arg[]`: Parameter array of `java.lang.String` objects designed to capture command-line arguments passed during startup.
    
- `System`: Built-in final class belonging to the `java.lang` package.
    
- `out`: Static member reference variable of type `PrintStream` declared inside the `System` class.
    
- `println()`: Member method of `PrintStream` that writes the string payload to the standard output console followed by a newline character.
    

### Compilation and Execution Steps

Bash

```
# Step 1: Compile the source file (Generates HelloWorld.class containing Bytecode)
javac HelloWorld.java

# Step 2: Launch the JVM and pass the compiled class name
java HelloWorld
```

### Program Execution Flow

```
[Start]
   │
   ▼
[JVM ClassLoader Loads .class File]
   │
   ▼
[Bytecode Verifier Validates Constraints]
   │
   ▼
[JVM Locates Entry Point: public static void main(String[])]
   │
   ▼
[Executes System.out.println("Hello")]
   │
   ▼
[Terminates Execution / Reclaims Resources]
```

## 4. Variables, Data Types & Type Casting

### 4.1 Variables

A **variable** is a named location allocated in main memory (RAM) that stores data during runtime.

```
Syntax:
datatype variableName = value; // Optional initialization at declaration

Memory Representation:
       Variable Name: a
       +---------------+
       |      10       |  <── Stored Value
       +---------------+
       Address: 0x123     <── Physical RAM location
```

### 4.2 Data Type Hierarchy

```
                            DATA TYPES
                                │
        ┌───────────────────────┴───────────────────────┐
        ▼                                               ▼
  PRIMITIVE TYPES                              NON-PRIMITIVE TYPES
  (Fixed memory size, value types)             (Reference types, heap objects)
        │                                               │
        ├── byte     (1 byte / 8 bits)                  ├── Arrays
        ├── short    (2 bytes / 16 bits)                ├── Classes
        ├── int      (4 bytes / 32 bits)                ├── Abstract Classes
        ├── long     (8 bytes / 64 bits)                ├── Interfaces
        ├── float    (4 bytes / 32 bits)                ├── Packages
        ├── double   (8 bytes / 64 bits)                └── String (Min. 2 bytes/char +
        ├── char     (2 bytes / 16-bit Unicode)                     object metadata)
        └── boolean  (1 byte logical evaluation)
```

|**Data Type**|**Category**|**Size in Memory**|**Value Domain / Nature**|
|---|---|---|---|
|`byte`|Integer|1 Byte (8 bits)|$-128$ to $127$|
|`short`|Integer|2 Bytes (16 bits)|$-32,768$ to $32,767$|
|`int`|Integer|4 Bytes (32 bits)|$-2^{31}$ to $2^{31}-1$ (Default integer type)|
|`long`|Integer|8 Bytes (64 bits)|$-2^{63}$ to $2^{63}-1$ (Suffix with `L` or `l`)|
|`float`|Floating Point|4 Bytes (32 bits)|6–7 decimal digits precision (Suffix with `f`)|
|`double`|Floating Point|8 Bytes (64 bits)|15–16 decimal digits precision (Default floating point)|
|`char`|Textual|2 Bytes (16 bits)|$0$ to $65,535$ (Unicode character set)|
|`boolean`|Logical|1 Byte|`true` or `false`|
|Reference Types|Non-Primitive|Min. 4–8 bytes reference|Memory allocated in Heap; referenced via Stack pointer|

### 4.3 Type Casting

**Type Casting** is the process of converting a value from one data type to another.

#### 1. Widening Casting (Implicit / Automatic)

- **Definition:** Converting a smaller data type into a larger data type.
    
- **Safety:** Safe operation; zero risk of data truncation or precision loss.
    
- **Conversion Order:**
    
    `byte` $\rightarrow$ `short` $\rightarrow$ `int` $\rightarrow$ `long` $\rightarrow$ `float` $\rightarrow$ `double`
    

Java

```
// Example:
byte b = 100;
int i = b;  // Automatically cast: 1 byte value fits safely inside 4 bytes
```

#### 2. Narrowing Casting (Explicit / Manual)

- **Definition:** Converting a larger data type into a smaller data type.
    
- **Safety:** Unsafe operation; potential data truncation, integer overflow, or precision loss. Requires explicit cast syntax.
    
- **Conversion Order:**
    
    `double` $\rightarrow$ `float` $\rightarrow$ `long` $\rightarrow$ `int` $\rightarrow$ `short` $\rightarrow$ `byte`
    

Java

```
// Syntax Formula: TargetVariable = (TargetType) SourceVariable;

// Example:
double d = 125.75;
int x = (int) d;  // Explicit cast: Fractional component (.75) is truncated -> x = 125
```

## 5. Object-Oriented Programming (OOP) Fundamentals

OOP models software after real-world entities through interacting objects and classes.

```
                           REAL-WORLD OBJECT
                                   │
                    ┌──────────────┴──────────────┐
                    ▼                             ▼
              STATE / PROPERTY            BEHAVIOR / ACTION
             (Variables/Fields)               (Methods)
             e.g., color, model          e.g., drive(), brake()
```

### 5.1 Class vs. Object

- **Class:** A logical template or blueprint defining the state and behavior of an entity. It consumes no heap space until instantiated.
    
- **Object:** A physical instance of a class occupying heap memory and holding concrete state values.
    

Java

```
// Class Blueprint Definition
class Car {
    // Member Data / Properties
    String color;
    String model;

    // Member Function / Behavior
    void drive() {
        System.out.println("Car is running");
    }
}

// Object Instantiation and Usage
class TestCar {
    public static void main(String args[]) {
        Car c = new Car(); // Object creation
        c.color = "red";
        c.model = "xb";
        c.drive();
    }
}
```

### 5.2 Anatomy of Object Creation Syntax

```
   Car          c       =     new           Car();
    │           │              │              │
Class Type  Reference      Allocation    Constructor
 (Blueprint) Variable       Operator      Invocation
 (in Stack) (in Stack)    (Allocates in  (Initializes
                             Heap)       new object)
```

```
STACK MEMORY                             HEAP MEMORY
+--------------------+                   +-------------------------------+
| Reference: c       | ──points to────>  | Object (Car Instance)         |
| Address: 0x500     |                   | color = "red"                 |
+--------------------+                   | model = "xb"                  |
                                         | methods -> link to Car class  |
                                         +-------------------------------+
```

### Comparison Matrix: Class vs. Object

|**Parameter**|**Class**|**Object**|
|---|---|---|
|**Nature**|Logical template / blueprint|Physical entity / real-world instance|
|**Creation**|Declared using `class` keyword|Created via `new` keyword and constructor|
|**Memory**|Consumes class metadata memory in Metaspace|Allocated dynamic memory in Heap at runtime|
|**Existence**|Exists once per ClassLoader|Multiple instances can exist per class|

## 6. Static vs. Non-Static Members & Memory Optimization

### The Memory Wastage Problem

When fields with common, unchanging values (such as an employer or college name) are declared as standard non-static instance variables, every object creates its own separate copy of that field in the Heap.

```
Scenario: 10,000 Employees working at "TCS"

WITHOUT STATIC (Instance Variable):
Heap Memory:
  Object 1 [ eid: 101, ename: "A", company: "TCS" ]  ──> 1 copy of "TCS"
  Object 2 [ eid: 102, ename: "B", company: "TCS" ]  ──> 1 copy of "TCS"
  ...
  Object 10,000 [ ...             company: "TCS" ]  ──> 1 copy of "TCS"
  Result: 10,000 duplicate strings stored in Heap -> Severe memory waste!

WITH STATIC (Class Variable):
Class Metadata / Metaspace:
  [ static company = "TCS" ]  <── Single shared memory allocation
Heap Memory:
  Object 1 [ eid: 101, ename: "A" ] ──┐
  Object 2 [ eid: 102, ename: "B" ] ──┼──> References single shared static variable
  ...                                 │
  Object 10,000 [ ... ] ──────────────┘
  Result: Optimal memory efficiency and fast compile-time binding.
```

### Static Rules Summary

- **Binding Time:** Bound during class loading / compile-time.
    
- **Storage Location:** Stored in Metaspace (Class/Method area), not repeated in Heap instances.
    
- **Identity:** Belongs to the class identity, accessed via `ClassName.memberName`.
    
## 7. The Four Pillars of OOP

```
                          FOUR PILLARS OF OOP
                                   │
         ┌────────────────┬────────┴───────┬────────────────┐
         ▼                ▼                ▼                ▼
   ENCAPSULATION    POLYMORPHISM      INHERITANCE       ABSTRACTION
```

### Pillar 1: Encapsulation

- **Definition:** Wrapping data (fields) and methods operating on that data into a single protective unit (`class`) while restricting direct variable access using the `private` access modifier.
    
- **Implementation:** Declare variables as `private`; expose controlled access through `public` getter and setter methods.
    

Java

```
class BankAccount {
    // Hidden private data
    private double balance;

    // Mutator (Setter) with validation
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    // Accessor (Getter)
    public double getBalance() {
        return balance;
    }
}
```

#### Core Benefits

1. **Data Security:** Internal state cannot be corrupted directly from outside callers.
    
2. **Controlled Access:** Custom logic (validation, authentication) can be enforced inside setter methods.
    

### Pillar 2: Polymorphism

- **Etymology:** Derived from Greek: _Poly_ (many) + _Morph_ (forms) + _ism_ (concept).
    
- **Definition:** The ability of a message, method, or operator to execute differently based on context or runtime object type.
    

```
                          POLYMORPHISM
                                │
        ┌───────────────────────┴───────────────────────┐
        ▼                                               ▼
  COMPILE-TIME POLYMORPHISM                       RUNTIME POLYMORPHISM
  (Static Binding / Overloading)                 (Dynamic Binding / Overriding)
  Resolved at compile-time                       Resolved at runtime
  e.g., Method Overloading                       e.g., Method Overriding
```

#### Compile-Time Polymorphism (Method Overloading)

Methods in the same class share the exact same name but differ in their parameter list (count, types, or order).

Java

```
class Calculator {
    void add(int x, int y) {
        System.out.println("Sum of two: " + (x + y));
    }

    void add(int x, int y, int z) {
        System.out.println("Sum of three: " + (x + y + z));
    }

    public static void main(String args[]) {
        Calculator calc = new Calculator();
        calc.add(10, 20);       // Invokes 2-parameter version
        calc.add(10, 20, 30);   // Invokes 3-parameter version
    }
}
```

### Pillar 3: Inheritance

- **Definition:** A mechanism where a child/subclass acquires properties (fields) and behaviors (methods) of an existing parent/superclass.
    
- **Keyword:** `extends`
    
- **Primary Benefit:** Eliminates redundancy and facilitates **Code Reusability**.
    

Java

```
// Superclass (Parent)
class Emp {
    int eid;
    String ename;
    String post;
}

// Subclass (Child) reusing fields from Emp
class Pay extends Emp {
    int pid;
    String paymentType;
    float salary;
}
```

### Pillar 4: Abstraction

- **Definition:** Hiding internal implementation complexities and showing only essential features to the user.
    
- **Real-World Analogy:** Driving a car requires interacting with the accelerator pedal without needing to manage internal fuel-injection timing.
    

#### Why Do We Use Abstraction?

1. **Hides Implementation Details:** End users interact with clean, purposeful interfaces.
    
2. **Improves Security:** Protects core business logic from direct external tampering.
    
3. **Reduces Complexity:** Isolates system components into clean conceptual layers.
    
4. **Provides Flexibility:** Underlying engine logic can be updated without breaking consumer code.
    
5. **Supports Loose Coupling:** Removes rigid dependencies between functional modules.
    
6. **Enforces Standardization:** Defines _what_ operations must occur, allowing implementers to determine _how_.

Java

```
// Central Bank defines contract
abstract class RBI {
    abstract void getInterestRate(); // Abstract method (no body)
}

// Concrete Implementations
class SBI extends RBI {
    void getInterestRate() {
        System.out.println("SBI Interest Rate: 9%");
    }
}

class CanaraBank extends RBI {
    void getInterestRate() {
        System.out.println("Canara Bank Interest Rate: 12%");
    }
}
```

## 8. Access Modifiers in Java

Access modifiers define the scope and visibility of classes, variables, methods, and constructors.

```
[Visibility Scope Hierarchy]
  PUBLIC  >  PROTECTED  >  DEFAULT (Package-Private)  >  PRIVATE
(Most Open)                                           (Most Restrictive)
```

|**Access Modifier**|**Within Same Class**|**Within Same Package**|**Subclass (Outside Package)**|**Outside Package Globally**|
|---|---|---|---|---|
|`private`|**YES**|NO|NO|NO|
|`default` (no keyword)|**YES**|**YES**|NO|NO|
|`protected`|**YES**|**YES**|**YES** (via `extends` only)|NO|
|`public`|**YES**|**YES**|**YES**|**YES**|

### Implementation Examples

#### 1. Private Scope

Java

```
class Student {
    private int marks = 90; // Accessible ONLY within class Student
}

class Main {
    public static void main(String args[]) {
        Student s = new Student();
        // System.out.println(s.marks); // COMPILE ERROR: marks has private access in Student
    }
}
```

#### 2. Default Scope (Package-Private)

Java

```
class Student {
    int marks = 90; // Default: Accessible to any class within the same package
}

class Test {
    public static void main(String args[]) {
        Student s = new Student();
        System.out.println(s.marks); // ALLOWED (if Test and Student share package)
    }
}
```

#### 3. Protected Scope

Java

```
package packageA;
public class Parent {
    protected int age = 90; // Accessible within packageA, and child classes outside packageA
}

package packageB;
import packageA.Parent;

class Child extends Parent {
    public static void main(String args[]) {
        Child c = new Child();
        System.out.println(c.age); // ALLOWED: Accessed through inheritance
    }
}
```

## 9. Class Relationships: IS-A vs. HAS-A

```
                         CLASS RELATIONSHIPS
                                  │
         ┌────────────────────────┴────────────────────────┐
         ▼                                                 ▼
  IS-A RELATIONSHIP                               HAS-A RELATIONSHIP
  (Inheritance via extends)                       (Association / Containment)
  e.g., Pay IS-A Employee                                  │
                                       ┌───────────────────┴───────────────────┐
                                       ▼                                       ▼
                                 AGGREGATION                              COMPOSITION
                              (Weak containment)                      (Strong containment)
```

### 9.1 The HAS-A Relationship

Occurs when one class contains a reference to another class as a member field.
#### 1. Aggregation (Weak Association)

- The containing class holds a reference to the contained class, but **both objects have independent lifecycles**.
    
- If the container object is destroyed, the contained object remains alive in memory.

Java

```
class Address {
    String city, state, country;
}

class Student {
    int sid;
    String sname;
    Address address; // Student HAS-A Address (Aggregation)
}
```

#### 2. Composition (Strong Association)

- The containing class owns the contained object entirely; **their lifecycles are tightly bound**.

- If the owner object is deleted, the contained object is destroyed with it.

- _Example:_ A `Car` and its `Engine`. An `Engine` cannot meaningfully exist as an active subsystem without the enclosing `Car`.

### 9.2 HAS-A vs. IS-A Architectural Comparison

Java

```
// HAS-A Relationship (Composition/Aggregation) - Recommended for loose coupling
class Car {
    Engine engine; // Car HAS-A Engine
}

// IS-A Relationship (Inheritance) - Used only when True Subtyping applies
class Car extends Vehicle { // Car IS-A Vehicle (Correct)
}

// ANTI-PATTERN / DESIGN FLAW:
class Car extends Engine {  // WRONG: A Car is NOT an Engine!
}
```

## 10. Types of Inheritance in Java

```
1. Single Inheritance         2. Multilevel Inheritance         3. Hierarchical Inheritance
      [Class A]                     [Class A1]                         [Parent]
         ▲                             ▲                                 ▲
         │                             │                            ┌────┴────┐
      [Class B]                     [Class B1]                      │         │
                                       ▲                        [Child 1]  [Child 2]
                                       │
                                    [Class C1]

2. Multiple Inheritance (With Classes) ──> NOT PERMITTED IN JAVA
      [Class A1]     [Class A2]
          ▲              ▲
          │              │        Result: COMPILE ERROR
          └──────┬───────┘        (Diamond Problem / Method Ambiguity)
             [Class B]
```

### Why Java Disallows Multiple Inheritance for Classes

If `Class A1` and `Class A2` both define a method `void show()`, and `Class B` extends both `A1` and `A2`, calling `new B().show()` creates an unresolvable collision known as the **Diamond Problem**. Java eliminates this ambiguity at the language level by allowing classes to `extend` only one superclass.

### Rule on Inheriting Private Members

- **Private members are physically inherited** into the internal memory footprint of the child object.
    
- However, **private members cannot be directly accessed** by child class code. Access must occur through inherited `public` or `protected` getters and setters.
    

## 11. Method Overriding & The `super` Keyword

### 11.1 Method Overriding (Runtime Polymorphism)

Method overriding occurs when a child class provides its own specific implementation of a method that has already been declared in its parent class.
#### Rules for Method Overriding

1. The method signature (name, parameter list, and return type) must be identical to that of the parent class.
    
2. **Access Modifier Rule:** The overriding method in the child class cannot assign a weaker (more restrictive) access privilege than was defined in the parent class.
    

```
       PARENT ACCESS SCOPE           ALLOWED CHILD OVERRIDING SCOPE
       ───────────────────           ──────────────────────────────
       public                ───>    public only
       protected             ───>    protected OR public
       default               ───>    default, protected, OR public
       private               ───>    CANNOT BE OVERRIDDEN (Hidden)
```

```
+--------------------------------------------------------------------------+
|                 METHOD OVERRIDING ACCESS PRIVILEGE RULE                  |
+--------------------------------------------------------------------------+
| Parent Modifier  | Child Modifier | Result                               |
|:-----------------|:---------------|:-------------------------------------|
| Stronger Scope   | Weaker Scope   | ❌ COMPILE ERROR (Restricting Access)|
| Weaker Scope     | Stronger Scope | ✔ ALLOWED (Broadening Visibility)    |
+--------------------------------------------------------------------------+
```

### 11.2 The `super` Keyword

The `super` keyword is an explicit reference pointer to the immediate parent class object.
#### The 3 Primary Usages of `super`

Java

```
class Parent {
    int age = 50;

    Parent() {
        System.out.println("Parent Constructor Initialized");
    }

    void display() {
        System.out.println("Parent display method");
    }
}

class Child extends Parent {
    int age = 20;

    Child() {
        super(); // Usage 3: Invoke immediate parent class constructor
    }

    void printDetails() {
        System.out.println(super.age); // Usage 2: Access parent instance variable (50)
        System.out.println(this.age);  // Access child instance variable (20)
    }

    void display() {
        super.display(); // Usage 1: Invoke immediate parent class method
        System.out.println("Child overriding display");
    }
}
```

## 12. Interfaces & Advanced Abstraction

### 12.1 Interface Definition & Architecture

An **Interface** is a formal contract in Java that specifies _what_ a class must do without prescribing _how_ it should do it. It acts as an architectural boundary between application developers and underlying frameworks.


```
      [Java Developer] ──writes against──> [API / Interface Specification]
                                                      │
                                                      ▼ connects to
                                            [Underlying Engine / Driver]
```

Java

```
// Declaration Syntax
interface Printable {
    void print(); // Implicitly public abstract
}

// Implementation Syntax
class Document implements Printable {
    public void print() { // Must be public (cannot reduce visibility)
        System.out.println("Document printed successfully.");
    }
}
```

### 12.2 Why Use Interfaces?

1. **Achieve 100% Pure Abstraction:** Exposes pure behavior signatures without leaking internal state.
    
2. **Enable Loose Coupling:** Code depends on stable abstract interfaces rather than concrete, volatile implementation classes.
    
3. **Achieve Multiple Inheritance:** While Java prohibits multiple class inheritance, a class may implement multiple interfaces:
    
    Java
    
    ```
    class ServiceImpl implements InterfaceOne, InterfaceTwo, InterfaceThree
    ```
    
1. **Facilitate Runtime Polymorphism:** Standardizes disparate backend implementations under a unified interface reference.

### Abstraction Spectrum Comparison

```
ABSTRACT CLASS                              INTERFACE
├── Partial Abstraction (0% to 100%)       ├── 100% Pure Abstraction (Classic Java)
├── Can have instance state variables      ├── All fields are public static final
└── Can provide concrete logic methods     └── Focuses strictly on contract specifications
```

### 12.3 Modern Interface Features (Java 8+)

#### 1. Default Methods (`default`)

- **Definition:** Concrete methods defined inside an interface decorated with the `default` keyword.
    
- **Why Were They Added? (Backward Compatibility Problem):**
    Suppose an established enterprise interface is implemented by 100 production classes. If the design demands a new method, adding a traditional abstract signature forces all 100 classes to immediately break until manually edited. A `default` method provides a fallback implementation, allowing existing implementers to run unmodified while offering optional overrides.
    

Java

```
interface Vehicle {
    void drive(); // Standard abstract method

    // Default method providing non-breaking backward compatibility
    default void playRadio() {
        System.out.println("Playing default station");
    }
}
```

#### 2. Static Methods inside Interfaces

- **Definition:** Utility methods defined inside an interface containing the `static` keyword.
    
- **Scope:** Belongs solely to the interface namespace. Must be invoked via `InterfaceName.methodName()`. Implementer classes cannot override them.
    

Java

```
interface Security {
    static void logAudit(String event) {
        System.out.println("Audit recorded: " + event);
    }
}

// Invocation
Security.logAudit("UserLogin_OK");
```

## 13. Comprehensive Educational Summary & Revision Toolkit

### Memory Tricks & Mnemonics

- **WORA:** **W**rite **O**nce, **R**un **A**nywhere (Java’s bytecode philosophy).
    
- **APIE (4 Pillars of OOP):**
    
      
    - **A**bstraction (Hide implementation details)
        
    - **P**olymorphism (Many functional forms)
        
    - **I**nheritance (Reusability via parent-child hierarchy)
        
    - **E**ncapsulation (Data protection via getters and setters)
        
- **Widening Casting Order:** **B**ig **S**tudents **I**n **L**ondon **F**eel **D**elighted

    $\rightarrow$ `byte` $\rightarrow$ `short` $\rightarrow$ `int` $\rightarrow$ `long` $\rightarrow$ `float` $\rightarrow$ `double`
- **Access Scope Hierarchy:** **P**ublic > **P**rotected > **D**efault > **P**rivate
    _(Mnemonic: **P**ublic **P**rotects **D**efault **P**rivacy)_

### Common Traps & Pitfalls (Exams & Interviews)

1. **The Overriding Access Scope Trap:**
    
      
    - _Trap:_ Attempting to override a `protected` method from a parent class by declaring it `default` or `private` in the child class.
        
    - _Correction:_ You can expand visibility (`protected` $\rightarrow$ `public`), but never restrict it.
        
2. **Platform Dependency Trap:**
    
      
    - _Trap:_ Stating "Java is platform-dependent" or "Java is completely platform-independent."
        
    - _Correction:_ **Java language and Bytecode are platform-independent.** The **JVM and JRE are platform-dependent.**
        
3. **Class vs. Object Memory Trap:**
    
      
    - _Trap:_ Believing declaring `class Car { ... }` allocates RAM for its fields.
        
    - _Correction:_ Memory for instance fields is only allocated during runtime when the `new` keyword executes.
        
4. **Multiple Inheritance Trap:**
    
      
    - _Trap:_ Stating "Java does not support multiple inheritance."
        
    - _Correction:_ Java does not support multiple inheritance with **classes**, but fully supports it through **interfaces**.
        

### Frequently Asked Questions (FAQ)

#### Q1: What happens if `static` is removed from `public static void main`?

The code will compile without errors. However, at runtime, the JVM will fail to invoke the entry point and throw a runtime error:

`Error: Main method is not static in class, please define the main method as: public static void main(String[] args)`

#### Q2: Why does `char` take 2 bytes in Java, but only 1 byte in C?

C uses the ASCII character set (values 0–127), which fits in 8 bits (1 byte). Java was designed for global internationalization and uses 16-bit **Unicode** (`UTF-16`), allowing it to represent every character from all major world languages.

#### Q3: Can an abstract class have a constructor?

**Yes.** Even though an abstract class cannot be instantiated directly via `new`, its constructor is called whenever an instance of its concrete subclass is created via `super()` during constructor chaining.

#### Q4: Why can't we declare interface fields as private or protected?

An interface represents a public contract. All variables declared within an interface are implicitly **`public static final`** constants.

  
### Quick Revision Checklist (Topper’s Formula Sheet)

- [ ] **Compilation:** `javac Filename.java` $\rightarrow$ Produces `Filename.class` (Bytecode).
    
- [ ] **Execution:** `java Filename` $\rightarrow$ Runs through JVM.
    
- [ ] **Integer Types:** `byte` (1B), `short` (2B), `int` (4B), `long` (8B).
    
- [ ] **Floating Point Types:** `float` (4B), `double` (8B).
    
- [ ] **Character & Boolean:** `char` (2B, Unicode), `boolean` (1B logical).
    
- [ ] **Widening (Implicit):** Small type to Large type (Safe, Automatic).
    
- [ ] **Narrowing (Explicit):** Large type to Small type: `(targetType) value` (Risk of data loss).
    
- [ ] **OOP Pillars:** Encapsulation, Polymorphism, Inheritance, Abstraction.
    
- [ ] **Static keyword:** Class-level scope, loaded once into Metaspace, saves heap memory.
    
- [ ] **Inheritance keyword:** `extends` (Classes). Single, Multilevel, and Hierarchical supported. Multiple class inheritance blocked due to Diamond Problem.
    
- [ ] **Interface keyword:** `interface` (Declared), `implements` (Consumed). Supports multiple inheritance and 100% abstraction.
    
- [ ] **super keyword:** Refers to immediate parent class (Constructor: `super()`, Method: `super.m()`, Variable: `super.v`).
    
- [ ] **Java 8 Interfaces:** Support `default` methods (backward-compatible bodies) and `static` utility methods.