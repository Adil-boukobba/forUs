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
		<input type="hidden" name="article.id" value="${article.id}">
	</td>
	</tr>
</c:if>
<tr>
	<td>Famille</td>
	
	<td>
	<select  name="article.famille.id" style="width:142px;height:22px">
		<c:if  test="${!empty familles}">
			 <c:forEach items="${familles}" var="fam">
			<option value="${fam.id}"  <c:if  test="${article.famille.id==fam.id}"> selected="selected"</c:if> >${fam.nbr}</option>
			</c:forEach>
		</c:if>
	</select>
	</td>
</tr>
<tr>
	<td>
	Group:
	</td>
	<td>
	<select  name="article.group.id" style="width:142px;height:22px">
		<c:if  test="${!empty groups}">
			 <c:forEach items="${groups}" var="gr">
			<option value="${gr.id}"  <c:if  test="${gr.id==article.group.id}"> selected="selected"</c:if>  >${gr.nbr}</option>
			</c:forEach>
		</c:if>
	</select>
	</td>
</tr>
<tr>
	<td>
	Libelle
	</td>
	<td>
	<input type="text"  name="article.libelle" value='<c:if test="${!empty article.id} }"> ${article.nbr }</c:if>'/>
	</td>
</tr>
<tr>
	<td>
	Valid From
	</td>
	<td>
	<input type="text" name="article.validfrom" value='<c:if  test="${!empty gr.id}"> ${article.validfrom }</c:if>' />
	</td>
</tr>
<tr>
	<td>
	Valid To
	</td>
	<td>
	<input type="text" name="article.validto"  value='<c:if  test="${!empty gr.id}"> ${article.validto }</c:if>'/>
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
  
      
<h3>Aricles</h3>
<c:if  test="${!empty articles}">
    <table class="list">
        <tr>
            <th align="left">Id</th>
            <th align="left">Famille</th>
            <th align="left">Group</th>
            <th align="left">Nom</th>
            <th align="left">Valid From</th>
             <th align="left">Valid to</th>
            <th> option</th>
        </tr>
        <c:forEach items="${articles}" var="art">
            <tr>
                <td>${art.id} </td>
                <td>${art.famille.nbr}</td>
                <td>${art.group.nbr}</td>
                <td>${art.libelle}</td>
                <td>${art.validfrom}</td>
                <td>${art.validto}</td>
                <td><a href="delete/${art.id}">delete</a> 
                 &nbsp; <a href="update/${art.id}">update</a></td> 
            </tr>
        </c:forEach>
    </table>
</c:if>
  
</body>
</html>