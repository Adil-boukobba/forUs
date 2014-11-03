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
<table>
	<tr>
	
		<td>
			ID Group
		</td>
		
		<td>
		 <s:textfield name="group.idGroup"></s:textfield>
		 </td>
	</tr>	
<tr>	
		<td>
			Nom: 
		</td>
		
		<td>
		 <s:textfield name="group.nbr"></s:textfield>
		 </td>
	</tr>	
<tr>
	<td>
		Famille : 
	</td>
	
	<td>
	<select  name="group.famille.id">
		<c:if  test="${!empty familles}">
			 <c:forEach items="${familles}" var="fam">
			<option value="${fam.id}">${fam.nbr}</option>
			</c:forEach>
		</c:if>
	</select>
	</td>
</tr>
<tr>
	<td></td>
	<td>
		<s:submit value="Save"></s:submit>
	</td>
</tr>
</table>
</s:form>


  
      
<h3>Groups</h3>
<c:if  test="${!empty groups}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Id Group</th>
            <th align="left">Nom</th>
            <th align="left">Famille</th>            
            <th> option</th>
        </tr>
        <c:forEach items="${groups}" var="gr">
            <tr>
                <td>${gr.id}</td>
                <td>${gr.idGroup}</td>
                <td>${gr.nbr}</td>
                <td>${gr.famille.nbr}</td>
                
                <td><a href="delete/${gr.id}">delete</a> &nbsp;
                 <a href="update/${gr.id}">update</a> 
				</td> 
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>