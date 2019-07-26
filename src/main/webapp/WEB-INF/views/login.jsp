<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="common/head.jsp" %>
<body>
<%@include file="common/header.jsp" %>

    <section class="login-page">
      <h2>Zaloguj się</h2>
      <form:form modelAttribute="user" method="post">
        <div class="form-group">
          <form:input type="email" name="email" placeholder="Email"  path="email"/>
        </div>
        <div class="form-group">
          <form:input type="password" name="password" placeholder="Hasło"  path="password"/>
          <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/register" class="btn btn--without-border">Załóż konto</a>
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form:form>
    </section>

<%@include file="common/footer.jsp" %>
  </body>
</html>
