package model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Sets <T>{

    private T set;

    Set<T> set1;
    Set<T> set2;

    public Sets(){
        set1 = new HashSet<T>();
        set2 = new HashSet<T>();
    }

    public void add2Set(T element, boolean whichSet){
        if (whichSet) {
            set1.add(element);
        }else{
            set2.add(element);
        }
    }

    public Set union(){
        if(set1.isEmpty()==false || set2.isEmpty()==false) {
            Set<T> union = new HashSet<T>(set1);
            union.addAll(set2);
            return union;
        }
        return null;
    }

    public Set intersection(){
        if(set1.isEmpty()==false || set2.isEmpty()==false) {
            Set<T> intersectSet = set1.stream().filter(set2::contains).collect(Collectors.toSet());
            return intersectSet;
        }
        return null;
    }

    public Set arithmeticDiff(){
        if(set1.isEmpty()==false || set2.isEmpty()==false) {
            Set<T> union = union();
            Set<T> intersectSet = intersection();
            union.removeAll(intersectSet);
            return union;
        }
        return null;
    }

}
