package com.academy.sosu.model.dto.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchRepoDTO {
    /* 검색할 row num */
    public int startRowNum;

    /* 검색할 row num */
    public int endRowNum;

    /* 검색 키워드 */
    public String keyword;

    @Builder
    public SearchRepoDTO(SearchDTO searchDTO) {
        int endRowNum = Integer.parseInt(searchDTO.getCurrentPage()) * Integer.parseInt(searchDTO.getEntries());
        int startRowNum = endRowNum - Integer.parseInt(searchDTO.getEntries()) + 1;

        this.startRowNum = startRowNum;
        this.endRowNum = endRowNum;
        this.keyword = searchDTO.keyword;
    }

    /*
    [ORALCE]
    SELECT * FROM [TABLE] WHERE ROWNUM <= endRowNum

    [MSSQL]
    SELECT TOP 10 * FROM [TABLE]

    [MYSQL]
    SELECT * FROM [TABLE] LIMIT startRowNum,endRowNum
     */
}
