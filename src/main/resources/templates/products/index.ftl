<!DOCTYPE html>
<html>
<head>
<#include "../_header.ftl">
    <title>招贤纳士</title>
</head>

<body>
<#include "../_top.ftl">

<div class="toppic">
    <div class="am-container-1">
        <div class="toppic-title left">
            <i class="am-icon-dropbox toppic-title-i"></i>
            <span class="toppic-title-span">产品展示</span>
            <p>Product Show</p>
        </div>
        <div class="right toppic-progress">
            <span><a href="/index" class="w-white">首页</a></span>
            <i class=" am-icon-arrow-circle-right w-white"></i>
            <span><a href="/product/index" class="w-white">产品展示</a></span>
        </div>
    </div>
</div>

<div>
    <ul class=" product-show-ul">
    <#assign num = 0.0>
    <#list  products as p>
        <#if num % 2 == 0>
            <li>
                <div class="product-content">
                    <div class="left am-u-sm-12 am-u-md-6 am-u-lg-6 product-content-left">
                        <div class="product-show-title">
                            <h3>${p.title}</h3>
                            <span>${p.smallTitle}</span>
                        </div>

                        <div class="product-show-content">
                            <div class="product-add">
                                <span>查看地址：</span>
                                <div>
                                    <a href="#">${p.viewAddr}</a>
                                </div>
                                <i class="am-icon-dribbble"></i>
                            </div>
                            <div class="product-intro">
                                <span>详情介绍：</span>
                                <div>
                                    <p>${p.detals}</p>
                                </div>
                                <i class="am-icon-tasks"></i>
                            </div>
                        </div>
                    </div>
                    <div class="right am-u-sm-12 am-u-md-6 am-u-lg-6 product-content-right">
                        <img class="product-img" src="${p.imgUrl}"/>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        <#else>
            <li class="gray-li">
                <div class="product-content">
                    <div class="left am-u-sm-12 am-u-md-6 am-u-lg-6 product-content-left">
                        <img class="product-img" src="${p.imgUrl}" />

                    </div>
                    <div class="right am-u-sm-12 am-u-md-6 am-u-lg-6 product-content-right">
                        <div class="product-show-title">
                            <h3>${p.title}</h3>
                            <span>${p.smallTitle}</span>
                        </div>

                        <div class="product-show-content">
                            <div class="product-add">
                                <span>查看地址：</span>
                                <div>
                                    <a href="#">${p.viewAddr}</a>
                                </div>
                                <i class="am-icon-dribbble"></i>
                            </div>
                            <div class="product-intro">
                                <span>详情介绍：</span>
                                <div>
                                    <p>${p.detals}</p>
                                </div>
                                <i class="am-icon-tasks"></i>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        </#if>
        <#assign num = num + 1>
    </#list>
        <div class="clear"></div>
    </ul>
</div>
</div>
<#include "../_footer.ftl">

</body>
</html>