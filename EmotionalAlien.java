public class EmotionalAlien extends AlienNPC {
    public EmotionalAlien(String name) {
        super(name);
    }

    @Override
    public String respondToPlayer(String input) {
        String inputLower = input.toLowerCase();

if ((inputLower.contains("peace") || inputLower.contains("feelings"))
    && !inputLower.contains("destroy") && !inputLower.contains("kill") && !inputLower.contains("invade")) {

    trustLevel += 15;
    return name + ": Your empathy touches me. [Trust: " + trustLevel + "]";

} else if (inputLower.contains("destroy") || inputLower.contains("kill") || inputLower.contains("invade")) {
    trustLevel -= 20;
    return name + ": Your violent desires disturb me. [Trust: " + trustLevel + "]";
} else {
    trustLevel -= 10;
    return name + ": I sense cold logic. I dislike it. [Trust: " + trustLevel + "]";
}

    }
}
