package model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class RandomPhraseSingleton {
    public static class RandomPhraseSingletonHolder {
        public static final RandomPhraseSingletonHolder SINGLETON_HOLDER = new RandomPhraseSingletonHolder();

        public static String getPhrase() {
            return supportPhrasesArray[getRandomNumber()].getPhrase();
        }
    }

    private static final Set<SupportPhrases> phrasesSet = EnumSet.allOf(SupportPhrases.class);
    private static final SupportPhrases[] supportPhrasesArray = phrasesSet.toArray(new SupportPhrases[0]);

    private RandomPhraseSingleton() {
    }

    public static RandomPhraseSingletonHolder getInstance() {
        return RandomPhraseSingletonHolder.SINGLETON_HOLDER;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * RandomPhraseSingleton.phrasesSet.size());
    }
}
