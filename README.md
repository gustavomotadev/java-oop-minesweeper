# java-oop-minesweeper
This is an old project of mine from 2018, it is an implementation of the famous game called Minesweeper in Java with Object Oriented Programming, I made it as part of a university course on OOP. It was originally named CampoMinadoPOO, this is Portuguese for "MineSweeperOOP", it was an Eclipse IDE Project. The library I used for graphics is not that well suited for game development as it is more focused on user interface development I believe, so I had to make do with some improvisation and magic constants, it's certainly not the best code out there.

# Game Description

This a fairly straightforward implementation of MineSweeper, it's a grid in which some cells are bombs and some are not, clicking on a cell with LMB will reveal its contents, in case it is a bomb you lose, in case it is not it reveals more of the map. Clicking a cell with RMB will mark it with a flag, signaling that you believe a bomb is there, but this action will reveal no information about the actual content of said cell. Empty cells have a colored number in them that tells the player how many bombs are in the 3x3 square of 9 cells centered on it (zero is not displayed though). There is a counter of remaining flags that starts showing the number of bombs present and decrements as you use flags, but you're free to remove flags at will, a second counter records the time you needed to complete the map or loose. The user is able to choose the size of the map and amount of bombs, therefore any difficulty desired is possible.

# Screenshots

## Defeat

![Screenshot of MineSweeper game showing defeat example](https://github.com/gustavomotadev/java-oop-minesweeper/blob/main/readme_images/defeat.png?raw=true)

## Victory

![Screenshot of MineSweeper game showing victory example](https://github.com/gustavomotadev/java-oop-minesweeper/blob/main/readme_images/victory.png?raw=true)
