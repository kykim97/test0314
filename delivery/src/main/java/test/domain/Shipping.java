package test.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.DeliveryApplication;
import test.domain.ShippingStarted;

@Entity
@Table(name = "Shipping_table")
@Data
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private String tel;

    private Long productId;

    @PostPersist
    public void onPostPersist() {
        ShippingStarted shippingStarted = new ShippingStarted(this);
        shippingStarted.publishAfterCommit();
    }

    public static ShippingRepository repository() {
        ShippingRepository shippingRepository = DeliveryApplication.applicationContext.getBean(
            ShippingRepository.class
        );
        return shippingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startShipping(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Shipping shipping = new Shipping();
        repository().save(shipping);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(shipping->{
            
            shipping // do something
            repository().save(shipping);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
