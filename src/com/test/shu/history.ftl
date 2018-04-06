<!DOCTYPE html>
<html xmlns = "http://www.w3.org/1999/xhtml" lang = "en" class = "no-ie" style="...">
<head>
    <meta charset = "utf-8" />
    <title>微量云商-商户平台</title>
    <meta name="description" content="Dashboard"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="resources/admin/img/tracenet.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link id="bootstrap-rtl-link" href="" rel="stylesheet"/>
    <link href="assets/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="assets/css/weather-icons.min.css" rel="stylesheet"/>

    <!--Fonts-->


    <!--Beyond styles-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/demo.min.css" rel="stylesheet"/>
    <link href="assets/css/typicons.min.css" rel="stylesheet"/>
    <link href="assets/css/animate.min.css" rel="stylesheet"/>
    <link id="skin-link" href="assets/css/skins/black.min.css" rel="stylesheet" type="text/css"/>

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="assets/js/skins.min.js"></script>

    <style type="type/css">

        body {
            overflow-x: hidden;
            overflow-y: hidden;
        }
    </style>
</head>
<body>
<#include "/header.ftl"/>
<!--Basic Scripts-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/slimscroll/jquery.slimscroll.min.js"></script>
<!--Beyond Scripts-->
<script src="assets/js/beyond.min.js"></script>

<script type="text/javascript" src="resources/admin/js/common/data.js"></script>
<script type="text/javascript" src="resources/admin/js/common/columns.js"></script>
<script type="text/javascript" src="resources/admin/js/common/common.js"></script>
<script type="text/javascript" src="resources/admin/js/common/layer.js"></script>
<script type="text/javascript" src="resources/admin/js/common/nav.js"></script>
<script type="text/javascript" src="assets/js/datatable/datatables.bootstrap.min.js"></script>
<script type="text/javascript">
    function ceshi () {
        var rows = "";
        var longnumber = "";
        var haveNumber = null;
        for (var i = 1 ; i < 4 ; i++) {
            rows =  document.getElementsByName(i);
            for (var j = 0; j < rows.length ; j++) {
                var number = rows[j].value;
                if (number == "") {
                    number = 0;
                } else {
                    haveNumber = document.getElementById( i + "," + (j + 1));
                    haveNumber.disabled = "disabled";
                    haveNumber.style.backgroundColor  = "#3fad";
                }
                if (j == rows.length - 1) {
                    longnumber += number;
                } else {
                    longnumber += number + ",";
                }
            }

            longnumber += ";";
        }

        $.ajax({
            type:'post',
            url:'countshu',
            // data:$("#myform").serialize(),
            data: {
                "longnumber" : longnumber
            },
            cache:false,
            dataType:'json',
            success:function(data){
                alert(data);
            }
        });
    }
    function revert () {
        for (var i = 1 ; i < 4 ; i++) {
            var rows =  document.getElementsByName(i);
            for (var j = 0; j < rows.length ; j++) {
                var haveNumber = rows[j];
                haveNumber.value = "";
                haveNumber.disabled = "";
                haveNumber.style.backgroundColor  = "#fff";
            }
        }
    }
</script>
</br></br></br>

    <form action="countshu" method="post" style="padding-left: 15px">
        <table border="1px">
            <#list 1..3 as index>
                <tr>
                    <#list 1..3 as index1>
                        <td>
                            <input type="text" id="${index},${index1}" name="${index}" style="width: 25px;text-align: center">
                        </td>
                     </#list>
                </tr>
            </#list>
        </table>
        <span>
            <input type="button" name="tijiao" onclick="ceshi()" value="提交" >
            <input type="button" name="chongzhi" onclick="revert()" value="重置">
        </span>
    </form>
    </br>
    <span><a href="welcome">return</a></span></br>
    </br>

    <span style="float: left;">perfect</span></br>
    <#list 0..(perfectList?size)-1 as index >
        <#if index != 0 && index%6 == 0>
            </br></br></br></br>
        </#if>
        <span style="float: left;padding-left: 2px;" name="history${index}">
            <table border="1px">
                <#list 0..(perfectList[index]?size)-1 as row>
                    <tr style="width: 25px;">
                        <#list 0..(perfectList[index][row]?size)-1 as line>
                            <td style="width: 25px;text-align: center" >
                                <span>${perfectList[index][row][line]}</span>
                            </td>
                        </#list>
                    </tr>
                </#list>
            </table>
        </span>
    </#list>
    </br></br></br></br></br>

    <span style="float: left;">history</span></br>
    <#list 0..(list?size)-1 as index >
        <#if index != 0 && index%6 == 0>
            </br></br></br></br>
        </#if>
        <span style="float: left;padding-left: 2px;" name="history${index}">
            <table border="1px">
                <#list 0..(list[index]?size)-1 as row>
                    <tr style="width: 25px;">
                        <#list 0..(list[index][row]?size)-1 as line>
                            <td style="width: 25px;text-align: center" >
                                <span>${list[index][row][line]}</span>
                            </td>
                        </#list>
                    </tr>
                </#list>
            </table>
        </span>
    </#list>
</body>
</html>