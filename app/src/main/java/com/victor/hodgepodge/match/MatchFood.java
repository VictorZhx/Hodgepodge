package com.victor.hodgepodge.match;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by victor on 17-8-17.
 */

public class MatchFood {
    private static final String TAG = "MatchFood";

    ArrayList<String> materialPools = new ArrayList<>(); // 原材料
    ArrayList<FoodInfo> allMenus = new ArrayList<>(); // 已存在的菜名
    ArrayList<FoodInfo> matchResults = new ArrayList<>(); // 匹配结果


    public void matchFoodByMaterial() {

        Log.i(TAG, " matchFoodByMaterial--> : ");

        for (FoodInfo foodInfo : allMenus) { // 遍历


            ArrayList<String> temMaterials = new ArrayList<>(); // 原材料
            temMaterials.addAll(materialPools);

            Log.i(TAG, " --> materials : " + temMaterials);
            Log.i(TAG, " --> consistMaterial : " + foodInfo.consistMaterial);

            if (temMaterials.containsAll(foodInfo.consistMaterial)) { // 原始材料满足
                Log.i(TAG, " --> match : " + true);
                matchResults.add(foodInfo); // 将匹配结果
            }
        }
        for (FoodInfo foodInfo : matchResults) {
            Log.i(TAG, " --> name : " + foodInfo.name + " , consistMaterial : " + foodInfo.consistMaterial);
        }
    }

    public void init() {

        // 有这些菜
        materialPools.add("鸡蛋");
        materialPools.add("芹菜");
        materialPools.add("猪肉");
        materialPools.add("牛肉");
        materialPools.add("土豆");
        materialPools.add("茄子");
        materialPools.add("青椒");
        materialPools.add("西红柿");
        materialPools.add("藕");
        materialPools.add("酸菜");
        materialPools.add("荷兰豆");
        materialPools.add("洋葱");
        materialPools.add("h2");
        materialPools.add("h3");

        // 菜谱
        FoodInfo foodInfo = new FoodInfo();
        foodInfo.name = "西红柿鸡蛋";
        foodInfo.consistMaterial.add("鸡蛋");
        foodInfo.consistMaterial.add("西红柿");
        allMenus.add(foodInfo);

        FoodInfo foodInfo1 = new FoodInfo();
        foodInfo1.name = "土豆牛腩";
        foodInfo1.consistMaterial.add("土豆");
        foodInfo1.consistMaterial.add("牛肉");
        allMenus.add(foodInfo1);


        FoodInfo foodInfo2 = new FoodInfo();
        foodInfo2.name = "榨菜肉丝";
        foodInfo2.consistMaterial.add("榨菜");
        foodInfo2.consistMaterial.add("猪肉");
        allMenus.add(foodInfo2);

        FoodInfo foodInfo3 = new FoodInfo();
        foodInfo3.name = "A";
        foodInfo3.consistMaterial.add("a2");
        foodInfo3.consistMaterial.add("a3");
        allMenus.add(foodInfo3);


        FoodInfo foodInfo4 = new FoodInfo();
        foodInfo4.name = "B";
        foodInfo4.consistMaterial.add("b2");
        foodInfo4.consistMaterial.add("b3");
        allMenus.add(foodInfo4);


        FoodInfo foodInfo5 = new FoodInfo();
        foodInfo5.name = "C";
        foodInfo5.consistMaterial.add("c2");
        foodInfo5.consistMaterial.add("c3");
        allMenus.add(foodInfo5);


        FoodInfo foodInfo6 = new FoodInfo();
        foodInfo6.name = "D";
        foodInfo6.consistMaterial.add("d2");
        foodInfo6.consistMaterial.add("d3");
        allMenus.add(foodInfo6);


        FoodInfo foodInfo7 = new FoodInfo();
        foodInfo7.name = "E";
        foodInfo7.consistMaterial.add("e2");
        foodInfo7.consistMaterial.add("e3");
        allMenus.add(foodInfo7);


        FoodInfo foodInfo8 = new FoodInfo();
        foodInfo8.name = "F";
        foodInfo8.consistMaterial.add("f2");
        foodInfo8.consistMaterial.add("f3");
        allMenus.add(foodInfo8);


        FoodInfo foodInfo9 = new FoodInfo();
        foodInfo9.name = "G";
        foodInfo9.consistMaterial.add("G2");
        foodInfo9.consistMaterial.add("G3");
        allMenus.add(foodInfo9);


        FoodInfo foodInfo10 = new FoodInfo();
        foodInfo10.name = "H";
        foodInfo10.consistMaterial.add("h2");
        foodInfo10.consistMaterial.add("h3");
        allMenus.add(foodInfo10);


    }

}
