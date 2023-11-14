package com.ecommerce.library.ProductsService;

public interface TaskOfferService {
    boolean isOfferEnabled(String offerName);
    void enabledOrDisable(String offerName, boolean enabled);
}
