<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<title>hunterIndex</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<!-- 导航栏 -->
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><strong>WebHunter</strong></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class=""><a href="#" role="button" aria-haspopup="true"
					aria-expanded="false">web客户端 <span class="caret"></span></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">版本1.0<span
						class="caret"></span></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- 导航栏结束 -->
	<!-- 主体部分开始-->
	<div class="container">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="page-header">
				<hr>
				<h1>
					Web猎手1.0
				</h1>
			</div>
			
			<div class="main-content">
				<form class="form-horizontal" action="" method="post">
				  <div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label"><h3>URL</h3></label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputPassword" placeholder="请输入要解析的URL,优先目标腾讯教育频道">
				    </div>
				  </div>
				  <div>
				  	<button type="submit" class="btn btn-danger btn-lg">提 交</button>
				  </div>
				</form>
			</div>
		</div>
	</div>
	<!-- 主题部分结束 -->

	<!-- footer开始 -->
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-bottom">
	<div class="container">
		<span class="footer-content">Copyright ©2016 SunOnline<sup>TM</sup></span>
	</div>
	</nav>
	<!-- footer结束 -->
</body>
</html>