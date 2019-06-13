<#include "../parts/security.ftl">
<#import "../parts/common.ftl" as c>

<@c.page>

<div class="card-columns">
    <#list reports as report>
        <div class="card my-3">
            <div class="m-2">
                <span>${report.inspectorId.username}</span>
                <span>${report.name}</span><br/>
                <i>${report.status}</i>
            </div>
            <div class="card-footer text-muted">
                <a class="btn btn-primary" href="/reports/edit/${report.id}">
                    ${prp.getMessage("text.edit")}
                </a>
                <a class="btn btn-primary" href="/reports/mods/${report.id}">
                    ${prp.getMessage("text.mods")}
                </a>
                <a class="btn btn-primary" href="/reports/delete/${report.id}">
                    ${prp.getMessage("text.delete")}
                </a>
                <a class="btn btn-primary" href="/reports/change/${report.id}">
                    ${prp.getMessage("text.change")}
                </a>
            </div>
        </div>
    <#else>
        ${prp.getMessage("text.noreports")}
    </#list>

    <div class="card my-3">
        <div class="m-2">
            <form method="post">
                <input type="text" class="form-control" name="name" placeholder="name">
                <input type="text" class="form-control" name="comment" placeholder="comment">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="card-footer text-muted">
                    <button type="submit" class="btn btn-primary">${prp.getMessage("text.create")}</button>
                </div>
            </form>
        </div>
    </div>


    </@c.page>