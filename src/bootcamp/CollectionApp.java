package bootcamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import java.util.function.Predicate;

public class CollectionApp
{

    public static <T> Collection<T> filter (Collection<T> col,
            Predicate<T> predicate)
    {
        Collection<T> result = new ArrayList<T> ();
        for (T element : col) {
            if (predicate.test (element)) {
                result.add (element);
            }
        }
        return result;
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

        for (String s : strList)
            System.out.println (s);

        // remove List
        strList.remove ("apa");

        for (String s : strList)
            System.out.println (s);

        // sort List
        strList.sort (new Comparator<String> () {

            @Override
            public int compare (String o1, String o2)
            {
                return o1.compareTo (o2);
            }

        });

        for (String s : strList)
            System.out.println (s);

        // filter List
        Predicate<String> pred = new Predicate<String> () {

            @Override
            public boolean test (String t)
            {
                return t.length () <= 3;
            }
        };

        Collection<String> strListNew = filter (strList, pred);

        for (String s : strListNew)
            System.out.println (s);

        // Set
        Set<String> strSet = new HashSet<String> ();

        // insert Set
        strSet.add ("apa");
        strSet.add ("makam");
        strSet.add ("itu");
        strSet.add ("ini");

        for (String s : strSet)
            System.out.println (s);

        // remove Set
        strSet.remove ("ini");

        for (String s : strSet)
            System.out.println (s);

        // sort Set
        SortedSet<String> strSortSet = new TreeSet<String> (
                new Comparator<String> () {

                    @Override
                    public int compare (String o1, String o2)
                    {
                        return o2.compareTo (o1);
                    }
                });
        strSortSet.addAll (strSet);

        for (String s : strSortSet)
            System.out.println (s);

        // filter Set
        Collection<String> strSetNew = filter (strSet, pred);

        for (String s : strSetNew)
            System.out.println (s);

        // Map
        Map<String, String> strMap = new HashMap<String, String> ();

        // insert Map
        strMap.put ("satu", "ipa");
        strMap.put ("dua", "makam");
        strMap.put ("tiga", "ini");
        strMap.put ("empat", "itu");

        Set<String> keySet = strMap.keySet ();

        for (String s : keySet)
            System.out.println (strMap.get (s));

        // remove Map
        strMap.remove ("tiga");

        keySet = strMap.keySet ();

        for (String s : keySet)
            System.out.println (strMap.get (s));

        // sort Map
        SortedMap<String, String> strSortMap = new TreeMap<String, String> ();
        strSortMap.putAll (strMap);

        keySet = strSortMap.keySet ();

        for (String s : keySet)
            System.out.println (strSortMap.get (s));

        // sort Map by value
        List<Map.Entry<String, String>> strMapList = new LinkedList<Map.Entry<String, String>> (
                strMap.entrySet ());
        Collections.sort (strMapList,
                new Comparator<Map.Entry<String, String>> () {
                    public int compare (Map.Entry<String, String> o1,
                            Map.Entry<String, String> o2)
                    {
                        return (o1.getValue ()).compareTo (o2.getValue ());
                    }
                });

        Map<String, String> strValMap = new LinkedHashMap<String, String> ();
        for (Map.Entry<String, String> entry : strMapList) {
            strValMap.put (entry.getKey (), entry.getValue ());
        }

        keySet = strValMap.keySet ();

        for (String s : keySet)
            System.out.println (strValMap.get (s));

        // filter Map
        Predicate<Map.Entry<String, String>> predEntry = new Predicate<Map.Entry<String, String>> () {

            @Override
            public boolean test (Map.Entry<String, String> t)
            {
                return t.getValue ().length () <= 3;
            }
        };

        Collection<Map.Entry<String, String>> strMapListNew = filter (
                strMapList, predEntry);

        Map<String, String> strMapNew = new LinkedHashMap<String, String> ();
        for (Map.Entry<String, String> entry : strMapListNew) {
            strMapNew.put (entry.getKey (), entry.getValue ());
        }

        keySet = strMapNew.keySet ();

        for (String s : keySet)
            System.out.println (strMapNew.get (s));
        
        //Stack
        Stack<String> strStack = new Stack<String>();
        
        //insert Stack
        strStack.push ("satu");
        strStack.push ("dua");
        strStack.push ("tiga");
        
        for(String s : strStack) {
            System.out.println (s);
        }
        
        //remove Stack
        strStack.pop ();
        
        for(String s : strStack) {
            System.out.println (s);
        }

    }

}
