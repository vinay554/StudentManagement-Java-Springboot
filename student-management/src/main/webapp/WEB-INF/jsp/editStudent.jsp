<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
function redirect_url(url)
{
	axios.get("http://localhost:8095/index/getCourse/"+url)
	.then(response =>{
	    console.log(response.data);
	    var data= response.data;
	    var s = '<option value="-1">Select Course</option>';
        for (var i = 0; i < data.length; i++) {
        	console.log(data[i].course);
            s += '<option value="' + data[i].course + '">' + data[i].course + '</option>';
        }
        $("#course").html(s);
	})
}
</script>
<div class="container">
<div>
		<a type="button" class="btn btn-primary btn-md" href="/index">View
			Student List</a>
	</div>
	<br>
	<div class="row">
		<div class="col-md-10 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Update Student</h4>
				</div>
				<div class="panel-body">
					<form action='/index/updateStudent' method='post'>

						<table class='table table-hover table-responsive table-bordered'>

							<tr>
								<td><b>Student ID</b></td>
								<td><input type='text' name='student_id'
									class='form-control' value="${student.student_id}"
									readonly="readonly" /></td>
							</tr>

							<tr>
								<td><b>first Name</b></td>
								<td><input type='text' name='firstName'
									class='form-control' value="${student.firstName}" /></td>
							</tr>
							<tr>
								<td><b>Last Name</b></td>
								<td><input type='text' name='lastName' class='form-control'
									value="${student.lastName}" /></td>
							</tr>

							<%-- <tr>
								<td><b>Program</b></td>
								<td><input type='text' name='program' class='form-control'
									value="${student.program}" /></td>

							</tr> --%>
							<tr>
								<td><b>DOB</b></td>
								<td><input type='date' name='dob' class='form-control'
									value="${student.dob}" /></td>

							</tr>
							<tr>
								<td><b>Department Name</b></td>
								<td><select name="departmentName" onchange="redirect_url(this.value)">
										<c:forEach items="${department}" var="departmentName"
											varStatus="loop">
											<option  value="${departmentName.departmentName}" 
											${departmentName.departmentName == student.departmentName ? 'selected="selected"' : ''}>
												${departmentName.departmentName}</option>
										</c:forEach></select></td>
							</tr>
							<tr>
								<td><b>Course</b></td>
								<td><select id="course" name="program" >
								<c:forEach items="${courses}" var="course"
											varStatus="loop">
											<option  value="${course.course}" 
											${course.course == student.program ? 'selected="selected"' : ''}>
												${course.course}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button type="submit" class="btn btn-primary">Update
										Student</button>
										<a type="button" class="btn btn-warning btn-md" href="/index">Cancel Update
										</a>
								</td>
							</tr>

						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>