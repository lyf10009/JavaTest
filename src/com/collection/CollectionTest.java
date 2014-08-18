package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import net.sf.json.JSONArray;

public class CollectionTest {
    public static void main(String[] args) {
//        iteratorTest();
//        clearList();
//        changeEntity();
//        sortIntegerList();
//        sortEntityList();
//        sortList1();//双排序问题
//        subListTest();
//        listToJSonArray();
//        removeAllTest();
//        retainAllTest();
//        listToString();
//        mapTest();
//        listSetTest();
//        listToSet();
//        nullTest();
//        queueTest();
        setTest();
    }
 
    public static void setTest() {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println("第一次："+set);
        set.add(2);
        System.out.println("第二次："+set);
    }
    public static void listToSet() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        Set<Integer> set = new HashSet<Integer>(list);
        System.out.println(set.size() + "asdfdsf");
        for (int i : set) {
            System.out.println(i);
        }
    }
    public static void queueTest() {
        Queue<Integer> list = new LinkedList<Integer>();
        list.offer(1);
        list.offer(2);
        list.offer(3);
        list.offer(4);
        while(!list.isEmpty()) {
            System.out.println(list.poll());
        }
    }

    public static void listSetTest() {
        List<Bus> list = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus("bus1", "bus2", 3);
        Bus one4 = new Bus("bus1", "bus2", 4);
        Bus one5 = new Bus("bus1", "bus2", 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list.add(one4);
        list.add(one5);
        Bus tmp = list.get(0);
        list.set(0, list.get(1));
        list.set(1, tmp);
        for (Bus bus : list) {
            System.out.println(bus.getBus1() + "\t" + bus.getBus2() + "\t" + bus.getBus3());
        }
    }

    //list中插入null的情况
    public static void nullTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(null);
        list.add(null);
        list.add(12);
        list.add(23);
        list.add(34);
        list.add(null);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void mapTest() {
        Bus one1 = new Bus("bus1", "bus21", 1);
        Bus one2 = new Bus("bus2", "bus22", 2);
        Bus one3 = new Bus("bus3", "bus23", 3);
        Map<String, Bus> maps = new HashMap<String, Bus>();
        maps.put("bus1", one1);
        maps.put("bus2", one2);
        maps.put("bus3", one3);
        Map<String, Bus> newMap = new HashMap<String, Bus>();
        newMap.putAll(maps);
        maps.get("bus1").setBus3(4);
        //循环打印map中的值
        Iterator<String> it = maps.keySet().iterator();
        while (it.hasNext()) {
            Bus tmp = maps.get(it.next());
            System.out.println(tmp.getBus1() + "\t" + tmp.getBus2() + "\t" + tmp.getBus3());
        }
        System.out.println("新map");
        Iterator<String> it1 = newMap.keySet().iterator();
        while (it1.hasNext()) {
            Bus tmp = newMap.get(it1.next());
            System.out.println(tmp.getBus1() + "\t" + tmp.getBus2() + "\t" + tmp.getBus3());
        }

        //containsKey函数
        if (maps.containsKey("bus6")) {
            System.out.println("map中含有值为bus6的key");
        } else {
            System.out.println("map中不含有值为bus6的key");
        }

    }

    public static void listToString() {
        List<String> sl = new ArrayList<String>();
        sl.add("a");
        sl.add("b");
        sl.add("c");
        StringBuffer buffer = new StringBuffer();
        buffer.append(sl);
        System.out.println(buffer.toString());

    }

    public static void iteratorTest() {
        List<String> sl = new ArrayList<String>();
        sl.add("a");
        sl.add("b");
        sl.add("c");
        Iterator<String> iterator = sl.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void clearList() {
        List<Bus> list = new ArrayList<Bus>();
        List<Bus> list1 = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus("bus1", "bus2", 3);
        Bus one4 = new Bus("bus1", "bus2", 4);
        Bus one5 = new Bus("bus1", "bus2", 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list.add(one4);
        list.add(one5);
        list1.addAll(list);
        System.out.println("clear之前list.size：" + list.size());
        System.out.println("clear之前list1.size：" + list1.size());
        list.clear();
        System.out.println("clear之后list.size：" + list.size());
        System.out.println("clear之后list1.size：" + list1.size());
    }

    //修改List中实体内容时，List中所存的实体内容是否会变化        答案：会（实体不是基础类型时）
    public static void changeEntity() {
        List<Bus> list = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus();
        one3.setBus1("bus3");
        one3.setBus2("bus3");
        list.add(one1);
        list.add(one2);
        list.add(one3);
        System.out.println("改变之前：");
        for (Bus bus : list) {
            System.out.println(bus.getBus1() + "\t" + bus.getBus2() + "\t" + bus.getBus3());
        }
        System.out.println("改变之后：");
        one1.setBus1("387");
        for (Bus bus : list) {
            System.out.println(bus.getBus1() + "\t" + bus.getBus2() + "\t" + bus.getBus3());
        }
    }

    public static void sortIntegerList() {
        System.out.println("List中存的是数字类型");
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(123);
        list.add(3215);
        list.add(56541);
        list.add(5465);
        list.add(65456);
        System.out.println("未排序：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        java.util.Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; //升序
//                   return o2-o1;                               //降序
//                if(o1-o2>0)   return 1;       //升序
//                if(o1-o2<0) return -1;
//                return 0;
            }
        });
        System.out.println("升序排序后：");
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void sortEntityList() {
        List<Bus> list = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus("bus1", "bus2", 3);
        Bus one4 = new Bus("bus1", "bus2", 4);
        Bus one5 = new Bus("bus1", "bus2", 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list.add(one4);
        list.add(one5);
        Collections.sort(list, new Comparator<Bus>() {
            public int compare(Bus q1, Bus q2) {
                int o1 = q1.getBus3();
                int o2 = q2.getBus3();
                return o1 - o2; //升序
//                return o2 - o1; //降序
//              if(o1.compareTo(o2)<0) return 1;            //降序
//              if(o1.compareTo(o2)>0) return -1;
//              return 0;
            }
        });
        for (Bus one : list) {
            System.out.println(one.getBus1() + "\t" + one.getBus2() + "\t" + one.getBus3());
        }
    }

    //根据两个字段排序
    public static void sortList1() {
        List<Bus> list = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", 1, 1);
        Bus one2 = new Bus("bus2", 1, 4);
        Bus one3 = new Bus("bus3", 1, 1);
        Bus one4 = new Bus("bus4", 2, 4);
        Bus one5 = new Bus("bus5", 2, 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list.add(one4);
        list.add(one5);
        Collections.sort(list, new Comparator<Bus>() {
            public int compare(Bus q1, Bus q2) {
//                int o1=q1.getBus3();
//                int o2=q2.getBus3();
//                if(o1>o2){ 
//                    return 1;
//                }else if(o1==o2){
//                    if(q1.getBus4()>q2.getBus4()){
//                        return 1;
//                    }else{
//                        return -1;
//                    }
//                }else{
//                    return -1;
//                }
                return q1.getBus3() > q2.getBus3() ? 1 : (q1.getBus3() == q2.getBus3() ? (q1
                        .getBus4() > q2.getBus4() ? 1 : -1) : -1);
            }
        });
        for (Bus one : list) {
            System.out.println(one.getBus1() + "\t" + one.getBus3() + "\t" + one.getBus4());
        }
    }

    public static void subListTest() {
        List<Bus> list = new ArrayList<Bus>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus("bus1", "bus2", 3);
        Bus one4 = new Bus("bus1", "bus2", 4);
        Bus one5 = new Bus("bus1", "bus2", 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list.add(one4);
        list.add(one5);
        System.out.println("原List：");
        for (Bus one : list) {
            System.out.println(one.getBus1() + "\t" + one.getBus2() + "\t" + one.getBus3());
        }
        list.subList(2, list.size()).clear();
        for (Bus one : list) {
            System.out.println(one.getBus1() + "\t" + one.getBus2() + "\t" + one.getBus3());
        }
        //subList(int fromIndex, int toIndex),index从0开始，不包括toIndex指向的一项
//        List<Bus> list1 = list.subList(1, 5);
//        System.out.println("子List1：");
//        for (Bus one : list1) {
//            System.out.println(one.getBus1() + "\t" + one.getBus2() + "\t" + one.getBus3());
//        }
    }

    public static void listToJSonArray() {
        List<Bus> list = new ArrayList<Bus>();
        List<Bus> list1 = new ArrayList<Bus>();
        List<List<Bus>> lista = new ArrayList<List<Bus>>();
        Bus one1 = new Bus("bus1", "bus2", 1);
        Bus one2 = new Bus("bus1", "bus2", 2);
        Bus one3 = new Bus("bus1", "bus2", 3);
        Bus one4 = new Bus("bus1", "bus2", 4);
        Bus one5 = new Bus("bus1", "bus3", 5);
        list.add(one1);
        list.add(one2);
        list.add(one3);
        list1.add(one4);
        list1.add(one5);
        lista.add(list);
        lista.add(list1);
        JSONArray a = JSONArray.fromObject(lista); //将List转化成JSon字符数组
        System.out.println(a.getJSONArray(0).getJSONObject(0).getInt("bus3"));
        System.out.println(a.getJSONArray(1).getJSONObject(1).getInt("bus3"));
    }

    public static void removeAllTest() {
        List<String> list = new ArrayList<String>();
        list.add("星期1");
        list.add("星期2");
        list.add("星期3");
        list.add("星期4");
        List<String> list1 = new ArrayList<String>();
        list1.add("星期1");
        list1.add("星期3");
        list1.add("星期4");
        list1.add("星期5");
        list.removeAll(list1);
        System.out.println("list1中没有而list中有的元素：");
        for (String day : list) {
            System.out.print(day + "\t");
        }
        System.out.println();
    }

    public static void retainAllTest() {
        List<String> list = new ArrayList<String>();
        list.add("星期1");
        list.add("星期2");
        list.add("星期3");
        list.add("星期4");
        List<String> list1 = new ArrayList<String>();
        list1.add("星期1");
        list1.add("星期3");
        list1.add("星期4");
        list1.add("星期5");
        list.retainAll(list1);
        System.out.println("list与list1的共同元素:");
        for (String day : list) {
            System.out.print(day + "\t");
        }
        System.out.println();
    }
}
