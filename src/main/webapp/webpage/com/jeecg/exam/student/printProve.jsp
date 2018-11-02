<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>单据打印</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="favicon.ico"> <link href="plug-in/bootstrap3.3.5/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="plug-in/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="plug-in/hplus/css/animate.css" rel="stylesheet">
<link href="plug-in/hplus/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="white-bg">
    <div class="wrapper wrapper-content p-xl">
        <div class="ibox-content p-xl">
            <div class="row">
                <div class="col-sm-6">
                    <address>
                        <strong>${prove.proveExamName }准考证</strong>
                    </address>
                </div>

            </div>

            <div class="table-responsive m-t">
                <table class="table invoice-table">
                    <!-- <thead>
                        <tr>
                            <th>清单</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>税率</th>
                            <th>总价</th>
                        </tr>
                    </thead> -->
                    <tbody>
                        <tr>
                            <td>
                                <div><strong>姓名：</strong>
                                </div>
                            </td>
                            <td>${prove.proveExamName }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>准考证号：</strong>
                                </div>
                            </td>
                            <td>${prove.proveCode }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>身份证号码：</strong>
                                </div>
                            </td>
                            <td>${prove.proveCardCode }</td>
                        </tr>
						<tr>
                            <td>
                                <div><strong>报考单位：</strong>
                                </div>
                            </td>
                            <td>${prove.proveOrg }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>报考职业：</strong>
                                </div>
                            </td>
                            <td>${prove.proveWork }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>考试地点：</strong>
                                </div>
                            </td>
                            <td>${prove.provePlace }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>考场号：</strong>
                                </div>
                            </td>
                            <td>${prove.proveRoom }</td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>座位号：</strong>
                                </div>
                            </td>
                            <td>${prove.proveSeat }</td>
                        </tr>
                         <tr>
                            <td>
                                <div><strong>考试时间：</strong>
                                </div>
                            </td>
                            <td>${prove.proveDate }</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- /table-responsive -->

            </div>
        </div>

    </div>

    <!-- 全局js -->
    <script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="plug-in/bootstrap3.3.5/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="plug-in/hplus/js/content.js?v=1.0.0"></script>

    <script type="text/javascript">
       window.print();
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
