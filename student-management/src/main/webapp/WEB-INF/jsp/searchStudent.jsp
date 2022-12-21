<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/index">View
			Student List</a>
	</div>
	<br>
	<div class="row">
		<div class="col-md-4">
			<form action='/index/searchStudent' method='post'>
			<div style="">
			<label for="fname">Student ID:</label><br>
			<input style=" width:400px" type='text' name='student_id'
									class='form-control' required /><br>
							
									<button style="" type="submit" class="btn btn-primary">Search
										Student</button><br>
			</div>
			<br>
			
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Student Details</h4>
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
								<tr>
									<td>${student.student_id}</td>
									<td>${student.firstName}</td>
									<td>${student.lastName}</td>
									
									<td>${student.dob}</td>
									<td>${student.departmentName}</td>
									<td>${student.program}</td>
								</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>