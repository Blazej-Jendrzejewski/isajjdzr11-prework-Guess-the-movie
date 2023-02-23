
public class Main {

    public static void main(String [] args){
        Game game = new Game();
        String title = game.randomMovieTitle();



        System.out.println("Welcome to the guessing game.");
        System.out.println("You have to guess a title of a movie.");
        System.out.println("You can be wrong 10 times. Please use only letter (A-Z)");
        System.out.println("Let's start!!!");
        System.out.println(" ");

        while(game.isGameOn()){
            System.out.println(" ");
            System.out.println("You have still " + game.leftPoints() + " guesses.");
            System.out.println("You wrong guesses " + (10-game.leftPoints())+": " + game.getWrongLetters());
            System.out.println("You are guessing: " + game.getHiddenMovieTitle());
            game.guessLetter();
        }

        if(game.endGame()){
            System.out.println("You WIN!!!!");
            System.out.println("You have guessed the title: " + title + " correctly.");
            System.out.println("CONGRATULATIONS!!!");
        }
        else {
            System.out.println("You used up all you chances");
            System.out.println("You wrong guesses were: " + game.getWrongLetters());
            System.out.println("The title of the movie was " + title);



        }

    }

}