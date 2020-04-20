package com.bookmall.daoimpl;

import com.bookmall.bean.Paginator;

import java.util.List;

/**
 * 通用分页数据填充
 *
 * @param <T>
 */
public class Page<T> {
    private Paginator<T> paginator;

    // 构造器
    public Page() {}

    public Page(int activePageNo, int pageSize, int recordsTotal, List<T> items, String url) {
        setPaginator(activePageNo, pageSize, recordsTotal, items, url);
    }
    // 方法
    public Paginator<T> getPaginator() {
        return paginator;
    }

    public void setPaginator(int activePageNo, int pageSize, int recordsTotal, List<T> items, String url) {
        Paginator<T> paginator = new Paginator<>(activePageNo, pageSize);
        paginator.setRecordsTotal(recordsTotal);
        paginator.setItems(items);
        paginator.setUrl(url);
        this.paginator = paginator;
    }

    /**
     * 检查当前活动页的合法性，并返回合法的值
     *
     * @param activePageNo
     * @param pageSize
     * @param recordsTotal
     * @return
     */
    public static int checkActivePageNo(int activePageNo, int pageSize, int recordsTotal) {
        Paginator<Object> paginator = new Paginator<>(activePageNo, pageSize);
        paginator.setRecordsTotal(recordsTotal);
        return paginator.getActivePageNo();
    }
}
