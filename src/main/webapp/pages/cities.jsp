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
		<input type="hidden" name="city.id" value="${city.id}">
	</td>
	</tr>
</c:if>

	<tr>
	
		<td>
			Code
		</td>
		
		<td>
		 <input type="text" name="city.code" <c:if test="${updated==true }">value='${ city.code}'</c:if>/>
		 </td>
	</tr>	
<tr>	
		<td>
			Name: 
		</td>
		
		<td>
		 <input type="text" name="city.name" value='<c:if test="${updated==true }">${city.name}</c:if>'/>
		 </td>
	</tr>	
<tr>

<tr>	
		<td>
			Region: 
		</td>
		
		<td>
		<select  name="city.region.id" style="width:142px;height:22px">
		<c:if  test="${!empty regions}">
			 <c:forEach items="${regions}" var="reg">
			<option value="${reg.id}"  <c:if  test="${city.region.id==reg.id}"> selected="selected"</c:if> >${reg.name}</option>
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


  
      
<h3>Cities</h3>
<c:if  test="${!empty cities}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Code</th>
            <th align="left">Name</th> 
            <th align="left">Region</th>                        
            <th> option</th>
        </tr>
        <c:forEach items="${cities}" var="cit">
            <tr>
                <td>${cit.id}</td>
                <td>${cit.code}</td>
                <td>${cit.name}</td> 
                <td>${cit.region.name}</td>                
                <td><a href="delete/${cit.id}">delete</a> &nbsp;
                 <a href="update/${cit.id}">update</a> 
				</td> 
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>