package concurrenthashmap;

import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
        String s = "Hi everyone";
        int i = 0;
        for(Character character : s.toCharArray()) {
            if(!map.contains(character)){
                map.put(character, 1);
            }
            else{
                map.put(character, map.get(character) + 1);
            }
            map.put(character, i++);

//            map.computeIfAbsent(character, (character1 -> 1));
//            map.computeIfPresent(character, ((character1, integer) -> ++integer));
            // -> above 2 can still lead to race conditinos sometimes...
            map.compute(character, (((character1, integer) -> {
                if(integer == null){
                    return 1;
                }
                else {
                    return integer + 1;
                }
            }
        )));

        }

        System.out.println(map);
    }
}
