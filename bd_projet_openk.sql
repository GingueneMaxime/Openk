USE [master]
GO
/****** Object:  Database [Projet ]    Script Date: 26/05/2022 15:11:54 ******/
CREATE DATABASE [Projet ]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Projet', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Projet .mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Projet _log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Projet _log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Projet ] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Projet ].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Projet ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Projet ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Projet ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Projet ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Projet ] SET ARITHABORT OFF 
GO
ALTER DATABASE [Projet ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Projet ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Projet ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Projet ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Projet ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Projet ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Projet ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Projet ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Projet ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Projet ] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Projet ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Projet ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Projet ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Projet ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Projet ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Projet ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Projet ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Projet ] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Projet ] SET  MULTI_USER 
GO
ALTER DATABASE [Projet ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Projet ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Projet ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Projet ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Projet ] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Projet ] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Projet ] SET QUERY_STORE = OFF
GO
USE [Projet ]
GO
/****** Object:  User [max]    Script Date: 26/05/2022 15:11:54 ******/
CREATE USER [max] FOR LOGIN [max] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [max]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[appartenance]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[batiment]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[cours]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[couverture]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[eleve]    Script Date: 26/05/2022 15:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[eleve](
	[num_eleve] [int] NOT NULL,
	[num_matiere] [int] NOT NULL,
	[note] [int] NOT NULL,
 CONSTRAINT [PK_eleve] PRIMARY KEY CLUSTERED 
(
	[num_eleve] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[enseignement]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[formation]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[matiere]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[prof]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[promotion]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[salle]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[seance]    Script Date: 26/05/2022 15:11:54 ******/
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
/****** Object:  Table [dbo].[utilisateur]    Script Date: 26/05/2022 15:11:54 ******/
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
	[mot_de_passe] [nvarchar](50) NOT NULL,
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
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (1, 1, 15)
GO
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (2, 1, 10)
GO
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (3, 2, 5)
GO
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (4, 2, 8)
GO
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (9, 3, 20)
GO
INSERT [dbo].[eleve] ([num_eleve], [num_matiere], [note]) VALUES (10, 3, 13)
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
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (1, N'Pommier', N'Bob', N'bob.pommier@gmail.com', N'0654722453', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (2, N'Latrie', N'Didier', N'didier.latrie@gmail.com', N'0654275831', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (3, N'David', N'Jean', N'jean.david@gmail.com', N'0698562412', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (4, N'Dos Santos', N'Jeff', N'jeff.dossantos@gmail.com', N'0785427351', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (7, N'Laine', N'Sophie', N'sophie.laine@gmail.com', N'0612345678', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (8, N'Lacroux', N'Pierre', N'pierre.lacroux@gmail.com', N'0782425156', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (9, N'Nanty', N'Stéphanie', N'stéphanie.nanty@gmail.comLL', N'0695421584', N'1')
GO
INSERT [dbo].[utilisateur] ([num_utilisateur], [nom], [prenom], [mail], [tel], [mot_de_passe]) VALUES (10, N'Dupont', N'Mohammed', N'Mohammed.boukar@gmail.com', N'0607070707', N'1')
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
USE [master]
GO
ALTER DATABASE [Projet ] SET  READ_WRITE 
GO
