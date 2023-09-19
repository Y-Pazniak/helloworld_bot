package model;

import java.util.EnumSet;
import java.util.Set;

public class RandomPhraseSingleton {
    public static class RandomPhraseSingletonHolder {
        public static final RandomPhraseSingletonHolder SINGLETON_HOLDER = new RandomPhraseSingletonHolder();

        public static String getPhrase() {
            return supportPhrasesArray[getRandomNumber()].getPhrase();
        }
    }

    private static final Set<Storage> phrasesSet = EnumSet.allOf(Storage.class);
    private static final Storage[] supportPhrasesArray = phrasesSet.toArray(new Storage[0]);

    private RandomPhraseSingleton() {
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * RandomPhraseSingleton.phrasesSet.size());
    }
}
