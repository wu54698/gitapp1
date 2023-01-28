var baseUrl = "";


axios.interceptors.response.use(
    res => {
      return res.data;
    },
    err => {}
)

// 分类
function getCategory() {
  return axios.get('api/dforum/category')
}
// 列表
/**
 * pageNum  int    
 pageSize  int    
 best  Boolean    精華 
 likeCountStart  Integer    GP開始
 likeCountEnd  Integer     GP結束
 * @param {*} param0 
 */
function getList({
  pageSize,
  pageNum,
  best,
  likeCountStart,
  likeCountEnd,
  categoryId,
  callBack,
}) {
  $.get(
    `${baseUrl}/api/dforum/post`,
    {
      pageSize,
      pageNum,
      best,
      likeCountEnd,
      likeCountStart,
      categoryId,
    },
    function (res) {
      const { content, totalElements, totalPages } = res.data;
      callBack && callBack({ content, totalElements, totalPages });
    },
    "json"
  );
}

var currentPage = 1;

function refreshPage(totalNum, totalList, callBack) {
  // pageMe.js 使用方法
  $("#page").paging({
    pageNum: currentPage, // 当前页面
    totalNum, // 总页码
    totalList, // 记录总数量
    callback: function (num) {
      callBack && callBack(num - 1);
      currentPage = num;
    },
  });

  $("#page2").paging({
    pageNum: currentPage, // 当前页面
    totalNum, // 总页码
    totalList, // 记录总数量
    callback: function (num) {
      callBack && callBack(num - 1);
      currentPage = num;
    },
  });
}

// 帖子详情
function gettieDetail({ uuid, data }) {
  return axios.get(`${baseUrl}/api/dforum/post/${uuid}`, { params: data})
}

/**
 * 接口：帖子樓層留言
 地址：POST:  /api/dforum/post/message
 协议：applicatin/json
 参数说明：
 content  String
 replyMember  MemberBean
 post  PostMain
 └─ id  Integer
 */
function sendFloorMsg(data) {
  return axios.post(`${baseUrl}/api/dforum/post/message`, data);
}

/**
 * 接口：點贊 or 踩
 地址：POST: /api/dforum/like
 协议：applicatin/json
 参数说明：
 id  Integer
 type  Integer  1 帖子 2 留言
 liked  Integer  1 贊  2踩
 dataId  Integer    數據ID
 */

function likeApi(data) {
  return axios.post(`${baseUrl}/api/dforum/like`, data);
}

/**
 * 接口：帖子詳情查詢
 地址：GET: http://172.25.144.1:8080/api/dforum/post/{uuid}?postId=0&pageSize=0&pageNum=0
 协议：application/x-www-form-urlencoded
 参数说明：
 uuid(Path)  String
 postId  Integer
 pageSize  int
 pageNum  int
 */

function postDetail({ uuid, postId }) {
  return axios.post(`${baseUrl}/api/dforum/post/${uuid}?postId=${String(postId)}&pageSize=0&pageNum=100000`)
}
/**
 * 接口：跟帖子
 地址：POST: /api/dforum/post
 协议：applicatin/json
 参数说明：
 body  String
 title  String
 uuid  String
 category  Integer

 Postman请求示例：
 {
  "body": "",
  "title": "",
  "uuid": "",
  "category": 0
}
 */

function genTiezi(data) {
  return axios.post(`${baseUrl}/api/dforum/post`, data);
}