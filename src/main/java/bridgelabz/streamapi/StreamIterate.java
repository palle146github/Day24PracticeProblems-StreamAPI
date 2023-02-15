package bridgelabz.streamapi;


import java.util.function.*;
import java.util.*;
import java.util.stream.*;
public class StreamIterate {
    public static void main(String[] args) {
        List<Integer> listStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Use case - I : Iterate Stream");
        Stream<Integer> integers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        integers.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
        System.out.println("Use Case - II : Print double of numbers");
        Function<Integer, Double> doubleFunction = Integer::doubleValue;
        listStream.stream().forEach(n -> System.out.print(doubleFunction.apply(n) + " "));
        System.out.println("\n");
        System.out.println("Use Case - III : Store the double values into a list");
        List<Double> doubles = listStream.stream().map(n -> doubleFunction.apply(n)).collect(Collectors.toList());
        System.out.println(doubles);
        System.out.println("\n");
        System.out.println("Use Case - IV : Store the even numbers into list");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> even = listStream.stream().filter(isEven).collect(Collectors.toList());
        System.out.print(even);
        System.out.println("");
        listStream.stream().forEach(n -> {
            System.out.println(n + " : Even number : " + isEven.test(n));
        });
        System.out.println("\n");
        System.out.println("Use Case - V : First even number in the list");
        System.out.println(listStream.stream().filter(isEven).findFirst());
        System.out.println("\n");
        System.out.println("Use Case - VI : Min and Max in the list");
        Integer maxNumber = listStream.stream().filter(n -> n % 2 == 0).max(Comparator.comparing(Integer::valueOf)).get();
        Integer minNumber = listStream.stream().filter(n -> n % 2 == 0).min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(maxNumber + ":" + minNumber);
        System.out.println("\n");
        System.out.println("Use Case - VII : Sum and Average");
        int sum = listStream.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble average = listStream.stream().mapToInt(Integer::intValue).average();
        System.out.println("Sum is : " + sum + " Average is : " + average);
        System.out.println("\n");
        System.out.println("Use Case - VIII : True least one even number");
        System.out.println(listStream.stream().allMatch(isEven));
        System.out.println(listStream.stream().anyMatch(isEven));
        System.out.println("\n");
        System.out.println("Use Case - IX : Sort Ascending order");
        List<Integer> list = List.of(3,1,6,3,8,6,7,9,3,5,5);
        list.stream().sorted();
        System.out.println(listStream);
    }
}

