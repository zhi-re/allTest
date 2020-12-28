package org.zhire.demo.guava.map;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

/**
 * @Date 2020/12/28 11:16
 * @Author by chenqi
 */
public class GuavaTest {

    /**
     * 谷歌集合工具类的使用
     */
    @Test
    public void testGoo() {
        // 普通Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();

        // 不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

        // 创建一个map key是字符串 value 是Integer集合
        Multimap<String, Integer> map2 = ArrayListMultimap.create();
        map2.put("aa", 1);
        map2.put("aa", 2);
        map2.put("bb", 3);
        map2.put("bb", 4);
        System.out.println(JSON.toJSONString(map2.asMap()));
        System.out.println(map2.get("aa"));  // [1, 2]


        // 无序 + 可重复 set
        Multiset<String> set2 = HashMultiset.create();
        set2.add("aaaa");
        set2.add("aaaa");
        System.out.println(JSON.toJSONString(set2));

        // key可以重复 map
        Multimap<String, String> mapp = ArrayListMultimap.create();
        mapp.put("name", "cq");
        mapp.put("name", "cq2");
        System.out.println(JSON.toJSONString(mapp.asMap()));

        // 双向Map(Bidirectional Map) 键与值都不能重复
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("name", "cq");
        biMap.put("name", "cq2");
        biMap.put("age", "2");
        // biMap.put("age2", "2");
        System.out.println(JSON.toJSONString(biMap));

        // 双键的Map Map--> Table-->rowKey+columnKey+value  // 类似和sql中的联合主键
        Table<String, String, String> tables = HashBasedTable.create();
        tables.put("id", "name", "cq");
        tables.put("id", "name", "cq");
        tables.put("id2", "name2", "cq2");
        System.out.println(tables.values());

        // 集合转字符串
        List<String> lists = new ArrayList();
        lists.add("aa");
        lists.add("bb");
        lists.add("cc");
        String result = Joiner.on(",").join(lists);
        System.out.println(result);

        // map转字符串
        Map<String, Integer> maps = Maps.newHashMap();
        maps.put("xiaoming", 12);
        maps.put("xiaohong", 13);
        String result2 = Joiner.on(",").withKeyValueSeparator("=").join(maps);
        System.out.println(result2);

        // 字符串转集合
        String str = "1,2,3";
        List<String> listss = Splitter.on(",").splitToList(str);
        System.out.println(listss);

        // 字符串转map
        String strs = "xiaoming=11,xiaohong=23";
        Map<String, String> mapss = Splitter.on(",").withKeyValueSeparator("=").split(strs);
        System.out.println(JSON.toJSONString(mapss));

        // set的交集, 并集, 差集
        HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> setB = Sets.newHashSet(4, 5, 6, 7, 8);

        Sets.SetView<Integer> union = Sets.union(setA, setB);
        System.out.println("union:");
        for (Integer integer : union) {
            // union 并集:12345867
            System.out.print(integer + " ");
        }
        System.out.println();

        Sets.SetView<Integer> difference = Sets.difference(setA, setB);
        System.out.println("difference:");
        for (Integer integer : difference) {
            // difference 差集:123
            System.out.print(integer + " ");
        }
        System.out.println();

        Sets.SetView<Integer> intersection = Sets.intersection(setA, setB);
        System.out.println("intersection:");
        for (Integer integer : intersection) {
            // intersection 交集:45
            System.out.print(integer + " ");
        }
        System.out.println();

        // map的交集，并集，差集
        HashMap<String, Integer> mapA = Maps.newHashMap();
        mapA.put("a", 1);
        mapA.put("b", 2);
        mapA.put("c", 3);

        HashMap<String, Integer> mapB = Maps.newHashMap();
        mapB.put("b", 20);
        mapB.put("c", 3);
        mapB.put("d", 4);

        MapDifference differenceMap = Maps.difference(mapA, mapB);
        differenceMap.areEqual();

        Map entriesDiffering = differenceMap.entriesDiffering();
        Map entriesOnlyLeft = differenceMap.entriesOnlyOnLeft();
        Map entriesOnlyRight = differenceMap.entriesOnlyOnRight();
        Map entriesInCommon = differenceMap.entriesInCommon();

        // {b=(2, 20)}
        System.out.println(entriesDiffering);
        // {a=1}
        System.out.println(entriesOnlyLeft);
        // {d=4}
        System.out.println(entriesOnlyRight);
        // {c=3}
        System.out.println(entriesInCommon);

    }
}
