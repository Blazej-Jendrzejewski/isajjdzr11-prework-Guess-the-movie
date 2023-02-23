import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String titleToGuess;
    private String wrongLettersGuessed = "";
    private String rightLettersGuessed = "";
    private int leftPoints = 10;

    public int leftPoints(){
        return leftPoints;
    }
    public boolean isGameOn(){
        return leftPoints>0 && (getHiddenMovieTitle().contains("_"));
    }
    public boolean endGame(){
        return !getHiddenMovieTitle().contains("_");

    }



    public String randomMovieTitle () {
        ArrayList<String> movieTitles = new ArrayList<>();


        // reading a txt file and creating an array with every movie title
        try {
            Scanner scannerMoviesList = new Scanner(new File("src/movies.txt"));

            while (scannerMoviesList.hasNextLine()){
                String line = scannerMoviesList.nextLine();
                movieTitles.add(line);
            }

        } catch (FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
        String [] moviesTitlesArray = movieTitles.toArray(movieTitles.toArray(new String[movieTitles.size()]));

        // Random number based on the size of movie titles
        double randomTitleNumber = (Math.random() * movieTitles.size());
        titleToGuess= moviesTitlesArray[(int)randomTitleNumber].toUpperCase();
        return titleToGuess;

    }
// method to cover the title with "_"
    public String getHiddenMovieTitle() {
        if(rightLettersGuessed.equals("")){
            return titleToGuess.replaceAll("[A-Z]", "_");
        }
        else{
            return titleToGuess.replaceAll("[A-Z&&[^" + rightLettersGuessed +"]]", "_");
        }
    }

//method to return wrong guessed letters
    public String getWrongLetters() {
        return wrongLettersGuessed;
    }

//method to get input from the user
    public String inputLetter (){
        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toUpperCase();

        if(!letter.matches("[A-Z]")){
            System.out.println("That is not a letter.");
            return inputLetter();
        }
        else if(wrongLettersGuessed.contains(letter) || rightLettersGuessed.contains(letter)){
            System.out.println("You already guessed that letter.");
            return inputLetter();
        }
        else{
            return letter;
        }
    }

    public void guessLetter() {

        String guessedLetter = inputLetter();

        if (titleToGuess.contains(guessedLetter)) {
            rightLettersGuessed += guessedLetter;
        }
        else {
            leftPoints--;
            wrongLettersGuessed += " " + guessedLetter;
        }
    }

}
