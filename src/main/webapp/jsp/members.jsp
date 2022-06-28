<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
        <th>id</th>
        <th>userName</th>
        <th>age</th>
    </thead>
    <tbody>
<%
    for (Member member : members) {
%>
        <tr>
            <td><%=member.getId()%></td>
            <td><%=member.getUserName()%></td>
            <td><%=member.getAge()%></td>
        </tr>
<%
    }
%>
    </tbody>
</table>
</body>
</html>