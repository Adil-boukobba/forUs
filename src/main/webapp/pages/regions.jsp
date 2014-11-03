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

<c:if test="${ updated ==true }"> 
<tr>
	<td>
		
			
		<input type="hidden" name="updated" value="${updated }">
	</td>
	<td>		
		<input type="hidden" name="region.id" value="${region.id}">
	</td>
	</tr>
</c:if>

	<tr>
	
		<td>
			Code
		</td>
		
		<td>
		 <input type="text" name="region.code" <c:if test="${updated==true }">value='${ region.code}'</c:if>/>
		 </td>
	</tr>	
<tr>	
		<td>
			Name: 
		</td>
		
		<td>
		 <input type="text" name="region.name" value='<c:if test="${updated==true }">${region.name}</c:if>'/>
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


  
      
<h3>Regions</h3>
<c:if  test="${!empty regions}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Code</th>
            <th align="left">Name</th>                        
            <th> option</th>
        </tr>
        <c:forEach items="${regions}" var="reg">
            <tr>
                <td>${reg.id}</td>
                <td>${reg.code}</td>
                <td>${reg.name}</td>                
                
                <td><a href="delete/${reg.id}">delete</a> &nbsp;
                 <a href="update/${reg.id}">update</a> 
				</td> 
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>