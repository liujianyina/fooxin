<!DOCTYPE html>
<html>
<head>
<#include "../_header.ftl" />
</head>
<body>
<#include "../_top.ftl">
<div class="toppic">
    <div class="am-container-1">
        <div class="toppic-title left">
            <i class="am-icon-lightbulb-o toppic-title-i"></i>
            <span class="toppic-title-span">解决方案</span>
            <p>Solutions</p>
        </div>
        <div class="right toppic-progress">
            <span><a href="/index" class="w-white">首页</a></span>
            <i class=" am-icon-arrow-circle-right w-white"></i>
            <span><a href="/solutions/index" class="w-white">解决方案</a></span>
        </div>
    </div>
</div>

<div data-am-widget="tabs" class="am-tabs am-tabs-d2 ">

    <ul class="am-tabs-nav am-cf solutions-tabs-ul ">
        <li class="am-active solutions-tabs-ul-li1">
            <a href="[data-tab-panel-0]"><i class=" am-icon-desktop"></i><span>网站解决方案</span></a>
        </li>
        <li class="solutions-tabs-ul-li2">
            <a href="[data-tab-panel-1]"><i class=" am-icon-mobile-phone mobile-phone"></i><span>解决方案</span></a>
        </li>
        <li class="solutions-tabs-ul-li3">
            <a href="[data-tab-panel-2]"><i class=" am-icon-desktop"></i><span>网站解决方案</span></a>
        </li>
        <li class="solutions-tabs-ul-li4">
            <a href="[data-tab-panel-3]"><i class=" am-icon-mobile-phone mobile-phone"></i><span>解决方案</span></a>
        </li>
    </ul>

    <div class="am-tabs-bd solutions-tabs-content ">
        <div data-tab-panel-0 class="am-tab-panel am-active">
            <ul class=" solutions-content-ul">
            <#list web as w>
                <li class="am-u-sm-12 am-u-md-6 am-u-lg-12">
                    <a href="solutions-inform.html">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 solution-tabs-img">
                            <img src="${w.imgUrl}"/>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-9 solution-tabs-words">
                            <h5>${w.title}</h5>
                            <p>${w.introduction}</p>
                        </div>
                    </a>
                </li>
            </#list>
                <div class="clear"></div>
            </ul>
        </div>
        <div data-tab-panel-1 class="am-tab-panel ">
            <ul class="am-container-1 solutions-content-ul">
            <#list pc as w>
                <li class="am-u-sm-12 am-u-md-6 am-u-lg-12">
                    <a href="solutions-inform.html">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 solution-tabs-img">
                            <img src="${w.imgUrl}"/>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-9 solution-tabs-words">
                            <h5>${w.title}</h5>
                            <p>${w.introduction}</p>
                        </div>
                    </a>
                </li>
            </#list>
            </ul>
        </div>
        <div data-tab-panel-2 class="am-tab-panel ">
            <ul class="am-container-1 solutions-content-ul">
            <#list mobile as w>
                <li class="am-u-sm-12 am-u-md-6 am-u-lg-12">
                    <a href="solutions-inform.html">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 solution-tabs-img">
                            <img src="${w.imgUrl}"/>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-9 solution-tabs-words">
                            <h5>${w.title}</h5>
                            <p>${w.introduction}</p>
                        </div>
                    </a>
                </li>
            </#list>
            </ul>
        </div>
        <div data-tab-panel-3 class="am-tab-panel ">
            <ul class="am-container-1 solutions-content-ul">
            <#list other as w>
                <li class="am-u-sm-12 am-u-md-6 am-u-lg-12">
                    <a href="solutions-inform.html">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 solution-tabs-img">
                            <img src="${w.imgUrl}"/>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-9 solution-tabs-words">
                            <h5>${w.title}</h5>
                            <p>${w.introduction}</p>
                        </div>
                    </a>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>