<#import "../parts/common.ftl" as c>

<@c.page>


    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control"
                       name="comment" placeholder="comment"/>
            </div>
            <div>${prp.getMessage("text.name")}</div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if report??>${report.name}</#if>" name="name" placeholder="name">
            </div>
            <div>${prp.getMessage("text.address")}</div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if report.address??>${report.address}</#if>" name="address" placeholder="address">
            </div>
            <div>${prp.getMessage("text.bank_name")}</div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if report.bank_name??>${report.bank_name}</#if>" name="bank_name"
                       placeholder="bank_name">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.bank_account")}</div>
                <input type="text" class="form-control"
                       value="<#if report.bank_account??>${report.bank_account}</#if>" name="bank_account"
                       placeholder="bank_account">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.bank_bic")}</div>
                <input type="text" class="form-control"
                       value="<#if report.bank_bic??>${report.bank_bic}</#if>" name="bank_bic" placeholder="bank_bic">
            </div>

            <div class="form-group">
                <div>${prp.getMessage("text.code")}</div>
                <input type="text" class="form-control"
                       value="<#if report.code??>${report.code}</#if>" name="code" placeholder="code">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.inn")}</div>
                <input type="text" class="form-control"
                       value="<#if report.inn??>${report.inn}</#if>" name="inn" placeholder="inn">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.kpp")}</div>
                <input type="text" class="form-control"
                       value="<#if report.kpp??>${report.kpp}</#if>" name="kpp" placeholder="kpp">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.name_short")}</div>
                <input type="text" class="form-control"
                       value="<#if report.name_short??>${report.name_short}</#if>" name="name_short"
                       placeholder="name_short">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.oktmo")}</div>
                <input type="text" class="form-control"
                       value="<#if report.oktmo??>${report.oktmo}</#if>" name="oktmo" placeholder="oktmo">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.parent_address")}</div>
                <input type="text" class="form-control"
                       value="<#if report.parent_address??>${report.parent_address}</#if>" name="parent_address"
                       placeholder="parent_address">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.parent_code")}</div>
                <input type="text" class="form-control"
                       value="<#if report.parent_code??>${report.parent_code}</#if>" name="parent_code"
                       placeholder="parent_code">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.parent_name")}</div>
                <input type="text" class="form-control"
                       value="<#if report.parent_name??>${report.parent_name}</#if>" name="parent_name"
                       placeholder="parent_name">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.parent_phone")}</div>
                <input type="text" class="form-control"
                       value="<#if report.parent_phone??>${report.parent_phone}</#if>" name="parent_phone"
                       placeholder="parent_phone">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.payment_name")}</div>
                <input type="text" class="form-control"
                       value="<#if report.payment_name??>${report.payment_name}</#if>" name="payment_name"
                       placeholder="payment_name">
            </div>
            <div class="form-group">
                <div>${prp.getMessage("text.phone")}</div>
                <input type="text" class="form-control"
                       value="<#if report.phone??>${report.phone}</#if>" name="phone" placeholder="phone">


                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <#--<input type="hidden" name="id" value="<#if report??>${report.id}</#if>"/>-->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">${prp.getMessage("text.save")}</button>
                </div>
        </form>
    </div>


</@c.page>