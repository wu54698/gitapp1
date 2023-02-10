create table carDealerInfo(
carDealerName nvarchar(50) primary key,
carDealerPhone nvarchar(50),
carDealerAddress nvarchar(90),
openTime time,
contactPerson nvarchar(50),
carDealerVATNumber int,
);

alter table carDealerInfo
alter column carDealerPhone varchar(50);

alter table carDealerInfo
alter column openTime time(0);

drop table carDealerInfo;

select* from carDealerInfo;