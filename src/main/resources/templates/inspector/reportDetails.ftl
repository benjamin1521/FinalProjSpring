<#import "../parts/common.ftl" as c>

<@c.page>


    <div class="form-group mt-3">
        <div class="form-group">
            ${prp.getMessage("text.status")}: ${report.status}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.name")}: ${report.name}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.address")}: ${report.address}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.bank_name")}: ${report.bank_name}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.bank_account")}: ${report.bank_account}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.bank_bic")}: ${report.bank_bic}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.code")}: ${report.code}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.inn")}: ${report.inn}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.kpp")}: ${report.kpp}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.name_short")}: ${report.name_short}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.oktmo")}: ${report.oktmo}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.parent_address")}: ${report.parent_address}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.parent_code")}: ${report.parent_code}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.parent_name")}: ${report.parent_name}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.parent_phone")}: ${report.parent_phone}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.payment_name")}: ${report.payment_name}
        </div>
        <div class="form-group">
            ${prp.getMessage("text.phone")}: ${report.phone}
        </div>
    </div>

</@c.page>
