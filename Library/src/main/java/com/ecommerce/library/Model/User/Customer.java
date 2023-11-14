package com.ecommerce.library.Model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Email cannot be null") @Email(message = "Enter a valid email address")
    private String email;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "User role cannot be null")
    private String role;

    @Pattern(regexp = "\\d{10}", message = "Enter a valid phone number of 10 digits.")
    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;

    @NotNull(message = "Constraint error, isDeleted was not set during account creation/updation.")
    private boolean isDeleted;

    @NotNull
    private boolean isBlocked;

    @NotNull
    private Date createdOn;

    private Date updatedOn;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    Wishlist wishlist;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    Wallet wallet;

    @ManyToMany
    @JoinTable(name = "customer_Coupons",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private List<Coupon> coupons;

    private Boolean referral;
}
