<%--@elvariable id="error" type="com.virtusaproject.vsharesecurities.dto.ErrorDto"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Page not found</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/errorpage.css"/>
    <script src="${pageContext.request.contextPath}/js/font-loader.js"></script>
</head>
<body>
    <div id="errorcenter">
        <span id="code">${error.status}</span>
        <span id="content">${error.title}</span>
        <span class="description">${error.description}</span>
        <span>
            <a class="home-button" href="${pageContext.request.contextPath}/">Home</a>
        </span>
    </div>
</body>
</html>