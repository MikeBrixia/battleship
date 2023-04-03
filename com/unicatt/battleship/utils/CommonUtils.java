package com.unicatt.battleship.utils;

public class CommonUtils
{
    // String representation of the internation alphabet.
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Get all alphabet letters as a unique string.
    public static String getAlphabetString()
    {
        return ALPHABET;
    }

    // Get all alphabet letters as an array of text characters.
    public static char[] getAlphabet()
    {
        return ALPHABET.toCharArray();
    }

    // Get a character a letter of the internation alphabet by it's index.
    public static char getAlphabetCharByIndex(int index)
    {
        char[] alphabetCharacters = getAlphabet();
        return alphabetCharacters[index];
    }

    // Find the index in the alphabet of the given letter.
    public static int getIndexOfAlphabetChar(char character)
    {
        return ALPHABET.indexOf(character);
    }
}
