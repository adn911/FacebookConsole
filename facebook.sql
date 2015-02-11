-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2015 at 05:39 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `facebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
`COMMENT_ID` int(11) NOT NULL,
  `POST_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `CONTENT` text NOT NULL,
  `DATETIME` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`COMMENT_ID`, `POST_ID`, `USER_ID`, `CONTENT`, `DATETIME`) VALUES
(1, 2, 1, 'This is a comment', '2015-02-07'),
(2, 2, 1, 'This is a comment', '2015-02-07'),
(6, 2, 1, 'This is a comment', '2015-02-07'),
(8, 12, 4, 'Hello', '2015-02-10'),
(9, 15, 2, 'Hello Alex', '2015-02-10');

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

CREATE TABLE IF NOT EXISTS `friends` (
  `USER_ID` int(11) NOT NULL,
  `FRIEND_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`USER_ID`, `FRIEND_ID`) VALUES
(1, 2),
(1, 4),
(2, 1),
(2, 4),
(4, 1),
(4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `likes`
--

CREATE TABLE IF NOT EXISTS `likes` (
  `LIKE_ID` int(11) NOT NULL,
  `POST_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL,
  `DATETIME` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
`MESSAGE_ID` int(11) NOT NULL,
  `FROM_USER` int(11) NOT NULL,
  `TO_USER` int(11) NOT NULL,
  `CONTENT` text NOT NULL,
  `DATETIME` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
`POST_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `POST_TYPE` int(11) NOT NULL,
  `CONTENT` text NOT NULL,
  `DATETIME` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`POST_ID`, `USER_ID`, `POST_TYPE`, `CONTENT`, `DATETIME`) VALUES
(2, 1, 1, 'This is a simple post', '2015-02-07 00:00:00'),
(3, 1, 1, 'This is another post', '2015-02-07 03:00:00'),
(6, 2, 1, 'HELLO WORLD... :D', '2015-02-09 12:57:47'),
(7, 2, 1, 'New STATUS', '2015-02-09 01:11:37'),
(8, 2, 1, 'HELLO JAVA..', '2015-02-09 02:13:19'),
(11, 2, 1, 'POSTING NEW STATUS', '2015-02-09 04:25:32'),
(12, 2, 1, 'Hello world ', '2015-02-10 09:48:04'),
(15, 4, 1, 'Hello this is Alex', '2015-02-10 10:32:48');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(99) NOT NULL,
  `EMAIL` varchar(99) NOT NULL,
  `PASSWORD` varchar(99) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL,
  `FIRST_NAME` varchar(99) NOT NULL,
  `LAST_NAME` varchar(99) NOT NULL,
  `DOB` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USER_ID`, `USER_NAME`, `EMAIL`, `PASSWORD`, `ACTIVE`, `FIRST_NAME`, `LAST_NAME`, `DOB`) VALUES
(1, 'asif.007', 'asif.rahman@gmail.com', '123456', 1, 'asif', 'rahman', '1991-01-23'),
(2, 'adnan911', 'adnan911@gmail.com', '123', 1, 'adnan', 'galib', '1992-01-23'),
(4, 'Alex', 'alex@gmail.com', '123', 1, 'Alex', 'Bell', '1990-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
`USER_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(99) NOT NULL,
  `LAST_NAME` varchar(99) NOT NULL,
  `DOB` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`USER_ID`, `FIRST_NAME`, `LAST_NAME`, `DOB`) VALUES
(1, 'adnan', 'galib', '1992-01-23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
 ADD PRIMARY KEY (`COMMENT_ID`), ADD KEY `POST_ID` (`POST_ID`), ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `friends`
--
ALTER TABLE `friends`
 ADD KEY `USER_ID` (`USER_ID`,`FRIEND_ID`), ADD KEY `FRIEND_ID` (`FRIEND_ID`);

--
-- Indexes for table `likes`
--
ALTER TABLE `likes`
 ADD PRIMARY KEY (`LIKE_ID`), ADD KEY `POST_ID` (`POST_ID`), ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
 ADD PRIMARY KEY (`MESSAGE_ID`), ADD KEY `TO_USER` (`TO_USER`), ADD KEY `FROM_USER` (`FROM_USER`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
 ADD PRIMARY KEY (`POST_ID`), ADD KEY `USER_ID` (`USER_ID`), ADD KEY `USER_ID_2` (`USER_ID`), ADD KEY `USER_ID_3` (`USER_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`USER_ID`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
 ADD PRIMARY KEY (`USER_ID`), ADD KEY `USER_ID` (`USER_ID`), ADD KEY `USER_ID_2` (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
MODIFY `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
MODIFY `MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
MODIFY `POST_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `posts` (`POST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likes`
--
ALTER TABLE `likes`
ADD CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `posts` (`POST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
