<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/fragement/header.jspf" %>
<%@include file="../WEB-INF/fragement/head.jspf" %>
  
  <div class="container">
  <form action="searsh" method="post">  	
  <div class="row">
  	
  	
 		<div class="col-md-2">
  		 # :<input type="text" class="form-control" name="region.id"/>
  		 </div>
  		 <div class="col-md-2">
  		 Code<input type="text" class="form-control" name="region.code"/> 
  		 </div>
  		 <div class="col-md-2">
  		 Name<input type="text" class="form-control" name="region.name"/>
  		 </div>
  				
  		<div class="col-md-2" style="margin-top:20px">
  		<button type="submit" class="btn btn-success"> Filtrer</button>
  		</div>
  	</div>
  	</form>
  
  
  
  
  
  
	<div class="row">
	<c:if  test="${!empty regions}">
		<div class="col-md-offset-2 col-md-6">
			
			<table class="table" style="text-align: center">
				<caption>Regions:</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>Code</th>
						<th>Name</th>
						<th>Options</th>						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${regions}" var="reg">
					<tr>
						<td>${reg.id}</td>
               			<td>${reg.code}</td>
                		<td>${reg.name}</td>   
						<td>
						<s:url action="delete" namespace="/Region" var="del_">
							<s:param name="region.id">${reg.id}</s:param>
						</s:url>
						<s:url action="update" namespace="/Region" var="up_">
							<s:param name="region.id">${reg.id}</s:param>
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
			<input type="hidden" name="region.id" value="${region.id}">
		</c:if>
		
		  <div class="form-group">
		    <label for="exampleInputEmail1">Code</label>
		    <input type="number" class="form-control" name="region.code" <c:if test="${updated==true }">value='${ region.code}'</c:if> placeholder="Enter le nom">
		  </div>
		 
		 <div class="form-group">
		    <label for="exampleInputEmail1">Nom</label>
		    <input type="text" class="form-control"  name="region.name" value='<c:if test="${updated==true }">${region.name}</c:if>' placeholder="Enter le nom">
		  </div>
		 
		 
  <button type="submit" class="btn btn-success">Save</button>
</form>
		</div>
	</div>
</div>
  
  
  
  
  
  




<%@include file="../WEB-INF/fragement/footer.jspf" %>