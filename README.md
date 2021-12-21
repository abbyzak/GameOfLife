I had earlier shared only the links to README.md file of my Github repository of my implementation You likely would have already figured out the SOLID principles. Since, I have recently designed John Conway's Game of Life in Java and applied the SOLID design principles with the objective of sharing my understanding of the principles  I am sharing my approach to solving this problem as an answer to the questions, which are so far unanswered. I hope this is helpful to all who arrive here wanting to wrap their heads around SOLID principles specifically by practicing it on Conway's Game of Life problem.

Below was my thought progression on what classes need to be there:

Step 1: I started out with obvious classes from the problem statement, which are the Board and Cell, the board being composed of many cells.

Step 2: On applying Single Responsibility Principle, a class should have a single responsibility and only one reason to change, to the Board and the Cell I broke these two classes down into these classes:

Board (for maintaining board dimensions and active cell locations, and the getNeighbourCount() method)
BoardRenderer (for drawing the board on the medium)
BoardPersister (for persisting, i.e. saving the board layout out of memory to a persistent storage like MySQL between steps)
BoardInitializer (for initial arrangement of live cells on the board at the start of game)
For cells I needed only CellRenderer, because at this point I began realizing my Cell class had no other work to do but to be rendered (active cell one way, inactive cell another way). It is the board which will have the knowledge of its dimensions and the location of active cells (and therefore also the location of inactive cells). I do not require the Cell class.
Step 3: Next from my understanding of what Open/Close and Dependency Inversion principles are, which respectively state, software entities should be open for extension but closed for modification and one should depend upon abstractions and not upon concretions (source Wikipedia), I converted BoardInitializer, BoardRenderer, BoardPersister, CellRenderer from classes to interfaces so that I can build new classes and use them by simply replacing existing classes. These new classes only need to implement their respective interfaces.

At this stage I realized and I also needed a game controller. So I added a GameController abstract class with newGame() and advanceGame() methods and a GameRenderer interface to primarily render the game controls. I also converted Board into an abstract class to be able to have two types of boards: EdgesWrappedBoard and BoundedBoard. GameRenderer would call BoardRenderer, which in turn would make use of CellRenderer for painting active and inactive cells.

So, now we have these classes,

Abstract Classes:
Board
GameController
Classes extending abstract classes:
EdgesWrappedBoard (extends Board)
BoundedBoard (extends Board)
ConsoleGameController (extends GameController)
Interfaces:
GameRenderer
BoardRenderer
CellRenderer
BoardInitializer
BoardPersister
Classes implementing interfaces:
ConsoleGameRenderer (implements GameRenderer)
ConsoleBoardRenderer (implements BoardRenderer)
ConsoleCellRenderer (implements CellRenderer)
RandomBoardInitializer (implements BoardInitializer)
Test1BoardInitializer (implements BoardInitializer)
Test2BoardInitializer (implements BoardInitializer)
FileBoardPersister (implements BoardPersister)
Step 4: Finally, I checked for any violation of Liskov's Subsitution Principle or Interface Segregation Principle. There were none. These principles respectively are: Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program. Many client-specific interfaces are better than one general-purpose interface.

Note: From the very beginning, to bring out Dependency Inversion and Open/Close principles I set out to have both Web (HTML) and Console interfaces, and be able to persist to both file or database.

If you are interested in seeing my thought progression as class diagrams, you can refer to the README.md file of my implementation of Game of Life shared on GitHub. There would be other solutions as well. My objective was to best communicate my understanding of SOLID principles.
