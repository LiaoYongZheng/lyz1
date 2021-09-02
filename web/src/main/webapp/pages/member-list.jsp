
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="${pageContext.request.contextPath}/member/findAll.do" method="post">
            <input type="hidden" name="page" value="${paginationBean.page}">
            <input type="hidden" name="size" value="${paginationBean.size}">
            <input class="layui-input" placeholder="开始日" name="start" id="start" >
            <input class="layui-input" placeholder="截止日" name="end" id="end" >
            <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input" id="username" >
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','${pageContext.request.contextPath}/member/add',600,400)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>用户名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>加入时间</th>
            <th>状态</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var = "member">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${member.id}</td>
            <td>${member.username}</td>
            <td>${member.sex}</td>
            <td>${member.phoneNumber}</td>
            <td>${member.email}</td>
            <td>${member.address}</td>
            <td>${member.createDateStr}</td>
            <td class="td-status">

                      <c:if test="${member.status == '1'}">
                          <span class="layui-btn layui-btn-normal layui-btn-mini"> 已启用 </span>
                      </c:if>
                      <c:if test="${member.status == '0'}">
                          <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled"> 已停用 </span>
                      </c:if>
            </td>
            <td class="td-manage">

                <a onclick="member_stop(this,${member.id})" href="javascript:;"  title="${member.status > 0 ? '停用':'启用'}">
                    <i class="layui-icon">${member.status > 0 ? '&#xe601;':'&#xe62f;'}</i>
                </a>
                <a title="编辑"  onclick="x_admin_show('编辑','${pageContext.request.contextPath}/member-edit.jsp',600,400)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a onclick="x_admin_show('修改密码','${pageContext.request.contextPath}/member-password.jsp',600,400)" title="修改密码" href="javascript:;">
                    <i class="layui-icon">&#xe631;</i>
                </a>
                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="${pageContext.request.contextPath}/member/findAll.do?page=${pageInfo.pageNum-1 <= 1 ? 1:pageInfo.pageNum}&size=${pageInfo.pageSize}">&lt;&lt;</a>
        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
            <c:if test="${pageNum == paginationBean.page}">
                 <span class="current"> ${pageNum}</span>
            </c:if>
            <c:if test="${pageNum != paginationBean.page}">
                <a class="mun" href="${pageContext.request.contextPath}/member/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
            </c:if>

        </c:forEach>

            <a class="next" href="${pageContext.request.contextPath}/member/findAll.do?page=${pageInfo.pages > pageInfo.pages ? pageInfo.pages:pageInfo.pages}&size=${pageInfo.pageSize}">&gt;&gt;</a>
        </div>
    </div>

</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

   function update(obj,member){
       if (member.status === 1){
           member.status = 0;

       }
      else if (member.status === 0){
           member.status = 1;

       }

       $.ajax({
           url: '/web/member/update.do',
           contentType: 'application/json;charset=UTF-8',
           data: JSON.stringify(member),
           dataType: 'json',
           type: 'post',
           success:function (data){
               if (data.flag){
                   if (member.status == 0){
                       $(obj).attr('title','启用')
                       $(obj).find('i').html('&#xe62f;');
                       $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                       layer.msg('已停用!',{icon: 5,time:1000});
                   }
                 else {
                       $(obj).attr('title','停用')
                       $(obj).find('i').html('&#xe601;');
                       $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                       layer.msg('已启用!',{icon: 5,time:1000});
                   }
               }
               else {
                   return  layer.msg('停用失败!',{icon: 5,time:1000});
               }
           }
       });

   }
    function findById(obj,id) {
        $.get("/web/member/" + id + ".do", function (data) {
            if (data.data == null) {
                return layer.msg('停用失败!', {icon: 5, time: 1000});
            }
           update(obj,data.data);

        });

    }
    /*用户-停用*/
    function member_stop(obj,id){
        var title = $(obj).parents("tr").find(".td-status").find('span').text();
       let msg = obj.title;
        layer.confirm('确认要'+msg+'吗？',function(index){
            if($.trim(title) == $.trim('已启用')){

                //发异步把用户状态进行更改
                findById(obj,id);


            }else{
                findById(obj,id);
            }
        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>

</body>

</html>
