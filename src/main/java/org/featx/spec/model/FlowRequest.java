package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.featx.spec.enums.QueryDirection;

import java.io.Serializable;

/**
 * @author Excepts
 * @since 2019/12/31 13:50
 */
@Data
@NoArgsConstructor
public class FlowRequest implements Serializable {

    private static final long serialVersionUID = -722145501939109453L;

    private String cursor;

    /**
     * Whether less than cursor or not, true for less than cursor , and false for not.
     */
    private QueryDirection direction;

    public void setDirection(int direction) {
        this.direction =  QueryDirection.of(direction);
    }

    public void setDirection(String string) {
        if("UP".equalsIgnoreCase(string)) {
            this.direction = QueryDirection.UP;
        } else {
            this.direction = QueryDirection.DOWN;
        }
    }
}
