# Basic-Word-Processor
Created a basic word processor using Java that can meet and fulfil various requirements. This was a part of a piece of coursework I completed based around object orientated design. 

Instructions for the baisc word processor:
-Run the Main class to start the word processor. 
-In the file menu you will be able to open or save a .txt file or exit the word processor. 
-The template button will direct you to a menu where there are two template options that can be inserted into the textbox. 
-The undo button will undo the last action in the textbox. 
-The redo button will do the opposite of the last undo action.
-Bold, italics and underline will change the appearance of the text based on the one selected. 
-The size spinner alters the size of the text. 
-The font of the text can be altered by using the dropdown box.
-The colour button will change the colour of the text to one of your chosing. 
-The character index should automatically update as you add or
delete text.

IMPORTANT: 
-Please only exit the word processor using the exit button in the File menu, otherwise it will not check for unsaved changes. 
-Note that copy isn\'t fully functional. When a new item is copied, the clipboard isn't cleared so when paste is used all of the copy history is pasted into the textbox. 
-When you save a file it will be saved as a .txt file. 
-When opening a file the file directory will automatically look for .txt files. 
-With the undo and redo buttons, it only tracks text that is being entered or removed from the textbox. It does not undo or redo any style modifications to the text such as making the text bold or italic. 
-The text can\'t be bold and italic at the same time it will switch between the two if attempted. 
-If the text is either bold or italic and you wish to reset it to plain please use the plain button to do so. 
-Any changes to style the text(e.g. size, bold, underline etc) is made to the entirety of the text and not justg selected or highlighted text. 
-when opening a text file it style the text to the current setings of the text no matter the style of the text when it was saved. (e.g. if the text was green when it saved and when opening the file the colour setting is set to black the text that is being opened will appear as black). 
-Note that the character index is the number of characters present in the textbox, not a word count. It includes spaces and punctuation.
