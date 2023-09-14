<html>
<body>
    <jsp:useBean id="secrets" class="github.mathianasj.secrets.SecretsBean" />
<h2>Hello World with secret <jsp:getProperty name="secrets" property="password" />!</h2>
</body>
</html>
