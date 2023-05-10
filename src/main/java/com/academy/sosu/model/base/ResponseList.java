package com.academy.sosu.model.base;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * ResponseObject
 * {
 *      status: success,
 *      data: {
 *          [payload]: [], //얘는 실제 주고받는 데이터(알맹이 데이터, Object)
 *          [meta]: ... //nullable
 *      }
 * }
 *,
 // * {
 // *     status: error,
 // *     errorMessage: ...
 // * }
 */
@Getter
public class ResponseList<T> {
    String status;
    ListData<T> data;

    public ResponseList(@NotNull List<T> payload) {
        this(payload,null);
    }

    public ResponseList(@NotNull List<T> payload, @Nullable BaseMeta meta) {
        this.status = "success";
        if (meta == null) {
            this.data = new ListData<>(payload);
        } else {
            this.data = new ListData<>(payload, meta);
        }
    }

    @Getter
    private static class ListData<T> {
        final List<T> payload;
        BaseMeta meta = null;

        ListData(List<T> payload, BaseMeta meta) {
            this.payload = payload;
            this.meta = meta;
        }

        ListData(List<T> payload) {
            this.payload = payload;
        }
    }
}
