public class CommandWords {
    private static final String[] validCommands = {
        "login", "create", "deposit", "withdraw", "look", "help"
    };

    public CommandWords() {}

    public boolean isCommand(String input) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(input)) {
                return true;
            }
        }
        //If we get here, string was not found in commands
        return false;
    }

}