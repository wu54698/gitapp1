create table carInfo(
carNo int primary key identity(1, 1),
carDealName nvarchar(50),
accountNumber nvarchar(50),
carBrand nvarchar(50),
carName nvarchar(50),
stock int,
carImage varbinary(MAX),
carDescription nvarchar(MAX),
announceDate nvarchar(50),
);

alter table carInfo
alter column carNo int primary key identity(1, 1);

alter table carInfo
alter column carDealName nvarchar(50) foreign key references carDealerInfo(carDealerName);


drop table carInfo;

select* from carInfo;
select* from carDealerInfo;