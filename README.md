# spellChecker
Used language: Java
Core implementation: Hash map
Create a Spell Checker that takes a String input and checks if the word is correctly pronounced or not. If misspelled, return a list of suggestions for the word. The project was created while Wordle (a game where players have 5 tries to find a 5-letter random English word) became very popular and the project performed quite helpful completing this game. 
The project consists of two main classes: spellChecker class and dictionary class. The dictionary class uses a text file containing all possible English words and abbreviations, then uses the hash method to store every word in a hash map as a code. When a spellChecker object is created, it creates a dictionary and looks for the inputted word inside the hash map.
Return a list of suggestions by 5 criteria: adding 1 letter before/after the inputted words, deleting 1 letter before/after the inputted words, and switching the positions between two adjacent letters. 
Method breakdowns: 
  Add 1 letter to the beginning: Run over the English alphabet and add each character to the beginning of the inputted word and find its new hash code. If the new word is found in the dictionary, add it to the suggestion list.
  Add 1 letter to the end: Run over the English alphabet and add each character to the end of the inputted word, and find its new hash code. If the new word is found in the dictionary, add it to the suggestion list.
  Delete 1 letter at the beginning: Delete 1 character at the beginning of the inputted word and find its new hash code. If the new word is found in the dictionary, add it to the suggestion list.
  Delete 1 letter at the end: Delete 1 character at the end of the inputted word and find its new hash code. If the new word is found in the dictionary, add it to the suggestion list.
  Switch position of 2 adjacent letters: Turn the String into an array of char, switch the position of 2 adjacent letters and find its new hash code. If the new word is found in the dictionary, add it to the suggestion list.
