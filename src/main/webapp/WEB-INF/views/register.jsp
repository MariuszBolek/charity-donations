<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<%@include file="common/head.jsp" %>
<body>
<%@include file="common/header.jsp" %>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form modelAttribute="user" method="post">
        <div class="form-group">
          <form:input type="text" name="firstname" placeholder="Imię" path="firstName"/>
        </div>
        <div class="form-group">
          <form:input type="text" name="lastName" placeholder="Nazwisko" path="lastName" />
        </div>
        <div class="form-group">
          <form:input type="email" name="email" placeholder="Email" path="email"/>
        </div>
        <div class="form-group">
          <form:input type="password" name="password" placeholder="Hasło" path="password"/>
        </div>

        <div class="form-group">
          <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>


<%@include file="common/footer.jsp" %>



  </body>
</html>
