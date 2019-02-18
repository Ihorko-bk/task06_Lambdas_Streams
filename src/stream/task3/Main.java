package stream.task3;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5};
        System.out.println(getSummaryStatistics(array));
        System.out.println(numbersThatBiggerThanAverage(array));


    }

    static List<Integer> getRandomIntegerList(int length) {
        Random random = new Random();
        return Stream.generate(random::nextInt).limit(length).collect(Collectors.toList());
    }
    static int[] getRandomIntArray(int length) {
        Random random = new Random();
        return IntStream.generate(random::nextInt).toArray();
    }

    static int maxFromStream(IntStream stream) {
        return stream.max().getAsInt();
    }
    static int getMax(int[] array) {
        return maxFromStream(Arrays.stream(array));
    }
    static int getMax(List<Integer> list) {
        return maxFromStream(list.stream().mapToInt(Integer::intValue));
    }

    static int minFromStream(IntStream stream) {
        return stream.min().getAsInt();
    }
    static int getMin(int[] array) {
        return minFromStream(Arrays.stream(array));
    }
    static int getMin(List<Integer> list) {
        return minFromStream(list.stream().mapToInt(Integer::intValue));
    }

    static int sumFromStream(IntStream stream) {
        return stream.sum();
    }
    static int getSum(int[] array) {
        return sumFromStream(Arrays.stream(array));
    }
    static int getSum(List<Integer> list) {
        return sumFromStream(list.stream().mapToInt(Integer::intValue));
    }

    static double avgFromStream(IntStream stream) {
        return stream.average().getAsDouble();
    }
    static double getAvg(int[] array) {
        return avgFromStream(Arrays.stream(array));
    }
    static double getAvg(List<Integer> list) {
        return avgFromStream(list.stream().mapToInt(Integer::intValue));
    }

    static IntSummaryStatistics getSummaryStatisticsFromStream(IntStream stream) {
        return stream.summaryStatistics();
    }
    static IntSummaryStatistics getSummaryStatistics(List<Integer> list) {
        return getSummaryStatisticsFromStream(list.stream().mapToInt(Integer::intValue));
    }
    static IntSummaryStatistics getSummaryStatistics(int[] array) {
        return getSummaryStatisticsFromStream(Arrays.stream(array));
    }

    static int numbersThatBiggerThanAverageFromStream(IntStream stream, double avg) {
        Counter counter = new Counter();
        stream.forEach(e -> {
            if (e > avg) counter.inc();
        });
        return counter.getCounter();
    }

    static int numbersThatBiggerThanAverage(int[] array) {
        return numbersThatBiggerThanAverageFromStream(
                Arrays.stream(array),
                getAvg(array)
                );
    }
    static int numbersThatBiggerThanAverage(List<Integer> list) {
        return numbersThatBiggerThanAverageFromStream(
                list.stream().mapToInt(Integer::intValue),
                getAvg(list)
                );
    }
}

class Counter {
    private int i;
    public void inc() {i++;}
    public int getCounter() {return i;}
}
