use master
go
create database [asmjava4]
go


use asmjava4
go

create table [user]
(
id          int			primary key identity,
username    varchar(10) unique not null,
[password]  varchar(10) not null,
email       varchar(50) unique not null,
isAdmin     bit			not null default 0,
isActive    bit			not null default 1

)
go
create table video
(
id			int					primary key identity,
title		nvarchar(255)       not null,
href		varchar(50)			unique not null,
poster		varchar(255)		null,
[views]		int					not null default 0,
shares		int					not null default 0,
[description] nvarchar(255)		not null,
)
go

create table history
(
id			int			primary key identity,
userId		int			foreign	key references [user](id),
videoId		int			foreign key references video(id),
viewedDate	datetime	not null default getDate(),
isLiked		bit			not null default 0,
likedDate	datetime	null
)
go

insert into[user](username,[password],email,isAdmin) values
('phi',     '111',		'phips15870@fpt.edu.vn', 1),
('hoang', '222' ,     'hoang@gmail.com',  0)
go

insert into video(title,href,[description]) values
(N'Mercedes C300',	'YGhE2HZ8g8M',	'Mercedes-Benz'),
(N' The New Mercedes-Maybach S-Class: World Premiere ',	'WMnxWw_0kiY',	' Mercedes-Benz'),
(N'Mercedes-AMG GT 4-Door Coupé 2018: World Premiere'	,'uwv2pDY3G_k',	'Mercedes-Benz')
go

insert into history(userId,videoId,isLiked,likedDate) values
(2, 1, 1, GETDATE()),
(2, 3, 0, null)
go
