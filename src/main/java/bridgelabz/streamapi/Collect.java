package bridgelabz.streamapi;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Collect {
    public static void main(String[] args) {
        System.out.println("Collect Examples");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> list = numbers.stream().filter( n -> n % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = numbers.stream().filter( n -> n % 2 != 0).collect(Collectors.toSet());
        Map<Integer,String> map = numbers.parallelStream().filter( n -> n % 2 == 0).collect(Collectors.toMap(Function.identity(),n -> String.valueOf(n)));
        System.out.println("\n");
        System.out.println("Predicate Examples");
    }
}
