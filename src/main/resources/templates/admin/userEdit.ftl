<#import "../parts/common.ftl" as c>

<@c.page>
    User editor

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">

        <select name="role">
            <option value="Admin">${prp.getMessage("text.admin")}Admin</option>
            <option value="Client">${prp.getMessage("text.client")}Client</option>
            <option value="Inspector">${prp.getMessage("text.inspector")}Inspector</option>
        </select>
        <select name="clientType">
            <option value="Yuridical">${prp.getMessage("text.yuri")}</option>
            <option value="Physical">${prp.getMessage("text.phys")}</option>
        </select>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>
