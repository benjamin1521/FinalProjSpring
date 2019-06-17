<#include "../parts/security.ftl">
<#import "../parts/common.ftl" as c>

<@c.page>

    <div class="card my-3">
        <#list mods as mod>

            <div class="container-fluid">
                <li class="list-group-item">
                    <#if mod.comment??>
                        <span>${mod.comment}</span>
                    </#if>
                    <div class="card-footer text-muted">
                        <span>${mod.userId.username}</span>
                        <span>${mod.date}</span>
                        <i>${mod.action}</i>
                    </div>
                </li>
            </div>
        <#else>
            ${prp.getMessage("text.nomods")}
        </#list>
    </div>

    <div class="card my-3">
        <div class="m-2">
            <form method="post">
                <input type="text" class="form-control" name="comment" value="comment">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="card-footer text-muted">
                    <button type="submit" class="btn btn-primary">${prp.getMessage("text.create")}</button>
                </div>
            </form>
        </div>
    </div>


</@c.page>