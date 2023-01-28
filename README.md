### Grid Traversal Game!

This game is deployed at:
http://3.141.163.188/GridTraversal/game.html

You can play using your arrow keys. It will not work on phones or tablets.

This game was created as an interview exercise. The problem as stated: 

In a 100 by 100 2-D grid world, you are given a starting point A on one side of the grid, and an
ending point B on the other side of the grid. Your objective is to get from point A to point B.
Each grid space can be in a state of [“Blank”, “Speeder”, “Lava”, “Mud”]. You start out with 100
points of health and 150 moves. Below is a mapping of how much your health and moves are
affected by landing on a grid space.
[
“Blank”: {“Health”: 0, “Moves”: -1},
“Speeder”: {“Health”: -5, “Moves”: 0},
“Lava”: {“Health”: -50, “Moves”: -10},
“Mud”: {“Health”: -10, “Moves”: -5},
]

Build a React application that allows a player to use the arrow keys to play this game.


### Methodology
The grid is a randomly generated 2D array consisting of ints between 1 and 7. Iterating through the grid and using DOM manipulation, I was able to print table cells for each grid tile. A value of 1 was printed as lava, 2 as mud, 3 as speeder, and 4-7 as blank tiles. 

I assigned each table cell an id based on it's X and Y positions so that I could access them again in other functions, namely the function that processes player movements. I also assigned them their corresponding types to process their effect on the player's health and moves when stepped on. 

An event listener enabled me to process inputs and call the movePlayer function. After checking inputs to make sure the player isn't trying to move off the map, I look up their desired position based on the direction they input and their current position using the cell ID's I assigned earlier. I then assign the new position the ID of "player" and change the image displayed there, as well as finally processing the changes to their health and moves. 

The player's health and moves are displayed at the top of the screen at all times below the Map Key. As the grid doesn't fit on the screen without scrolling, they are also printed to the console to prevent the need to scroll to the top of the page while playing. 

If the players health or moves reaches 0, the game no longer accepts input and displays a "Game Over!" message. If the player reaches the goal tile, the game again stops accepting input and displays a "You win!" message. 

I took some creative freedoms by making the grid only 50x50 and having blank tiles be more prevalent than the other types. I tested 100x100 with equal changes for all tile types, and it was very often unsolvable. I think the changes make for a better player experience while remaining in the spirit of the exercise. # GridTraversal
