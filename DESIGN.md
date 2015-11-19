# Spiral Excercise

### Exercise Description
Create a command line tool to draw spirals. Just print the output to console. They’re just ASCII characters (dash -, pipe |, and plus +).

The program should be object oriented. Currently it only draws spirals, but the tool will eventually draw more things like rectangle, triangle, etc and it will not only draw it as ASCII, it will draw as SVG and other formats too. The drawing functionalities will also be exposed via web application and REST API. Your class design should take into account those future requirements so that it’s easy to add those functionalities. Write down your design rationale on the file DESIGN.md on the root of the project directory using Markdown format.

The image below shows the output of spiral 6, spiral 11, and spiral 17 from left to right.spiral 6 can be ruby spiral.rb 6 or whatever is convenient for your programming language. Use git to version control the code as you work on it.
```sh
Spiral 17
+----------------
|                
| +------------+ 
| |            | 
| | +--------+ | 
| | |        | | 
| | | +----+ | | 
| | | |    | | | 
| | | | ++ | | | 
| | | |  | | | | 
| | | +--+ | | | 
| | |      | | | 
| | +------+ | | 
| |          | | 
| +----------+ | 
|              | 
+--------------+ 
```
### Design
There were a few things to keep in mind when designing this application.
* Future implementations will draw additional shapes
* Future implementation to output as SVG

Keeping these things in mind I decided to implement the application with a 2d char array as the "canvas" that will store the shape. I chose the array because it's essentially a matrix with built in coordinates and in the future can help faciilitate SVG output because SVG's use coordinates/points to draw shapes. In the current implementation we only need to store ascii characters for console output.

After studying the examples supplied with the example I was able to figure out a pattern that facilitates drawing the spiral shape. In the future different shapes will require different draw algorithm but the shapes can still be stored in the array.

The pattern is that every edge is one character length shorter than the previous edge. Also the drawing of the edges happen in a particular order (top, left, bottom, and right). The algorithm populates the array drawing edges following the predescribed order, decrementing the length at direction changes and continue drawing until side length 0 is reached.

```sh
Using the spiral 17 example
            17   
    +----------------   Top edge 17 chars including corner char
    |       13          Left edge 16 chars including corner char
    | +------------+    Bottom edge 15 chars including corner char
    | |            |    Right edge 14 chars including corner char
    | | +--------+ |    Start at the top edge again and continues until the edge size reaches 0
    | | |        | | 
    | | | +----+ | | 
16  | | | |    | | |   14    
    | | | | ++ | | | 
    | | | |  | | | | 
    | | | +--+ | | | 
    | | |      | | | 
    | | +------+ | | 
    | |          | | 
    | +----------+ | 
    |              | 
    +--------------+ 
            15
```

### Implementation
```sh
Java File
Spiral.java //the spiral class object.
Methods
Spiral(int spiral) //the constructor method.
