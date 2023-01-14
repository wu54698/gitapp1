USE [iSpan_car]
GO
/****** Object:  Table [dbo].[SHOPDETAIL]    Script Date: 2023/1/14 下午 02:55:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SHOPDETAIL](
	[productno] [int] IDENTITY(1,1) NOT NULL,
	[productname] [nvarchar](max) NOT NULL,
	[type] [nvarchar](max) NULL,
	[spec] [nvarchar](max) NULL,
	[price] [int] NULL,
	[stock] [int] NULL,
	[uptime] [nvarchar](50) NULL,
	[productinfo] [nvarchar](max) NULL,
	[productimage] [varbinary](max) NULL,
	[productimagename] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[productno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
