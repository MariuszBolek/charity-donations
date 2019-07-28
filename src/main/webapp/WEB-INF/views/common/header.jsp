<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/index" class="btn btn--without-border active">Start</a></li>
            <li><a href="/index#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/index#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/index#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="form" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="${pageContext.request.contextPath}#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>
