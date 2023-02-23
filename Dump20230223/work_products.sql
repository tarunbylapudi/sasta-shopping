-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: work
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(512) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `rating` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'This soft cotton t-shirt is perfect for casual wear.','Soft Cotton T-Shirt',19.99,50,0),(2,'Classic vintage denim jeans that never go out of style.','Vintage Denim Jeans',39.99,25,0),(3,'A stylish and practical leather crossbody bag for everyday use.','Leather Crossbody Bag',69.99,15,0),(4,'Stay hydrated with this durable and reusable stainless steel water bottle.','Stainless Steel Water Bottle',12.99,100,0),(5,'Protect your phone and look great with this sleek and stylish smartphone case.','Smartphone Case',9.99,75,0),(6,'A high-quality leather wallet with plenty of space for your cards and cash.','Leather Wallet',29.99,30,0),(7,'Stay comfortable and supported during your workouts with these running shoes.','Running Shoes',59.99,20,0),(8,'Enjoy your music without the hassle of wires with these high-quality wireless headphones.','Wireless Headphones',79.99,10,0),(9,'Take your yoga practice to the next level with this comfortable and non-slip yoga mat.','Yoga Mat',24.99,40,0),(10,'Look and feel great during your workouts with these stylish and comfortable high-waisted leggings.','High-Waisted Leggings',29.99,50,0),(11,'A high-tech smartwatch that tracks your fitness and keeps you connected on the go.','Smartwatch',149.99,5,0),(12,'Set of three resistance bands for versatile and effective at-home workouts.','Resistance Bands',14.99,30,0),(13,'A timeless leather jacket that adds edge and style to any outfit.','Leather Jacket',129.99,10,0),(14,'Set of four reusable grocery bags that are eco-friendly and stylish.','Reusable Grocery Bags',19.99,25,0),(15,'A complete set of durable and high-quality stainless steel cookware.','Stainless Steel Cookware Set',99.99,5,0),(16,'Get a good night\'s sleep with this comfortable and supportive memory foam pillow.','Memory Foam Pillow',39.99,20,0),(17,'Take your music with you wherever you go with this portable and powerful bluetooth speaker.','Portable Bluetooth Speaker',49.99,15,0),(18,'Upgrade your dental hygiene with this effective and convenient electric toothbrush.','Electric Toothbrush',29.99,30,0),(19,'Stay nourished and energized with this delicious and nutritious plant-based protein powder./nStay nourished and energized with this delicious and nutritious plant-based protein powder./nStay nourished and energized with this delicious and nutritious plant-based protein powder.','Plant-Based Protein Powder',29.99,50,0),(20,'','Insulated Lunch Bag',0,0,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-23 14:07:12
