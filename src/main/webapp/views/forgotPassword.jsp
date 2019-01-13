<%@ include file="headerLogin.jsp" %>

<form method="post" action="${action}">
    <table>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" style="border: 1px black solid" required>
            </td>
        </tr>

        <tr>
            <td>Nr matricol</td>
            <td>
                <input type="text" name="nrMatricol" style="border: 1px black solid" required>
            </td>
        </tr>

    <tr>
        <td rowspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
    </table>

</form>

<%@ include file="footer.jsp" %>
