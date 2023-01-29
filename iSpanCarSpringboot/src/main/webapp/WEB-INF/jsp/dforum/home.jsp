<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <!-- 必須的 meta 標籤 -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="stylesheet" href="/iSpanCar/script/css/reset.css" />
    <link href="/iSpanCar/script/css/basic.css" rel="stylesheet" type="text/css" />
    <link
      href="https://i2.bahamut.com.tw/css/search.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/index_top.css?v=1663318940"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Teko:300,400"
    />
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/dailybonus.css?v=1648105932"
      rel="stylesheet"
      type="text/css"
    />
    <link href="/iSpanCar/script/css/forum.css" rel="stylesheet" type="text/css" />
    <link
      href="https://i2.bahamut.com.tw/css/forum_wallpaper_C.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/plugins/tippy-1.4.0.css?v=1635411701"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/plugins/slick.css?v=1610514513"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/plugins/gamercard.css?v=1628734305"
      rel="stylesheet"
      type="text/css"
    />
    <link href="/iSpanCar/script/css/forum_wide.css" rel="stylesheet" type="text/css" />
    <link
      href="https://i2.bahamut.com.tw/css/forum-beta.css?v=1610514513"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/plugins/shepherd-theme-arrows.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/guild_create_dialogify.css?v=1611893974"
      rel="stylesheet"
      type="text/css"
    />

    <link
      href="https://i2.bahamut.com.tw/css/forum-post.css?v=1668483120"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://i2.bahamut.com.tw/css/forum-fontfix.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/c-editor.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/plugins/dialogify_insertpic.css?v=1656640995"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/plugins/croppie-2.5.0.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/plugins/toastr.min.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/im_all-site-message.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://i2.bahamut.com.tw/css/im_all-site-message-utils.css"
    />

    <!-- Bootstrap 的 CSS 文件 -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
      crossorigin="anonymous"
    />

    <link
      href="https://unpkg.com/@wangeditor/editor@latest/dist/css/style.css"
      rel="stylesheet"
    />
    <script src="https://cdn.bootcdn.net/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script src="https://unpkg.com/@wangeditor/editor@latest/dist/index.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="/iSpanCar/script/js/pageMe.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/axios/1.2.3/axios.js"></script>
    <script src="/iSpanCar/script/js/request.js"></script>
    
    <title>貼文</title>
  </head>
  <body>
    <div id="BH-wrapper">
      <div id="BH-master">
        <!-- 分頁器 -->

        <div id="page" class="page_div" style="margin-top: 20px;"></div>
        </div>

        <!-- 分頁器结束 -->

        <!-- 分類 -->
      <div id="catetrys">
      </div>
        <!-- 列表開始 -->

        <form
          name="formm"
          method="post"
          action="https://forum.gamer.com.tw/B.php?page=2&amp;bsn=23805&amp;qt=4&amp;q=5"
        >
          <input type="hidden" name="gparent" value="0" />
          <input type="hidden" name="unlock" value="0" />
          <input type="hidden" value="1979" name="vcode" />

          <div class="b-list-wrap b-imglist-wrap b-imglist-wrap03">
            <table class="b-list">
              <tr class="b-list__head">
                <td colspan="2" class="b-list__filter">
                  <div class="BH_forum_mainop">
                    <span>
                      <a
                      class="now_stop"
                      id="now_stop_1"
                        onclick="changeType(1)"
                      >
                        <i class="fa fa-th-list" aria-hidden="true"></i>縮圖
                      </a>
                      <a
                      id="now_stop_2"
                      onclick="changeType(2)"
                        ><i class="fa fa-align-justify" aria-hidden="true"></i
                        >清單</a
                      >
                    </span>
                  </div>
                  <div class="b-header_filter">
                    <p>
                      <i class="fa fa-filter" aria-hidden="true"></i>篩選 :
                    </p>
                    <select
                      class="b-list__filter__gp is-select"
                      onchange="selectListChange(this.options[this.options.selectedIndex])"
                    >
                      <option value="0">一般顯示</option>
                      <option value="5" selected="">GP &gt; 5</option>
                      <option value="20">GP &gt; 20</option>
                      <option value="50">GP &gt; 50</option>
                      <option value="100">GP &gt; 100</option>
                      <option value="200">GP &gt; 200</option>
                    </select>
                    <div>
                      <button
                        type="button"
                        class="b-list__filter__feature"
                        onclick="extractList();"
                      >
                        精華
                      </button>
                      <button
                        type="button"
                        class="b-list__filter__expert"
                        onclick="darenList(23805, 4);"
                      >
                        達人
                      </button>
                    </div>
                  </div>
                </td>
                <td>互動 / 人氣</td>
                <td style="width: 200px;">最新回覆</td>
              </tr>
            </table>
            <table  id="tab-list" class="b-list">
              <tbody>
                
              </tbody>
            </table>
          </div>
        </form>
        <!--列表結束-->
        <!-- 分頁器 -->

        <div id="page2" class="page_div" style="margin-top: 20px;"></div>
        <script src="/iSpanCar/script/js/list.js"></script>
        <script>
        </script>
        <!-- 分頁器结束 -->
      </div>
    </div>

    <!-- ------------------------------------詳情---------------------------------------------------------------- -->

    <div id="BH-master" class="detailshow" style="position: relative">
      
      <div class="menu__post__btn" style="right: -80px;">

        <div class="menu_cancel" onclick="backList()">
          <img src="https://i2.bahamut.com.tw/forum/icons/post_del.svg" />
          <span>返回列表</span>
        </div>
      </div>
      <!--內容左側區塊-->
      <div id="liuyanId">

      <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

      </div>
      <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

      <!--------------------------------------------------------------------- 加入樓層 ------------------------------>
      <section class="c-section">
        <div class="c-section__main c-editor c-quick-reply replysection">
          <div class="c-editor__input option floorOption">
            <input id="floorTitle" placeholder="請輸入標題">
            <div class="line"></div>
            <!-- 樓層 -->
<%--            <textarea id="floortextarea" placeholder="請輸入內容"></textarea>--%>
            <div id="toolbar-container"></div>
            <div id="floortextarea"></div>
            <div class="floorsend">
              <input
                type="button"
                class="btn--sm btn--send btn--normal"
                value="送出"
                onclick="quickPost()"
              />
            </div>
          </div>
        </div>
      </section>
      <!--------------------------------------------------------------------- 加入樓層完畢 ------------------------------>
    </div>

    <!-- ------------------------------------詳情結束---------------------------------------------------------------- -->

    <!-- 回覆…………………………………………………………………………………………………………………………………………………………………………………………………………………………………… -->

    <div class="modal-custom" tabindex="-1" id="editor">
      <div id="editor—wrapper">
<%--        <div id="toolbar-container"></div>--%>

        <!-- 文章信息 -->
        <div class="c-post__header c-post__header_custom">
          <h3>回覆文章</h3>
          <span>草稿已儲存於 2023-1-25 9:8，共 389 個 byte</span>
        </div>

        <h1 class="re-c-post__header__title header_title2" id="editTitle">
        </h1>
        <!-- 文章信息 -->

        <div class="c-section__main">
          <div class="c-post main_editor_section box-shadow__fromabove">
            <div id="editor-container"></div>
          </div>
        </div>

        <!-- 提交按鈕 -->

        <div class="menu__post__btn">
          <div class="menu_cancel" onclick="onBackDetail()">
            <img src="https://i2.bahamut.com.tw/forum/icons/post_del.svg" />
            <span>取消</span>
          </div>

          <div class="menu_confirm" onclick="onpublishWZ()">
            <img src="https://i2.bahamut.com.tw/forum/icons/post.svg" />
            <span>發佈文章</span>
          </div>
        </div>

        <!-- 提交按鈕後 -->
      </div>
    </div>
    <script>
      const { createEditor, createToolbar, i18nAddResources, i18nChangeLanguage } = window.wangEditor;

      const editorConfig = {
        MENU_CONF: {
          uploadImage: {
            // 小於該值就插入 base64 格式（而不上傳），默認為 0
            server: '/api/upload-image',
            base64LimitSize: 50000 * 1024 // 50000kb
          }
        },
        placeholder:
          "請輸入内容...",
        onChange(editor) {
          const html = editor.getHtml();
          console.log("editor content", html);
          // 也可以同步到 <textarea>
        },
      };

      const editor = createEditor({
        selector: "#floortextarea",
        html: "<p><br></p>",
        config: editorConfig,
        mode: "default", // or 'simple'
      });

      const twLang = {
        "editor": {
          "more": "更多",
          "justify": "對齊",
          "indent": "縮進",
          "image": "圖片",
          "video": "視頻"
        },
        "common": {
          "ok": "確定",
          "delete": "刪除",
          "enter": "回車"
        },
        "blockQuote": {
          "title": "引用"
        },
        "codeBlock": {
          "title": "代碼塊"
        },
        "color": {
          "color": "文字顏色",
          "bgColor": "背景色",
          "default": "默認顏色",
          "clear": "清除背景色"
        },
        "divider": {
          "title": "分割線"
        },
        "emotion": {
          "title": "表情"
        },
        "fontSize": {
          "title": "字號",
          "default": "默認字號"
        },
        "fontFamily": {
          "title": "字體",
          "default": "默認字體"
        },
        "fullScreen": {
          "title": "全屏"
        },
        "header": {
          "title": "標題",
          "text": "正文"
        },
        "image": {
          "netImage": "網絡圖片",
          "delete": "刪除圖片",
          "edit": "編輯圖片",
          "viewLink": "查看鏈接",
          "src": "圖片地址",
          "desc": "圖片描述",
          "link": "圖片鏈接"
        },
        "indent": {
          "decrease": "減少縮進",
          "increase": "增加縮進"
        },
        "justify": {
          "left": "左對齊",
          "right": "右對齊",
          "center": "居中對齊",
          "justify": "兩端對齊"
        },
        "lineHeight": {
          "title": "行高",
          "default": "默認行高"
        },
        "link": {
          "insert": "插入鏈接",
          "text": "鏈接文本",
          "url": "鏈接地址",
          "unLink": "取消鏈接",
          "edit": "修改鏈接",
          "view": "查看鏈接"
        },
        "textStyle": {
          "bold": "粗體",
          "clear": "清除格式",
          "code": "行內代碼",
          "italic": "斜體",
          "sub": "下標",
          "sup": "上標",
          "through": "刪除線",
          "underline": "下劃線"
        },
        "undo": {
          "undo": "撤銷",
          "redo": "重做"
        },
        "todo": {
          "todo": "待辦"
        },
        "listModule": {
          "unOrderedList": "無序列表",
          "orderedList": "有序列表"
        },
        "tableModule": {
          "deleteCol": "刪除列",
          "deleteRow": "刪除行",
          "deleteTable": "刪除表格",
          "widthAuto": "寬度自適應",
          "insertCol": "插入列",
          "insertRow": "插入行",
          "insertTable": "插入表格",
          "header": "表頭"
        },
        "videoModule": {
          "delete": "刪除視頻",
          "uploadVideo": "上傳視頻",
          "insertVideo": "插入視頻",
          "videoSrc": "視頻地址",
          "videoSrcPlaceHolder": "視頻文件 url 或第三方 <iframe>",
          "videoPoster": "視頻封面",
          "videoPosterPlaceHolder": "封面圖片 url",
          "ok": "確定",
          "editSize": "修改尺寸",
          "width": "寬度",
          "height": "高度"
        },
        "uploadImgModule": {
          "uploadImage": "上傳圖片",
          "uploadError": "{{fileName}} 上傳出錯"
        },
        "highLightModule": {
          "selectLang": "選擇語言"
        }
      }

      i18nAddResources('tw', twLang)
      i18nChangeLanguage('tw')

      const toolbarConfig = {
        excludeKeys: ["fullScreen"],
      };

      const toolbar = createToolbar({
        editor,
        selector: "#toolbar-container",
        config: toolbarConfig,
        mode: "default", // or 'simple'
      });

      function onBackDetail() {
        editor.clear();
        document.getElementById("editor").style.display = "none";
      }

    </script>

    <!-- 回覆结束…………………………………………………………………………………………………………………………………………………………………………………………………………………………………… -->

    <script type="text/javascript" src="/iSpanCar/script/js/emoji_jQuery.min.js"></script>
    <script>
      function backList() {
        document.getElementById("BH-wrapper").style.display = "block";
        document.getElementsByClassName("detailshow")[0].style.display =
          "none";
      }

      //   詳情回覆
      function toReply(str) {
        const item = tiezeList.filter(it => it.id == str);
        selectTiziItem = item[0];
        const title = selectTiziItem.title;
        console.log("詳情回覆", title);
        document.getElementById("editor").style.display = "block";
        $('#editTitle').append(`RE:` + title)
      }


      // 讚一個
      // 倒讚一個
      function commentBp(e) {}
      // 插入表情

      function insetEmoji() {
        console.log("插入表情");
      }

      // 回覆
    </script>
    <!-- 選項 1：jQuery 和 Bootstrap 集成包（集成了 Popper） -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
