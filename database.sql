-- CREATE DATABASE school_library;
--
-- CREATE TABLE public."member" (
--                                  id serial primary key,
--                                  "name" varchar(100) not null ,
--                                  email varchar(100) unique,
--                                  phone varchar(100) not null,
--                                  address varchar(500),
--                                  join_date date default current_date
-- );
--
-- insert into public.member(name, email, phone, address)
-- values ('Amira Rahmayanti', 'amira.rh@gmail.com', '628111111', 'Jalan Almahera Barat No.10, Jakarta Pusat'),
--        ('Muhammad Hanafi', 'han.mhd@gmail.com', '628121212', 'Jalan Batu Nunggal No.50, Jakarta Selatan'),
--        ('Emir Ghana', 'emirghana@gmail.com', '628333333', 'Jalan Jambu No.3, Depok'),
--        ('Zahrani', 'zahrani@gmail.com', '6288888888', 'Jalan Impian No.89, Jakarta Pusat'),
--        ('Hanumi Belinda', 'hnm.belinda@gmail.com', '6287777777', 'Jalan Kalimantan Timur No.23, Jakarta Barat');

select * from public.member;
delete from public.member;

-- CREATE TABLE public.book (
--                              id serial primary key,
--                              "name" varchar(100) not null ,
--                              author varchar(100) not null,
--                              publisher varchar(100) not null,
--                              date_of_entry date default current_date,
--                              number_of_page int default 0
-- );
--
-- insert into public.book(name, author, publisher)
-- values ('Conversations on Love', 'Natasha Lunn', 'GPU'),
--        ('Dunia Sophie', 'Jostein Gaarder', 'Mizan'),
--        ('Educated', 'Tara Westover', 'GPU'),
--        ('Yellowface', 'RF Kwang', 'GPU'),
--        ('Laut Bercerita', 'Leila S. Chudori', 'KPG'),
--        ('Atomic Habits', 'James Clear', 'GPU'),
--        ('Sang Alkemis', 'Paulo Coelho', 'GPU'),
--        ('As Long As The Lemon Trees Grow', 'Zoulfa Katouh', 'Mizan'),
--        ('The 5am Club', 'Robin Sharma', 'BIP');

select * from public.book;

-- CREATE TABLE public.rent (
--                              id serial primary key,
--                              book_id int not null,
--                              member_id int not null,
--                              borrowing_date date default current_date,
--                              return_date date,
--                              deadline_return_date date default current_date+interval '1 day'
-- );

-- insert into public.rent (id_member, id_book)
-- values (1,2);

select * from public.rent;

-- alter table public.rent
--     add constraint fk_rent_member foreign key (member_id) references public.member(id),
--     add constraint fk_rent_book foreign key (book_id) references public.book(id);