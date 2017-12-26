$(function () {

    var ul = $('#test01');

    $.ajax({
        url: "/recruit/recruit_list",
        type: "post",
        data: {
            page: 1,
            size: 10
        },
        success: function (result) {
            console.log(result);

            var data = result['data'];
            for (var i = 0; i < data.length; i++) {
                var temp = data[i];
                var imgUrl = temp['imgUrl'];
                var title = temp['title'];
                var description = temp['description'];
                var qualifications = temp['qualifications'];

                var li

                if (i % 2 == 0) {
                    li = $("<li></li>");
                } else {
                    li = $("<li class='gray-li'></li>");
                }
                var div = $("<div class='product-content'></div>");

                var img = $("<div class='left am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-left'><img src='" + imgUrl + "'/></div>");
                var div2 = $("<div class='right am-u-sm-12 am-u-md-6 am-u-lg-6 recruit-right'>" +
                    "<div class='product-show-title'><span>" + title + "</span></div>" +
                    "</div>");

                var div3 = $("<div class='product-show-content'>" +
                    "<div class='product-add'>" +
                    "<span>岗位描述：</span>" +
                    "<div>" + description +
                    "</div>" +
                    "</div>" +
                    "<span>任职要求：</span>" +
                    "<div>" + qualifications +
                    "</div>" +
                    "</div>" +
                    "</div>");


                $(img).appendTo(div);
                $(div2).appendTo(div);
                $(div3).appendTo(div);
                $("<div class='clear'></div>").appendTo(div);

                $(div).appendTo(li);

                $(li).appendTo(ul);


            }


        }


    });


});