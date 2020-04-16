package com.bookmall.bean;

import java.util.Arrays;
import java.util.List;

/**
 * 分页器
 */
public class Paginator<T> {
    // 默认的每页显示的记录数
    private static final int PAGE_SIZE = 10;
    // 默认的分页导航条的格式
    private static final int[] PAGE_FORMAT = new int[]{1, 3, 1};

    // 当前页码，0：表示最后一页
    private int activePageNo = 1;
    // 总页码
    // private int pageTotal = 1;
    // 总记录数
    private int recordsTotal;
    // 每页显示的记录条数
    private int size = PAGE_SIZE;
    // 要显示的数据
    private List<T> items;
    /*
    * 分页导航条的格式
    * 如 [1, 5, 1]，
    *     第一元素表示左边显示的页数，
    *     第二个的元素表示中间显示的页数，要求必须是>=3的奇数
    *     第三个元素表示右边显示的页数
    * */
    private int[] pageFormat = PAGE_FORMAT;
    // 分页请求基本地址，如果html页面定义了base地址，url：manager/bookServlet?action=page
    // 否则使用完整的URL地址
    private String url;

    // 构造器
    public Paginator() {}

    public Paginator(int[] pageFormat) {
        setPageFormat(pageFormat);
    }

    public Paginator(int activePageNo, int size) {
        super();
        setActivePageNo(activePageNo);
        setSize(size);
    }

    // 方法
    public int getActivePageNo() {
        // 异常情况，显示最后一页
        //      1. activePageNo > pageTotal
        //      2. activePageNo == 0
        if (activePageNo > getPageTotal() || activePageNo == 0) {
            return getPageTotal();
        }
        return activePageNo;
    }

    public void setActivePageNo(int activePageNo) {
        if (activePageNo < 0) { // 需要允许设置当前活动页为0，表示查看最后一页
            this.activePageNo = 1;
        }
        // 当还没有传pageTotal，这时候还是初始值1，限制 activePageNo <= pageTotal 放在设置pageTotal值的方法中
        // else if (activePageNo > pageTotal) {
        //     this.activePageNo = pageTotal;
        // }
        else {
            this.activePageNo = activePageNo;
        }
    }


    /**
     * 获取总页码，可由size, recordsTotal计算得出
     *
     * @return
     */
    public int getPageTotal() {
        if (recordsTotal <= 0) {
            return 1;
        }
        int pageTotal = recordsTotal / size;
        // 如果 recordsTotal不是pageSize整数倍，显示总页数要加1页
        if (recordsTotal % size != 0) {
            ++pageTotal;
        }
        return pageTotal;
    }

    // public void setPageTotal(int pageTotal) {
    //     if (pageTotal < 1) {
    //         pageTotal = 1;
    //     }
    //     this.pageTotal = pageTotal;
    //     // 要满足 activePageNo <= pageTotal
    //     if (activePageNo > pageTotal) {
    //         activePageNo = pageTotal;
    //     }
    // }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        if (recordsTotal < 0) {
            this.recordsTotal = 0;
        } else {
            this.recordsTotal = recordsTotal;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1) {
            this.size = 1;
        }
        this.size = size;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        if (items == null) {
            return;
        }
        this.items = items;
    }

    public int[] getPageFormat() {
        return pageFormat;
    }

    public void setPageFormat(int[] pageFormat) {
        if (pageFormat == null) {
            return;
        }
        if (pageFormat.length < 3 || pageFormat[0] < 1 || pageFormat[2] < 1) {
            return;
        }
        if (pageFormat[1] < 3 || pageFormat[1] % 2 != 1) {
            return;
        }
        this.pageFormat = pageFormat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 是否有上一页
    public boolean hasPrevious() {
        return getActivePageNo() > 1;
    }

    // 是否有下一页
    public boolean hasNext() {
        return getActivePageNo() < getPageTotal();
    }
    @Override
    public String toString() {
        return "Paginator{" +
                "activePageNo=" + activePageNo +
                ", pageTotal=" + getPageTotal() +
                ", recordsTotal=" + recordsTotal +
                ", size=" + size +
                ", items=" + items +
                ", pageFormat=" + Arrays.toString(pageFormat) +
                ", url='" + url + '\'' +
                '}';
    }

}
