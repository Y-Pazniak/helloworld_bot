package model;

public enum SupportPhrases {
    LOOK_GOOD("отлично выглядишь"),
    JUST_DRINK("дорогая, выпей вина"),
    EVERYBODY_JERKS("все козлы, а ты хорошенькая"),
    LIKE_YOU("ты мне нравишься"),
    YOU_FIRE("ТЫ АГОНЬ");

    private final String phrase;

    SupportPhrases(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
