<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>모임 생성</title>
<body>
<jsp:include page="../include/header.jsp"/>

<section class="bg-light w-100">
    <div class="container">
        <div class="row d-flex align-items-center py-5">
            <div class="col-lg-6 text-start">
                <h1 class="h2 py-5 text-primary typo-space-line">3.3.5.5. 모임 만들기</h1>
                <p class="light-300">
                    지역과 관심사를 선택하고 마음이 맞는 사람들과 함께 취미 활동을 해보세요 !
                </p>
            </div>
            <div class="col-lg-6">
                <img src="./assets/img/banner-img-02.svg">
            </div>
        </div>
    </div>
</section>
<section class="container my-lg-5">
    <form id="groupMakeFrm" method="POST" action='groupMake.do' enctype="multipart/form-data">
        <input type="hidden" name="userid" value="${sessionScope.get("userData").userid}">
        <input type="hidden" name="catecode" id="catecode" value="">
        <input type="hidden" name="groupNo" value="${groupNo}">

        <div class="service-wrapper py-3">
            <%-- 모임 대표 사진 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="pricing-list-icon col-3 text-center m-auto text-secondary ml-5 py-2">
                        <i class="display-3 bx bx-image-add"></i>
                        <p>대표 사진</p>
                    </div>
                    <div class="pricing-list-body col-md-5 align-items-center pl-3 pt-2">
                        <ul class="list-unstyled text-center light-300">
                            <div class="form-floating mb-4">
                                <c:choose>
                                    <c:when test="${not empty group_img}">
                                        <img class="img-fluid border rounded" id="preview"
                                             src="${group_img}"
                                             style="width:250px; height:250px; margin-bottom: 10px;">
                                    </c:when>
                                    <c:otherwise>
                                        <img class="img-fluid border rounded" id="preview"
                                             src="./assets/img/work-slide-05-small.jpg"
                                             style="width:250px; height:250px; margin-bottom: 10px;">
                                    </c:otherwise>
                                </c:choose>
                                <div class="input-group">
                                    <input type="file" class="form-control" id="fileName" name="fileName"
                                           aria-describedby="inputGroupFileAddon04"
                                           aria-label="Upload" accept="image/*;capture=camera">
                                </div>
                            </div>
                        </ul>
                    </div>
                    <div class="pricing-list-footer col-4 text-center m-auto align-items-center">
                    </div>
                </div>
            </div>

            <%-- 모임 이름 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="pricing-list-icon col-3 text-center m-auto text-secondary ml-5 py-2">
                        <i class="display-3 bx bx-edit"></i>
                        <p>모임 이름</p>
                    </div>
                    <div class="pricing-list-body col-9 align-items-center pl-3 pt-2 pe-4">
                        <ul class="list-unstyled text-center light-300">
                            <div class="form-floating mb-4">
                        <textarea name="group_name" id="group_name" class="form-control form-control-lg light-300"
                                  style="resize: none; width: border-box; height: 100px; "
                                  placeholder="4 ~ 20자 이내로 입력해 주세요."></textarea>
                                <label for="group_name">4 ~ 20자 이내로 입력해 주세요.</label>
                                <p align="left" id="groupNameKeyUp"></p>

                            </div>
                        </ul>
                    </div>
                    <div class="pricing-list-footer col-4 text-center m-auto align-items-center">
                    </div>
                </div>
            </div>

            <%-- 모임 소개글 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="pricing-list-icon col-3 text-center m-auto text-secondary ml-5 py-2">
                        <i class="display-3 bx bx-edit"></i>
                        <p>모임 소개</p>
                    </div>

                    <div class="pricing-list-body col-9 align-items-center pl-3 pt-2 pe-4">
                        <ul class="list-unstyled text-center light-300">
                            <div class="form-floating mb-4">
                        <textarea name="content" id="content" class="form-control form-control-lg light-300"
                                  style="resize: none; width: border-box; height: 300px;"
                                  placeholder="10 ~ 1000자 이내로 입력해 주세요."></textarea>
                                <label for="content">10 ~ 1000자 이내로 입력해 주세요.</label>
                                <p align="left" id="contentKeyUp"></p>
                            </div>
                        </ul>
                    </div>
                    <div class="pricing-list-footer col-4 text-center m-auto align-items-center">
                    </div>
                </div>
            </div>

            <%-- 관심사 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="pricing-list-icon col-3 text-center m-auto text-secondary ml-5 py-2">
                        <i class="display-3 bx bx-category-alt"></i>
                        <p>관심사</p>
                    </div>
                    <div class="pricing-list-body col-9 align-items-center py-5">
                        <input type="button" style="" id="interestBtn"
                               class="btn rounded-pill px-4 btn-outline-primary light-300" value="관심사 선택"
                               onclick="window.open('groupCategory.do', '관심사 선택', 'width=600, height=450, left=100, top=50');"/>
                        <div class="text-left text-secondary text-muted d-inline-flex">
                            <p id="interest" class="align-middle badge bg-primary text-wrap"
                               style="font-size: 14px; padding: 1em;"></p>
                        </div>
                    </div>
                    <div class="pricing-list-footer col-4 text-center m-auto align-items-center">
                    </div>
                </div>
            </div>

            <%-- 지역 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="pricing-list-icon col-3 text-center m-auto text-secondary ml-5 py-2">
                        <i class="display-3 bx bx-location-plus"></i>
                        <p>지역</p>
                    </div>
                    <div class="pricing-list-body col-9 align-items-center py-5">
                        <select name="area_code" id="area_code" class="form-select" style="width: 15vh; float:left;">
                            <option value="" selected disabled hidden>=== 선택 ===</option>
                            <c:forEach items="${areaList}" var="area">
                                <option value="${area.area_code}">${area.area_code} ${area.area_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="pricing-list-footer col-4 text-center m-auto align-items-center">
                    </div>
                </div>
            </div>

            <%-- 완료 --%>
            <div class="pricing-list shadow-sm rounded-top rounded-3 py-sm-0 py-5">
                <div class="row p-2">
                    <div class="col-md-12 col-12 my-5 text-center">
                        <input type="button" onclick="confirm()" value="완료"
                               class="btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>
<!-- End Service -->

<jsp:include page="../include/footer.jsp"/>
</body>
</html>