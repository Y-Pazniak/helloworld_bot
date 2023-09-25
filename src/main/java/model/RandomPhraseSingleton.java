package model;

public class RandomPhraseSingleton {
    public static class RandomPhraseSingletonHolder {
        private static final RandomPhraseSingleton RandomPhraseSingleton = new RandomPhraseSingleton();
    }

    private RandomPhraseSingleton() {
    }

    public String getPhrase() {
        return Storage.values()[getRandomNumber()].getPhrase();
    }

    public static RandomPhraseSingleton getInstance() {
        return RandomPhraseSingletonHolder.RandomPhraseSingleton;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * Storage.values().length);
    }
}
