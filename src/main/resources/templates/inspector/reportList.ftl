<#import "../parts/common.ftl" as c>

<@c.page>

<div class="card-columns">
    <#list reports as report>
        <div class="card my-3">
            <div class="m-2">
                <span>${report.clientId.username}</span>
                <span>${report.name}</span><br/>
                <i>${report.status}</i>
            </div>
            <div class="card-footer text-muted">
                <a class="btn btn-primary" href="/inspector/view/${report.id}">
                    ${prp.getMessage("text.view")}
                </a>
                <a class="btn btn-primary" href="/inspector/mods/${report.id}">
                    ${prp.getMessage("text.mods")}
                </a>
                <a class="btn btn-primary" href="/inspector/approve/${report.id}">
                    ${prp.getMessage("text.approve")}
                </a>
                <a class="btn btn-primary" href="/inspector/reject/${report.id}">
                    ${prp.getMessage("text.reject")}
                </a>
            </div>
        </div>
    <#else>
        ${prp.getMessage("text.noreports")}
    </#list>

    </@c.page>
