<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource
    var="oracle"
    driver="oracle.jdbc.driver.OracleDriver"
    url="jdbc:oracle:thin:@localhost:1521:XE"  
    user="hr"
    password="hr"
    />

<sql:query  var="emplist" dataSource="${oracle}">
    select  * from employees
    where salary > 10000
    order by first_name
</sql:query>

<ul>
    <c:forEach  var="row"  items="${emplist.rows}">
        <li>${row.employee_id}, ${row.first_name}, ${row.salary} </li>
    </c:forEach>
</ul>




