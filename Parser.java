import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public String getCommand() {
        String inputLine;
        String word1 = null;

        System.out.print("> ");
        inputLine = reader.nextLine();

        // Reading user input
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
        }
        tokenizer.close();

        
        //Check if words are known
        if (commands.isCommand(word1)) {
            return word1;
        } 
        return "ERROR";
    }

}