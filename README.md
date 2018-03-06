# Fractals Simulation

This is a basic program where you can see step-by-step the implemented fractals behaviour.

Until now, there are only these fractals:
* Sierpinski triangle. [link to Wikipedia!](https://en.wikipedia.org/wiki/Sierpinski_triangle)

### How to use
It's used by running the program and writing on the console to see the next step or the last one.
To see the next step, type **next** and press enter.
To see the last step, type **last** and press enter.

If nothing is written and enter is pressed, the program will end.

### How to implement new Fractals
To implement new fractals, create a `class` on the `package` *br.com.alexfogjava.fractalsdraw.models*.
Your `class` needs to extend the `PaintableFractal.class`.

There's a `package` *br.com.alexfogjava.fractaldraw.models.shapes*, which contains helpful implementations of shapes.
Every shape in this `package` is implemented with Points and arrays.
