--Kabasuji -- 
Team Imbrius
Abby Harrison
Brendan O'Connor
Dylan Fontana
Evan Bosia
Hans Johnson

Introduction:
Hello, this is the ReadMe file for team Imbrius's final submission for Software Engineering. It will include instructions on how certain functionality works,
and point out some interesting features.

THE GAME:
We recommend that you begin by playing the game, we will go over the builder later on and it will become clear why we suggest you use the builder second.

In order to launch the game you must launch MainGame.java in the app folder inside source. This will launch the game, and you will be greeted by the splash screen.
By default only level one will be unlocked, underneath the button saying level one you can see there are three blank stars, those will update when you earn stars
inside the level and the same will happen for each level individually, once one or more stars are earned on a level the next level in order will be unlocked for play.

Once a level is launched by clicking the button for that level you will see the level screen come up, while there are three different types of levels, all three use 
the same mechanics with only a few minor changes.

In order to place a piece inside of a level you must first click the piece you would like to place inside the bullpen, each piece available for your use will have a
picture of the piece and a count of how many are available to be used for that level. Once you click on the image of the piece in the bullpen it will appear in the
selected piece preview area. 

Using the buttons to the right you may rotate the piece of flip the piece. Once you have the piece in your desired orientation you may move the mouse down onto
the board. To place a piece simply click on the board where you want the piece to go. If before clicking the piece is green that is a valid location to place the
piece, if the piece is red then it is an invalid location to place the piece, and clicking will do nothing.

If you are not satisfied with the orientation of the piece before you place it you are free to go back to the rotate buttons before placing the piece. Each of the 3 
game modes have separate small rules that differentiate them from each other:



PUZZLE:
This mode is all about filling up the entire board with the pieces given, but watch out, you only have a certain number of moves to complete your task!
Stars:
1: Have between 12 and 7 tiles remaining to be filled
2: Have between 6 and 1 tiles remaining to be filled
3: Have 0 tiles remaining to be filled

Additional information about Puzzle mode:
Puzzle mode allows the user to move pieces already placed on the board to another position on the board, or remove it from the board. Moving a piece from one position
on the board to another is done by clicking and holding on a placed piece and then releasing the mouse button when it is at the desired position. In order to remove
a piece from the board simply click and hold on a piece and move the mouse off of the board, the piece will be removed
from play and added back into the bullpen.

As stated earlier a puzzle level must be completed within a certain number of moves set when the level is created. The following actions will cost a move:
1: Moving a piece from the bullpen to the board
2: Moving a piece from a position on the board to another position on the board
3: Moving a piece off of the board



LIGHTNING:
This mode is all about filling up the entire board within the time limit, pieces may overlap and using a piece will replace it with a new random piece in the bullpen!
Stars:
1: Have between 12 and 7 tiles remaining to be filled
2: Have between 6 and 1 tiles remaining to be filled
3: Have 0 tiles remaining to be filled

The only separating factor about this game mode is that pieces may be placed on top of each other in order to achieve victory, when a piece is placed the location
it was placed at becomes blue, pieces may be placed over these blue regions, but nothing will happen to tiles already marked blue.



RELEASE:
This mode is all about releasing full sets of numbers, but be careful once you place a piece it cannot be moved!
Stars:
1: Release one full set of numbers
2: Release two full sets of numbers
3: Release three full sets of numbers
(A full set of numbers is 1-6 of a certain color, getting two red 1's is the same as getting one red 1 in terms of stars)

Pieces may not be moved once they are placed like in puzzle, and cannot be stacked on top of eachother like in lightning.



THE BUILDER:

PLEASE READ CAREFULLY:
If you would like to easily play any levels you create on the game side of the application, you should follow the following steps: In a folder named "LevelSolutions" 
you will find a file named: "StarMap.storage" this is the file type we use for saving level progress. We suggest that in order to play your new levels 
you move the StarMap.storage in the "LevelSolutions" folder to the folder "imbriusLevelFiles" and replace the "StarMap.storage" before launching the builder.
(This unlocks the default 15 levels, so the 16th level created will be available immediately. You can of course test your board in the 
builder, just not in the game side. If you deleted a default level, the level you make will replace that number).

To launch the builder run "MainBuilder.jave in the app folder in src.

Once the builder is launched you will see a scrollable area that contains all levels for the game, clicking on the level will allow you to edit that level, clicking delete will delete it from the game.

In order to make a new level click the button in the middle of the screen corresponding to the level type you would like to make. 

MAKING A LEVEL:
The easiest way to begin making a board is to simply click a tile on the board with the mouse. This action will turn an empty tile into a board tile, or a board tile into an empty tile. 

The second way you can create a level is to create it using pieces. To do this follow these steps:
1: Click the button "Place Pieces" directly above the board.
2: Click the button "Make Board With Pieces" button directly above the board
3: Increment the piece you would like to place in the bullpen and then click the piece in the bullpen.
4: Rotate and flip the piece to your desired orientation.
5: Move your mouse to the position you would like the board to take shape. (green = valid placement option, red = invalid placement option)
6: Click to place the piece down as board tiles in order to create the board.

IN ORDER TO GO BACK TO PLACING TILES NORMALLY YOU MUST CLICK THE "PLACE PIECES" BUTTON AGAIN TO TOGGLE IT OFF SO YOU MAY CLICK TO PLACE SINGLE TILES AGAIN


PLACING A HINT:
1: Click the button "Place Pieces" directly above the board.
2: Click the button "Place Hints" directly above the board.
3: Increment the piece you would like to place in the bullpen and then click the piece in the bullpen.
4: Rotate and flip the piece to your desired orientation.
5: Move your mouse to the position you would like the hint to go. (green = valid placement option, red = invalid placement option)
6: Click to place the hint onto the board.
The hint now shows up yellow on the board.


REMOVING A HINT:
1: Make sure "Place Pieces" is disabled.
2: Click any tile that the hint is on and the entire hint will disapear.



Once you have a board you would like to test out you may do so by clicking the "Place Pieces" button.
Once the button is pressed you simply have to click on the piece you would like to place in the bullpen
	(Make sure the piece you are trying to place has more than a value of 0 in the bullpen, if it has a value of 0 simply increment the piece in order to place it)
You may then flip and rotate the piece and then place it like you do in the main game, as well as pick it up and move it as you can in the puzzle mode, and even drag
it off the board to remove it and add it back into the bullpen.

If you have placed pieces and do not want to have to remove them all by hand simply click the "Remove Pieces" button in the bottom right and it will remove all
pieces currently placed on the board.

In the botoom right of the builder are also the undo and redo buttons.


SAVING THE LEVEL:
In order to save a level you are making you must click the "save" button on the bottom right of the screen.
THE FOLLOWING ELEMENTS ARE SAVED:
1: The board, so empty tiles, board tiles, release tiles. 
(ALL PIECES ARE REMOVED FROM THE BOARD WHEN THE SAVE BUTTON IS PRESSED AND THOSE PIECES ARE ADDED TO THE BULLPEN) 
2: Pieces in the bullpen. The pieces inside the bullpen when the level is saved and pieces removed will be the pieces available to the player at the start of the level.
   (So it is NOT required to solve a level before saving, if you are confident the level can be solved with the pieces you incremented in the
   bullpen, then those are the only ones saved).
3: Specific level conditions. (Move count, time limit)


BUILDING A PUZZLE LEVEL:
You can set the number of moves on the right hand side by either typing in the desired number of moves, or incrementing/decrementing to your desired number of moves.
Any pieces in the bullpen will be the pieces available to the person playing the game.


BUILDING A LIGHTNING LEVEL:
You can set the time that the player has to complete the level on the right hand side (this is in seconds).
Any pieces in the bullpen will be the pieces initially available to the player, once a player uses a piece though it will be replaced by any random piece in the bullpen


BUILDING A RELEASE LEVEL:
How to set up release tiles:
1: Make sure the "Place Piece" button is toggled off so you can individually edit tiles.
2: From the drop down menu on the right hand side choose a color you would like to place.
3: Click the number you would like to place, this toggles that number on.
4: While the number button is toggled any click on a white board tile will make that board tile into a release tile with that number and color on it.
5: To stop placing that number either toggle off the number being placed or toggle another number to be able to place that one instead.

To remove a release tile, simply click it (with no toggle buttons selected).