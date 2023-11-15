-- select * from admins;
--
-- select * from otp;
--
-- delete from admins where username = 'nived@gmail.com';
--
-- select * from admins_roles;
--
-- truncate table admins_roles;
--
-- update admins_roles set role_id = 3;
--
-- select * from roles;
--
-- delete from admins_roles where admin_id = 3;
delete from product_images_url where product_id = 7;
delete from product_size where product_product_id = 7;
delete from products where product_id = 7;

delete from product_images_url where product_id = 8;
delete from product_size where product_product_id = 8;
delete from products where product_id = 8;

delete from product_images_url where product_id = 9;
delete from product_size where product_product_id = 9;
delete from products where product_id = 9;

delete from product_images_url where product_id = 6;
delete from product_size where product_product_id = 6;
delete from products where product_id = 6;