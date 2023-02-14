USE [iSpan_car]
GO
/****** Object:  Table [dbo].[cart]    Script Date: 2023/2/14 下午 03:08:40 ******/
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
/****** Object:  Table [dbo].[orderItem]    Script Date: 2023/2/14 下午 03:08:40 ******/
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
PRIMARY KEY CLUSTERED 
(
	[orderNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 2023/2/14 下午 03:08:40 ******/
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
	[totalPrice] [varchar](20) NULL,
	[accountnumber] [nvarchar](40) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[cart] ON 

INSERT [dbo].[cart] ([cartId], [memberId], [productNumber], [productName], [productPrice], [quantity]) VALUES (10, N'', 1, NULL, NULL, 4)
INSERT [dbo].[cart] ([cartId], [memberId], [productNumber], [productName], [productPrice], [quantity]) VALUES (11, N'', 2, NULL, NULL, 2)
INSERT [dbo].[cart] ([cartId], [memberId], [productNumber], [productName], [productPrice], [quantity]) VALUES (10099, N'andy123', 4, NULL, NULL, 3)
INSERT [dbo].[cart] ([cartId], [memberId], [productNumber], [productName], [productPrice], [quantity]) VALUES (10100, N'andy123', 5, NULL, NULL, 300)
INSERT [dbo].[cart] ([cartId], [memberId], [productNumber], [productName], [productPrice], [quantity]) VALUES (10101, N'andy123', 1, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[cart] OFF
GO
SET IDENTITY_INSERT [dbo].[orderItem] ON 

INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (56, N'andy12353', N'2', NULL, 9)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (57, N'andy12353', N'3', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (58, N'andy12355', N'5', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (59, N'andy12355', N'3', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (60, N'andy12357', N'4', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (61, N'andy12358', N'5', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (62, N'andy12358', N'2', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (63, N'andy12360', N'4', NULL, 20)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (64, N'andy12360', N'1', NULL, 5)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (65, N'andy12362', N'3', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (66, N'andy12362', N'2', NULL, 9)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (67, N'andy12364', N'3', NULL, 10)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (68, N'andy12365', N'4', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (69, N'andy12366', N'5', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (70, N'andy12367', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (71, N'andy12368', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (72, N'andy12369', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (73, N'andy12370', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (74, N'andy12371', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (75, N'andy12372', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (76, N'andy12373', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (77, N'andy12374', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (78, N'andy12375', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (79, N'andy12376', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (80, N'andy12377', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (81, N'andy12378', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (82, N'andy12379', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (83, N'andy12380', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (84, N'andy12381', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (85, N'andy12382', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (86, N'andy12383', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (87, N'andy12384', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (88, N'andy12385', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (89, N'andy12386', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (90, N'andy12387', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (91, N'andy12388', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (92, N'andy12389', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (93, N'andy12390', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (94, N'andy12390', N'5', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (95, N'andy12392', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (96, N'andy12393', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (97, N'andy12394', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (98, N'andy12395', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (99, N'andy12396', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (100, N'andy12397', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (101, N'andy12398', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (102, N'andy12399', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (103, N'andy123100', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (104, N'andy123101', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (105, N'andy123102', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (106, N'andy123103', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (107, N'andy123104', N'2', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (108, N'andy123104', N'3', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (109, N'andy123104', N'5', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (110, N'andy123108', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (111, N'andy123108', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (112, N'andy123108', N'3', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (113, N'andy123111', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (114, N'andy123111', N'3', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (115, N'andy123113', N'1', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (116, N'andy123113', N'2', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (117, N'andy123113', N'5', NULL, 5)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (118, N'andy123116', N'4', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (119, N'andy123116', N'3', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (120, N'andy123118', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (121, N'andy123118', N'2', NULL, 4)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (122, N'andy123118', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (123, N'andy123121', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (124, N'andy123122', N'3', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (125, N'andy123122', N'4', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1055, N'andy12310052', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1056, N'andy12310053', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1057, N'andy12310082', N'1', NULL, 999)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1058, N'andy12310082', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1059, N'andy12310082', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1060, N'andy12310087', N'1', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1061, N'andy12310087', N'2', NULL, 3)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1062, N'andy12310090', N'2', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1063, N'andy12310091', N'1', NULL, 1)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1064, N'andy12310091', N'2', NULL, 2)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1065, N'andy12310093', N'1', NULL, 2000)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1066, N'andy12310095', N'2', NULL, 200)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1067, N'andy12310096', N'3', NULL, 7)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1068, N'andy12310097', N'3', NULL, 6)
INSERT [dbo].[orderItem] ([orderNo], [orderId], [productNumber], [productName], [quantity]) VALUES (1069, N'andy12310098', N'3', NULL, 10)
SET IDENTITY_INSERT [dbo].[orderItem] OFF
GO
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12353', CAST(N'2023-02-05T00:00:00.000' AS DateTime), CAST(N'2023-02-10T12:00:17.343' AS DateTime), N'訂單完成', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'43182', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12355', CAST(N'2023-02-04T00:00:00.000' AS DateTime), CAST(N'2023-02-07T14:24:55.577' AS DateTime), N'訂單完成', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'70700', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12358', CAST(N'2023-02-07T21:42:20.077' AS DateTime), CAST(N'2023-02-10T11:58:23.380' AS DateTime), N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'115194', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12362', CAST(N'2023-01-31T00:00:00.000' AS DateTime), CAST(N'2023-02-09T16:55:15.570' AS DateTime), N'已出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'43182', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12365', CAST(N'2023-02-08T14:38:50.313' AS DateTime), CAST(N'2023-02-09T23:26:38.427' AS DateTime), N'訂單完成', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'198', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12367', CAST(N'2023-02-08T15:27:57.187' AS DateTime), CAST(N'2023-02-09T16:55:22.280' AS DateTime), N'已出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12369', CAST(N'2023-02-08T15:31:53.350' AS DateTime), CAST(N'2023-02-09T16:55:57.913' AS DateTime), N'已出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12371', CAST(N'2023-02-08T15:40:05.453' AS DateTime), CAST(N'2023-02-10T11:08:26.683' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12372', CAST(N'2023-02-08T15:44:15.710' AS DateTime), CAST(N'2023-02-10T11:28:08.077' AS DateTime), N'訂單完成', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12373', CAST(N'2023-02-08T15:47:11.370' AS DateTime), CAST(N'2023-02-10T11:40:04.523' AS DateTime), N'訂單完成', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12374', CAST(N'2023-02-08T15:49:54.813' AS DateTime), CAST(N'2023-02-10T11:48:01.210' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12377', CAST(N'2023-02-08T15:53:28.307' AS DateTime), CAST(N'2023-02-10T11:54:53.587' AS DateTime), N'已出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12378', CAST(N'2023-02-08T15:56:43.930' AS DateTime), CAST(N'2023-02-10T11:58:07.507' AS DateTime), N'訂單取消', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12379', CAST(N'2023-02-08T16:02:41.380' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12382', CAST(N'2023-02-08T16:05:15.840' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12384', CAST(N'2023-02-08T16:13:04.760' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12386', CAST(N'2023-02-08T16:26:45.030' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12388', CAST(N'2023-02-08T16:31:37.053' AS DateTime), CAST(N'2023-02-10T11:30:22.297' AS DateTime), N'訂單完成', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12393', CAST(N'2023-02-08T16:58:49.137' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12394', CAST(N'2023-02-08T17:21:21.943' AS DateTime), CAST(N'2023-02-10T11:52:18.350' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12396', CAST(N'2023-02-08T21:39:33.890' AS DateTime), CAST(N'2023-02-10T11:58:47.967' AS DateTime), N'訂單取消', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12397', CAST(N'2023-02-09T12:53:42.363' AS DateTime), CAST(N'2023-02-10T11:30:34.240' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12398', CAST(N'2023-02-09T12:59:16.237' AS DateTime), CAST(N'2023-02-10T11:31:07.233' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123101', CAST(N'2023-02-09T13:13:27.407' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123103', CAST(N'2023-02-09T13:17:56.480' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123113', CAST(N'2023-02-09T15:47:44.270' AS DateTime), CAST(N'2023-02-09T23:27:54.037' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'203194', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123116', CAST(N'2023-02-09T15:53:21.747' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'3996', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123118', CAST(N'2023-02-09T16:11:11.107' AS DateTime), CAST(N'2023-02-10T12:55:55.087' AS DateTime), N'訂單取消', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'27592', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12310052', CAST(N'2023-02-10T11:06:42.063' AS DateTime), CAST(N'2023-02-10T11:07:37.930' AS DateTime), N'已出貨', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12357', CAST(N'2023-02-03T00:00:00.000' AS DateTime), CAST(N'2023-02-07T15:27:33.597' AS DateTime), N'訂單完成', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'198', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12375', CAST(N'2023-02-08T15:51:04.263' AS DateTime), CAST(N'2023-02-10T11:36:02.770' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12385', CAST(N'2023-02-08T16:25:37.800' AS DateTime), CAST(N'2023-02-10T12:00:06.960' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12387', CAST(N'2023-02-08T16:28:08.693' AS DateTime), CAST(N'2023-02-10T12:54:29.077' AS DateTime), N'訂單取消', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123111', CAST(N'2023-02-09T14:22:26.737' AS DateTime), CAST(N'2023-02-10T12:52:15.337' AS DateTime), N'訂單完成', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5298', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12310090', CAST(N'2023-02-12T20:18:14.533' AS DateTime), CAST(N'2023-02-12T20:19:50.397' AS DateTime), N'訂單完成', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12310091', CAST(N'2023-02-13T14:03:24.600' AS DateTime), CAST(N'2023-02-14T12:55:22.647' AS DateTime), N'訂單完成', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'13796', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123108', CAST(N'2023-02-09T14:05:28.647' AS DateTime), CAST(N'2023-02-10T12:55:49.470' AS DateTime), N'訂單完成', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'10298', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12310087', CAST(N'2023-02-12T20:15:01.277' AS DateTime), CAST(N'2023-02-12T20:16:39.750' AS DateTime), N'訂單完成', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'23194', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12360', CAST(N'2023-02-02T00:00:00.000' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'28960', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12368', CAST(N'2023-02-08T15:29:01.697' AS DateTime), NULL, N'未出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12370', CAST(N'2023-02-08T15:38:11.030' AS DateTime), NULL, N'未出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12376', CAST(N'2023-02-08T15:51:58.877' AS DateTime), NULL, N'未出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12383', CAST(N'2023-02-08T16:06:56.773' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12392', CAST(N'2023-02-08T16:57:11.327' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123102', CAST(N'2023-02-09T13:15:20.463' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123122', CAST(N'2023-02-09T23:21:51.543' AS DateTime), CAST(N'2023-02-09T23:26:20.950' AS DateTime), N'已出貨', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'2196', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12366', CAST(N'2023-02-08T15:20:03.350' AS DateTime), CAST(N'2023-02-10T11:59:18.120' AS DateTime), N'已出貨', N'未支付', N'貨到付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'34000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12380', CAST(N'2023-02-08T16:03:43.553' AS DateTime), CAST(N'2023-02-10T11:51:41.387' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12381', CAST(N'2023-02-08T16:04:31.673' AS DateTime), CAST(N'2023-02-10T11:34:33.323' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12389', CAST(N'2023-02-08T16:33:19.823' AS DateTime), CAST(N'2023-02-10T11:38:02.480' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12390', CAST(N'2023-02-08T16:39:13.643' AS DateTime), CAST(N'2023-02-10T11:59:23.723' AS DateTime), N'已出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'39000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12395', CAST(N'2023-02-08T21:33:39.063' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12399', CAST(N'2023-02-09T13:04:42.813' AS DateTime), CAST(N'2023-02-10T11:51:49.170' AS DateTime), N'訂單完成', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123100', CAST(N'2023-02-09T13:05:34.597' AS DateTime), CAST(N'2023-02-10T11:51:58.717' AS DateTime), N'訂單取消', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'5000', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123104', CAST(N'2023-02-09T14:03:59.097' AS DateTime), NULL, N'未出貨', N'未支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'122292', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy123121', CAST(N'2023-02-09T16:16:58.717' AS DateTime), CAST(N'2023-02-09T16:21:33.787' AS DateTime), N'已出貨', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
INSERT [dbo].[orders] ([orderId], [orderDate], [newDate], [orderStatus], [paidSate], [paidMethod], [deliveryAddress], [orderName], [orderPhone], [totalPrice], [accountnumber]) VALUES (N'andy12310053', CAST(N'2023-02-10T11:13:47.723' AS DateTime), CAST(N'2023-02-10T11:27:05.423' AS DateTime), N'已出貨', N'已支付', N'線上付款', N'桃園市中壢區新生路二段421號', N'andy', N'0955662778', N'4398', N'andy123')
GO
