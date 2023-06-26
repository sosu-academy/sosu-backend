package com.academy.sosu.model.base;

import com.academy.sosu.model.dto.common.SearchDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BaseMeta {

    /* 태이블 내 전체 컬럼 수 */
    public String totalNum;

    /* 현재 페이지 */
    public String currentPage;

    /* 전체 페이지(전체 컬럼 수 / 한 페이지 당 보여지는 데이터 갯수) */
    public String totalPage;

    /* 한 페이지 당 보여지는 데이터 갯수 */
    public String entries;


    private String calculateTotalPage(String tn, String e) {
        int totalNum = Integer.parseInt(tn);
        int entries = Integer.parseInt(e);

        int totalPage = totalNum / entries;
        if (totalNum % entries != 0) {
            totalPage += 1;
        }

        return Integer.toString(totalPage);
    }

    @Builder
    BaseMeta(SearchDTO searchDTO, int totalNum) {
        this.totalNum = Integer.toString(totalNum);
        this.currentPage = searchDTO.getCurrentPage();
        this.entries = searchDTO.getEntries();
        this.totalPage = calculateTotalPage(this.totalNum, this.entries);
    }
}
