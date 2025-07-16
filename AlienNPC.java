public abstract class AlienNPC {
    protected String name;
    protected int trustLevel;

    public AlienNPC(String name) {
        this.name = name;
        this.trustLevel = 50;
    }

    public abstract String respondToPlayer(String input);

    public String getName() {
        return name;
    }

    public int getTrustLevel() {
        return trustLevel;
    }
}
