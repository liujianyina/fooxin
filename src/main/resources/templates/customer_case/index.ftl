<!DOCTYPE html>
<html>
<head>
<#include "../_header.ftl">
    <title>客户案例</title>
</head>

<body>
<#include "../_top.ftl">
<div class="toppic">
    <div class="am-container-1">
        <div class="toppic-title left">
            <i class="am-icon-briefcase toppic-title-i"></i>
            <span class="toppic-title-span">客户案例</span>
            <p>Customer Case</p>
        </div>
        <div class="right toppic-progress">
            <span><a href="/index" class="w-white">首页</a></span>
            <i class=" am-icon-arrow-circle-right w-white"></i>
            <span><a href="/customer_case/index" class="w-white">客户案例</a></span>
        </div>
    </div>
</div>

<div class="am-container-1">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-1
  am-avg-md-3 am-avg-lg-4 am-gallery-bordered customer-case-ul" data-am-gallery="{  }">
    <#list cases as c>
        <li>
            <div class="am-gallery-item">
                <a href="case-inform.html" class="">
                    <div class="customer-case-img">
                        <img src="${c.imgUrl}"/>
                    </div>
                    <h3 class="am-gallery-title">${c.title}</h3>
                    <div class="am-gallery-desc gallery-words">
                        ${c.content}
                    </div>
                </a>
            </div>
        </li>
    </#list>
    </ul>
</div>
<div class="part-all gray-li">
    <div class="customer  am-container-1">
        <div class="part-title">
            <i class="am-icon-users part-title-i"></i>
            <span class="part-title-span">服务客户</span>
            <p>Serve Customers</p>
        </div>

        <div class="am-slider am-slider-default am-slider-carousel part-all"
             data-am-flexslider="{itemWidth:150, itemMargin: 5, slideshow: false}"
             style="  background-color: #f0eeed; box-shadow:none;">
            <ul class="am-slides">
                <li><img src="/static/img/ptn4.png"/></li>
                <li><img src="/static/img/ptn5.png"/></li>
                <li><img src="/static/img/ptn6.png"/></li>
                <li><img src="/static/img/ptn7.png"/></li>
                <li><img src="/static/img/ptn8.png"/></li>
                <li><img src="/static/img/ptn4.png"/></li>
                <li><img src="/static/img/ptn5.png"/></li>
                <li><img src="/static/img/ptn6.png"/></li>
                <li><img src="/static/img/ptn7.png"/></li>
                <li><img src="/static/img/ptn8.png"/></li>
            </ul>
        </div>
    </div>
</div>

<#include "../_footer.ftl">
</body>
</html>