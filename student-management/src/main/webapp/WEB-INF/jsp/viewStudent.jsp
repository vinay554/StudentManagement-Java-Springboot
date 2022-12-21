<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>
<%
            // Set refresh, autoload time as 10 seconds
            if(session.getAttribute("message") != null){
            	response.setIntHeader("Refresh", 10);
            }
            
%>
<div class="container">
	<div class="row">
		<div class="col-md-10 ">
			<a type="button" class="btn btn-primary btn-md"
				href="/index/getStudentForm">Add Student</a>
			<a type="button" class="btn btn-primary btn-md"
				href="/index/getStudentSearchForm">Search Student</a>
		</div>
	</div>
	<br>
	<div class="row">
	<div class="col-md-10 ">
	<div style="background-color: yellow; ">
							<c:out value="${message}"></c:out>
						</div>
						</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-10 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>List of Students</h4>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Student ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								
								<th>DOB</th>
								<th>Department Name</th>
								<th>Course</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${students}" var="student">
								<tr>
									<td>${student.student_id}</td>
									<td>${student.firstName}</td>
									<td>${student.lastName}</td>
									
									
									<td>${student.dob}
											</td>
											<td>${student.departmentName}</td>
											<td>${student.program}</td>
									<td><a type="button" class="btn btn-success"
										href="/index/${student.student_id}/editStudent">Update</a> <a
										type="button" class="btn btn-warning"
										href="/index/${student.student_id}/deleteStudent">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>