<%--
  Created by IntelliJ IDEA.
  User: FYG
  Date: 17/6/23
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${event.eventName}</title>
</head>
<body>

    <%--<div id="messageBar">You can't see this!</div>--%>
    <h1>${event.eventName}</h1>
    <h2>The event will be hold on ${event.eventDate}</h2>
    <p>${event.description}</p>
    <a href="/fvb_web/event${event.eventId}/deleteEvent">Delete</a>
    <%--<button type="submit" href="/fvb_web/event${event.eventId}/deleteEvent">Next</button>--%>
    <h1>Add restaurants </h1>
    <input type="text" name="restaurantName" id="restaurantName"/>
    <input type="submit" value="Add" onclick="addRestaurant();"/>


    <h1>Add Members </h1>
    <input type="text" name="memberName" id="memberName"/>
    <input type="submit" value="Add" onclick="addMember();"/>




    <%--<input type="submit" value="添加" onclick="ajaxTest();"/>--%>
    <script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
    <script src="../fvb_web/js/eventPage.js"></script>
    <script>
        function addRestaurant(){
            var data = {restaurantName: $("#restaurantName").val()};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "text",
                url:"event" + "${event.eventId}" + "/addRestaurant",
                success: function(result){
                    //alert(result)
                    if(result == "true")
                    {
                        alert("Add restaurant successfully!!!");
                    }
                    else {
                        alert("No such restaurant or you have already added this restaurant");
                    }
                }
            });
        }
    </script>
    <script>
        $("#restaurantName").blur(function () {
            if ($(this).val()) {
                var data = {restaurantName: $(this).val()};
                console.log(data);
                $.ajax({
                    type: "GET",
                    url: "event" + "${event.eventId}" + "/validRestName",
                    data: data,
                    dataType: "text",
                    success: function(result){
                        //alert(result)
                        if(result == "true")
                        {
                            $("#restaurantName").css("border", "5px solid green")
                        }
                        else if(result == "false"){
                            $("#restaurantName").css("border", "5px solid red");
                        }
                    }
                })
            }
        })
    </script>
    <script>
        $("#memberName").blur(function () {
            if ($(this).val()) {
                var data = {memberName: $(this).val()};
                $.ajax({
                    type: "GET",
                    url: "event" + "${event.eventId}" + "/validMemberName",
                    data: data,
                    dataType: "text",
                    success: function(result){
                        //alert(result)
                        if(result == "true")
                        {
                            $("#memberName").css("border", "5px solid green")
                        }
                        else if(result == "false"){
                            $("#memberName").css("border", "5px solid red");
                        }
                    }
                })
            }
        })
    </script>
    <script>
        function addMember(){
            var data = {memberName: $("#memberName").val()};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "text",
                url:"event" + "${event.eventId}" + "/addMember",
                success: function(result){
                    //alert(result)
                    console.log(result);
                    if(result == "true")
                    {
                        alert("Add member successfully!!!");
                    }
                    else {
                        alert("No such user or you have already added this user");
                    }
                }
            });
        }
    </script>
</body>
</html>