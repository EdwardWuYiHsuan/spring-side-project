package com.edward.spring.service.impl;

import com.edward.spring.annotation.EdwardCustomizQualifier;
import com.edward.spring.enumeration.PaymentType;
import com.edward.spring.service.CustomerService;
import com.edward.spring.service.ItemService;
import com.edward.spring.service.OrderBookService;
import com.edward.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl implements OrderBookService {


    /**
     * SOLID - DIP：Dependency Inversion Principle(依賴倒轉)
     * Dependency Injection (DI)
     * 每個元素為了達成自己的工作，或多或少都會依賴其他的元素來完成不是自己責任的工作，也因此不同的元素之間存在著一種相依性
     */
//    private CustomerService customerService = new CustomerServiceImpl();
//    private ItemService itemService = new ItemServiceImpl();

    /*
     * Field Inject.
     */
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private ItemService itemService;

    /*
     * Setter Inject.
     */
//    private CustomerService customerService;
//    private ItemService itemService;
//
//    @Autowired
//    @Resource
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @Autowired
//    public void setItemService(ItemService itemService) {
//        this.itemService = itemService;
//    }

    /*
     * Constructor Inject.
     */
    private CustomerService customerService;
    private ItemService itemService;

    public OrderBookServiceImpl(CustomerService customerService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
    }


    /**
     * Constructor Injection With Lombok.
     * https://stackoverflow.com/questions/41092751/spring-injects-dependencies-in-constructor-without-autowired-annotation
     *
     * Spring injects dependencies in constructor without @Autowired annotation
     * https://stackoverflow.com/questions/41092751/spring-injects-dependencies-in-constructor-without-autowired-annotation
     *
     * @NoArgsConstructor : 創建無參數建構子
     * @AllArgsConstructor : 建立全參數的建構子
     * @RequiredArgsConstructor : 創建一個必要欄位的建構子，必要欄位包含 final field 和 欄位被掛載(限制constraints) lombok.@NonNull
     * 以上所有lombok annotation 對 static field是不適用的
     */
//    private final CustomerService customerService;
//    private final ItemService itemService;


    /**
     * Spring Qualifier by enum - "Custom Qualifier" with value() Method using Java Configuration
     * https://www.concretepage.com/spring/spring_custom_qualifier_annotation#java-config
     *
     * Spring Custom @Qualifier Annotation. How we can create a custom @Qualifier annotation.
     * http://www.javabyexamples.com/spring-custom-qualifier-annotation
     *
     * Annotation - org.springframework.beans.factory.annotation.@Qualifier
     * https://www.baeldung.com/spring-qualifier-annotation
     */

//    @Qualifier("visaPaymentService")
//    @Autowired
//    private PaymentService paymentService;



    @Autowired
    @EdwardCustomizQualifier(PaymentType.VISA)
    private PaymentService paymentService;









    @Override
    public int order() {
        int customeId = customerService.getCustomerById(0);
        int itemId = itemService.getItemById(customeId);
        return paymentService.pay(itemId);
    }
}
