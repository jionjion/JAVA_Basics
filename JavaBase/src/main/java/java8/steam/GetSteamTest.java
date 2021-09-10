package java8.steam;

import java.util.*;
import java.util.stream.Stream;

/**
 *  @author Jion
 *      从集合,数组获得流
 */
public class GetSteamTest {


    /** 从集合框架中获得流 */
    public void testGetStreamFromCollection(){
        Collection collection = new ArrayList<String>();
        // 获得串行流
        Stream<String> stream = collection.stream();
        // 获得并行流
        Stream<String> parallelStream = collection.parallelStream();
    }

    /** 从数组中获得流 */
    public void testGetSteamFromArrary(){
        String[] arr =  {"A","B","C"};
        Stream<String> stream = Arrays.stream(arr);
    }

    /** 从Steam静态方法获得 */
    public void testGetSteamFromStaticMethod(){
        Stream<String> stream = Stream.of("A","B","C");
    }

    /** 从Steam获得 */
    public void  test(){
        Stream<Double> stream = Stream.generate(Math::random);
    }

    /** 从Steam获得无限流 */
    public void testCreateUnlimtStream(){
        // 获得自增+1的流
        Stream<Integer> stream = Stream.iterate(0, t -> t+1);
    }
}
