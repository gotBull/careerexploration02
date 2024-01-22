$( function() {
    // 可拖曳的Home鍵
    $( "#dragImgH" ).draggable($(".contentW").hide());

    $("#dropG").droppable({
        drop: function (event, ui) {
            // 把LOGO放到圖片上會出現隱藏內容
            $(".contentV").hide();
            $(".contentW").show();
        },
        out: function (event, ui) {
            // 把LOGO移出圖片會恢復原狀
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
        }, 250); // 動畫的持續時間
    }

    function switchToPreviousGroup() {
        $(".contentW > div").hide();
        currentIndex = (currentIndex - 1 + totalGroups) % totalGroups;
        $(".contentW > div:eq(" + currentIndex + ")").css({
            'margin-left': -containerWidth
        }).show().animate({
            'margin-left': 0
        }, 250); //動畫的持續時間
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