# showcase

## Background
The task concerns seeking for the solution of how best to approach 
the issue of toggling `PLC`s from `RUN` or `PROGRAM` modes respectively.

### The first approach - the mechanical but robust
The simplest way to solve this issue is to simulate the whole process of `employees` following the procedure of
the line initialisation; that concerns two for loops representing each `employee` and each `PLC` with conditioned 
conducting of the planned steps.  
As it is the most reliable solution, it has been used as basic implementation to test other solutions.  
This implementation is presented in `TestAssemblyLine` class.

### The second approach - the optimised one
Focused on finding faster route, based on using divisor finding algorithm.  
This implementation is presented in `FirstAssemblyLine` class.

### The third approach - the optimal one
The optimal approach further reduces the number of iterations required.  
This implementation is presented in `SecondAssemblyLine` class.
