USE [master]
GO
/****** Object:  Database [iSpan_car]    Script Date: 2022/12/28 下午 02:55:27 ******/
CREATE DATABASE [iSpan_car]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'iSpan_car', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\iSpan_car.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'iSpan_car_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\iSpan_car_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [iSpan_car] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [iSpan_car].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [iSpan_car] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [iSpan_car] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [iSpan_car] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [iSpan_car] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [iSpan_car] SET ARITHABORT OFF 
GO
ALTER DATABASE [iSpan_car] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [iSpan_car] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [iSpan_car] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [iSpan_car] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [iSpan_car] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [iSpan_car] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [iSpan_car] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [iSpan_car] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [iSpan_car] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [iSpan_car] SET  DISABLE_BROKER 
GO
ALTER DATABASE [iSpan_car] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [iSpan_car] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [iSpan_car] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [iSpan_car] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [iSpan_car] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [iSpan_car] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [iSpan_car] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [iSpan_car] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [iSpan_car] SET  MULTI_USER 
GO
ALTER DATABASE [iSpan_car] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [iSpan_car] SET DB_CHAINING OFF 
GO
ALTER DATABASE [iSpan_car] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [iSpan_car] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [iSpan_car] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [iSpan_car] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [iSpan_car] SET QUERY_STORE = OFF
GO
USE [iSpan_car]
GO
/****** Object:  User [watcher]    Script Date: 2022/12/28 下午 02:55:27 ******/
CREATE USER [watcher] FOR LOGIN [watcher] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[carDealerInfo]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[carDealerInfo](
	[carDealerName] [nvarchar](50) NOT NULL,
	[carDealerPhone] [varchar](50) NULL,
	[carDealerAddress] [nvarchar](90) NULL,
	[openTime] [time](0) NULL,
	[contactPerson] [nvarchar](50) NULL,
	[carDealerVATNumber] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[carDealerName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[carInfo]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[carInfo](
	[carNo] [int] IDENTITY(1,1) NOT NULL,
	[carDealName] [nvarchar](50) NULL,
	[accountNumber] [nvarchar](50) NULL,
	[carBrand] [nvarchar](50) NULL,
	[carName] [nvarchar](50) NULL,
	[stock] [int] NULL,
	[carImage] [varbinary](max) NULL,
	[carDescription] [nvarchar](max) NULL,
	[announceDate] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[carNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cart]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[cartId] [bigint] IDENTITY(1,1) NOT NULL,
	[memberId] [varchar](max) NULL,
	[productNumber] [bigint] NULL,
	[productName] [varchar](max) NULL,
	[productPrice] [bigint] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK__cart__415B03B83EF95C34] PRIMARY KEY CLUSTERED 
(
	[cartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[forummember]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[forummember](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[accountnumber] [varchar](40) NOT NULL,
	[memberpassword] [varchar](20) NULL,
	[membername] [nvarchar](20) NULL,
	[phonenumber] [nvarchar](20) NULL,
	[email] [varchar](40) NULL,
	[memberaddress] [varchar](max) NULL,
	[platenumber] [varchar](20) NULL,
	[birthday] [date] NULL,
	[idnumber] [varchar](20) NULL,
	[cardnumber] [varchar](50) NULL,
	[personalimg] [varbinary](max) NULL,
	[imgfilename] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[accountnumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[memberPosition]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[memberPosition](
	[accountnumber_position] [varchar](40) NOT NULL,
	[position_fk] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[accountnumber_position] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orderItem]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderItem](
	[orderNo] [int] IDENTITY(1,1) NOT NULL,
	[orderId] [varchar](20) NULL,
	[productNumber] [varchar](20) NULL,
	[productName] [varchar](max) NULL,
	[quantity] [int] NOT NULL,
	[productPrice] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[orderNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[orderId] [varchar](max) NOT NULL,
	[orderDate] [datetime] NULL,
	[newDate] [datetime] NULL,
	[orderStatus] [nvarchar](20) NULL,
	[paidSate] [nvarchar](20) NULL,
	[paidMethod] [nvarchar](20) NULL,
	[deliveryAddress] [nvarchar](50) NULL,
	[orderName] [nvarchar](20) NULL,
	[orderPhone] [varchar](20) NULL,
	[totalPrice] [bigint] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[permissionsOfPosition]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permissionsOfPosition](
	[member_position] [varchar](40) NOT NULL,
	[permissions_insert] [varchar](1) NULL,
	[permissions_update] [varchar](1) NULL,
	[permissions_delete] [varchar](1) NULL,
	[permissions_select] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[member_position] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[post]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[body] [varchar](255) NULL,
	[isOP] [bit] NULL,
	[time] [datetime2](7) NULL,
	[title] [varchar](255) NULL,
	[memberId] [int] NULL,
	[threadId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[Service_name] [varchar](20) NOT NULL,
	[Carimage] [varbinary](max) NULL,
	[Servicedescription] [varchar](max) NULL,
	[Serviceinfomation] [varchar](max) NULL,
	[Contactperson] [varchar](max) NULL,
	[Reseller_nonreseller] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Service_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SHOP_DETAIL]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SHOP_DETAIL](
	[productno] [int] IDENTITY(1,1) NOT NULL,
	[productname] [nvarchar](max) NOT NULL,
	[type] [nvarchar](max) NULL,
	[spec] [nvarchar](max) NULL,
	[price] [int] NULL,
	[stock] [int] NULL,
	[uptime] [nvarchar](50) NULL,
	[productinfo] [nvarchar](max) NULL,
	[productimage] [varbinary](max) NULL,
	[productimage_name] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[productno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thread]    Script Date: 2022/12/28 下午 02:55:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thread](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[time] [datetime2](7) NULL,
	[categoryId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[memberPosition]  WITH CHECK ADD FOREIGN KEY([accountnumber_position])
REFERENCES [dbo].[member] ([accountnumber])
GO
ALTER TABLE [dbo].[memberPosition]  WITH CHECK ADD FOREIGN KEY([position_fk])
REFERENCES [dbo].[permissionsOfPosition] ([member_position])
GO
USE [master]
GO
ALTER DATABASE [iSpan_car] SET  READ_WRITE 
GO
