$( function() {
    // 可拖曳的Home鍵
    $( "#dragImgH" ).draggable($(".contentW").hide());
    //放到圖片內改變旁邊的文章內容
    $("#dropG").droppable({
        drop: function (event, ui) {
            // 在這裡你可以根據需要改變文章結構和內容
            $(".contentV").hide();
            $(".contentW").show();
        },
        out: function (event, ui) {
            // 在這裡你可以根據需要恢復原本的文章結構和內容
            $(".contentW").hide();
            $(".contentV").show();
        }
    });
});
//輪播的內容
$(document).ready(function() {
    var currentIndex = 0;
    var totalGroups = $(".contentW > div").length;
    var containerWidth = $(".contentW").width(); //容器寬度
    $(".contentW > div").hide();
    $(".contentW > div:first-of-type").show();

    function switchToNextGroup() {
        $(".contentW > div").hide();
        currentIndex = (currentIndex + 1) % totalGroups;
        $(".contentW > div:eq(" + currentIndex + ")").css({
            'margin-left': containerWidth
        }).show().animate({
            'margin-left': 0
        }, 250); // 500 是動畫的持續時間，可以根據需要調整
    }

    function switchToPreviousGroup() {
        $(".contentW > div").hide();
        currentIndex = (currentIndex - 1 + totalGroups) % totalGroups;
        $(".contentW > div:eq(" + currentIndex + ")").css({
            'margin-left': -containerWidth
        }).show().animate({
            'margin-left': 0
        }, 250); // 500 是動畫的持續時間，可以根據需要調整
    }

    $("#switch-to-next").click(function() {
        switchToNextGroup();
    });

    $("#switch-to-previous").click(function() {
        switchToPreviousGroup();
    });
    //自動輪播的功能, 會跟按鈕功能衝到
    // setInterval(function() {
    //     switchToNextGroup();
    // }, 5000);
});