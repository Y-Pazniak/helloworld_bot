package model;

public enum Storage {
    SAY_HELLO("Прывітанне! Націсніце кнопку і атрымайце вынік"),

    LOOK_GOOD("выдатна выглядаеш"),
    JUST_DRINK("даражэнькая, выпі віна"),
    EVERYBODY_JERKS("усе ёлупні, а ты сонейка"),
    LIKE_YOU("ты мне да спадобы"),
    YOU_FIRE("ТЫ ПРОСТА ПОЛЫМЯ");

    private final String phrase;

    Storage(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
