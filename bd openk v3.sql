USE [Projet ]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[num_admin] [int] NOT NULL,
 CONSTRAINT [PK_admin] PRIMARY KEY CLUSTERED 
(
	[num_admin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[appartenance]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[appartenance](
	[num_eleve] [int] NOT NULL,
	[num_promotion] [int] NOT NULL,
 CONSTRAINT [PK_appartenance] PRIMARY KEY CLUSTERED 
(
	[num_eleve] ASC,
	[num_promotion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[batiment]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[batiment](
	[num_batiment] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NOT NULL,
	[adresse] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_batiment] PRIMARY KEY CLUSTERED 
(
	[num_batiment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cours]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cours](
	[num_cours] [int] IDENTITY(1,1) NOT NULL,
	[num_prof] [int] NOT NULL,
	[num_matiere] [int] NOT NULL,
	[num_promotion] [int] NOT NULL,
	[date_debut] [datetime] NOT NULL,
	[date_fin] [datetime] NOT NULL,
 CONSTRAINT [PK_cours] PRIMARY KEY CLUSTERED 
(
	[num_cours] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[couverture]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[couverture](
	[num_matiere] [int] NOT NULL,
	[num_formation] [int] NOT NULL,
 CONSTRAINT [PK_couverture] PRIMARY KEY CLUSTERED 
(
	[num_matiere] ASC,
	[num_formation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[eleve]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[eleve](
	[num_eleve] [int] NOT NULL,
 CONSTRAINT [PK_eleve] PRIMARY KEY CLUSTERED 
(
	[num_eleve] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[enseignement]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[enseignement](
	[num_matiere] [int] NOT NULL,
	[num_prof] [int] NOT NULL,
 CONSTRAINT [PK_enseignement] PRIMARY KEY CLUSTERED 
(
	[num_matiere] ASC,
	[num_prof] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[formation]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[formation](
	[num_formation] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NOT NULL,
	[certif_ou_diplome] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_formation] PRIMARY KEY CLUSTERED 
(
	[num_formation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[matiere]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[matiere](
	[num_matiere] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_matiere] PRIMARY KEY CLUSTERED 
(
	[num_matiere] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prof]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prof](
	[num_prof] [int] NOT NULL,
 CONSTRAINT [PK_prof] PRIMARY KEY CLUSTERED 
(
	[num_prof] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotion]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotion](
	[num_promotion] [int] IDENTITY(1,1) NOT NULL,
	[num_formation] [int] NOT NULL,
	[date_debut] [datetime] NOT NULL,
	[date_fin] [datetime] NOT NULL,
 CONSTRAINT [PK_promotion] PRIMARY KEY CLUSTERED 
(
	[num_promotion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[salle]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[salle](
	[num_salle] [int] NOT NULL,
	[num_batiment] [int] NOT NULL,
	[nom] [nvarchar](50) NOT NULL,
	[equipement_virtuel] [bit] NOT NULL,
	[nb_places] [int] NOT NULL,
 CONSTRAINT [PK_salle] PRIMARY KEY CLUSTERED 
(
	[num_salle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seance]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seance](
	[num_seance] [int] IDENTITY(1,1) NOT NULL,
	[num_cours] [int] NOT NULL,
	[num_salle] [int] NOT NULL,
	[date_debut] [datetime] NOT NULL,
	[date_fin] [datetime] NOT NULL,
 CONSTRAINT [PK_seance] PRIMARY KEY CLUSTERED 
(
	[num_seance] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[utilisateur]    Script Date: 24/01/2022 15:52:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[utilisateur](
	[num_utilisateur] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NOT NULL,
	[prenom] [nvarchar](50) NOT NULL,
	[mail] [nvarchar](50) NOT NULL,
	[tel] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_utilisateur] PRIMARY KEY CLUSTERED 
(
	[num_utilisateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[batiment] ON 
GO
INSERT [dbo].[batiment] ([num_batiment], [nom], [adresse]) VALUES (1, N'Batiment A', N'14 rue Louis Kermorran')
GO
INSERT [dbo].[batiment] ([num_batiment], [nom], [adresse]) VALUES (2, N'Batiment B', N'18 rue Louis Kermorran')
GO
INSERT [dbo].[batiment] ([num_batiment], [nom], [adresse]) VALUES (3, N'Batiment C', N'20 rue Louis Kermorran')
GO
SET IDENTITY_INSERT [dbo].[batiment] OFF
GO
SET IDENTITY_INSERT [dbo].[cours] ON 
GO
INSERT [dbo].[cours] ([num_cours], [num_prof], [num_matiere], [num_promotion], [date_debut], [date_fin]) VALUES (21, 1, 1, 5, CAST(N'2022-11-24T08:00:00.000' AS DateTime), CAST(N'2024-11-24T17:00:00.000' AS DateTime))
GO
INSERT [dbo].[cours] ([num_cours], [num_prof], [num_matiere], [num_promotion], [date_debut], [date_fin]) VALUES (24, 2, 2, 5, CAST(N'2022-11-24T08:00:00.000' AS DateTime), CAST(N'2024-11-24T17:00:00.000' AS DateTime))
GO
INSERT [dbo].[cours] ([num_cours], [num_prof], [num_matiere], [num_promotion], [date_debut], [date_fin]) VALUES (25, 3, 3, 5, CAST(N'2022-11-24T08:00:00.000' AS DateTime), CAST(N'2024-11-24T17:00:00.000' AS DateTime))
GO
INSERT [dbo].[cours] ([num_cours], [num_prof], [num_matiere], [num_promotion], [date_debut], [date_fin]) VALUES (27, 8, 9, 5, CAST(N'2022-11-24T08:00:00.000' AS DateTime), CAST(N'2024-11-24T17:00:00.000' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[cours] OFF
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (1)
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (2)
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (3)
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (4)
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (9)
GO
INSERT [dbo].[eleve] ([num_eleve]) VALUES (10)
GO
SET IDENTITY_INSERT [dbo].[formation] ON 
GO
INSERT [dbo].[formation] ([num_formation], [nom], [certif_ou_diplome]) VALUES (1, N'SIO', N'BTS')
GO
INSERT [dbo].[formation] ([num_formation], [nom], [certif_ou_diplome]) VALUES (2, N'MCO', N'BTS')
GO
INSERT [dbo].[formation] ([num_formation], [nom], [certif_ou_diplome]) VALUES (3, N'PI', N'BTS')
GO
INSERT [dbo].[formation] ([num_formation], [nom], [certif_ou_diplome]) VALUES (4, N'BQE', N'BTS')
GO
INSERT [dbo].[formation] ([num_formation], [nom], [certif_ou_diplome]) VALUES (5, N'NDRC', N'BTS')
GO
SET IDENTITY_INSERT [dbo].[formation] OFF
GO
SET IDENTITY_INSERT [dbo].[matiere] ON 
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (1, N'Economie')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (2, N'Anglais')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (3, N'Maths')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (4, N'Droit')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (5, N'Management')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (6, N'SLAM')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (7, N'SISR')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (8, N'CGE')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (9, N'Suivi')
GO
INSERT [dbo].[matiere] ([num_matiere], [nom]) VALUES (10, N'Physique')
GO
SET IDENTITY_INSERT [dbo].[matiere] OFF
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (1)
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (2)
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (3)
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (4)
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (7)
GO
INSERT [dbo].[prof] ([num_prof]) VALUES (8)
GO
SET IDENTITY_INSERT [dbo].[promotion] ON 
GO
INSERT [dbo].[promotion] ([num_promotion], [num_formation], [date_debut], [date_fin]) VALUES (5, 1, CAST(N'2022-11-23T08:30:00.000' AS DateTime), CAST(N'2024-11-23T19:00:00.000' AS DateTime))
GO
INSERT [dbo].[promotion] ([num_promotion], [num_formation], [date_debut], [date_fin]) VALUES (6, 2, CAST(N'2023-11-23T08:00:00.000' AS DateTime), CAST(N'2024-11-23T19:00:00.000' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[promotion] OFF
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (1, 1, N'salle Victor Hugo', 1, 25)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (2, 1, N'salle Magellan', 1, 20)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (3, 1, N'salle Aristote', 0, 30)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (4, 1, N'salle Jeanne D''arc', 0, 18)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (5, 2, N'salle Juliette Drouet', 1, 20)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (6, 2, N'salle Leonard de Vinci', 1, 32)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (7, 2, N'salle Louis XVI', 0, 28)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (8, 3, N'salle Steeve Jobs', 1, 23)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (9, 3, N'salle Thomas Edison', 0, 15)
GO
INSERT [dbo].[salle] ([num_salle], [num_batiment], [nom], [equipement_virtuel], [nb_places]) VALUES (10, 3, N'salle Marco Polo', 1, 40)
GO
SET IDENTITY_INSERT [dbo].[seance] ON 
GO
INSERT [dbo].[seance] ([num_seance], [num_cours], [num_salle], [date_debut], [date_fin]) VALUES (1, 21, 1, CAST(N'2022-11-24T08:00:00.000' AS DateTime), CAST(N'2022-11-24T10:00:00.000' AS DateTime))
GO
INSERT [dbo].[seance] ([num_seance], [num_cours], [num_salle], [date_debut], [date_fin]) VALUES (2, 24, 1, CAST(N'2022-11-24T10:10:00.000' AS DateTime), CAST(N'2022-11-24T12:00:00.000' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[seance] OFF
GO
SET IDENTITY_INSERT [dbo].[utilisateur] ON 
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (1, N'Pommier', N'Bob', N'bob.pommier@gmail.com', N'0654722453')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (2, N'Latrie', N'Didier', N'didier.latrie@gmail.com', N'0654275831')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (3, N'David', N'Jean', N'jean.david@gmail.com', N'0698562412')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (4, N'Dos Santos', N'Jeff', N'jeff.dossantos@gmail.com', N'0785427351')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (7, N'Laine', N'Sophie', N'sophie.laine@gmail.com', N'0612345678')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (8, N'Lacroux', N'Pierre', N'pierre.lacroux@gmail.com', N'0782425156')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (9, N'Nanty', N'Stéphanie', N'stéphanie.nanty@gmail.comLL', N'0695421584')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel]) VALUES (10, N'Boukar', N'Mohammed', N'Mohammed.boukar@gmail.com', N'0657849323')
GO
SET IDENTITY_INSERT [dbo].[utilisateur] OFF
GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD  CONSTRAINT [FK_admin_utilisateur] FOREIGN KEY([num_admin])
REFERENCES [dbo].[utilisateur] ([num_utilisateur])
GO
ALTER TABLE [dbo].[admin] CHECK CONSTRAINT [FK_admin_utilisateur]
GO
ALTER TABLE [dbo].[appartenance]  WITH CHECK ADD  CONSTRAINT [FK_appartenance_eleve] FOREIGN KEY([num_eleve])
REFERENCES [dbo].[eleve] ([num_eleve])
GO
ALTER TABLE [dbo].[appartenance] CHECK CONSTRAINT [FK_appartenance_eleve]
GO
ALTER TABLE [dbo].[appartenance]  WITH CHECK ADD  CONSTRAINT [FK_appartenance_promotion] FOREIGN KEY([num_promotion])
REFERENCES [dbo].[promotion] ([num_promotion])
GO
ALTER TABLE [dbo].[appartenance] CHECK CONSTRAINT [FK_appartenance_promotion]
GO
ALTER TABLE [dbo].[cours]  WITH CHECK ADD  CONSTRAINT [FK_cours_matiere] FOREIGN KEY([num_matiere])
REFERENCES [dbo].[matiere] ([num_matiere])
GO
ALTER TABLE [dbo].[cours] CHECK CONSTRAINT [FK_cours_matiere]
GO
ALTER TABLE [dbo].[cours]  WITH CHECK ADD  CONSTRAINT [FK_cours_prof] FOREIGN KEY([num_prof])
REFERENCES [dbo].[prof] ([num_prof])
GO
ALTER TABLE [dbo].[cours] CHECK CONSTRAINT [FK_cours_prof]
GO
ALTER TABLE [dbo].[cours]  WITH CHECK ADD  CONSTRAINT [FK_cours_promotion] FOREIGN KEY([num_promotion])
REFERENCES [dbo].[promotion] ([num_promotion])
GO
ALTER TABLE [dbo].[cours] CHECK CONSTRAINT [FK_cours_promotion]
GO
ALTER TABLE [dbo].[couverture]  WITH CHECK ADD  CONSTRAINT [FK_couverture_formation] FOREIGN KEY([num_formation])
REFERENCES [dbo].[formation] ([num_formation])
GO
ALTER TABLE [dbo].[couverture] CHECK CONSTRAINT [FK_couverture_formation]
GO
ALTER TABLE [dbo].[couverture]  WITH CHECK ADD  CONSTRAINT [FK_couverture_matiere] FOREIGN KEY([num_matiere])
REFERENCES [dbo].[matiere] ([num_matiere])
GO
ALTER TABLE [dbo].[couverture] CHECK CONSTRAINT [FK_couverture_matiere]
GO
ALTER TABLE [dbo].[eleve]  WITH CHECK ADD  CONSTRAINT [FK_eleve_utilisateur] FOREIGN KEY([num_eleve])
REFERENCES [dbo].[utilisateur] ([num_utilisateur])
GO
ALTER TABLE [dbo].[eleve] CHECK CONSTRAINT [FK_eleve_utilisateur]
GO
ALTER TABLE [dbo].[enseignement]  WITH CHECK ADD  CONSTRAINT [FK_enseignement_matiere] FOREIGN KEY([num_matiere])
REFERENCES [dbo].[matiere] ([num_matiere])
GO
ALTER TABLE [dbo].[enseignement] CHECK CONSTRAINT [FK_enseignement_matiere]
GO
ALTER TABLE [dbo].[enseignement]  WITH CHECK ADD  CONSTRAINT [FK_enseignement_prof] FOREIGN KEY([num_prof])
REFERENCES [dbo].[prof] ([num_prof])
GO
ALTER TABLE [dbo].[enseignement] CHECK CONSTRAINT [FK_enseignement_prof]
GO
ALTER TABLE [dbo].[prof]  WITH CHECK ADD  CONSTRAINT [FK_prof_utilisateur] FOREIGN KEY([num_prof])
REFERENCES [dbo].[utilisateur] ([num_utilisateur])
GO
ALTER TABLE [dbo].[prof] CHECK CONSTRAINT [FK_prof_utilisateur]
GO
ALTER TABLE [dbo].[promotion]  WITH CHECK ADD  CONSTRAINT [FK_promotion_formation] FOREIGN KEY([num_formation])
REFERENCES [dbo].[formation] ([num_formation])
GO
ALTER TABLE [dbo].[promotion] CHECK CONSTRAINT [FK_promotion_formation]
GO
ALTER TABLE [dbo].[salle]  WITH CHECK ADD  CONSTRAINT [FK_salle_batiment] FOREIGN KEY([num_batiment])
REFERENCES [dbo].[batiment] ([num_batiment])
GO
ALTER TABLE [dbo].[salle] CHECK CONSTRAINT [FK_salle_batiment]
GO
ALTER TABLE [dbo].[seance]  WITH CHECK ADD  CONSTRAINT [FK_seance_cours] FOREIGN KEY([num_cours])
REFERENCES [dbo].[cours] ([num_cours])
GO
ALTER TABLE [dbo].[seance] CHECK CONSTRAINT [FK_seance_cours]
GO
ALTER TABLE [dbo].[seance]  WITH CHECK ADD  CONSTRAINT [FK_seance_salle] FOREIGN KEY([num_salle])
REFERENCES [dbo].[salle] ([num_salle])
GO
ALTER TABLE [dbo].[seance] CHECK CONSTRAINT [FK_seance_salle]
GO
