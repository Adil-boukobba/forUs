<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    <style>
    table.list
    {
        border-collapse:collapse;
        width: 40%;
    }
    table.list, table.list td, table.list th
    {
        border:1px solid gray;
        padding: 5px;
    }
    </style>
</head>
<body>
  

  
<s:form method="post" action="add">

<s:textfield key="ID" name="article.id"></s:textfield>
<s:textfield key="famille" name="article.famille"></s:textfield> <!-- combo -->
<s:textfield key="group" name="article.group"></s:textfield><!-- combo -->
<s:textfield key="Libelle" name="article.libelle"></s:textfield> 

<%--    <s:combobox list="familles" label="famille:" headerKey="-1" headerValue="--- Select ---" ></s:combobox> --%>

<s:submit value="Save"></s:submit>
</s:form>
  
      
<h3>Aricles</h3>
<c:if  test="${!empty articles}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Famille</th>
            <th align="left">Group</th>
            <th align="left">Nom</th>
            <th align="left">Valid From</th>
            <th> option</th>
        </tr>
        <c:forEach items="${articles}" var="art">
            <tr>
                <td>${art.id} </td>
                <td>${art.famille.nbr}</td>
                <td>${art.group.nbr}</td>
                <td>${art.libelle}</td>
                <td>adil</td>
                <td><a href="delete/${art.id}">delete</a></td> 
<%--                  <td><a href="update/${emp.id}">update</a></td> --%>
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>