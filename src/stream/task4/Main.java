package stream.task4;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String string = getStringOfEnteredLinesUntilEmptyLine();
        String[] words = getWordsArray(deleteAllTrash(string));
        System.out.println(WordCounter.countWordFrequency(words));
        System.out.println(LetterCounter.countLetterFrequency(words));

    }

    static String getStringOfEnteredLinesUntilEmptyLine() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String string;
        while (true){
            string = scanner.nextLine();
            if (string.equals("")) {
                break;
            } else {
                sb.append(string + " ");
            }
        }
        return sb.toString();
    }
    static String deleteAllTrash(String string) {
//        return string.replaceAll("![A-zА-я']", "")
        return string.replaceAll("[.,!?()]", "")
                .replaceAll("  ", " ")
                .replaceAll("  ", " ")
                .toLowerCase();
    }
    static String[] getWordsArray(String string) {
        String[] returnString = deleteAllTrash(string).split(" ");
        Arrays.sort(returnString);
        return returnString;
    }
    static String[] getUniqueWords(String[] words) {
        return Arrays.stream(words)
                .distinct()
                .toArray(String[]::new);
    }

}
class WordCounter {
    private static Map<String, Integer> wordCounter;

    public WordCounter() {
        wordCounter = new TreeMap<>();
    }

    public Map<String, Integer> getWordCounterMap() {
        return wordCounter;
    }

    public void countThisWord(String word) {
        if (wordCounter.containsKey(word)) {
            wordCounter.put(word, wordCounter.get(word)+1);
        } else wordCounter.put(word, 1);
    }

    public static WordCounter countWordFrequency(String[] words) {
        return countWordFrequency(new WordCounter(), words);
    }
    public static WordCounter countWordFrequency(WordCounter wc, String[] words) {
        Stream<String> stream = Arrays.stream(words);
        stream.forEach(wc::countThisWord);
        return wc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int wordColumnSize = findBiggestWordSize() + 2;
        wordColumnSize = wordColumnSize > 5 ? wordColumnSize : 6;
        String format = "%-" + wordColumnSize + "s%d\n";

        for(Map.Entry me: wordCounter.entrySet()) {
            sb.append(String.format(format, me.getKey(), me.getValue()));
        }
        return sb.toString();
    }
    private int findBiggestWordSize() {
        int size = 0, newSize;
        for (Map.Entry me: wordCounter.entrySet()) {
            newSize = ((String) me.getKey()).length();
            if (newSize>size) size = newSize;
        }
        return size;
    }
}
class LetterCounter {
    private static Map<Character, Integer> letterCounter;

    public LetterCounter() {
        letterCounter = new TreeMap<>();
    }

    public Map<Character, Integer> getLetterCounterMap() {
        return letterCounter;
    }

    public void countThisLetter(char letter) {
        if (letterCounter.containsKey(letter)) {
            letterCounter.put(letter, letterCounter.get(letter)+1);
        } else letterCounter.put(letter, 1);
    }
    public void countLettersFromWord(String word) {
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            countThisLetter(letter);
        }
    }

    public static LetterCounter countLetterFrequency(String...words) {
        return countLetterFrequency(new LetterCounter(), words);
    }
    public static LetterCounter countLetterFrequency(LetterCounter lc, String...words) {
        if (words.length == 1) {
            lc.countLettersFromWord(words[0]);
        }
        Arrays.stream(words)
                .forEach(lc::countLettersFromWord);
        return lc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry me: letterCounter.entrySet()) {
            sb.append(String.format("%c  %d\n", me.getKey(), me.getValue()));
        }
        return sb.toString();
    }
}











