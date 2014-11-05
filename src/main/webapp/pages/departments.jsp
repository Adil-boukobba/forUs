<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/fragement/header.jspf" %>
<%@include file="../WEB-INF/fragement/head.jspf" %>
  
  <div class="container">
	<div class="row">
	<c:if  test="${!empty departements}">
		<div class="col-md-offset-2 col-md-6">
			
			<table class="table" style="text-align: center">
				<caption>Health Centers:</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>Code</th>
						<th>Name</th>
						<th>Hospital</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${departements}" var="dep">
					<tr>
						 <td>${dep.id}</td>
		                <td>${dep.code}</td>
		                <td>${dep.name}</td> 
		                <td>${dep.hospital.name}</td>     
						<td>
						<s:url action="delete" namespace="/Department" var="del_">
							<s:param name="departement.id">${dep.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/Department" var="up_">
							<s:param name="departement.id">${dep.id}</s:param>
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
			<input type="hidden" name="updated" value="${updated }"/>		
			<input type="hidden" name="departement.id" value="${departement.id}"/>
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Code</label>
		    <input type="text" class="form-control" name="departement.code" <c:if test="${updated==true }">value='${ departement.code}'</c:if> placeholder="Enter le nom">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Name</label>
		    <input type="text" class="form-control"  name="departement.name" value='<c:if test="${updated==true }">${departement.name}</c:if>' placeholder="Enter l'address">
		  </div>
		 
		  <div class="form-group">
			    <label for="exampleInputPassword1">Hospital</label>
			<select name="departement.hospital.id" class="form-control">
			  <c:forEach items="${hospitals}" var="hos">
					<option value="${hos.id}"  <c:if  test="${departement.hospital.id==hos.id}"> selected="selected"</c:if> >${hos.name}</option>
				</c:forEach>
			</select>  
		  </div>
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  
  
  
  
  
  




<%@include file="../WEB-INF/fragement/footer.jspf" %>