package bootcamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionLambdaApp
{
    public static <T> Collection<T> filter (Collection<T> col,
            Predicate<T> predicate)
    {
        Collection<T> result = new ArrayList<T> ();
//        for (T element : col) {
//            if (predicate.test (element)) {
//                result.add (element);
//            }
//        }
        col.forEach (e -> {
            if(predicate.test (e))
                result.add (e);
        });
        return result;
    }
    
    public static <T> int sum (Collection<T> col, Function<T,Integer> op) {
        int sum = 0;
        //cannot use lambda since it modifies non-final local variable
        //lambda can only modifies instance variable or final or effectively final variable
        for(T t : col)
            sum += op.apply (t);
        return sum;
    }


    public static void main (String[] args)
    {
        // List
        List<String> strList = new ArrayList<String> ();

        // insert List
        strList.add ("apa");
        strList.add ("makam");
        strList.add ("itu");
        strList.add ("ini");

        strList.forEach (s -> System.out.println (s));

        // remove List
        strList.remove ("apa");

        strList.forEach (System.out::println);

        // sort List
        strList.sort ((o1,o2) -> o2.compareTo (o1));

        strList.forEach (System.out::println);

        // filter List
        Predicate<String> pred = t -> t.length ()<=3;

        Collection<String> strListNew = filter (strList, pred);

        strListNew.forEach (System.out::println);

        // Set
        Set<String> strSet = new HashSet<String> ();

        // insert Set
        strSet.add ("apa");
        strSet.add ("makam");
        strSet.add ("itu");
        strSet.add ("ini");

        strSet.forEach (System.out::println);

        // remove Set
        strSet.remove ("ini");

        strSet.forEach (System.out::println);

        // sort Set
        SortedSet<String> strSortSet = new TreeSet<String> ((o1,o2) -> o2.compareTo (o1));
        strSortSet.addAll (strSet);

        strSortSet.forEach (System.out::println);

        // filter Set
        Collection<String> strSetNew = filter (strSet, pred);

        strSetNew.forEach (System.out::println);

        // Map
        Map<String, String> strMap = new HashMap<String, String> ();

        // insert Map
        strMap.put ("satu", "ipa");
        strMap.put ("dua", "makam");
        strMap.put ("tiga", "ini");
        strMap.put ("empat", "itu");

        Set<String> keySet = strMap.keySet ();
        
        strMap.forEach ((k,v) -> System.out.println (v));

        // remove Map
        strMap.remove ("tiga");

        keySet = strMap.keySet ();

        strMap.forEach ((k,v) -> System.out.println (v));

        // sort Map
        SortedMap<String, String> strSortMap = new TreeMap<String, String> ();
        strSortMap.putAll (strMap);

        keySet = strSortMap.keySet ();

        strSortMap.forEach ((k,v) -> System.out.println (v));

        // sort Map by value
        List<Map.Entry<String, String>> strMapList = new LinkedList<Map.Entry<String, String>> (
                strMap.entrySet ());
        Collections.sort (strMapList, (o1,o2) -> (o1.getValue ()).compareTo (o2.getValue ()));

        Map<String, String> strValMap = new LinkedHashMap<String, String> ();
        
        strMapList.forEach (e -> strValMap.put (e.getKey (), e.getValue ()));

        strValMap.forEach ((k,v) -> System.out.println (v));

        // filter Map
        Predicate<Map.Entry<String, String>> predEntry = t -> t.getValue ().length ()<=3;

        Collection<Map.Entry<String, String>> strMapListNew = filter (
                strMapList, predEntry);

        Map<String, String> strMapNew = new LinkedHashMap<String, String> ();
        
        strMapListNew.forEach (e -> strMapNew.put (e.getKey (), e.getValue ()));

        strMapNew.forEach ((k,v) -> System.out.println (v));
        
        //Stack
        Stack<String> strStack = new Stack<String>();
        
        //insert Stack
        strStack.push ("satu");
        strStack.push ("dua");
        strStack.push ("tiga");
        
        strStack.forEach (System.out::println);

        //remove Stack
        strStack.pop ();
        
        strStack.forEach (System.out::println);
        
        //lambda sum
        System.out.println (sum(strStack,t -> t.length ()));
        
        // filter List with high order function
        Predicate<String> pred2 = t -> t.charAt (2)=='i';

        Collection<String> strListNew2 = filter (strList, pred.and (pred2));

        strListNew2.forEach (System.out::println);
        
        Predicate<String> pred3 = t -> t.charAt (0)=='m';

        Collection<String> strListNew3 = filter (strList, pred.or (pred3));

        strListNew3.forEach (System.out::println);

    }

}
