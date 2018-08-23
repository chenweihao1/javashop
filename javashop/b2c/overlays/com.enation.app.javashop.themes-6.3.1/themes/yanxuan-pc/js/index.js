$(function () {
    var mySwiper = new Swiper ('.index-banner .swiper-container', {
        direction: 'horizontal',
        loop: true,

        // 如果需要分页器
        pagination: {
            el: '.index-banner .swiper-pagination',
        },

        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.index-banner .swiper-button-next',
            prevEl: '.index-banner .swiper-button-prev',
        },


    })
    var swiper2 = new Swiper('.index-ad-floor .swiper-container', {
        slidesPerView: 4,
        spaceBetween: 30,
        slidesPerGroup: 4,
        loop: true,
        loopFillGroupWithBlank: true,
        pagination: {
            el: '.index-ad-floor .swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.index-ad-floor .swiper-button-next',
            prevEl: '.index-ad-floor .swiper-button-prev',
        },
    });
    // 大家都在说

    var swiper = new Swiper('.everybady-says-content .swiper-container', {
        slidesPerView: 3,
        centeredSlides: true,
        spaceBetween: 15,
        autoplay:{
            delay: 1500,
        },
        loop: true,
        navigation: {
            nextEl: '.everybady-says-content .swiper-button-next',
            prevEl: '.everybady-says-content .swiper-button-prev'
        },
    });

// 悬停出现小菜单

    $(document).on('hover','.jujia',function () {
        $('.hover-menu-box').show();
        $(this).siblings().removeClass('selected-li');
        $(this).addClass('selected-li')
    })
    $(document).on('mouseleave','.jujia',function () {
        $('.hover-menu-box').hide();
        $(this).removeClass('selected-li')
    })
    $(document).on('hover','.yinshi',function () {
        $('.hover-menu-box2').show();
        $(this).siblings().removeClass('selected-li');
        $(this).addClass('selected-li')
    })
    $(document).on('mouseleave','.yinshi',function () {
        $('.hover-menu-box2').hide();
        $(this).removeClass('selected-li')
    })

    // 获取 鼠标滚轴滚动高度
    $(window).bind("scroll", function(){
        var scrollT = $(this).scrollTop(); // 当前窗口的滚动距离
        //alert( scrollT)
        if( scrollT >= 245){
            $('.yanxuan-menu').addClass('fixed-box');
        }else {
            $('.yanxuan-menu').removeClass('fixed-box');
        }

    });
})
