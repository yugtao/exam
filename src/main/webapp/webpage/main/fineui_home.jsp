<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>Jeecg 微云快速开发平台</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="plug-in/themes/fineui/main/iconfont.css">
	<script src="plug-in/laydate/laydate.js"></script> 
    <style type="text/css">
	.gray-bg{
		background-color: #e9ecf3;
	}
	.col-sm-2 {
	    width: 10%;
		padding-left: 5px;
		padding-right: 5px;
		float: left;
	}
	.p-lg{
		padding:0px 0px 10px 0px;
	}
	.widget{
		margin-top: 0px;
	}
	.iconfont{
		font-size: 30px;
		color: white;
	}
	h2 {
        font-size: 19px;
    }
    .echart_div{
    	height:240px;width:100%;
    }
	.ibtn{
		cursor: pointer;
	}
	.flot-chart{
		height:400px;
	}
   /*  .top-navigation .wrapper.wrapper-content{padding:20px 5px !important;}
	.container {
    	 width:99% !important; margin:10px;
    	 padding-right: 1px !important;
    	 padding-left: 1px !important;
	}
	.color_red{color:#e55555;}
	.col-cs-2 {
	    width: 10%;
		padding-left: 5px;
		padding-right: 5px;
		float: left;
	}*/
	
	@media (min-width: 992px){
		.col-cs-2 {
		    width: 11.11%;
			padding-left: 5px;
			padding-right: 5px;
			float: left;
		}
	}

    </style>
</head>
 <body class="gray-bg">
       <!--  <div class="wrapper wrapper-content">
           
			<div class="row">
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #cfa972;">
						<div>class="ibtn"
                            <i class="iconfont icon-zhihuizhongxin" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能1</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #f29b76;">
						<div>
                            <i class="iconfont icon-yujing" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能2</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #acd598;">
						<div>
                            <i class="iconfont icon-ln-" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能3</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #84ccc9;">
						<div>
                            <i class="iconfont icon-wuliu" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能4</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #89c997;">
						<div>
                            <i class="iconfont icon-quanshengmingzhouqiguanli" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能5</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #88abda;">
						<div>
                            <i class="iconfont icon-jixiao" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能6</small>
                        </div>
                    </div>
                </div>
				<div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #8c97cb;">
						<div>
                            <i class="iconfont icon-fangdajing-copy" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能7</small>
                        </div>
                    </div>
                </div>
				<div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #c490bf;">
						<div>
                            <i class="iconfont icon--youhuajieduan" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能8</small>
                        </div>
                    </div>
                </div>
				<div class="col-md-1 col-cs-2 col-xs-4">
					<div class="widget  p-lg text-center" style="background: #f19ec2;">
						<div>
                            <i class="iconfont icon-duoren" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能9</small>
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">您是否需要一款企业级J2EE快速开发平台，提高开发效率，缩短项目周期…
            <br>您是否一直在苦苦寻找一款强大的代码生成器，节省码农的繁琐重复工作…
            <br>您是否想拥有移动报表能力、自定义表单设计能力、插件开发能力(可插拔)、工作流配置能力…
            <br>…………
            <h4 class="text-danger">那么，现在Jeecg来了</h4>
        </blockquote>
        <hr>
    </div>
    <div class="col-sm-3">
        <h2>Hello,Guest</h2>
        <small>移动设备访问请扫描以下二维码：</small>
        <br>
        <br>
        <img src="plug-in/login/images/jeecg.jpg" width="100%" style="max-width:264px;">
        <br>
    </div>
    <div class="col-sm-5">
        <h2>
            Jeecg 微云快速开发平台
        </h2>
        <p>JEECG是一款基于代码生成器的J2EE快速开发平台，开源界“小普元”超越传统商业企业级开发平台。引领新的开发模式(Online Coding模式(自定义表单)->代码生成器模式->手工MERGE智能开发)， 可以帮助解决Java项目60%的重复工作，让开发更多关注业务逻辑。既能快速提高开发效率，帮助公司节省人力成本，同时又不失灵活性。她可以用于所有的Web应用程序，如:<b>MIS</b>，<b>CRM</b>，<b>OA</b>，<b>ERP</b>，<b>CMS</b>，<b>网站后台</b>，<b>微信管家</b>，等等，当然，您也可以对她进行深度定制，以做出更强系统。</p>
        <p>
            <b>当前版本：</b>v_3.8
        </p>
        <p>
            <span class="label label-warning">开源     &nbsp; | &nbsp; 免费  | &nbsp; 更多插件</span>
        </p>
        <br>
        <p>
        	<a class="btn btn-success btn-outline" href="http://yun.jeecg.org" target="_blank">
                <i class="fa fa-cloud"></i> JEECG插件下载
            </a>
            <a class="btn btn-white btn-bitbucket" href="http://www.jeecg.org/forum.php?mod=viewthread&tid=1249&page=1&extra=#pid3689" target="_blank">
                <i class="fa fa-qq"> </i> 联系我们
            </a>
            <a class="btn btn-white btn-bitbucket" href="http://jeecg3.mydoc.io" target="_blank">
                <i class="fa fa-home"></i> 在线文档
            </a>
        </p>
    </div>
    <div class="col-sm-4">
        <h4>Jeecg具有以下特点：</h4>
        <ol>
            <li>采用主流J2EE框架，容易上手;</li>
            <li>强大的代码生成器，一键生成</li>
            <li>提供5套不同风格首页</li>
            <li>开发效率很高，节省80%重复工作</li>
            <li>使用最流行的的扁平化设计</li>
            <li>在线开发能力，通过在线配置实现功能，零代码</li>
            <li>在线报表配置能力，一次配置七种报表风格，支持移动报表</li>
            <li>移动平台支持，采用Bootstrap技术，移动OA，移动报表</li>
            <li>强大数据权限，访问级，按钮级、数据行级，列级，字段级</li>
            <li>国际化能力，支持多语言</li>
            <li>多数据源，跨数据源操作，便捷集成第三方系统</li>
            <li>简易Excel、Word 导入导出,满足企业需求</li>
            <li>插件开发，可插拔开发模式，集成第三方组件</li>
            <li>流程定义，在线画流程，流程挂表单，符合国情流程</li>
            <li>自定义表单，可视化拖拽布局，自定义表单风格</li>
            <li>更多……</li>
        </ol>
    </div>

</div> -->
			<div class="row">

                <div class="col-sm-5">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>待办事项</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                    <p>为什么选择jeecg？</p>
                    <ol>
                        <li>采用主流框架，容易上手，学习成本低；</li>
                        <li>强大代码生成器和在线配置能力，提高开发效率，大大缩短项目周期；</li>
                        <li>开源免费，万人活跃社区；</li>
                        <li>封装基础用户权限，报表等功能模块，无需再次开发；</li>
                        <li>采用SpringMVC + Hibernate + Minidao+ Easyui+Jquery+Boostrap等基础架构</li>
                        <li>支持多浏览器，多数据库；</li>
                        <li>支持移动开发，可以完美兼容电脑、手机、pad等多平台；</li>
                        <li>……</li>
                    </ol>
                    <hr>
                    <div class="alert alert-warning">JEECG智能开发平台，可以应用在任何J2EE项目的开发中，尤其适合企业信息管理系统（MIS）、内部办公系统（OA）、企业资源计划系统（ERP） 、客户关系管理系统（CRM）等，其半智能手工Merge的开发方式，可以显著提高开发效率60%以上，极大降低开发成本。
                    </div>
                </div>
                    </div>
                </div>
                <div class="col-sm-4">
					<div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>用户浏览器比例分析</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">天</button>
                                    <button type="button" class="btn btn-xs btn-white">月</button>
                                    <button type="button" class="btn btn-xs btn-white">年</button></div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="flot-chart" style="height:315px;">
                                        <div class="flot-chart-content" id="chart4"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="col-sm-3" style="padding-left: 10px;">
					<!-- <iframe src="http://tianqi.5ikfc.com:90/plugin-code/?style=1&dy=1&fs=12" frameborder="0" scrolling="no" width="300" height="60" id="weather_frame"></iframe> -->
					<iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=7" style="border:solid 1px #7ec8ea" width="105%" height="90" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					<div id="calendar"></div>
				</div>
			</div>
			<div class="row">
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>用户浏览器分析</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">天</button>
                                    <button type="button" class="btn btn-xs btn-white">月</button>
                                    <button type="button" class="btn btn-xs btn-white">年</button></div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="chart1"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>浏览器分析</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">天</button>
                                    <button type="button" class="btn btn-xs btn-white">月</button>
                                    <button type="button" class="btn btn-xs btn-white">年</button></div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="chart2"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
					<div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>仪表盘</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">天</button>
                                    <button type="button" class="btn btn-xs btn-white">月</button>
                                    <button type="button" class="btn btn-xs btn-white">年</button>
                                 </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                         	<div class="row">
                                <div class="col-sm-12">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="chart3"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				
			</div>
            
            <div class="wrapper wrapper-content">
   
</div>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>
<script type="text/javascript" src="plug-in/echart/echarts.min.js"></script>
<script type="text/javascript" src="plug-in/jquery-plugs/i18n/jquery.i18n.properties.js"></script>
<t:base type="tools"></t:base>
<script type="text/javascript" src="plug-in/login/js/getMsgs.js"></script>
<script>
$(document).ready(function() {
	//直接嵌套显示
    laydate.render({
      elem: '#calendar'
      ,position: 'static'
      ,theme: 'molv'
    	
    });
	var chart1 = echarts.init(document.getElementById('chart1'));
	var chart2 = echarts.init(document.getElementById('chart2'));
	var chart3 = echarts.init(document.getElementById('chart3'));
	var chart4 = echarts.init(document.getElementById('chart4'));
	$.ajax({
		type : "POST",
		url : "jeecgListDemoController.do?broswerCount&reportType=pie",
		success : function(jsondata) {
			jsondata=JSON.parse(jsondata);
			var data=jsondata[0].data;
			var xAxisData=[];
			var seriesData=[];
			var picData = [];
			for(var i in data){
				xAxisData.push(data[i].name);
				seriesData.push(data[i].percentage);
				picData.push({"value":data[i].percentage,"name":data[i].name});
			}
			chart1.setOption({
				tooltip: {
					trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
			    legend: {
			        data: xAxisData
			    },
			    series : [
					        {
					            name: "用户人数",
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data:picData,
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
			});
		}
	});
	
	
	var option3 = {
		    tooltip : {
		        formatter: "{a} <br/>{b} : {c}%"
		    },
		    toolbox: {
		        feature: {
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    series: [
		        {
		            name: '业务指标',
		            type: 'gauge',
		            detail: {formatter:'{value}%'},
		            data: [{value: 50, name: '完成率'}]
		        }
		    ]
		};

	$.ajax({
		type : "POST",
		url : "jeecgListDemoController.do?broswerCount&reportType=column",
		success : function(jsondata) {
			jsondata=JSON.parse(jsondata);
			var data=jsondata[0].data;
			var xAxisData=[];
			var seriesData=[];
			for(var i in data){
				xAxisData.push(data[i].name);
				seriesData.push(data[i].percentage);
			}
			var option3 = {
		            tooltip: {},
		            legend: {
		                data:[jsondata[0].name],
		                left:'center'
		            },
		            xAxis: {
		            	type: 'category',
		                data: xAxisData,
		                axisLabel:{
		                	interval:0,//横轴信息全部显示
		                	rotate:-30,//-10角度倾斜展示
		                }
		            },
		            yAxis: {},
		            series: [{
		                name: jsondata[0].name,
		                type: 'bar',
		                data: seriesData
		            }]
		        };
			chart3.setOption(option3);
		}
	});
		
		$.ajax({
			type : "POST",
			url : "jeecgListDemoController.do?broswerCount&reportType=line",
			success : function(jsondata) {
				jsondata=JSON.parse(jsondata);
				var data=jsondata[0].data;
				var xAxisData=[];
				var seriesData=[];
				for(var i in data){
					xAxisData.push(data[i].name);
					seriesData.push(data[i].percentage);
				}
				var option4 = {
					    color: ['#3398DB'],
					    tooltip : {
					        trigger: 'axis',
					        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
					    grid: {
					        left: '3%',
					        right: '4%',
					        bottom: '10%',
					        containLabel: true
					    },
					    xAxis : [
					        {
					            type : 'category',
					            data : xAxisData,
					            axisTick: {
					                alignWithLabel: true
					            },
					            axisLabel:{
				                	interval:0,//横轴信息全部显示
				                	rotate:-30,//-10角度倾斜展示
				                }
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value'
					        }
					    ],
					    series : [
					        {
					            name:'用户人数',
					            type:'line',
					            barWidth: '60%',
					            data:seriesData
					        }
					    ]
					};
				chart4.setOption(option4, true);
			}
		});
		
		var colors = ['#5793f3', '#d14a61', '#675bba'];
		$.ajax({
			type : "POST",
			url : "graphReportController.do?datagridGraph",
			data:{
				configId:'yhcztj'
			},
			success : function(jsondata) {
				var data = jsondata.rows;
				var xAxisData=[];
				var seriesData=[];
				var loginData=[];
				if(data!=null){
					for(var i = data.length-1; i >= 0; i--){
						xAxisData.push(data[i].userid);	//用户名
						seriesData.push(data[i].ct);	//操作次数
						loginData.push(data[i].login_count);//登陆次数
					}
				}
				var option2 = {
			            tooltip : {
			                trigger: 'axis',
			                axisPointer : {
			                    type : 'shadow'
			                }
			            },
			            legend: {
			                data: ["操作次数",'登陆次数']
			            },
			            grid: {
			                left: '1%',
			                right: '6%',
			                bottom: '3%',
			                containLabel: true
			            },
			            xAxis:  {
			                type: 'value'
			            },
			            yAxis: {
			                type: 'category',
			                data: xAxisData
			            },
			            series: [
			                {
			                    name: '操作次数',
			                    type: 'bar',
			                    stack: '总量',
			                    label: {
			                        normal: {
			                            show: true,
			                            position: 'insideRight'
			                        }
			                    },
			                    data : seriesData
			                },
			                {
			                    name: '登陆次数',
			                    type: 'bar',
			                    stack: '总量',
			                    label: {
			                        normal: {
			                            show: true,
			                            position: 'insideRight'
			                        }
			                    },
			                    data : loginData
			                }
			            ]
			        };
				chart2.setOption(option2, true);
			}
		});
		
		
		
		$(window).resize(chart1.resize);
		$(window).resize(chart2.resize);
		$(window).resize(chart3.resize);
		$(window).resize(chart4.resize);
});
</script>
<!--统计代码，可删除-->
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>