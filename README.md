# Kabasuji
Software engineering game about Hexominoes

## Group Resources
 <b>Any useful tips+tricks can be shared here guys :) So share anything you learn and feel would be useful for someone else!</b>

### GitHub Related
* <b>How do I use Markdown in this thing?!</b>
   * Here's an awesome [cheat sheet](https://guides.github.com/features/mastering-markdown/)!
* <b>How can I get git?</b>
   * [Download](https://git-scm.com/downloads) here
   * It comes with something called GitBash, which is the command prompt you'll want to be executing your git commands from (unless you're fancy and you setup your favorite flavor of prompt to have access to these commands). An important note: GitBash is bash, not the default windows terminal. So anything you've learned about the command prompt in Linux is applicable to GitBash!
* <b>Guys, I forgot how to use Git</b>
   * Here's a [tutorial](https://try.github.io/levels/1/challenges/1) on the command line version of git.
   * Here's a [GUI](https://desktop.github.com/) front end for git, reducing the need for the commandline. Dead simple to follow.
* <b>What's the structure for eclipse?</b>
   * Src folder with two packages in there: gameMockups, builderMockups
   * Put your files in there accordingly
   * Put the resource folder into the root folder of your project (not inside the src folder!) and link in eclipse as a source folder
* <b>Rules and Regulations for Happiness</b>
   * DON'T merge your branch INTO master branch!
   * DO merge master branch INTO your branch. (RECOGNIZE THE DIFFERENCE)
   * When you want to merge your branch into master, go into your branch and create a new pull request (can be done on github.com or from the gui in the upper right).
   * DON'T approve your own merge, someone else MUST review it.

### WindowBuilder Related
* <b>I opened Eclipse and it's not showing the WindowBuilder Designer!</b>
   * Right-click the source file and hit: Open with -> WindowBuilder Editor
* <b>Why isn't my Hexominoe appearing?!</b>
   * Make sure you have put it in the SRC folder (LIKE IT BEST BE THERE)
   * It should be a .png
   * The file should be 35x35, with the Hexominoe centered
   * Scale the image to be 30x30, leaving a small border around it on the button


## A Few Todos
* <b>Serialization</b>
   * Make everything serializeable
   * Mark unwanted fields transient inside each entity
   * Write the saveLevel and loadLevel functionality in the Builder and Game classes
* <b>BuilderView</b>
   * Correct the ReleaseTileCreationView to show the spinner (Something wonky is up)
   * Push that change to master so others can grab it
