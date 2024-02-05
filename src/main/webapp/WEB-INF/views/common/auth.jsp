<c:if test="${sessionScope.user.getAuthenticated() != true}">
    <c:redirect url="/home"/>
</c:if>