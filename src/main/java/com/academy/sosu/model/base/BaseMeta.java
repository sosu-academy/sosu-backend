package com.academy.sosu.model.base;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseMeta {

    /* 태이블 내 전체 컬럼 수 */
    public String totalNum;

    /* 현재 페이지 */
    public String currentPage;

    /* 전체 페이지(전체 컬럼 수 / 한 페이지 당 보여지는 데이터 갯수) */
    public String totalPage;

    /* 한 페이지 당 보여지는 데이터 갯수 */
    public String entries;


    private int calculateTotalPage(int totalNum, int entries) {
        int totalPage = totalNum / entries;
        if (totalNum % entries != 0) {
            totalPage += 1;
        }

        return totalPage;
    }
}
