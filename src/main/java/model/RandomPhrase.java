package model;

import java.util.ArrayList;

public class RandomPhrase {
    private boolean needInit = true;

    public String getPhrase(){
        ArrayList<String> phrases = new ArrayList<>();
        if (needInit) {
            phrases = feelArray();
            needInit = false;
        }
        return phrases.get(getRandomNumber(phrases));
    }

    private int getRandomNumber(ArrayList<String> arrayList) {
        return (int) (Math.random() * arrayList.size());
    }

    private ArrayList<String> feelArray() {
        ArrayList<String> localArrayList = new ArrayList<>();
        localArrayList.add(Strings.EVERYBODY_JERKS);
        localArrayList.add(Strings.JUST_DRINK);
        localArrayList.add(Strings.LOOK_GOOD);
        return localArrayList;
    }
}
