# Calculator Parser

A Java math expression parser that takes in an expression and outputs the answer using the correct order of operations..

## Features

- **Basic Operations**: +, -, x, *, /
- **Parenthesis**: (2 + 3) * 5 
- **Exponents**: 2 ^ 5
- **Order of Operations**: The program uses PEMDAS to give the correct answer

## Prerequisites 

- Java 8 or higher (It's a simple program that's it!)

## Installation & Setup

1.  **Clone the repository** 
```bash 
git clone https://github.com/calculator-parser/bible-verse-bootcamp.git 
cd bible-verse-bootcamp
```

2. **Build and run**
```bash
mvn compile exec:java
```

## Project Structure
```pgsql
.
├── pom.xml // For Maven 
├── README.md 
├── src
│   └── main
│       └── java
│           └── com
│               └── aaronxyzheng
│                   └── calculatorparser
│                       ├── datastructures // Data Structures used for algorithms.
│                       │   ├── Queue.java 
│                       │   └── Stack.java
│                       ├── Main.java // User Interface
│                       └── MathLogic.java // Where the Math gets done and expression gets evaluated.
└── target
```


## What I Learned :)

- Infix + Postfix Notation
- Shunting Yard Algorithm (Turns Infix -> Postfix)
- Type Casting 
- Tokening Strings. (Is tokening a word? Or is it tokenizing.  ¯\_(ツ)_/¯)

## Potential Improvements / Known Errors

- Decimal Compatability (The tokenizer right Now doesn't tokenize decimals)
- Error Handling + Custom Errors
- Add Unit Tests

## Contributing

This is a personal learning project, but suggestions and feedback are welcome! Feel free to:

-   Open issues for bugs or feature requests
-   Submit pull requests for improvements
-   Share ideas for new practice modes

## Connect with Me

**Github:** aaronxyzheng (it's literally just my username. And I created this project. So you should be able to find my username. Just saying ¯\_(ツ)_/¯)
