create table carInfo(
carNo int primary key identity(1, 1),
carDealName nvarchar(50) foreign key references carDealerInfo(carDealerName),
accountNumber nvarchar(50),
carBrand nvarchar(50),
carName nvarchar(50),
stock int,
carImage varbinary(MAX),
carDescription nvarchar(MAX),
announceDate nvarchar(50),
);

create table carInfoImage(
imageNo int primary key identity(1000, 1),
carNo int not null,
carImage varbinary(MAX),
);



alter table carInfo
alter column carNo int primary key identity(1, 1);

alter table carInfo
alter column carDealName nvarchar(50) foreign key references carDealerInfo(carDealerName);


drop table carInfo;
drop table carInfoImage;

select* from carInfo;
select* from carDealerInfo;