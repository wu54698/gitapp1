refreshPage(1, 0);
changePage({ pageNum: 0, pageSize: 10 });
var ListData = [];

var globalMember = {};
var tiezeList = [];
var selectTiziItem = {};
var tieList = [];


var selectMen = selectTiziItem.member && selectTiziItem.member.accountnumber || "";



/**
 */
function showMessage(message, type) {
    let messageJQ= $("<div class='showMessage'>" + message + "</div>");
    if (type == 0) {
        messageJQ.addClass("showMessageError");
    } else if (type == 1) {
        messageJQ.addClass("showMessageSuccess");
    }
    // 先将原始隐藏，然后添加到页面，最后以400毫秒的速度下拉显示出来
    messageJQ.hide().appendTo("body").slideDown(400);
    // 4秒之后自动删除生成的元素
    window.setTimeout(function() {
        messageJQ.show().slideUp(400, function() {
            messageJQ.remove();
        })
    }, 4000);
}

var categoryActive = 1;
var categoryList = [];
getCategory().then(res => {
    const { data } = res;
    categoryList = data;
    refreshcategory(data);
})

function refreshcategory(data) {

    let str = "";
    data && data.forEach(item => {
        str += `<div onclick="categoryClick(${item.id})" id="${item.id}" class="cataItem ${categoryActive == item.id ? 'active' : ''}">${item.name}</div>`;

    })
    $('#catetrys').html(str)
}
function categoryClick(id) {
    categoryActive = id;
    refreshcategory(categoryList);

    changePage({pageNum: 0, pageSize: 10, categoryId: id})
}
function changePage({ pageNum, pageSize, best, likeCountEnd, likeCountStart, categoryId, title }) {
  getList({
    pageNum,
    pageSize,
    best,
    likeCountEnd,
    likeCountStart,
      categoryId,
      title,
    callBack: (data) => {
      const { content, totalElements, totalPages } = data;
      ListData = content;
      xrList(content);
      refreshPage(totalPages, totalElements, (num) => {
        changePage({ pageNum: num, pageSize, best });
      });
    },
  });
}

var TYPE_SIMPLE = false;
function xrList(content) {
    $('#tab-list').html(``);

    if (!content.length) {
      $('#tab-list').html(`<div class="empty">暂无数据</div>`);
    }
    var str = ``;
    for(var i = 0; i < content.length; i++) {
        var item = content[i];
        var { floorCount, title, question, bodySimple, image, interactiveCount, popularityCount, lastReplyTime, lastReplay, uuid, thread } = item;
        var imgurl = `/iSpanCar/script/img/${question}.png`;
        var img =  question != '空白' ? "<img class='b-list__img lazyloaded' src ="+ imgurl + "/>" : '';
        str += `
        <tr class="b-list__row b-list-item b-imglist-item" id=${uuid+'|'+thread.category.id}>
        <td class="b-list__summary">
          <a name="687636"></a>
          <p class="b-list__summary__sort">
            <span data-subbsn="4">${thread.category.name}</span>
          </p>
          <span class="b-list__summary__gp b-gp b-gp--normal">${floorCount}</span>
        </td>
        <td class="b-list__main">
          <a
            data-gtm="B頁文章列表-縮圖"
          >
            <div class='b-list__img lazyloaded' id="list_img">
            
            ${
            (image && image != 'null') ? image : img
            }
            </div>
            <div class="imglist-text">
              <div class="b-list__tile">
                <p
                  data-gtm="B頁文章列表-縮圖"
                  href="C.php?bsn=23805&amp;snA=687636&amp;tnum=3&amp;bPage=2"
                  class="b-list__main__title"
                >
                  ${question && `【${question}】`||''}${title}
                </p>
              </div>
              <p class="b-list__brief">
                ${bodySimple}
              </p>
            </div>
          </a>
        </td>
        <td class="b-list__count">
          <p class="b-list__count__number">
            <span title="互動：9">${interactiveCount}</span>/
            <span title="人氣：">${popularityCount}</span>
          </p>
          <p class="b-list__count__user">
            <a
              href="https://home.gamer.com.tw/foreverHei"
              target="_blank"
              ></a
            >
          </p>
        </td>
        <td class="b-list__time">
          <p class="b-list__time__edittime">
            <a
              data-gtm="B頁文章列表-縮圖"
              title="觀看最新回覆文章"
              >${lastReplyTime || ''}</a
            >
          </p>
          <p class="b-list__time__user">
            <a
              >${lastReplay && lastReplay.accountnumber || ''}</a
            >
          </p>
        </td>
      </tr>
        `

    }

    $('#tab-list').html(str)
    $('#tab-list tr').click(function() {
        if(!this.id) {
            return;
        }
        const id = this.id.split('|')[0];
        categoryId = this.id.split('|')[1];
        uuidglobal = id;
        document.getElementById("BH-wrapper").style.display = "none";
        document.getElementById("mainNav").style.display = "none";
        document.getElementsByClassName("detailshow")[0].style.display =
          "block";
          getDetail(id);
      })
}
let uuidglobal = "";

let categoryId = "";

function getDetail(uuid) {
    gettieDetail({
        uuid,
        data: {
            pageNum: 0,
            pageSize: 1000,
        },
    }).then(res => {
        const { code, msg, data } = res;
        const { content } = data || {};
        xrtiezeDetail(content || []);

        if (code == 401) {
            Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
        }
    })
}

let selectPoId = selectTiziItem.id;
function replyToFloor(e, id, name, i) {
    selectPoId = id;
    selectMen = name;
    $(`#lyenter${i}`).html(`@`+ e + ' ')
}
function throttle(fn, interval) {
    var timer;
    return function() {
        if (timer) {
            return false;
        }
        timer = setTimeout(function() {
            console.log("throttle---");
            fn.apply();
            clearTimeout(timer);
            timer = null;
        }, interval)}
}

function xrhfinput(i) {
    const jq$ = $;

    document
        .getElementById(`lyenter${i}`)
        .addEventListener("keydown", (e) => {
            if (e.keyCode == 13) {
                const tiezeItem = tiezeList[i];
                var content = $(`#lyenter${i}`).val();
                console.log("回车监听");
                content = jq$.emojiParse({
                    content: content,
                    emojis: [
                        { type: "qq", path: "/iSpanCar/script/img/qq/", code: ":" },
                        { path: "/iSpanCar/script/img/tieba/", code: ";", type: "tieba" },
                        { path: "/iSpanCar/script/img/emoji/", code: ",", type: "emoji" },
                    ],
                });



                const data = {
                    content,
                    replyMember: {
                        accountnumber: tiezeItem.member.accountnumber
                    },
                    post: {
                        id:  tiezeItem.id,
                    },
                };
                sendFloorMsg(data).then(res => {
                    if (res.code == 200) {
                        getDetail(uuidglobal);
                        $(`#lyenter${i}`).val("");
                    } else if (res.code == 401) {
                        Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
                    }

                })
            }
        });



    $.Lemoji({
        emojiInput: "#lyenter" + i,
        emojiBtn: "#emojibtn" + i,
        position: "LEFTBOTTOM",
        length: 8,
        emojis: {
            qq: { path: "/iSpanCar/script/img/qq/", code: ":", name: "QQ表情" },
            tieba: { path: "/iSpanCar/script/img/tieba", code: ";", name: "贴吧表情" },
            emoji: { path: "/iSpanCar/script/img/emoji", code: ",", name: "Emoji表情" },
        },
    });
}
function xrtiezeDetail(content) {
    if (!content.length) {
        return;
    }
    tiezeList = content;
    let str = '';
    for(let i = 0; i < content.length; i++) {
        const item = content[i];
        console.log('详情', item);
        const { body, member, title, question, time, floorCount, postMessages, likeCount, disliked, liked, disLikeCount, thread } = item;
        if (floorCount == 1) {
            globalMember = member;
        }
        const { accountnumber, memberName } = member;

        let commentStr = "";

        for(let j = 0; j < postMessages.length; j++) {
            const commItem = postMessages[j];

            commentStr += `             <div
                class="c-reply__item"
                id="Commendcontent_3372715"
                name="comment_parent"
                data-comment='{"bsn":23805,"snB":4020110,"sn":3372715,"isLogin":true,"deletable":false,"editable":false,"content":"\u597d\u7684 \u611f\u8b1d1.2\u6a13\u5927\u5927"}'
              >
                <div>
                  <button
                    type="button"
                    class="more tippy-reply-menu"
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-18"
                  >
                    <i class="material-icons"></i>
                  </button>
                  <a class="reply-avatar user--sm" href="javascript:;"
                    ><img
                      class="gamercard lazyloaded"
                      data-src="https://avatar2.bahamut.com.tw/avataruserpic/j/o/john19945646/john19945646_s.png?v=1674486021"
                      data-gamercard-userid="john19945646"
                      data-tooltipped=""
                      aria-describedby="tippy-tooltip-2"
                      src="https://avatar2.bahamut.com.tw/avataruserpic/j/o/john19945646/john19945646_s.png?v=1674486021"
                  /></a>
                  
                  <div class="reply-content">
                    <a class="reply-content__user" href="javascript:;">${commItem.member.accountnumber}</a>
                    <article class="reply-content__article c-article">
                      <span class="comment_content" data-formatted="yes"
                        >${commItem.content}</span
                      >
                    </article>

                    <div class="reply-content__footer">
                      <div
                        class="edittime"
                        style="margin-right: 6px"
                        name="comment_floor"
                      >
                        B4
                      </div>
                      <div
                        class="edittime"
                        data-tooltipped=""
                        aria-describedby="tippy-tooltip-41"
                        data-original-title="留言時間 2023-01-23 23:36:36"
                      >
                        ${commItem.time}
                      </div>
                      <div class="buttonbar">
                        <button
                          type="button"
                          onclick="commentGp(1, ${commItem.id});"
                          class="gp ${commItem.liked ? 'is-highlight' : ''}"
                          title="推一個！"
                        >
                          <i class="material-icons"></i>
                        </button>
                        <a data-gp="0" href="javascript:;" class="gp-count"></a>
                        <button
                          type="button"
                          onclick="commentGp(2, ${commItem.id});"
                          class="bp ${commItem.disliked ? 'is-highlight' : ''}"
                          title="我要噓…"
                        >
                          <i class="material-icons"></i>
                        </button>
                        <a data-bp="0" href="javascript:;" class="bp-count"></a>
                        <button
                          class="tag"
                          type="button"
                          onclick="replyToFloor(${member.accountnumber}, ${commItem.id}, ${commItem.member.accountnumber}, ${i});"
                        >
                          回覆
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              `;
        }




        str += `
           <section class="c-section" id="post_4020110">
        <div class="c-section__side">
          <div class="c-user">
            <a
              class="c-user__avatar gamercard"
              data-gamercard-userid="john19945646"
              data-tooltipped=""
              aria-describedby="tippy-tooltip-1"
            >
              <img
                class="lazyloaded"
                data-src="https://avatar2.bahamut.com.tw/avataruserpic/j/o/john19945646/john19945646.png?v=1674486021"
                alt=""
                id="avatar_fpath4020110"
                src="https://avatar2.bahamut.com.tw/avataruserpic/j/o/john19945646/john19945646.png?v=1674486021"
              />
            </a>
            <div
              class="c-user__honor"
              data-userid="john19945646"
              data-honors=""
            ></div>
          </div>
        </div>
        <div class="c-section__main c-post">
          <div class="c-post__header">
            <h1 class="c-post__header__title">${question && '【'+question+'】'}${title}</h1>
            <div class="tag-category">
              <a href="javascript:;">
                <div class="tag-category_item">${thread.category.name}</div>
              </a>
            </div>
            <div class="c-post__header__author">
              <a
                href="javascript:;"
                class="floor tippy-gpbp"
                data-floor="1"
                data-tooltipped=""
                aria-describedby="tippy-tooltip-26"
                data-original-title="只看此樓"
                >${floorCount == 1 ? '樓主' : (floorCount + '楼')}</a
              >
              <a href="javascript:;" class="username">${memberName || '未知'}</a>
              <a href="javascript:;" class="userid">${accountnumber}</a>
              <div class="postcount">
                <span class="postgp">GP<span>1</span></span>
                <span class="postbp">BP<span>-</span></span>
              </div>
            </div>
            <div class="c-post__header__info">
              <a
                href="javascript:;"
                class="edittime tippy-post-info"
                data-hideip="180.176.40.xxx"
                data-mtime="2023-01-23 23:16:32"
                data-area="C"
                data-tooltipped=""
                aria-describedby="tippy-tooltip-16"
                >${moment(time).format('YYYY-MM-DD HH:mm:ss')}</a
              >
            </div>
          </div>
          <div class="c-post__body">
            <article class="c-article FM-P2" id="cf4020110">
              <div class="c-article__content">
               ${body}
                <div></div>
              </div>
            </article>

            <div class="c-post__body__buttonbar" style="">
              <div>
                <div class="gp" style="">
                  <button
                    class="ef-btn ef-firework tippy-gpbp ${liked ? 'is-active': ''}"
                    onclick="addgpbp(1, ${item.id})"
                    type="button"
                    id="gp_4020110"
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-27"
                    data-original-title="GP 讓勇者獲得能量! <br>1 GP＝- 2 巴幣，原作者可分紅"
                  >
                    <div class="ef-btn__effect">
                      <i class="icon material-icons"></i>
                      <div class="effect-group">
                        <span class="effect"></span>
                        <span class="effect"></span>
                        <span class="effect"></span>
                        <span class="effect"></span>
                        <span class="effect"></span>
                      </div>
                    </div>
                  </button>
                  <a
                    class="count tippy-gpbp-list"
                    href="javascript:;"
                    data-tippy='{"bsn":23805,"sn":4020110,"type":1}'
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-37"
                    >${likeCount}</a
                  >
                </div>
                <div class="bp" style="">
                  <button
                    class="ef-btn ef-bounce tippy-gpbp ${disliked ? 'is-active': ''}"
                    onclick="addgpbp(2, ${item.id})"
                    type="button"
                    id="bp_4020110"
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-28"
                    data-original-title="BP 讓文章削弱光芒! <br>1 BP＝- 2 巴幣"
                  >
                    <div class="ef-btn__effect">
                      <i class="icon material-icons"></i>
                    </div>
                  </button>
                  <a
                    class="count tippy-gpbp-list"
                    href="javascript:;"
                    data-tippy='{"bsn":23805,"sn":4020110,"type":2}'
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-38"
                    >${disLikeCount ?? '-'}</a
                  >
                </div>
              </div>
              <div>
               <!-- <div class="article-footer_right">
                  <a
                    class="article-footer_right-btn"
                    style=""
                    href="javascript:;"
                    onclick="toReply(${item.id})"
                  >
                    <img
                      src="https://i2.bahamut.com.tw/icon/msg_regular.png"
                      data-src="https://i2.bahamut.com.tw/icon/msg_regular.png"
                      data-hover-src="https://i2.bahamut.com.tw/icon/msg_regular_active.png"
                    />
                    <p>回覆</p>
                  </a>
                </div> -->
              </div>
            </div>
          </div>
          <div class="c-post__footer c-reply">
            <div class="c-reply__head nocontent">
            </div>
            <div id="Commendlist_4020110">
 
                ${commentStr}
    
<!--       1111111111111111111111111       -->
            </div>
            <div class="c-reply__editor">
              <a
                class="reply-avatar user--sm"
                href="/home.jsp/home.gamer.com.tw/earth159357"
                ><img
                  src="https://avatar2.bahamut.com.tw/avataruserpic/j/o/john19945646/john19945646_s.png?v=1674486021"
              /></a>
              <div
                class="reply-input"
                data-tooltipped=""
                aria-describedby="tippy-tooltip-35"
                data-original-title="超過85個字了喔～"
              >
                <textarea
                  data-bsn="23805"
                  data-snb="4020110"
                  class="content-edit"
                  placeholder="留言⋯"
                  id="lyenter${i}"
                ></textarea>
                <div class="comment_icon">
                  <a
                    class="gif_box gif_box_emoji"
                    href="javascript:;"
                    id="emojibtn${i}"
                    data-tooltipped=""
                    aria-describedby="tippy-tooltip-51"
                    data-original-title="插入表情符號"
                  >
                    <img
                      title="插入表情符號"
                      src="https://i2.bahamut.com.tw/forum/icons/comment_emoji.svg"
                      onmouseout="this.src='https://i2.bahamut.com.tw/forum/icons/comment_emoji.svg'"
                      onmouseover="this.src='https://i2.bahamut.com.tw/forum/icons/comment_emoji_active.svg'"
                    />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
        `;

    }

    $('#liuyanId').html(str);

    setTimeout(() => {
        for(let k = 0; k <  content.length; k++) {
            xrhfinput(k)
        }
    }, 1000)
}

function posttz(uuid, postid) {
    postDetail({ uuid, postId }).then(res => {
    })
}

function addgpbp(type, id) {
    const data = {
        type: 1,
        liked: type,
        dataId: id,
    };
    likeApi(data).then(res => {
        if (res.code == 200) {
            getDetail(uuidglobal);
        } else if (res.code == 401) {
            Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
        }
    })
}

function commentGp(type, id) {

    const data = {
        type: 2,
        liked: type,
        dataId: id,
    };
    likeApi(data).then(res => {
        if (res.code == 200) {
            getDetail(uuidglobal);
        } else if (res.code == 401) {
            Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
        }
    })
}

function changeType(type) {
    if (type == 1) {
        $('#now_stop_1').attr("class", "now_stop");
        $('#now_stop_2').attr("class", "");
        $('.lazyloaded').css("width", '130px');
    } else {
        $('#now_stop_2').attr("class", "now_stop");
        $('#now_stop_1').attr("class", "");
        $('.lazyloaded').css("width", '0');
    }
}

const dict = {
    5: 20,
    20: 50,
    50: 100,
    100: 200,
    200: 99999,
}
function selectListChange(e) {
    if (!e.value) {
        return;
    }
    changePage({ pageNum: 0, pageSize: 10, likeCountStart:  e.value, likeCountEnd: dict[e.value]});
}

var best = false;
function extractList() {
    best = !best;
    changePage({ pageNum: 0, pageSize: 10, best: best ? best : '' });

}

function darenList() {

}

function quickPost() {

    const html = editor.getHtml();
    const data = {
        "body": html,
        "title": $('#floorTitle').val(),
        "uuid": uuidglobal,
        "category": categoryId
    }
    genTiezi(data).then(res => {
        if (res.code == 200) {
            getDetail(uuidglobal);
            editor.clear();
            $('#floorTitle').val("");
        } else if (res.code == 401) {
            Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
        }

    })
}


function onpublishWZ() {
    const html = editor.getHtml();
    const data = {
        content: html,
        replyMember: selectTiziItem.member,
        post: {
            id: selectTiziItem.id,
        },
    };
    sendFloorMsg(data).then(res => {
        if (res.code == 200) {
            getDetail(uuidglobal);
            onBackDetail();
        } else if (res.code == 401) {
            Swal.fire("未登錄！請先登錄!", "", "error").then(r=>window.location.href = "/login?redirectUrl=/dforum/home");
        }

    })
}