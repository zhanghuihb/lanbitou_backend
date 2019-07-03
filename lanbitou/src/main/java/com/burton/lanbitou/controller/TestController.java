package com.burton.lanbitou.controller;

import com.burton.common.domain.Goods;
import com.burton.common.domain.test.DeepCopy;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;

import javax.persistence.Access;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Tainy
 * @date 2019/6/17 14:21
 */
public class TestController {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*Goods g1=new Goods(1,"苹果1斤",5);
        Goods g2=new Goods(2,"西瓜1斤",2);
        Goods g3=new Goods(3,"香蕉1斤",4);
        Goods g4=new Goods(4,"火龙果1斤",9);
        Goods g5=new Goods(5,"菠萝1斤",6);
        List<Goods> goodsList=Arrays.asList(g1,g2,g3,g4,g5);

        // 过滤
        final List<Goods> collect = goodsList.stream().filter(goods -> goods.getGoodsPrice() < 6).collect(Collectors.toList());
        System.out.println(collect);
        // 价格最小值
        Integer minPrice = goodsList.stream().min(Comparator.comparing(goods -> goods.getGoodsPrice())).get().getGoodsPrice();
        System.out.println(minPrice);
        // 价格最大值
        Integer maxPrice = goodsList.stream().max(Comparator.comparing(goods -> goods.getGoodsPrice())).get().getGoodsPrice();
        System.out.println(maxPrice);
        // 所有价格总和
        Integer sum = goodsList.stream().map(Goods::getGoodsPrice).collect(Collectors.toList()).stream().reduce(0, (acc, element) -> acc + element);
        System.out.println(sum);
        Integer total = goodsList.stream().mapToInt(Goods::getGoodsPrice).sum();
        System.out.println(total);
        // 排序
        List<Goods> smallToBig = goodsList.stream().sorted(Comparator.comparing(Goods::getGoodsPrice)).collect(Collectors.toList());
        List<Goods> bigToSmall = goodsList.stream().sorted(Comparator.comparing(Goods::getGoodsPrice).reversed()).collect(Collectors.toList());
        System.out.println(smallToBig);
        System.out.println(bigToSmall);
        // List to Map
        Map<Integer, Goods> goodsMap = goodsList.stream().collect(Collectors.toMap(Goods::getId, Function.identity()));
        System.out.println(goodsMap);

        String s1 = "ab";
        String s2 = s1.intern();
        System.out.println(s1 == s2);*/

        DeepCopy deepCopy1 = new DeepCopy();
        deepCopy1.setDeepCopy(new DeepCopy("burton"));

        DeepCopy deepCopy2 = deepCopy1.clone();

        deepCopy2.getDeepCopy().setParam3("tainy");

        System.out.println(deepCopy1);
        System.out.println(deepCopy2);


    }

}
