package com.bookmall.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 */
public class Cart {
    private LinkedHashMap<Integer, CartGoods> goodsMap = new LinkedHashMap<>();

    public Cart() {
    }

    // 方法

    /**
     * 添加商品到购物车
     */
    public void addGoods(CartGoods goods) {
        goodsMap.put(goods.getId(), goods);
    }

    /**
     * 从购物车中移除指定的商品
     */
    public void deleteGoods(int goodsId) {
        goodsMap.remove(goodsId);
    }

    /**
     * 修改指定商品的数量
     */
    public void updateGoods(int goodsId, int count) {
        CartGoods g = goodsMap.get(goodsId);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        goodsMap.clear();
    }


    /**
     * 获取商品总数量
     *
     * @return
     */
    public int getTotalCount() {
        int count = 0;
        for (CartGoods g : goodsMap.values()) {
            count += g.getCount();
        }
        return count;
    }

    /**
     * 计算购物车中选中商品的总价
     *
     * @return
     */
    public BigDecimal getTotalPrice() {
        for (CartGoods g : goodsMap.values()) {

        }
        return null;
    }

    public LinkedHashMap<Integer, CartGoods> getGoods() {
        return goodsMap;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "goodsMap=" + goodsMap +
                '}';
    }
}