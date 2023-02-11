package jenerics;

import java.util.Collection;
import java.util.Comparator;

public class Main <T>{
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person[] persons = {p1, p2};
        System.out.println(getPersonName(persons));
    }

    private T value;

    public static <Y> String getPersonName(Y ...items) {
        Y item = items[0];
        return ((Person)item).getName();
    }

    public static <Y extends Person> String getPersonBounded(Y ...items) {
        Y item = items[0];
        return item.getName();
    }

    public static <Y extends Person & Payable> String getPersonIntersect(Y ...items) {
        Y item = items[0];
        return item.getName();
    }

//    Мнемоническое правильно PECS
//    Producer extends, Consumer super
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comparator) {
//        Collections.max(List < Integer > list, Comparator < Number >);
//        Collections.max(List < String > list, Comparator < Object >);
        return coll.stream().max(comparator).get();
    }
}