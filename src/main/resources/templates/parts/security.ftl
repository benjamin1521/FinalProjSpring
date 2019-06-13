<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    currentUserId = user.getId()
    isAdmin = user.isAdmin()
    isClient = user.isClient()
    isInspector = user.isInspector()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isClient = false
    isInspector = false
    currentUserId = -1
    >
</#if>
