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
            <i class="am-icon-paper-plane toppic-title-i"></i>
            <span class="toppic-title-span">招贤纳士</span>
            <p>Recruit</p>
        </div>
        <div class="right toppic-progress">
            <span><a href="/index" class="w-white">首页</a></span>
            <i class=" am-icon-arrow-circle-right w-white"></i>
            <span><a href="/recruit/index" class="w-white">招贤纳士</a></span>
        </div>
    </div>
</div>
<div>
    <ul class=" product-show-ul">
    <#assign num = 0.0>
    <#list  recruits as r>
        <#if num % 2 == 0>
            <li>
                <div class="product-content">
                    <div class="left am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-left">
                        <img class="product-img" src="${r.imgUrl}"/>
                    </div>
                    <div class="right am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-right">

                        <div class="product-show-title">
                            <span>${r.title}</span>
                        </div>

                        <div class="product-show-content">
                            <div class="product-add">
                                <span>岗位描述：</span>
                                <div>
                                ${r.description}
                                </div>
                            </div>
                            <div class="product-add">
                                <span>任职资格：</span>
                                <div>
                                ${r.qualifications}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        <#else>
            <li class="gray-li">
                <div class="product-content">
                    <div class="left am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-left">
                        <div class="product-show-title">
                            <span>${r.title}</span>
                        </div>

                        <div class="product-show-content">
                            <div class="product-add">
                                <span>岗位描述：</span>
                                <div>
                                ${r.description}
                                </div>
                            </div>
                            <div class="product-add">
                                <span>任职资格：</span>
                                <div>
                                ${r.qualifications}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="right am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-right">
                        <img class="product-img" src="${r.imgUrl}"/>
                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        </#if>
        <#assign num = num + 1>
    </#list>
    </ul>
</div>

<div class=" gray-li">
    <div class="am-container-1">
        <div class="part-title part-title-mar">
            <i class="am-icon-users part-title-i"></i>
            <span class="part-title-span">优厚待遇</span>
            <p>Good Treatments</p>
        </div>
    </div>
    <div data-am-widget="tabs" class="am-tabs am-tabs-d2 ">

        <ul class="am-tabs-nav am-cf daiyu-title-ul ">
            <li class="am-active ">
                <a href="[data-tab-panel-0]"><span class="w-white"> 福利待遇</span></a>
            </li>
            <li class="">
                <a href="[data-tab-panel-1]"><span class="w-white">薪资待遇</span></a>
            </li>

        </ul>

        <div class="am-tabs-bd daiyu-content ">
            <div data-tab-panel-0 class="am-tab-panel am-active">
                <div class=" daiyu-content-1">
                    <p>1.享有每周双休</p>
                    <p>2.年终奖</p>
                    <p>3.项目奖金/产品提成</p>
                    <p>4.调休</p>
                    <p>5.五险（养老保险、医疗保险、失业保险、工伤保险和生育保险）</p>
                    <p>6.出差补贴（一线城市100/天，二线城市60/天），出差包住</p>
                    <p>7. 公司每1-2月举行聚餐 </p>
                    <p>8. 每天7小时工作时间 早上9：00-12：00下午1：30-5:30</p>
                </div>

            </div>
            <div data-tab-panel-1 class="am-tab-panel ">
                <div class=" daiyu-content-1">
                    <p>1.安卓开发工程师：4000元-7000元</p>
                    <p>2.软件测试人员：3000元-5000元</p>
                    <p>3.JAVA软件开发工程师：4000元-6000元</p>
                </div>
            </div>

        </div>
    </div>
</div>

<#include "../_footer.ftl">

</body>
</html>