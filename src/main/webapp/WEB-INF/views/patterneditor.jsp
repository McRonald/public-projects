<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	
  	<title>Pattern Editor - Team 6</title>
  	<meta name="description" content="Pattern Editor of PAF assignment 2 build by team 6">
  
	<jsp:include page="../includes/default_header.jsp" /> 
    
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/"/>">PAF2 team 6</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="<c:url value="/"/>">Home</a></li>
            <li><a href="<c:url value="/pattern-selector"/>">Pattern Selector</a></li>
            <li class="active"><a href="<c:url value="/pattern-editor"/>">Pattern Editor</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

	     <div class="no-padding panel panel-primary col-md-3">
			<div class="panel-heading">Current Patterns</div>
			<div class="panel-body">
				<c:choose>
					<c:when test="${not empty patterns}">
					<div class="list-group">
						<c:forEach var="patterns" items="${patterns}" varStatus="loopStatus">
							<li class="list-group-item list-group-item-info">
								<a href="<c:url value="/pattern-editor/"/>${loopStatus.index}" >${patterns.name}</a>
								
								<span class="badge">
								<a href="<c:url value="/pattern-editor/remove/"/>${loopStatus.index}" >
									<i class="glyphicon glyphicon-remove"></i>
									</a>
								</span>
								
							</li>
						</c:forEach>
					</div>
					</c:when>
					<c:otherwise>
						<p>no patterns yet..</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="panel-footer">
				<a class="btn btn-primary" href="<c:url value="/pattern-editor"/>">
					<span>
						<i class="glyphicon glyphicon-plus"></i>
						<span>New Pattern</span>
					</span>
				</a>
			</div>
		</div>
	<form:form role="form" method="POST" commandName="PatternForm">
		<div class="no-padding panel panel-primary col-md-7 col-md-offset-1">
			<div class="panel-heading">Pattern Editor</div>
			<div class="panel-body">
				    
				  <div class="form-group">
				    <label for="name">Name</label>
				    <form:input type="text" class="form-control" id="name" path="name" placeholder="Enter name of the pattern" />
				    <form:input type="hidden" id="id" path="id"/>
				  </div>
				  <div class="form-group">
				    <label for="context">Context</label>
					<form:textarea class="form-control" rows="2" id="context" path="context" placeholder="Enter context in which this pattern occurs"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="problems">Problems</label>
					<form:textarea class="form-control" rows="3" id="problems" path="problems" placeholder="Enter problems of the pattern"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="forces">Forces</label>
					<form:textarea class="form-control" rows="6" id="forces" path="forces" placeholder="Enter forces which contribute to the problems"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="solution">Solution</label>
					<form:textarea class="form-control" rows="3" id="solution" path="solution" placeholder="Enter solution which resolves the forces and therefore the problem"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="description">Description</label>
					<form:textarea class="form-control" rows="6" id="description" path="description" placeholder="Enter description of the solution"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="consequences">Consequences</label>
					<form:textarea class="form-control" rows="4" id="consequences" path="consequences" placeholder="Enter consequences of implementing the solution"></form:textarea>
				  </div>
				  <div class="form-group">
				    <label for="diagram">Upload diagram</label>
				    <form:input type="file" id="diagram" path="name" />
				    <p class="help-block">All files are accepted, this file can then be downloaded when viewing the pattern.</p>
				  </div>
				  <div class="form-group">
				    <label for="participants">participants</label>
				    <input type="text" class="form-control" id="participants" path="participants" placeholder="Enter participants seperated by comma's">
				  </div>
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</div>
	</form:form>

    </div><!-- /.container -->

	<jsp:include page="../includes/default_footer.jsp" /> 
	
  </body>
</html>
