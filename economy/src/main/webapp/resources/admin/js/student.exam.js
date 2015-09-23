//override dialog's title function to allow for HTML titles
$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
    _title: function(title) {
        var $title = this.options.title || '&nbsp;'
        if( ("title_html" in this.options) && this.options.title_html == true )
            title.html($title);
        else title.text($title);
    }
}));

$(".submitExam" ).on('click', function(e) {
    // 提示还有多少题没有回答
    var tip = '确定提交试卷吗？<br />';
    if(problemCount < 50) {
        tip += '你还有' +
            '<strong class="red bigger-130">' + (50-problemCount) + '</strong>' +
            '道题没有回答哦！^_^';
    }
    $('#tip').html(tip);

    e.preventDefault();
    var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
        modal: true,
        title: "<div class='widget-header widget-header-small'>" +
            "<h4 class='smaller'><i class='icon-exclamation-sign'></i> " +
            "确认提交试卷" +
            "</h4></div>",
        title_html: true,
        buttons: [
            {
                text: "取消",
                "class" : "btn btn-xs",
                click: function() {
                    $( this ).dialog( "close" );
                }
            },
            {
                text: "确认",
                "class" : "btn btn-primary btn-xs",
                click: function() {
                    $('form').submit();
                }
            }
        ]
    });
});


$(".exitExam" ).on('click', function(e) {
    // 提示还有多少题没有回答
    var tipExit = '确定退出自考平台吗？<br />';
    if(problemCount < 50) {
        tipExit += '你还没有提交试卷！！！';
    }
    $('#tipExit').html(tipExit);

    e.preventDefault();
    var dialog = $( "#dialog-message-exit" ).removeClass('hide').dialog({
        modal: true,
        title: "<div class='widget-header widget-header-small'>" +
            "<h4 class='smaller'><i class='icon-exclamation-sign'></i> " +
            "确认退出自考平台" +
            "</h4></div>",
        title_html: true,
        buttons: [
            {
                text: "取消",
                "class" : "btn btn-xs",
                click: function() {
                    $( this ).dialog( "close" );
                }
            },
            {
                text: "确认",
                "class" : "btn btn-primary btn-xs",
                click: function() {
                    var url = $('.exitExam').attr('href');
                    window.location.href = url;
                }
            }
        ]
    });
});
//$('[name="subExam"]').on('click', function() {
//    $('form').submit();
//});

var problemCount = 0, problemFinished = {};
// 检测input的是否发生变化
$('input').on('click', function() {
    var $pNo = $(this).attr('pNo'),
        $pType = $(this).attr('pType');
    // 题目没有被做过
    if(!problemFinished[$pNo]) {
        problemFinished[$pNo] = true;
        problemCount ++;
    } else {
        if($pType == 2) {
            var $checkboxChecked = $('input:checkbox[pNo="' + $pNo + '"]:checked');
            if($checkboxChecked.length == 0) {
                problemFinished[$pNo] = false;
                problemCount --;
            }
        } else {
            var $radioChecked = $('input:radio[pNo="' + $pNo + '"]:checked');
            if($radioChecked.length == 0) {
                problemFinished[$pNo] = false;
                problemCount --;
            }
        }
    }
    $('#progress-percent').css('width', (problemCount*2)+'%');
    $('#progress-percent').parent().attr('data-percent', (problemCount*2)+'%');
    $('#progress-number').text(problemCount + '/50');
});

$('#reset-btn').on('click', function() {
    problemCount = 0;
    for(var i = 0;i <= 50; ++i) {
        problemFinished[i] = false;
    }
    $('#progress-percent').css('width', (problemCount*2)+'%');
    $('#progress-percent').parent().attr('data-percent', (problemCount*2)+'%');
    $('#progress-number').text(problemCount + '/50');
});

var minute, sec;
function startExam(examTime) {
    minute = examTime;
    sec = 1;
    countdown();
}
function countdown() {
    if(minute == 0 && sec == 0) {
        $('form').submit();
        return ;
    }
    if(sec == 0) {
        minute = minute-1;
        sec = 60;
    }
    sec = sec - 1;
    if(sec < 10) {
        $('#countdownTime').text(minute + ':0' + sec);
    } else {
        $('#countdownTime').text(minute + ':' + sec);
    }
    window.setTimeout('countdown()', 1000);
}
