package com.academy.sosu.model.dto.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchDTO {
    /* 한 페이지 당 보여지는 데이터 갯수 */
    public String entries;

    /* 검색할 현재 페이지 */
    public String currentPage;

    /* 태이블 내 전체 컬럼 수 */
    public String totalNum;
}
