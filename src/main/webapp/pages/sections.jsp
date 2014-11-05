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
						<th>Department</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${sections}" var="sec">
					<tr>
						 <td>${sec.id}</td>
		                <td>${sec.code}</td>
		                <td>${sec.name}</td> 
		                <td>${sec.department.name}</td>     
						<td>
						<s:url action="delete" namespace="/Section" var="del_">
							<s:param name="section.id">${sec.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/Section" var="up_">
							<s:param name="section.id">${sec.id}</s:param>
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
			<input type="hidden" name="section.id" value="${section.id}"/>
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Code</label>
		    <input type="number" class="form-control" name="section.code" <c:if test="${updated==true }">value='${ section.code}'</c:if> placeholder="Enter le nom">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Name</label>
		    <input type="text" class="form-control"  name="section.name" value='<c:if test="${updated==true }">${section.name}</c:if>' placeholder="Enter l'address">
		  </div>
		 
		  <div class="form-group">
			    <label for="exampleInputPassword1">Department</label>
			<select name="section.department.id" class="form-control">
			  <c:forEach items="${departements}" var="dep">
					<option value="${dep.id}"  <c:if  test="${section.department.id==dep.id}"> selected="selected"</c:if> >${dep.name}</option>
				</c:forEach>
			</select>  
		  </div>
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  

<%@include file="../WEB-INF/fragement/footer.jspf" %>