package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return x -> {
            for (String word : x) {
                if (word.isEmpty() || Character.isLowerCase(word.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            for (Integer number : x) {
                if (number%2 == 0) {
                    x.add(number);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> {
            for (int i = 0; i < values.size(); i++) {
                if (Character.isLowerCase(values.get(i).charAt(0)) || values.get(i).charAt(values.get(i).length()-1) == '.' ||
                values.get(i).split(" ").length <= 3) {
                    values.remove(values.get(i));
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String y : x) {
                result.put(y, y.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {

        return (list1, list2) -> {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };
    }
}
