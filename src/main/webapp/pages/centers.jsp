<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/fragement/header.jspf" %>
<%@include file="../WEB-INF/fragement/head.jspf" %>
  
  <div class="container">
	<div class="row">
	<c:if  test="${!empty centers}">
		<div class="col-md-offset-2 col-md-6">
			
			<table class="table" style="text-align: center">
				<caption>Health Centers:</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>Code</th>
						<th>Name</th>
						<th>City</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${centers}" var="cen">
					<tr>
						 <td>${cen.id}</td>
		                <td>${cen.code}</td>
		                <td>${cen.name}</td> 
		                <td>${cen.city.name}</td>     
						<td>
						<s:url action="delete" namespace="/HealthCenter" var="del_">
							<s:param name="center.id">${cen.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/HealthCenter" var="up_">
							<s:param name="center.id">${cen.id}</s:param>
						</s:url>
						<s:a href="%{up_}"><button type="button" class="btn btn-warning">Update</button></s:a>
						<s:a href="%{del_}"><button type="button" class="btn btn-danger">Delete</button></s:a>
						</td>
					</tr>				
				</c:forEach>					
				</tbody>
			</table>
			
		</div>
		</c:if>
		
		
		
		
	<div class="col-md-4">
		<form role="form" method="post" action="add">
		
		<c:if test="${ updated ==true }"> 
			<input type="hidden" name="updated" value="${updated }">		
			<input type="hidden" name="center.id" value="${center.id}">
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Code</label>
		    <input type="number" class="form-control" name="center.code" <c:if test="${updated==true }">value='${ center.code}'</c:if> placeholder="Enter le code">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Nom</label>
		    <input type="text" class="form-control"  name="center.name" value='<c:if test="${updated==true }">${center.name}</c:if>' placeholder="Enter le nom">
		  </div>
		 
		  <div class="form-group">
			    <label for="exampleInputPassword1">City</label>
			<select name="center.city.id" class="form-control">
			  <c:forEach items="${cities}" var="cit">
					<option value="${cit.id}"  <c:if  test="${center.city.id==cit.id}"> selected="selected"</c:if> >${cit.name}</option>
				</c:forEach>
			</select>  
		  </div>
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  
  
  
  
  
  




<%@include file="../WEB-INF/fragement/footer.jspf" %>