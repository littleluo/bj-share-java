package com.bj.jdk.collections.list;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/18 9:20
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class ListNlognTest {

    public static void main(String[] args){
        int elementCount = 100000;
        int loopCount = 100000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("linkedListGet");
        linkedListGet(elementCount, loopCount);
        stopWatch.stop();
        stopWatch.start("arrayListGet");
        arrayListGet(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        StopWatch stopWatchAdd = new StopWatch();
        stopWatchAdd.start("linkedListAdd");
        linkedListAdd(elementCount, loopCount);
        stopWatchAdd.stop();
        stopWatchAdd.start("arrayListAdd");
        arrayListAdd(elementCount, loopCount);
        stopWatchAdd.stop();
        System.out.println(stopWatchAdd.prettyPrint());
    }

    /**
     * ArrayList插入
     * @param elementCount 元素个数
     * @param loopCount 循环次数
     */
    private static void arrayListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }

    /**
     * ArrayList访问
     * @param elementCount 元素个数
     * @param loopCount 循环次数
     */
    private static void arrayListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    /**
     * LinkedList插入
     * @param elementCount 元素个数
     * @param loopCount 循环次数
     */
    private static void linkedListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }

    /**
     * LinkedList访问
     * @param elementCount 元素个数
     * @param loopCount 循环次数
     */
    private static void linkedListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

}
