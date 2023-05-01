use rental_house;

insert into account(username,password,repassword,role_id) values("thanh","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe",1);
insert into account(username,password,repassword,role_id) values("thanhadmin","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe",2);
insert into account(username,password,repassword,role_id) values("thanh2","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe","$2a$12$QRwNXZhOVxFg0EoWmj9cDOHmoSWLtGlGvQR3LPOmexxCp.nhx.oXe",1);

insert into employee(name,birthdate,gender,phone,email,idnumber,house_id, position, account_id, startdate, status, description) values('employee1',current_date(),0,012345678,"employee1@gmail.com",1,1,1,1,current_date(),0,"test employee1");
insert into employee(name,birthdate,gender,phone,email,idnumber,house_id, position, account_id, startdate, status, description) values('employee2',current_date(),0,012345678,"employee1@gmail.com",2,1,2,1,current_date(),0,"test employee1");
insert into employee(name,birthdate,gender,phone,email,idnumber,house_id, position, account_id, startdate, status, description) values('employee3',current_date(),0,012345678,"employee1@gmail.com",2,1,2,1,current_date(),0,"test employee1");

insert into house(name,location,street,establishdate,totalroom,manager,status) values('house1',"tan binh","Cong Hoa",current_date(),5,"thanh2",1);
insert into house(name,location,street,establishdate,totalroom,manager,status) values('house2',"go vap","Quang Trung",current_date(),3,"thanh",0);
insert into house(name,location,street,establishdate,totalroom,manager,status) values('house3',"quan 10","CMT8",current_date(),2,"thanh2",1);

insert into invoice(house_id,room_id,paymentmethod_id,tenant_id,phone,email,creator, createddate, closingdate) values(1,2,1,2,02432578913,"tenant2@gmail.com","thanh",current_date(),current_date());
insert into invoice(house_id,room_id,paymentmethod_id,tenant_id,phone,email,creator, createddate, closingdate) values(2,3,2,1,02432578913,"tenant1@gmail.com","admin",current_date(),current_date());
insert into invoice(house_id,room_id,paymentmethod_id,tenant_id,phone,email,creator, createddate, closingdate) values(3,1,3,3,02432578913,"tenant3@gmail.com","user",current_date(),current_date());

insert into paymentmethod(name,type) values("Cash","Give cash");
insert into paymentmethod(name,type) values("Bank","Momo");
insert into paymentmethod(name,type) values("Bank","Bank");

insert into role(name) values("manager");
insert into role(name) values("admin");

insert into room(house_id,floor,area,currenttenants,currentmax,status,service_id, rents, description) values(1,3,"100m2",12,20,0,1,"2000","test room");
insert into room(house_id,floor,area,currenttenants,currentmax,status,service_id, rents, description) values(2,2,"150m2",30,30,1,2,"2500","test room");
insert into room(house_id,floor,area,currenttenants,currentmax,status,service_id, rents, description) values(3,1,"120m2",15,25,0,1,"2200","test room");

insert into service(name) values("clean");
insert into service(name) values("washing clothes");
insert into service(name) values("parking");

insert into tenant(name,birthdate,gender,phone,email,idnumber,address, house_id, room_id, rentdate, status, description) values('tenant1',current_date(),0,012345678,"tenant1@gmail.com",2,"123 Cong Hoa",2,1,current_date(),0,"test tenant1");
insert into tenant(name,birthdate,gender,phone,email,idnumber,address, house_id, room_id, rentdate, status, description) values('tenant2',current_date(),0,012345678,"tenant1@gmail.com",1,"745 Pham Van Dong",3,3,current_date(),1,"test tenant2");
insert into tenant(name,birthdate,gender,phone,email,idnumber,address, house_id, room_id, rentdate, status, description) values('tenant3',current_date(),0,012345678,"tenant1@gmail.com",3,"56 Truong Chinh",1,2,current_date(),0,"test tenant3");

insert into user(username,password,role) values('admin','$2a$10$hUu9SbvjcEKm90unafwb9.IA4JxAhR3Zv/P9K2QVC9LVUcXQsQ7ba','ADMIN');
insert into user(username,password,role) values('user','$2a$10$hUu9SbvjcEKm90unafwb9.IA4JxAhR3Zv/P9K2QVC9LVUcXQsQ7ba','USER');


