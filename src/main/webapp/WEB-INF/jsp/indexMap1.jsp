<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>腾讯地图-简单地图示例</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script charset="utf-8" src="https://map.qq.com/api/js?v=2.exp&key=JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS"></script>
    <%--JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS,,OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77--%>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
        body,
        button,
        input,
        select,
        textarea {
            font: 12px/22px Verdana, Helvetica, Arial, sans-serif;
        }
        html,
        body {
            height: 100%;
            margin: 0px;
            padding: 0px;
        }
        #container {
            width: 100%;
            height: 70%
        }
        body div {
            text-indent: 20px;
        }
    </style>
</head>

<body onload="init()">
<div id="container"></div>

<div id="fitBoundsDiv1"></div>
<div></div>
<div id="fitBoundsDiv"></div>
<div id="centerDiv"></div>
<div id="zoomDiv"></div>
<div id="containerDiv"></div>
<div id="mapTypeIdDiv"></div>
<div id="projection"></div>

<script type="text/javascript">
    function init() {
        var sw = new qq.maps.LatLng(39.88795, 116.28666); //西南角坐标
        var ne = new qq.maps.LatLng(39.96693, 116.49369);; //东北角坐标
        var latlngBounds = new qq.maps.LatLngBounds(sw ,ne); //矩形的地理坐标范围

        //div容器
        var container = document.getElementById("container");
        var centerDiv = document.getElementById("centerDiv");
        var zoomDiv = document.getElementById("zoomDiv");
        var fitBoundsDiv = document.getElementById("fitBoundsDiv");
        var containerDiv = document.getElementById("containerDiv");
        var mapTypeId = document.getElementById("mapTypeId");


        //初始化地图
        var map = new qq.maps.Map(container, {
            // 地图的中心地理坐标。
            center: new qq.maps.LatLng(39.916527, 116.397128),
            zoom: 13
        });

        var aa;
        //根据指定的范围调整地图视野。
        map.fitBounds(latlngBounds);
        //当可视区域范围更改时会触发此事件。返回当前地图的视野范围。
        qq.maps.event.addListener(map, 'bounds_changed', function() {
            fitBoundsDiv.innerHTML = "地图的可视范围0为：" + map.getBounds();
            aa = map.getBounds();
        });
        fitBoundsDiv1.innerHTML = "地图的可视范围1为：" + aa;


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


        // var times = 0;
        // var oInterval = setInterval(function() {
        //
        //     //panBy()将地图中心移动一段指定的距离（以像素为单位）。
        //     map.panBy(-100, 100);
        //
        //     //zoomBy()将地图缩放到指定的缩放比例（每次所增加的数值）。
        //     map.zoomBy(5);
        //     times++;
        //     if (times >= 1) {
        //         clearInterval(oInterval)
        //     }
        // }, 3 * 1000);
        //
        //
        // setTimeout(function() {
        //
        //     //panTo()将地图中心移动到指定的经纬度坐标。
        //     map.panTo(new qq.maps.LatLng(39.9, 116.4));
        //
        //     //zoomTo()将地图缩放到指定的级别。
        //     map.zoomTo(15);
        //
        // }, 8 * 1000);
        //
        //
        // setTimeout(function() {
        //     //setCenter()设置地图中心点坐标。
        //     map.setCenter(new qq.maps.LatLng(30, 117));
        //
        //     //setZoom()设置地图缩放级别。
        //     map.setZoom(6);
        //
        //     //setMapTypeId()设置地图类型。
        //     map.setMapTypeId(qq.maps.MapTypeId.HYBRID);
        //
        // }, 15 * 1000);
        //
        //
        // setTimeout(function() {
        //
        //     //设置地图参数。
        //     map.setOptions({
        //         keyboardShortcuts: false,
        //         scrollwheel: false
        //     });
        //
        // }, 30 * 1000);
    }
</script>
</body>

</html>
