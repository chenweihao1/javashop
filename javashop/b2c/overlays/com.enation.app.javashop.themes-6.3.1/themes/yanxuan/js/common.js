$(function() {
    // 绑定 超链接
    $(document).on('click', '.tap', function () {
        var _href = $(this).attr('data-href') || $(this).attr('href');
        _href && (location.href = _href);
        return false
    });
    //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
    $(function () {
        $(window).scroll(function(){
            if ($(window).scrollTop()>100){
                $("#back-to-top").show(500);
            }
            else
            {
                $("#back-to-top").hide(500);
            }
        });

        //当点击跳转链接后，回到页面顶部位置
        $("#back-to-top").click(function(){
            //$('body,html').animate({scrollTop:0},1000);
            if ($('html').scrollTop()) {
                $('html').animate({ scrollTop: 0 }, 500);
                return false;
            }
            $('body').animate({ scrollTop: 0 }, 500);
            return false;
        });
    });
})
