<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<body>
<h3> Information for all</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="salary"
        onclick="window.location.href = 'hr_info'">
Only for HR
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="performance"
       onclick="window.location.href = 'manager_info'">
Only for manager
</security:authorize>
<br><br>

</body>
</html>