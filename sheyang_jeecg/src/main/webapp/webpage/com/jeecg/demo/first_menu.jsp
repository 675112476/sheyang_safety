<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="plug-in/joints/jquery.js"></script>
    <script src="plug-in/joints/lodash.js"></script>
    <script src="plug-in/joints/backbone.js"></script>
    <script src="plug-in/joints/joint.js"></script>
    <link rel="stylesheet" type="text/css" href="plug-in/joints/joint.css" />
</head>
<body onload="fatie();">
<div id="paper" class="paper"></div>
<script type="text/javascript">
function fatie() {
    $.ajax({
        url: "http://106.14.9.53:8090/get",
        type: "GET",
        data:{country:"县政府"},
        dataType: "jsonp",
        processData: true,
        success: function(json) {
            if(json[0].target==null)
            {
                alert("数据不存在！");
                return;
            }
            var team2="";
            var team="";
            var map="";
            //var a="{root:".concat(json);
            //a=a.concat("}");
            //var obj = eval("("+a+")");
            var obj=json;
            for(var i=0;i<obj.length;i++)
            {
                if(obj[i].id==json[0].target)
                {
                    map=map.concat(i+"/");
                    team=team.concat(i+"|");
                    break;
                }
            }
            for(;;)
            {
                if(team=="")
                {break;}
                var index1 = team.indexOf("|");
                var temp= team.substring(0,index1);
                team = team.slice(index1+1);
                for(var i=0;i<obj.length;i++)
                {
                    if(obj[i].fid==obj[temp].id)
                    {
                        team=team.concat(i+"|");
                        map=map.concat(i+"/");
                    }
                }
            }
            var arr = new Array(obj.length);
            team=map;
            team2=map;
            team2=team2.substring(0,team2.length-1);
            for(;;)
            {
                if(team=="")
                {break;}
                var index1 = team.indexOf("/");
                var temp= team.substring(0,index1);
                team = team.slice(index1+1);
                if(obj[temp].id==json[0].target)
                {
                    arr[temp]=1;
                }
                else
                {
                    for(var i=0;i<obj.length;i++)
                    {
                        if(obj[i].id==obj[temp].fid)
                        {
                            arr[temp]=arr[i]+1;
                        }
                    }
                }
            }
            team=map;
            var level=1;
            for(;;)
            {
                if(team=="")
                {break;}
                var index1 = team.indexOf("/");
                var temp= team.substring(0,index1);
                team = team.slice(index1+1);
                if(arr[temp]!=level)
                {
                    level++;
                    var index1 = map.indexOf(temp);
                    var sub_string1 = map.substring(0,index1-1);
                    var sub_string2 = map.substring(index1);
                    map=sub_string1+"|"+sub_string2;
                }
            }
            map=map.substring(0,map.length-1);
            var t=map.split("|");
            var color = new Array(5);
            color[0]='#30d0c6';
            color[1]='#7c68fd';
            color[2]='#feb563';
            color[3]='#ff05ff';
            color[4]='#ffee0f';
            var point = new Array(obj.length);
            var dtl=t[t.length-1].split("/");
            var dtl2=t.length;
            //if(dtl2<5)
            //height=800;}
            //else
            //{height=300*height;}
            height=dtl2*200;
            if(dtl.length<8)
            {length=1000;}
            else
            {length=dtl.length*100+100;}


            var graph = new joint.dia.Graph();
            var paper = new joint.dia.Paper({
                el: $('#paper'),
                width: length,
                height: height,
                gridSize: 1,
                model: graph,
                perpendicularLinks: true,
                restrictTranslate: true

            });
            paper.$el.css('pointer-events', 'none');
            var member = function(x, y, rank, name, image, background, textColor,dp,size,font) {

                var width,height,refx=0.5;
                if(size==0||size==1)
                {size=1;
                refx=0.4}
                width=200-size*50;
                height=110-size*30;
                if(width<=100)
                {width=100;}
                if(height<=50)
                {height=50;}
                textColor = textColor || "#000";

                var cell = new joint.shapes.org.Member({
                    size:{width:width,height:height},
                    position: { x: x, y: y },
                    attrs: {
                        '.card': { fill: background, stroke: 'none'},
                        //image: { 'xlink:href': 'images/'+ image, opacity: 0.7 },
                        '.rank': { text: dp, fill: textColor, 'word-spacing': '-5px', 'letter-spacing': 0, 'y-alignment': 'middle','x-alignment': 'middle',"ref-y":refx},
                        '.name2': { text: rank, fill: textColor, 'word-spacing': '-5px', 'letter-spacing': 0, 'y-alignment': 'middle','x-alignment': 'middle'},
                        '.name': { text: name, fill: textColor, 'font-size':font, 'font-family': 'Arial', 'letter-spacing': 0 , 'y-alignment': 'middle','x-alignment': 'middle'}
                    }
                });
                graph.addCell(cell);
                return cell;
            };
            function link(source, target, breakpoints) {

                var cell = new joint.shapes.org.Arrow({
                    source: { id: source.id },
                    target: { id: target.id },
                    vertices: breakpoints,
                    attrs: {
                        '.connection': {
                            'fill': 'none',
                            'stroke-linejoin': 'round',
                            'stroke-width': '2',
                            'stroke': '#4b4a67'
                        }
                    }
                });
                graph.addCell(cell);
                return cell;
            }

            for(var i=0;i<t.length;i++)
            {
                var t1=t[i].split("/");
                var heigh=80+150*i;
                var width=length/t1.length;

                var string="";
                for(var j=0;j<t1.length;j++)
                {
                    for(var o=0;o<obj[t1[j]].industry.length;o++)
                    {
                        if(o%3==0)
                        {
                            string=string+"\n";
                        }
                        string=string+obj[t1[j]].industry[o]+",";
                    }
                    //alert(string);
                    string=string.substring(0,string.length-1);
                    if(i==0&&j==0)
                    {member(width/2+j*width-50, 20, '', '射阳县安全生产网格图', 'male.png', '#ffffff', '#000000',"",i,40);}
                    point[t1[j]] = member(width/2+j*width-50, heigh, string, obj[t1[j]].name, 'male.png',color[i], '#f1f1f1',obj[t1[j]].dp,i,14);
                    string="";
                    var temp2=team2.split("/");
                    for(var n=0;n<temp2.length;n++)
                    {
                        if(obj[t1[j]].fid==obj[temp2[n]].id)
                        {
                            link(point[t1[j]],point[temp2[n]]);
                        }
                    }
                }
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(textStatus);
        }
    });
}
</script>

</body>
</html>