<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<header>
    <h1>오늘은 내 생의 가장 젊은 날</h1>
</header>
<hr class="hr-16" />
<section class="main">
    <div class="body">
        <form onsubmit="return false;">
            <input id="date-input" type="date" /> 
            <input id="time-input" type="time" />
            <a href="${rootPath }/write"><button type="button">새로작성</button></a>
        </form>
        <ul class="list" data-m_seq="${MEMO.m_seq }">
            <c:forEach items="${MEMO_LIST }" var="MEMO">
                <li><a href="${rootPath }/view?num=${MEMO.m_seq}">${MEMO.m_title }</a></li>
            </c:forEach>
        </ul>
    </div>
</section>