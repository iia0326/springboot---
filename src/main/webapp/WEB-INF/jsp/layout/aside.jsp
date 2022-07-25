<aside class="aside layui-show-md-block layui-hide-sm layui-hide-xs layui-bg-black" id="menu">
    <%--            ${menuList}--%>
    <ul class="layui-nav layui-nav-tree" lay-filter="test" style="width: 100%">
        <c:forEach items="${menuList}" varStatus="status" var="menuFather">
            <li class="layui-nav-item ${status.index==0?'layui-nav-itemed':''}  ">
                <a href="javascript:;">
                    <i class="layui-icon ${menuFather.icon}"></i>
                    ${menuFather.name}
                </a>
                <dl class="layui-nav-child">
                    <c:forEach items="${menuFather.children}" var="menuChild" varStatus="childStatus">
                        <dd class="menu-item ${childStatus.index == 0&&status.index==0?'layui-this':''}" data-id="${menuChild.id}">
                            <a href="${menuChild.url}" target="inner-page"  onclick="handleChangeTab(${menuFather.id},${menuChild.id})">
                                &nbsp;&nbsp;
                                <i class="layui-icon ${menuChild.icon}"></i>
                                ${menuChild.name}
                            </a>
                        </dd>
                    </c:forEach>
                </dl>
            </li>
            <li class="layui-menu-item-divider"></li>
        </c:forEach>
    </ul>
</aside>
