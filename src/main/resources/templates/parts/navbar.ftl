<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">${prp.getMessage("text.taxservice")}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">${prp.getMessage("text.home")}</a>
            </li>
            <#if isClient>
                <li class="nav-item">
                    <a class="nav-link" href="/reports/${currentUserId}">${prp.getMessage("text.myreports")}</a>
                </li>
            </#if>
            <#if isInspector>
                <li class="nav-item">
                    <a class="nav-link" href="/inspector/${currentUserId}">${prp.getMessage("text.clientreports")}</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">${prp.getMessage("text.userlist")}</a>
                </li>
            </#if>
            <#--<#if user??>-->
            <#--<li class="nav-item">-->
            <#--<a class="nav-link" href="/user/profile">${prp.getMessage("text.profile")}</a>-->
            <#--</li>-->
            <#--</#if>-->
        </ul>
        <div class="mr-2">
            <select id="locales" class="form-control">
                <option value="">${prp.getMessage("text.language")}</option>
                <option value="EN">EN</option>
                <option value="UA">UA</option>
            </select>
        </div>
        <div class="navbar-text mr-3"><#if user??>${name}<#else>${prp.getMessage("text.guest")}</#if></div>
        <#if user??>
            <@l.logout />
        <#else>
            <a href="/login" class="btn btn-primary">${prp.getMessage("text.login")}</a>
        </#if>
    </div>
</nav>
