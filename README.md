# ShoppingCart

## Description:
This is a simple shopping cart calculator. It reads a text file with a series of product names. The application then outputs a text file with subtotals for each product, as well as a total for all products.

## Java Version:
This application was built and test with Java version 9.0.4.

## Usage:
Run "java -jar Shopping.jar (input file name) (output file name)". For example "java -jar Shopping.jar sampleInput.txt output.txt". The subtotals and total will be written to the output file.

## Note: 
The output file name is optional. If an output file name is not provided, then the output file name will be "output_(timestamp).txt"

## File Descriptions:
- README.md = This file.
- Requirements.md = A document containing the project requirements.
- ShoppingCart.java = This file contains the core code for the ShoppingCart calculation.
- Product.java = This file contains code for the "Product" class, which stores information about prices and quantities.
- ReadFile.java = This file contains a helper function for reading input files.
- sampleInput.txt = This is a sample input file to use with the application.
- sampleInput.txt = This is an alternate sample input file to use with the application.
- sampleInput.txt = This is yet another alternate sample input file to use with the application.
- sampleOutput.txt = This is a sample output file produced by the application.
- Shopping.jar = This is a compiled jar file.
- /META-INF/MANIFEST.MF = This is a manifest file for compiling a jar file.

## To Compile:
1. Navigate to the main project directory.
2. Run "javac *.java". This compiles the .java files into .class files.
3. Run "jar cmvf META-INF/MANIFEST.MF Shopping.jar *.class *.java" to create the .jar file.
4. Run "java -jar Shopping.jar sampleInput.txt sampleOutput.txt" to run the jar file. The output will be written to the file "sampleOutput.txt".
