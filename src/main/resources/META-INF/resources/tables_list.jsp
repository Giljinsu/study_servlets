<%-- HttpServletRequest request, HttpServletResponse response // 정의가 됨 넘어올때  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>


<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Document</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' 
    integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'>
    <link rel='stylesheet' href='./css/common.css'>
</head>
<body>
    <%@include file="navbars.jsp" %> 
    <%-- 반복적인 것들을 저렇게 넣으면 바로 들어감 여기선 navbars --%>
    <% 
        HashMap<String, String> searchForm = (HashMap<String, String>)request.getAttribute("searchForm"); 
        ArrayList<String> tablesListWithString = (ArrayList<String>)request.getAttribute("tablesListWithString");
    %>
<%-- 테이블안에 캐스트를 해줘야 함 왜냐면 object로 오기 때문 --%>
    <div class='container'>
        <div class='fs-3'>Tables Normal <%= searchForm.get("search_key") %></div>
        <table class='table'>
            <thead>
                <tr>
                    <th scope=>#</th>
                    <th scope=>Handle</th>
                </tr>
            </thead>
            <tbody>
            <% for(int i=0; i< tablesListWithString.size() ; i++) { %>
                <tr>
                    <th scope=><%= (i+1) %></th>
                    <td><%=  tablesListWithString.get(i) %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>

    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' 
    integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4' 
    crossorigin='anonymous'></script>
</body>
</html>