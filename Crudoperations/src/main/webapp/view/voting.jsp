<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Voting</title>
</head>
<body>
    <h2>Voting Page</h2>
    <form action="vote" >
        <label for="candidateId">Select a Candidate:</label>
        <select id="candidateId" name="candidateId">
            <c:forEach items="${ve}" var="candidate">
                <option value="${candidate.id}">${candidate.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Vote</button>
    </form>
    
       <form action="removeSession" method="post">
        <button type="submit">LogOut</button>
    </form>
</body>
</html>



