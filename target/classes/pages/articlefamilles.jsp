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
  


<s:form action="add" method="post">

 <table>
    	<tr>
            <td><s:textfield key="ID" name="famille.idFamille" /></td>
        </tr>    
        <tr>
            <td><s:textfield key="Nom " name="famille.nbr"/></td>
        </tr>
        
        <tr>
            <td>
                <s:submit key="Add"></s:submit>
            </td>
        </tr>
    </table> 
</s:form>

  
      
<h3>Familles</h3>
<c:if  test="${!empty familles}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Nom</th>
            <th align="left">Id_Famille</th>            
            <th> option</th>
        </tr>
        <c:forEach items="${familles}" var="fam">
            <tr>
                <td>${fam.id} </td>
                <td>${fam.nbr}</td>
                <td>${fam.idFamille}</td>
                
                <td><a href="delete/${fam.id}">delete</a>
               <a href="prepare/${fam.id}">update</a> 
				</td> 
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>