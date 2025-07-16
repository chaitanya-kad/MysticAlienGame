public class LogicalAlien extends AlienNPC {
    public LogicalAlien(String name) {
        super(name);
    }

    @Override
    public String respondToPlayer(String input) {
        if (input.contains("trade") || input.contains("benefit")) {
            trustLevel += 10;
           return name +": Approval sounds logical.[Trust: " + trustLevel + "]";
        } else {
            trustLevel -= 5;
            return name +": Vague intentions reduce trust.[Trust: " + trustLevel + "]";
        }
    }
}
