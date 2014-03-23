<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	
  	<title>PAF - Assignment 2</title>
  	<meta name="description" content="Home of PAF assignment 2">
  
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
            <li class="active"><a href="<c:url value="/"/>">Home</a></li>
            <li><a href="<c:url value="pattern-selector"/>">Pattern Selector</a></li>
            <li><a href="<c:url value="pattern-editor"/>">Pattern Editor</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <div class="starter-template">
        <h1>Home</h1>
        <p class="lead">Welcome to our Pattern web app of team 6.</p>
      </div>

    </div><!-- /.container -->

	<jsp:include page="../includes/default_footer.jsp" /> 
	
  </body>
</html>
