package com.ecommerce.library.ProductsService;

import com.ecommerce.library.Model.User.Wishlist;

public interface WishlistService {

    Wishlist findByCustomerEmail(String email);


    void addToWishlist(Long productId, String name);

    void removeFromWishlist(Long productId, String name);
}
