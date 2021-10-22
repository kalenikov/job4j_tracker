package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private Builder builder;

    private EasyStream(Builder builder) {
        this.builder = builder;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(new Builder(source));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        builder.map(fun);
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        builder.filter(fun);
        return this;
    }

    public List<Integer> collect() {
        return builder.collect();
    }

    static class Builder {
        private List<Integer> data;

        public Builder(List<Integer> source) {
            data = new ArrayList<>(source);
        }

        public Builder filter(Predicate<Integer> fun) {
            Iterator<Integer> it = data.iterator();
            while (it.hasNext()) {
                if (!fun.test(it.next())) {
                    it.remove();
                }
            }
            return this;
        }

        public Builder map(Function<Integer, Integer> fun) {
            for (int i = 0; i < data.size(); i++) {
                data.set(i, fun.apply(data.get(i)));
            }
            return this;
        }

        public List<Integer> collect() {
            return data;
        }
    }

    public static void main(String[] args) {
        var data = List.of(1, 2, 3, 4, 5);
        var collect = EasyStream.of(data)
                .filter(n -> n > 2)
                .map(n -> n * 10)
                .collect();
        System.out.println(collect);
    }


}