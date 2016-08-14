Game Of Life

Just an attempt at Game of Life. I've tried to develop it using TDD way. 

The problem statement is as below. 

 
The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

Any live cell with fewer than two live neighbours dies, as if by loneliness.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any live cell with two or three live neighbours lives, unchanged, to the next generation.
Any dead cell with exactly three live neighbours comes to life.


The initial pattern constitutes the 'seed' of the system. The first generation is created by applying the above rules Simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick. (In other words, each generation is a pure function of the one before.) The rules continue to be applied repeatedly to create further generations.
 
Problem.
The inputs below represent the cells in the universe as X or - . X is a alive cell. - is a dead cell or no cell. The below inputs provide the provide pattern or initial cells in the universe. The output is the state of the system in the next tick (one run of the application of all the rules), represented in the same format.
 
-------------------------------------------------------------------------------------------
Input A:
(Block pattern)
	<br/>
	X X
	<br/>
	X X
	<br/>
Output A:
	<br/>
	X X
	<br/>
	X X
	<br/>
 
-------------------------------------------------------------------------------------------
Input B
(Boat pattern)
	<br/>
	X X -
	<br/>
	X - X
	<br/>
	- X -
	<br/> 

Output B
	<br/>
	X X -
	<br/>
	X - X
	<br/>
	- X -
 	<br/>
-------------------------------------------------------------------------------------------
Input C
(Blinker pattern)
	<br/>
	- X -
	<br/>
	- X -
	<br/>
	- X -
	<br/>

Output C
	<br/>
	- - -
	<br/>
	X X X
	<br/>
	- - -
	<br/>
	
-------------------------------------------------------------------------------------------
Input D
(Toad pattern)
	<br/>
	- X X X
	<br/>
	X X X -
	<br/>
Output D
	<br/>
	- - X -
	<br/>
	X - - X
	<br/>
	X - - X
	<br/>
	- X - -
	<br/>
