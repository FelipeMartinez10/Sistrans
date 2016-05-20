package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StackOverFlow {

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }       
        return sets;
    }

    public static int sumSet(Set<Integer> set){
        int sum =0;
        for (Integer s : set) {
            sum += s;
        }
        return sum;     
    }

    public static void main(String[] args) {
         Set<Integer> mySet = new HashSet<Integer>();
         mySet.add(1);
         mySet.add(-9);
         mySet.add(3);
         mySet.add(18);
         mySet.add(23);
         mySet.add(193);
         mySet.add(-13);
         mySet.add(-1);
         mySet.add(9);
         mySet.add(-3);
         mySet.add(-18);
         mySet.add(-23);
         mySet.add(-193);
         mySet.add(123);
         mySet.add(359);
         mySet.add(-323);
         mySet.add(-1824);
         mySet.add(-2673);
         mySet.add(-1953);
         mySet.add(13384);
         mySet.add(1);
         mySet.add(-9);
         mySet.add(3);
         mySet.add(18);
         mySet.add(23);
         mySet.add(193);
         mySet.add(-13);
         mySet.add(-1);
         mySet.add(9);
         mySet.add(-3);
         mySet.add(-18);
         mySet.add(-23);
         mySet.add(-193);
         mySet.add(123);
         mySet.add(359);
         mySet.add(-323);
         mySet.add(-1824);
         mySet.add(-2673);
         mySet.add(-1953);
         mySet.add(13384);
         mySet.add(124);
         mySet.add(-39);
         mySet.add(332);
         mySet.add(148);
         mySet.add(243);
         mySet.add(1393);
         mySet.add(-134);
         mySet.add(-124);
         mySet.add(9);
         mySet.add(-33);
         mySet.add(-18);
         mySet.add(-243);
         mySet.add(-1923);
         mySet.add(1223);
         mySet.add(-3549);
         mySet.add(-323);
         mySet.add(-18424);
         mySet.add(-26733);
         mySet.add(-31953);
         mySet.add(184);

         
         int mySum = 51;
         for (Set<Integer> s : powerSet(mySet)) {
             if(mySum == sumSet(s))
                 System.out.println(s + " = " + sumSet(s));
         }
    }
}