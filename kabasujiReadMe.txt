Kabasuji Readme -- Team Imbrius

Builder milestones:
	-Launch the MainBuilder.java in the app package, this will launch the builder
	-at the top you will see a scollpane that contains all of the current levels on disk that may be edited
	-to add a new level click one of the three large buttons half way down the window (puzzle in this case)
	-to make the board simply click on a square on the board to turn it into a board tile (white = playable space, grey = not playable space)
	-to set the number of moves either type into the "moves" area in the builder, or you can incrememnt it up to 10 using the small incrememnt button on the spinner
	-the bullpen is the scollable area to the upper right, to add a piece to the bullpen for use simply incrememnt it up, or type the number you want into the space next to the piece
	-to place the piece onto the board in the builder follow these steps:
		1:click the "place piece" button directly above the board
		2:click the piece you want to place on the board in the bullpen
		3:the piece is now in the "selected piece area", so you may flip it or rotate it freely
		4:when you want to place the piece simply move your mouse onto the board
		5:if the piece is red it cannot be placed at that location, if green it may be placed
		6:once it is at a valid location cimply click the mouse and the piece will be placed.
	-once satisfied with piece placement you can click the "save" button in the lower right corner of the window
	-once you have closed the builder and re launched it, to get to the level you just created scroll all the way to the right on the upper scroll bar, it should be level 16
	-to edit that level simply click the button with the picture and level label
	-for the lightning level follow the same process as you did for the puzzle, except now instead of setting the moves set the time in the same way you did moves.


Player milestones:
	-launch the MainGame.java in the app package, this will launch the game
	-click the button labled "Level 1", that will launch level one for play.
	!-Quick discrepency, our level here is different from the one in the milestone, but it is perfectly fine and will show all the functionality-!
	!-The yellow tiles are hint tiles, feel free to take advantage of them by placing the relevant piece on top of them-!
	-to place a piece on the board click the piece you would like to place in the bullpen
	-the piece will now apear in the selected piece area, you are free to use the flip and rotate buttons for the piece
	-once you are satisfied with the rotation/flipping on the piece move your mouse to the board
	-same exact functionality as the builder now, green = can be placed, red = cannot be placed
	-continue this until you have earned three stars, once three stars are earned the game will automatically end and you will see the end game screen, click the return to leve lselect button and you will go back to the level select screen
	-lightning level is exactly the same as the puzzle except you have to be quick, if a tile is claimed in lightning it will turn blue, as is specified in the rules of the game pieces may still be placed on top of these places, so feel free to place on top of them all you want.
	-for new piece replacement keep an eye on the numbers as well, since a piece may be incrememnted to keep a constant number in the bullpen, so you will either see a brand new piece, or an additional piece you already had.