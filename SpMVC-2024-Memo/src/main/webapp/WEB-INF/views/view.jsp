<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="content">
    <div class="body view">
        <ul data-m_seq="${MEMO.m_seq}">
            <li>제목 : ${MEMO.m_title}</li>
            <li>작성자 : ${MEMO.m_author}</li>
            <li>작성일자 : ${MEMO.m_date} ${MEMO.m_time}</li>
            <li>${MEMO.m_memo}</li>
            <c:if test="${not empty MEMO.m_image}">
                <li><img src="${MEMO.m_image}" alt="이미지" /></li>
            </c:if>
        </ul>
        <div class="button-container">
            <a href="${rootPath }/update?num=${MEMO.m_seq}"><button>수정</button></a>
            <a href="${rootPath }/delete?num=${MEMO.m_seq}"><button>삭제</button></a>
        </div>
    </div>
</section>
