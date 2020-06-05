package com.bookmall.bean;

import com.bookmall.utils.CommonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车
 */
public class Cart implements Serializable {
    private LinkedHashMap<Integer, CartGoods> goodsMap = new LinkedHashMap<>();

    public Cart() {}

    // 方法
    public LinkedHashMap<Integer, CartGoods> getGoodsMap() {
        // return goodsMap;
        // 反转排序
        return CommonUtils.reverse(goodsMap);
    }

    /**
     * 添加商品到购物车
     */
    public void addGoods(CartGoods goods) {
        CartGoods g = goodsMap.get(goods.getId());
        if ( g != null ) { // 购物车中已经添加了此商品
            g.countIncrease(goods.getCount());
        } else {
            goodsMap.put(goods.getId(), goods);
        }
    }

    /**
     * 从购物车中移除指定的商品
     */
    public void deleteGoods(int goodsId) {
        if (goodsId <= 0) {
            return;
        }
        goodsMap.remove(goodsId);
    }

    /**
     * 修改指定商品的数量
     */
    public void updateGoods(int goodsId, int count) {
        CartGoods g = goodsMap.get(goodsId);
        if ( g == null ) {
            return;
        }
        g.setCount(count);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        goodsMap.clear();
    }

    /**
     * 获取已选中的商品总数量
     *
     * @return
     */
    public int getCheckedTotalCount() {
        int count = 0;
        for (CartGoods g : goodsMap.values()) {
            if (!g.isChecked()) {
                continue;
            }
            count += g.getCount();
        }
        return count;
    }

    /**
     * 获取已选中的商品总数量
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
        BigDecimal total = BigDecimal.ZERO;
        for (CartGoods g : goodsMap.values()) {
            if ( !g.isChecked() ) { // 未选中的不计算
                continue;
            }
            total = total.add(g.getTotalPrice());
        }
        return total;
    }

    /**
     * 获取购物车中已选中的商品
     *
     * @return 购物车中已选中的商品组成的List对象
     */
    public List<CartGoods> getAllCheckedGoods() {
        List<CartGoods> goods = new ArrayList<>();
        for (CartGoods g : goodsMap.values()) {
            if (!g.isChecked()) {
                continue;
            }
            goods.add(g);
        }
        return goods;
    }

    /**
     * 买单后，清除购物车中已经买单的商品
     *
     * @return 购物车中已经买单的商品的种类数量
     */
    public int removeCheckedGoods() {
        int count = 0;
        System.out.println(goodsMap.values());
        /*
         * 使用for会报 java.util.ConcurrentModificationException 并发修改异常
         * 这是因为遍历的map对象发生了改变，删除了一个元素，size减少了
         * */
        //for (CartGoods g : goodsMap.values()) {
        //    if (g.isChecked()) {
        //        ++count;
        //        deleteGoods(g.getId());
        //    }
        //}
        Iterator<CartGoods> iterator = goodsMap.values().iterator();
        while (iterator.hasNext()) {
            CartGoods g = iterator.next();
            if ( g.isChecked() ) {
                iterator.remove(); // 删除最近一次获取的元素，即当前正在遍历到的元素
                // 如果用下面的方法删除元素，也会报java.util.ConcurrentModificationException 并发修改异常
                // deleteGoods(g.getId()); // goodsMap.remove(goodsId);
            }
        }
        return count;
    }

    /**
     * 选中 \ 取消 指定商品
     *
     * @param goodsId
     * @param checked 选中情况
     *                false: 取消
     *                true: 选中
     */
    public void checkedGoods(int goodsId, boolean checked) {
        CartGoods g = goodsMap.get(goodsId);
        if ( g != null ) {
            g.setChecked(checked);
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "goodsMap=" + goodsMap +
                '}';
    }

    // 购物车所有商品是否都选中
    public boolean isAllChecked() {
        boolean isAllChecked = true;
        for (CartGoods g : goodsMap.values()) {
            if (!g.isChecked()) {
                isAllChecked = false;
                break;
            }
        }
        return isAllChecked;
    }

    // 全选/取消 购物车所有商品
    public void checkedAllOrNot() {
        // System.out.println("isAllChecked:" + isAllChecked());
        if (!isAllChecked()) {
            for (CartGoods g : goodsMap.values()) {
                if (!g.isChecked()) {
                    g.setChecked(true);
                }
            }
        } else {
            for (CartGoods g : goodsMap.values()) {
                if (g.isChecked()) {
                    g.setChecked(false);
                }
            }
        }
    }

    /**
     * 查询购物车上指定ID的商品
     *
     * @param goodsId
     * @return
     */
    public CartGoods getCartGoodSById(int goodsId) {
        CartGoods cartGoods = goodsMap.get(goodsId);
        return cartGoods;
    }
}