<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/5/28
  Time: 11:43 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Hello world!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <style type="text/css">
        #container {
            /*地图(容器)显示大小*/
            width: 1000px;
            height: 400px;
        }
    </style>
    <!--引入Javascript API GL，参数说明参见下文-->
    <script src="https://map.qq.com/api/gljs?v=1.exp&key=JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS"></script>
    <script>
        //地图初始化函数，本例取名为init，开发者可根据实际情况定义
        function initMap() {
            //定义地图中心点坐标
            var center = new TMap.LatLng(39.984120, 116.307484)
            //定义map变量，调用 TMap.Map() 构造函数创建地图
            var map = new TMap.Map(document.getElementById('container'), {
                center: center,//设置地图中心点坐标
                zoom: 17.2,   //设置地图缩放级别
                pitch: 43.5,  //设置俯仰角
                rotation: 45    //设置地图旋转角度
            });

            //根据指定的范围调整地图视野。
            map.fitBounds(latlngBounds);
            //当可视区域范围更改时会触发此事件。返回当前地图的视野范围。
            qq.maps.event.addListener(map, 'bounds_changed', function() {
                fitBoundsDiv.innerHTML = "地图的可视范围为：" + map.getBounds();
            });


            //返回地图当前中心点地理坐标。
            centerDiv.innerHTML = "地图中心为：" + map.getCenter();
            //当地图中心属性更改时会触发此事件。
            qq.maps.event.addListener(map, 'center_changed', function() {
                centerDiv.innerHTML = "地图中心为：" + map.getCenter();
            });


            //返回地图缩放级别。
            zoomDiv.innerHTML = "地图缩放级别为：" + map.getZoom();
            //当地图缩放级别更改时会触发此事件。
            qq.maps.event.addListener(map, 'zoom_changed', function() {
                zoomDiv.innerHTML = "地图缩放级别为：" + map.getZoom();
            });


            //返回当前地图所在的 HTML 容器。
            containerDiv.innerHTML = "地图所在的 HTML 容器为：" + map.getContainer();


            //返回当前地图类型ID。
            mapTypeIdDiv.innerHTML = "地图类型ID为：" + map.getMapTypeId();
            //当 mapTypeId 属性更改时会触发此事件。
            qq.maps.event.addListener(map, 'maptypeid_changed', function() {
                mapTypeIdDiv.innerHTML = "地图类型ID为：" + map.getMapTypeId();
            });

        }
    </script>
</head>
<!-- 页面载入后，调用init函数 -->

<body onload="initMap()">
<!-- 定义地图显示容器 -->
<div id="container"></div>


</body>

</html>