package test.domain;

import java.util.*;
import lombok.*;
import test.domain.*;
import test.infra.AbstractEvent;

@Data
@ToString
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private String address;
    private String tel;
    private Long productId;

    public ShippingStarted(Shipping aggregate) {
        super(aggregate);
    }

    public ShippingStarted() {
        super();
    }
}
