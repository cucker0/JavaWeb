<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty requestScope.page}">
    <div class="clearfix paginator">
        <div class="pull-left text-y-middle">共${requestScope.page.recordsTotal}条</div>

        <div class="pull-left page-nav">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                        <%-- 前一页 --%>
                    <c:choose>
                        <c:when test="${requestScope.page.hasPrevious()}">
                            <li class="page-item previous">
                                <a class="page-link"
                                   href="javascript: void(0);"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&lt;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item previous disabled">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&lt;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                        <%-- 中间的数字页码 --%>
                    <c:choose>
                        <%-- 情况A：导航条数字部分无省略标 --%>
                        <c:when test="${
                        requestScope.page.pageTotal <=
                        (requestScope.page.pageFormat[0] + requestScope.page.pageFormat[1] + requestScope.page.pageFormat[2])
                        }">
                            <c:forEach var="i" begin="1" end="${requestScope.page.pageTotal}" step="1">
                                <c:choose>
                                    <c:when test="${i == requestScope.page.activePageNo}">
                                        <li class="page-item active" aria-current="page">
                                            <a class="page-link" href="javascript: void(0);">${i}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a class="page-link" href="javascript: void(0);">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:when>
                        <%-- 情况B：同时有左、右省略标，需要排在情况C、情况D情况前 --%>
                        <c:when test="${
                        requestScope.page.activePageNo >
                        (requestScope.page.pageFormat[0] + 1 + requestScope.page.pageFormat[1] / 2)
                        &&
                        requestScope.page.pageTotal - requestScope.page.activePageNo > (requestScope.page.pageFormat[2] + requestScope.page.pageFormat[1] / 2)
                        }">
                            <li class="page-item"><a class="page-link" href="javascript: void(0);">1</a>
                            </li>
                            <li class="page-item ellipsis"><a class="page-link" href="javascript: void(0);">...</a></li>
                            <c:forEach var="i"
                                       begin="${requestScope.page.activePageNo - (requestScope.page.pageFormat[1] / 2) + 0.5}"
                                       end="${requestScope.page.activePageNo - 1}" step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="javascript: void(0);">
                                        ${requestScope.page.activePageNo}
                                </a>
                            </li>
                            <c:forEach var="i"
                                       begin="${requestScope.page.activePageNo + 1}"
                                       end="${requestScope.page.activePageNo + (requestScope.page.pageFormat[1] / 2)}"
                                       step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item ellipsis"><a class="page-link" href="javascript: void(0);">...</a></li>
                            <li class="page-item">
                                <a class="page-link" href="javascript: void(0);">
                                        ${requestScope.page.pageTotal}
                                </a>
                            </li>
                        </c:when>
                        <%-- 情况C：只有左省略标 --%>
                        <c:when test="${requestScope.page.activePageNo > (requestScope.page.pageFormat[0] + 1 + requestScope.page.pageFormat[1] / 2)}">
                            <li class="page-item"><a class="page-link" href="javascript: void(0);">1</a>
                            </li>
                            <li class="page-item ellipsis"><a class="page-link" href="javascript: void(0);">...</a></li>
                            <c:forEach var="i"
                                       begin="${requestScope.page.activePageNo - (requestScope.page.pageFormat[1] / 2) + 0.5}"
                                       end="${requestScope.page.activePageNo - 1}" step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="javascript: void(0);">
                                        ${requestScope.page.activePageNo}
                                </a>
                            </li>
                            <c:forEach var="i" begin="${requestScope.page.activePageNo + 1}"
                                       end="${requestScope.page.pageTotal}" step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                        </c:when>
                        <%-- 情况D：只有右省略标 --%>
                        <%-- 这时最后一种情况，也可以用 otherwise --%>
<%--                        <c:when test="${--%>
<%--                        requestScope.page.pageTotal - requestScope.page.activePageNo >--%>
<%--                        (requestScope.page.pageFormat[2] + requestScope.page.pageFormat[1] / 2)--%>
<%--                        }">--%>
<%--                        </c:when>--%>
                        <c:otherwise>
                            <c:forEach var="i" begin="1" end="${requestScope.page.activePageNo - 1}" step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item active" aria-current="page">
                                <a class="page-link"
                                   href="javascript: void(0);">
                                        ${requestScope.page.activePageNo}
                                </a>
                            </li>
                            <c:forEach var="i" begin="${requestScope.page.activePageNo + 1}"
                                       end="${requestScope.page.activePageNo + (requestScope.page.pageFormat[1] / 2) - 0.5}"
                                       step="1">
                                <li class="page-item">
                                    <a class="page-link" href="javascript: void(0);">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item ellipsis"><a class="page-link" href="javascript: void(0);">...</a></li>
                            <li class="page-item">
                                <a class="page-link" href="javascript: void(0);">
                                        ${requestScope.page.pageTotal}
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                        <%-- 后一页 --%>
                    <c:choose>
                        <c:when test="${requestScope.page.hasNext()}">
                            <li class="page-item next">
                                <a class="page-link" href="javascript: void(0);" aria-label="Next">
                                    <span aria-hidden="true">&gt;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item next disabled">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&gt;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>

        <div class="jump-page pull-left">
            <input type="text" size="2" name="input_page_number" placeholder="页码">
            <button type="submit" name="jump-page" class="btn btn-primary y-baseline">跳转</button>
        </div>

        <div class="btn-group dropup pull-left">
                <%-- value用于记录用户选择了多少条/页的值 --%>
            <button type="button" value="${requestScope.page.size}" class="btn btn-secondary dropdown-toggle"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${requestScope.page.size}条/页
            </button>
            <div class="dropdown-menu">
                <!-- Dropdown menu links -->
                <a class="dropdown-item" value="10" href="javascript: void(0);">10条/页</a>
                <a class="dropdown-item" value="20" href="javascript: void(0);">20条/页</a>
                <a class="dropdown-item" value="50" href="javascript: void(0);">50条/页</a>
                <a class="dropdown-item" value="100" href="javascript: void(0);">100条/页</a>
            </div>
        </div>

    </div>
</c:if>

<script>

    /**
     * 查询指定页码的数据
     */
    function specifyPageQuery(pageNo) {
        var parseNum = parseInt(pageNo);
        pageNo = parseNum ? parseNum : null;
        var page_size = $(".btn-group button").attr("value").trim();
        var min_price = $(".search-by-price input:eq(0)").val() ? parseFloat($(".search-by-price input:eq(0)").val().trim()) : -1;
        var max_price = $(".search-by-price input:eq(1)").val() ? parseFloat($(".search-by-price input:eq(1)").val().trim()) : -1;

        if (pageNo) {
            if (min_price && max_price && min_price < max_price) {
                location.href = "${requestScope.page.url}" +
                    "&page_no=" + pageNo +
                    "&min_price=" + min_price +
                    "&max_price=" + max_price;
            } else {
                location.href = "${requestScope.page.url}" +
                    "&page_no=" + pageNo +
                    "&page_size=" + page_size;
            }
        }
    }

    $(function () {
        // 绑定事件

        // 非活动页码，绑定点击事件
        $("li.page-item:not(.previous, .next, .ellipsis, .active)").click(function () {
            var pageNo = $(this).find("a").text().trim();
            specifyPageQuery(pageNo);
        });

        // 上一页
        $("li.page-item.previous").click(function () {
            var activePageNo = parseInt($("li.page-item.active").find("a").text().trim());
            if (activePageNo > 1) {
                specifyPageQuery(activePageNo - 1);
            }
        });

        // 下一页
        $("li.page-item.next").click(function () {
            var activePageNo = parseInt($("li.page-item.active").find("a").text().trim());
            if (activePageNo < ${requestScope.page.pageTotal} && activePageNo > 0) {
                specifyPageQuery(activePageNo + 1);
            }
        });

        // 输入页码，跳转到指定页码
        $("button[name='jump-page']").click(function () {
            var page_no = $("input[name='input_page_number']").val().trim();
            specifyPageQuery(page_no);
        });

        // 选择 x条/每页
        $(".btn-group .dropdown-menu a").click(function () {
            var _selector = $(".btn-group button");
            var page_size = _selector.attr("value").trim();
            var new_page_size = $(this).attr("value").trim();
            if (new_page_size === page_size) {
                return;
            }
            _selector.attr("value", new_page_size);
            // 显示第一页
            specifyPageQuery(1);
        });
    });
</script>