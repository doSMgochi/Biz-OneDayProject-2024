<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="content">
    <form class="no-flex" action="${rootPath}${action}" method="POST">
        <input type="hidden" name="m_seq" value="${MV.m_seq}" />
        <input type="hidden" name="m_author" value="${MV.m_author}" />
        <input type="hidden" name="m_date" value="${MV.m_date}" />
        <input type="hidden" name="m_time" value="${MV.m_time}" />
        <input type="text" name="m_title" placeholder="제목을 입력하세요" value="${MV.m_title}" />
        <textarea name="m_memo" placeholder="내용을 입력하세요">${MV.m_memo}</textarea>
        <input type="text" name="m_image" placeholder="이미지 URL을 입력하세요" value="${MV.m_image}" />
        <button type="submit">저장</button>
    </form>
</section>