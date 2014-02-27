CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `price` double(6,2) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `author` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'Sycamore Row',28.95,'John Grisham\'s A Time to Kill is one of the most popular novels of our time. Now we return to that famous courthouse in Clanton as Jake Brigance once again finds himself embroiled in a fiercely controversial trial.','sycamoreRow.jpg','Grisham, John'),(3,'Cockroaches',18.99,'When the Norwegian ambassador to Thailand is found dead in a Bangkok brothel, Inspector Harry Hole is dispatched from Oslo to help hush up the case.','cockroaches.jpg','Nesbo, Joe'),(4,'The Book Thief',12.99,'It is 1939. Nazi Germany. The country is holding its breath. Death has never been busier, and will become busier still.','theBookThief.jpg','Zusak, Markus'),(5,'Still Life with Bread Crumbs',26.00,'Still Life with Bread Crumbs begins with an imagined gunshot and ends with a new tin roof. Between the two is a wry and knowing portrait of Rebecca Winter, a photographer whose work made her an unlikely heroine for many women.','stillLifeWithBreadCrumbs.jpg','Quindlen, Anna'),(6,'Gone Girl',25.00,'c On a warm summer morning in North Carthage, Missouri, it is Nick and Amy Dunne’s fifth wedding anniversary. Presents are being wrapped and reservations are being made when Nick’s clever and beautiful wife disappears from their rented McMansion on the Mississippi River. ','goneGirl.jpg','Flynn, Gillian'),(7,'The Martian',24.00,'Six days ago, astronaut Mark Watney became one of the first people to walk on Mars. Now, he\'s sure he\'ll be the first person to die there.','theMartian.jpg','Weir, Andy'),(8,'Bared',3.99,'At Las Vegas’s exclusive Club Sin, Aidan Knight is the Master, unleashing the erotic yearnings of his submissive lovers. But his dominant façade conceals a devastating loss—something he instantly recognizes in his personally trained submissive Cora Adams.','bared.jpg','Kennedy, Stacey'),(9,'Fifty Shades of Grey',15.95,'When literature student Anastasia Steele goes to interview young entrepreneur Christian Grey, she encounters a man who is beautiful, brilliant, and intimidating. The unworldly, innocent Ana is startled to realize she wants this man and, despite his enigmatic reserve, finds she is desperate to get close to him. Unable to resist Ana’s quiet beauty, wit, and independent spirit, Grey admits he wants her, too—but on his own terms.','fiftyShadesOfGrey.jpg','James, E.L.'),(10,'Takedown Twenty',28.00,'Stephanie Plum has her sights set on catching a notorious mob boss. If she doesn’t take him down, he may take her out.','takedownTwenty.jpg','Evanovich, Janet'),(11,'Inferno',29.95,'In the heart of Italy, Harvard professor of symbology Robert Langdon is drawn into a harrowing world centered on one of history’s most enduring and mysterious literary masterpieces . . . Dante’s Inferno.','inferno.jpg','Brown, Dan'),(12,'Innocence',28.00,'In Innocence, Dean Koontz blends mystery, suspense, and acute insight into the human soul in a masterfully told tale that will resonate with readers forever.','innocence.jpg','Koontz, Dean'),(13,'Thursdays in the Park',15.95,'Jeanie is on the brink of turning sixty, and the man she’s been married to for more than half of her life has suddenly abandoned the marital bed. When Jeanie’s husband George retreats from his conjugal duties, she is deeply hurt and very confused','thursdaysInThePark.jpg','Boyd, Hilary'),(14,'Game of Thrones',9.99,'Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdom’s protective Wall','gameOfThrones.jpg','Martin, George RR'),(15,'The Wolf of Wallstreet',16.00,'By day he made thousands of dollars a minute. By night he spent it as fast as he could. From the binge that sank a 170-foot motor yacht and ran up a $700,000 hotel tab, to the wife and kids waiting at home and the fast-talking, hard-partying young stockbrokers who called him king, here, in Jordan Belfort’s own words, is the story of the ill-fated genius they called the Wolf of Wall Street.','theWolfOfWallstreet.jpg','Belfort, Jordan'),(16,'Killer',14.99,'Killer is a mesmerizing L.A. noir portrayal of the darkest impulses of human nature carried to shocking extremes.','killer.jpg','Kellerman, Jonathan'),(17,'The Sense of an Ending',14.95,'This intense novel follows Tony Webster, a middle-aged man, as he contends with a past he never thought much aboutâuntil his closest childhood friends return with a vengeance: one of them from the grave, another maddeningly present.','theSenseOfAnEnding.jpg','Barnes, Julian'),(18,'Thing Falls Apart',11.95,'Things Fall Apart tells two intertwining stories, both centering on Okonkwo, a âstrong manâ of an Ibo village in Nigeria. The first, a powerful fable of the immemorial conflict between the individual and society, traces Okonkwoâs fall from grace with the tribal world.                     ','thingsFallApart.jpg','Achebe, Chinua');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order`
--

DROP TABLE IF EXISTS `book_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `total` double(6,2) DEFAULT NULL,
  `tax` double(6,2) DEFAULT NULL,
  `grand_total` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order`
--

LOCK TABLES `book_order` WRITE;
/*!40000 ALTER TABLE `book_order` DISABLE KEYS */;
INSERT INTO `book_order` VALUES (24,34,'2014-02-25',393.54,22.04,415.58),(27,39,'2014-02-25',89.85,5.03,94.88),(28,41,'2014-02-25',279.65,15.66,295.31),(30,43,'2014-02-25',29.95,1.68,31.63),(31,44,'2014-02-25',104.75,5.87,110.62),(35,45,'2014-02-25',105.92,5.93,111.85),(37,46,'2014-02-26',123.86,6.94,130.80),(38,47,'2014-02-26',55.97,3.13,59.10),(39,48,'2014-02-26',268.67,15.05,283.72),(41,49,'2014-02-26',138.63,7.76,146.39),(43,50,'2014-02-26',408.35,22.87,431.22),(49,53,'2014-02-26',28.95,1.62,30.57),(56,55,'2014-02-27',56.00,3.14,59.14);
/*!40000 ALTER TABLE `book_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `credit_card_number` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (33,'Justin','Trzebiatowski','jtrzebiatowski2@my.wctc.edu','262-707-9227','2004 Oakdale Dr. #49','Waukesha','WI','53189','1586956321457412'),(34,'Timothy','Green','Tim@gmail.com','414-254-7458','123 West Main St.','Milwaukee','WI','53221','151262629545262'),(35,'John','Hopkins','johnIsCool@gmail.com','41422555448','8765 GreenWay Drive','Brookfield','WI','52145','45158829292892'),(36,'Bill','Dance','DanceWithBill@yahoo.com','815-568-4715','5463 Redeo Dr','Las Angelos','CA','21454','225262246216246'),(37,'Vicki','Koeller','VickiK@hotmail.com','2626893610','Montgomery Dr. #9','Germantown','WI','53225','5951264292976786'),(38,'Vicki','Koeller','VickiK@hotmail.com','2626893610','Montgomery Dr. #9','Germantown','WI','53225','5951264292976786'),(39,'Richard','Geer','IownYourMother@geer.net','414-995-8956','Hollywood Blvd','Los Angelos','CA','12564','4512369854125478'),(40,'Andrew','Glaser','AirforceMan23@af.us','26214545698','Brickpalace circle','Tampa Bay','FL','45789','45422625646228'),(41,'Andrew','Glaser','AirforceMan23@af.us','26214545698','Brickpalace circle','Tampa Bay','FL','45789','45422625646228'),(42,'Clarence ','Nightengale','ThepoetWhoKnowit@gmail.com','414-569-8549','23745 West Oakmont Circle','New Berlin','WI','53187','1236854745698563'),(43,'Clarence ','Nightengale','ThepoetWhoKnowit@gmail.com','414-569-8549','23745 West Oakmont Circle','New Berlin','WI','53187','1236854745698563'),(44,'Justin','Trzebiatowski','jtrzebiatowski2@my.wctc.edu','2627079227','2004 Oakdale Dr. #49','Waukesha','WI','53189','454484981916549'),(45,'Marty','SmartyPants','ILoveJava@java.com','26251485698','123 Main Ave','St. Louis','MI','47589','454745728245575'),(46,'Greg','Little','BaseballMan@gmail.com','414-256-5624','1234 West Main St.','Milwaukee','WI','52145','1452256359589856'),(47,'Terry','Bradshaw','NFLPlayer64@yahoo.com','262-562-8945','7647 West National Ave','Milwaukee','WI','53189','5415561561151'),(48,'Darrel','Revis','JetsMan@yahoo.com','142-598-4746','West Hollywood Blvd.','New York','NY','25484','1235552825855'),(49,'Jared','Treb','jaredt@gmail.com','2627079228','213 West Mongomery Dr','Germantown','WI','52135','41552151494165'),(50,'Clarence ','Hawsdill','ILoveDemBooks@hotmail.com','4147856985','3245 West Bluemound Rd','Brookfield','WI','53264','1423658965231452'),(51,'Jabari','Trumfield','killerInstinct446@wi.rr.net','414-568-9587','2233 Cherry Ave','Milwaukee','WI','32554','1234567891234567'),(54,'John','Doe','JohnLovesYou@gmail.com','12515151511','1234 West Oakmont Pl','New Berlin','WI','53214','54116119165165'),(55,'Edgar ','Ridgewater','myjava@java.net','262-658-9561','123 West National Blvd.','West Allis','WI','53212','4125684458952256');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `order_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` smallint(6) DEFAULT NULL,
  `total` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (24,3,2,37.98),(24,6,3,75.00),(24,9,6,95.70),(24,10,1,28.00),(24,11,2,59.90),(24,14,4,39.96),(24,15,10,160.00),(25,7,3,72.00),(27,11,3,89.85),(28,2,2,57.90),(28,3,6,113.94),(28,13,3,47.85),(28,16,4,59.96),(30,11,1,29.95),(31,2,1,28.95),(31,5,1,26.00),(31,6,1,25.00),(31,9,3,47.85),(31,10,4,112.00),(31,13,2,31.90),(31,14,4,39.96),(31,15,2,32.00),(31,17,1,14.95),(35,2,1,28.95),(35,3,2,37.98),(35,4,3,38.97),(35,9,5,79.75),(35,15,2,32.00),(35,16,3,44.97),(37,3,1,18.99),(37,11,2,59.90),(37,16,3,44.97),(38,5,1,26.00),(38,14,3,29.97),(39,3,3,56.97),(39,11,6,179.70),(39,15,2,32.00),(41,2,1,28.95),(41,3,4,75.96),(41,9,10,159.50),(41,14,2,19.98),(41,15,3,48.00),(41,17,6,89.70),(43,2,1,28.95),(43,11,10,299.50),(43,13,2,31.90),(43,15,3,48.00),(44,4,3,38.97),(44,11,3,89.85),(44,13,1,15.95),(44,15,14,224.00),(45,7,3,72.00),(46,9,10,159.50),(48,14,2,19.98),(49,2,1,28.95),(49,6,2,50.00),(49,10,2,56.00),(49,13,1,15.95),(49,15,1,16.00),(49,18,3,35.85),(53,2,14,405.30),(53,7,3,72.00),(53,15,18,288.00),(54,13,20,319.00),(55,2,1,28.95),(55,3,1,18.99),(55,7,2,48.00),(55,11,1,29.95),(55,15,3,48.00),(56,12,2,56.00);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-27 12:28:28
