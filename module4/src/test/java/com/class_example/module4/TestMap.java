package com.class_example.module4;


import java.util.HashMap;
import java.util.Map;

/**
 * 映射关系
 */
public class TestMap {
    public static void main(String[] args) {
        // todo 可变new HashMap
        Map<String, String> hashMap = new HashMap<>();

        // todo put 新增或修改
        hashMap.put("bright", "小明");
        hashMap.put("white", "小白");
        hashMap.put("black", "小黑");
        hashMap.put("bright", "小小明");

        // todo 根据key删除
        hashMap.remove("black");

        // todo 打印  打印key 打印value 判断是否为空
        System.out.println(hashMap); // {white=小白, bright=小小明}
        System.out.println(hashMap.keySet()); // [white, bright]
        System.out.println(hashMap.values()); // [小白, 小小明]
        System.out.println(hashMap.isEmpty()); // 判断是否为空 false

        // todo 遍历 增强for获取所有键值对集合
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + " value=" + entry.getValue()); // key=white value=小白
        }

        // todo get  getOrDefault 查询
        System.out.println(hashMap.get("white")); // 小白
        System.out.println(hashMap.get("blue")); // null
        System.out.println(hashMap.getOrDefault("blue", "默认值")); // 默认值

        // 清空
        hashMap.clear();
        System.out.println(hashMap); // {}
        System.out.println(hashMap.isEmpty()); // true
    }

}
