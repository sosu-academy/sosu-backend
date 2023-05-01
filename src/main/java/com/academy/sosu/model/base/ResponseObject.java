package com.academy.sosu.model.base;

import com.academy.sosu.exception.ErrorCode;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

/**
 * ResponseObject
 * {
 *      status: success,
 *      data: {
 *          [payload]: {}, //얘는 실제 주고받는 데이터(알맹이 데이터, Object)
 *          [meta]: ... //nullable
 *      }
 * }
 *,
 * {
 *     status: error,
 *     errorMessage: ...
 * }
 * ,
 * {
 *      status: error,
 *      data: {
 *          [payload]: {}, //얘는 실제 주고받는 데이터(알맹이 데이터, Object)
 *      }
 * }
 */
@Getter
public class ResponseObject<T> {
    String status;
    String errorMessage;
    ObjectData<T> data;

    public ResponseObject(@NotNull T payload) {
        this(payload,null);
    }

    public ResponseObject(@NotNull T payload, @Nullable BaseMeta meta) {
        this.status = "success";
        if (meta == null) {
            this.data = new ObjectData<>(payload);
        } else {
            this.data = new ObjectData<>(payload, meta);
        }
    }

    public ResponseObject(@NotNull String errorMessage) {
        this.status = "error";
        this.errorMessage = errorMessage;
    }

    public ResponseObject(@NotNull String errorMessage, @NotNull T payload) {
        this.status = "error";
        this.errorMessage = errorMessage;
        this.data = new ObjectData<>(payload);
    }

    @Getter
    private static class ObjectData<T> {
        final T payload;
        BaseMeta meta = null;

        ObjectData(T payload, BaseMeta meta) {
            this.payload = payload;
            this.meta = meta;
        }

        ObjectData(T payload) {
            this.payload = payload;
        }
    }
}
