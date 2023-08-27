<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>
<body>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        table {
            border-collapse: collapse;
            width: 60%;
            margin: 20px auto;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #333;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>

    <h2>Voting Results</h2>
     <table border="1">
        <tr>
            <th>party</th>
            <th>Votes</th>
        
        </tr>
        <c:forEach items="${candidates}" var="candidate" varStatus="loop">
            <tr>
                <td>${candidate.name}</td>
                <td>${votesCount[loop.index]}</td>
            </tr>
        </c:forEach>
    </table>
    
    
     <form action="party" method="post">
        <label for="name">Register Party Name</label>
        <input type="text" name="name" required>

        <button type="submit">Register</button>
        </form>
    
    <a href="addAdmin">add admin Page</a>
        
         <form action="removeSessions" method="post">
        <button type="submit">LogOut</button>
    </form>
    
        
</body>
</html>