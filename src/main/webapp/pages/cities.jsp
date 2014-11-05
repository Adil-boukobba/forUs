<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/fragement/header.jspf" %>
<%@include file="../WEB-INF/fragement/head.jspf" %>


  <div class="container">
  
    	<form action="search" method="post"> 
  <div class="row">
  	
 	
  
  		 <div class="col-md-2">
  		 # :<input type="text" class="form-control" name="city.id"/>
  		 </div>
  		 <div class="col-md-2">
  		 Code<input type="text" class="form-control" name="city.code"/>
  		 </div>
  		<div class="col-md-2">
  		Name<input type="text" class="form-control" name="city.name"/>
  		</div>
  		
  		<div class="col-md-2">
  		 Region<input type="text" class="form-control" name="city.region.name"/>
  		</div>
  		<div class="col-md-4"></div>
  		  </div>
  		<div class="row">
  		<div class="col-md-2">
  		<button type="submit" class="btn btn-success">Filtrer</button>
  		</div>
  		</div>
  	</form>
  
  
  

  
  
	<div class="row">
	<c:if  test="${!empty regions}">
		<div class="col-md-offset-2 col-md-6">
			
			<table class="table" style="text-align: center">
				<caption>Cities:</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>Code</th>
						<th>Name</th>
						<th>Region</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${cities}" var="cit">
					<tr>
						 <td>${cit.id}</td>
		                <td>${cit.code}</td>
		                <td>${cit.name}</td> 
		                <td>${cit.region.name}</td>     
						<td>
						<s:url action="delete" namespace="/City" var="del_">
							<s:param name="city.id">${cit.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/City" var="up_">
							<s:param name="city.id">${cit.id}</s:param>
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
			<input type="hidden" name="city.id" value="${city.id}">
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Code</label>
		    <input type="number" class="form-control" name="city.code" <c:if test="${updated==true }">value='${ city.code}'</c:if> placeholder="Enter le nom">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Nom</label>
		    <input type="text" class="form-control"  name="city.name" value='<c:if test="${updated==true }">${city.name}</c:if>' placeholder="Enter le nom">
		  </div>
		 
		  <div class="form-group">
			    <label for="exampleInputPassword1">Region</label>
			<select name="city.region.id" class="form-control">
			  <c:forEach items="${regions}" var="reg">
					<option value="${reg.id}"  <c:if  test="${city.region.id==reg.id}"> selected="selected"</c:if> >${reg.name}</option>
				</c:forEach>
			</select>  
		  </div>
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  
  
  
  
  
  




<%@include file="../WEB-INF/fragement/footer.jspf" %>