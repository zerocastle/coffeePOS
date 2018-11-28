<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['월', '매출액'],
          ['1',  1000],
          ['2',  1170],
          ['3',  660],
          ['4',  1030],
          ['5',  1030],
          ['6',  1030],
          ['7',  1030],
          ['8',  1030],
          ['9',  1030],
          ['10',  1030],
          ['11',  1030],
          ['12',  100000],
        ]);

        var options = {
          title: '월별 매출액',
          hAxis: {title: '월',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id="chart_div" style="width: 100%; height: 500px;"></div>
</body>
</html>