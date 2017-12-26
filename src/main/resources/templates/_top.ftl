<header class="am-topbar header">
    <div class="am-container-1">
        <a href="/index">
            <div class="left hw-logo">
                <img src="/static/img/logo.png"/>
            </div>
        </a>
        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                data-am-collapse="{target: '#doc-topbar-collapse'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse right" id="doc-topbar-collapse">

            <div class=" am-topbar-left am-form-inline am-topbar-right" role="search">
                <ul class="am-nav am-nav-pills am-topbar-nav hw-menu" id="menu">
                    <li>
                        <a href="/index">首页</a>
                    </li>
                    <li>
                        <a href="solutions.html">解决方案</a>
                    </li>
                    <li>
                        <a href="product-show.html">产品展示 </a>
                    </li>
                    <li>
                        <a href="customer-case.html">客户案例</a>
                    </li>
                    <li>
                        <a href="service-center.html">服务中心 </a>
                    </li>
                    <li>
                        <a href="/news/index">新闻动态 </a>
                    </li>
                    <li>
                        <a href="about-us.html">关于我们</a>
                    </li>
                    <li>
                        <a href="recruit.html">招贤纳士 </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        /**
         * url选中变化
         */
        $(function () {
            /**
             * 当前url
             * @type {string}
             */
            var current_url = window.location.pathname;
            /**
             * 当前选中的元素
             * @type {*|jQuery|HTMLElement}
             */
            var current_a = $("#menu a[href='" + current_url + "']");

            var sclass = $(current_a.parent()).attr("class");
            $(current_a.parent()).attr("class", sclass + " hw-menu-active");
        });
    </script>
</header>