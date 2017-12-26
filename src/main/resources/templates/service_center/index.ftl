<!DOCTYPE html>
<html>
<head>
<#include "../_header.ftl">
    <title>服务中心</title>
</head>

<body>
<#include "../_top.ftl">

<div class="toppic">
    <div class="am-container-1">
        <div class="toppic-title left">
            <i class="am-icon-hand-paper-o toppic-title-i"></i>
            <span class="toppic-title-span">服务中心</span>
            <p>Service Center</p>
        </div>
        <div class="right toppic-progress">
            <span><a href="/index" class="w-white">首页</a></span>
            <i class=" am-icon-arrow-circle-right w-white"></i>
            <span><a href="/service_center/index" class="w-white">服务中心</a></span>
        </div>
    </div>
</div>

<div class=" am-container-1">
    <div class="service-center">
        <ul class="service-ul">
        <#list serviceCenters as s>
            <li class="am-u-lg-12 am-u-md-12 am-u-sm-12">
                <div class="am-u-lg-8 am-u-md-8 am-u-sm-12 service-content">
                    <h4 class="w-blue">${s.title}</h4>
                    <p>${s.content}</p>
                </div>
                <div class="am-u-lg-4 am-u-md-4 am-u-sm-12 service-img">
                    <img src="${s.imgUrl}"/>
                </div>
            </li>
        </#list>
        </ul>
    </div>
</div>

<#include "../_footer.ftl">

</body>
</html>