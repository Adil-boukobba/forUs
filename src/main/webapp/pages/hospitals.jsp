<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/fragement/header.jspf" %>
<%@include file="../WEB-INF/fragement/head.jspf" %>
  
  <div class="container">
	<div class="row">
	<c:if  test="${!empty hospitals}">
		<div class="col-md-offset-2 col-md-6">
			
			<table class="table" style="text-align: center">
				<caption>Health Centers:</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Address</th>
						<th>Health Center</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${hospitals}" var="hos">
					<tr>
						 <td>${hos.id}</td>
		                <td>${hos.name}</td>
		                <td>${hos.address}</td> 
		                <td>${hos.center.name}</td>     
						<td>
						<s:url action="delete" namespace="/Hospital" var="del_">
							<s:param name="hospital.id">${hos.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/Hospital" var="up_">
							<s:param name="hospital.id">${hos.id}</s:param>
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
			<input type="hidden" name="hospital.id" value="${hospital.id}">
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Name</label>
		    <input type="text" class="form-control" name="hospital.name" <c:if test="${updated==true }">value='${ hospital.name}'</c:if> placeholder="Enter le nom">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Address</label>
		    <input type="text" class="form-control"  name="hospital.address" value='<c:if test="${updated==true }">${hospital.address}</c:if>' placeholder="Enter l'address">
		  </div>
		 
		  <div class="form-group">
			    <label for="exampleInputPassword1">Center</label>
			<select name="hospital.center.id" class="form-control">
			  <c:forEach items="${centers}" var="cen">
					<option value="${cen.id}"  <c:if  test="${hospital.center.id==cen.id}"> selected="selected"</c:if> >${cen.name}</option>
				</c:forEach>
			</select>  
		  </div>
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  
  
  
  
  
  




<%@include file="../WEB-INF/fragement/footer.jspf" %>