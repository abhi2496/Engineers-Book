-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2018 at 07:21 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `engineers_book`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `street` varchar(20) NOT NULL,
  `city` varchar(15) NOT NULL,
  `pincode` int(6) NOT NULL,
  `state` varchar(15) NOT NULL,
  `country` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`user_id`, `street`, `city`, `pincode`, `state`, `country`) VALUES
('1', 'wadi', 'Vadodara', 390017, 'Gujarat', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `user_id` int(10) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `article_id` int(14) NOT NULL COMMENT '14 is the length of article id',
  `likes` int(11) NOT NULL,
  `article_type` int(3) NOT NULL,
  `article_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `article_image` longblob,
  `create_time` mediumint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`user_id`, `dept_id`, `article_id`, `likes`, `article_type`, `article_text`, `article_image`, `create_time`) VALUES
(1, 7, 1, 0, 1, 'hello there', NULL, 0),
(3, 0, 2, 0, 1, 'second art', NULL, 0),
(2, 7, 3, 0, 1, 'another user', NULL, 0),
(4, 7, 4, 0, 0, 'abc', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE `college` (
  `user_id` varchar(10) NOT NULL,
  `univ_id` varchar(5) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `colg_name` text NOT NULL,
  `website` varchar(40) NOT NULL,
  `tpo_no` bigint(13) NOT NULL,
  `tpo_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `college`
--

INSERT INTO `college` (`user_id`, `univ_id`, `colg_id`, `colg_name`, `website`, `tpo_no`, `tpo_name`) VALUES
('1', '1', 41, 'SVIT', 'svitvasad.ac.in', 9999999999, 'Ajit Shah'),
('18', '2154', 42, 'svit', 'www.svit.com', 0, 'ajit shah'),
('21', '2154', 43, 'svi', 'www.svit.com', 0, 'ajit shah');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `comp_name` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `hr_name` varchar(35) NOT NULL,
  `domain` varchar(40) NOT NULL COMMENT 'csv''s of the technologies nd all'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`comp_name`, `address`, `hr_name`, `domain`) VALUES
('TCS', 'malad west, mumbai, maharashtra.', 'Mayank', 'all services');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_id` int(2) NOT NULL COMMENT '2 is std length of dept',
  `dept_name` varchar(20) NOT NULL,
  `hod_name` text NOT NULL,
  `placements` int(3) NOT NULL DEFAULT '0',
  `colg_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`, `hod_name`, `placements`, `colg_id`) VALUES
(7, 'computer', 'bijal mam', 0, 41);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `enroll_no` bigint(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `ranking` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`enroll_no`, `user_id`, `dept_id`, `colg_id`, `univ_id`, `ranking`) VALUES
(14041071222, 13, 7, 41, 2154, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hod`
--

CREATE TABLE `hod` (
  `user_id` int(10) NOT NULL,
  `enroll_no` bigint(12) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `ranking` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hod`
--

INSERT INTO `hod` (`user_id`, `enroll_no`, `dept_id`, `colg_id`, `univ_id`, `ranking`) VALUES
(14, 14041071223, 7, 41, 2154, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `user_id` int(10) NOT NULL COMMENT 'This is a unique id assigned to every user',
  `enroll_no` bigint(12) NOT NULL COMMENT 'every member of universityy is assigned a unique number by it',
  `dept_id` int(2) DEFAULT NULL COMMENT 'dept id ',
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `year_of_passing` int(4) NOT NULL,
  `ranking` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`user_id`, `enroll_no`, `dept_id`, `colg_id`, `univ_id`, `year_of_passing`, `ranking`) VALUES
(0, 140410107002, 7, 41, 0, 2018, 0),
(10, 140410107003, 7, 41, 2154, 2018, 0),
(2, 140410107024, 7, 41, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `user_id` varchar(10) NOT NULL,
  `uni_name` varchar(50) NOT NULL,
  `uni_id` varchar(5) NOT NULL,
  `website` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`user_id`, `uni_name`, `uni_id`, `website`) VALUES
('22', 'GTU', '222', 'gtu.ac.in');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `login_status` tinyint(1) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(10) NOT NULL,
  `gender` int(1) NOT NULL COMMENT '0- male',
  `dob` varchar(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `contact` bigint(13) NOT NULL,
  `address` text NOT NULL,
  `user_type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `login_status`, `fname`, `lname`, `gender`, `dob`, `email`, `contact`, `address`, `user_type`) VALUES
(1, '1234', 1, 'shabbir', 'bhaisaheb', 0, '2017-12-11', 'abc@gmail.com', 9033257850, '', 'student'),
(2, '1234', 0, 'abhi', 'koranne', 0, '2017-12-11', 'xyz@gmail.com', 9999999999, '', 'faculty'),
(3, '1234', 0, 'Shabbir', 'bhaisaheb', 0, '1996-09-15', 'shabbirhussainb@gmail.com', 9033257850, '', 'student'),
(4, '12345', 0, 'shabbir', 'bhaisaheb', 0, '15-09-1996', 'avd@gasjb.com', 9033257850, '', NULL),
(5, '12345', 0, 'charu', 'bhadaurya', 1, '15-04-1996', 'avs@gasjb.com', 9233257850, 'abc bunglow, vadodara', NULL),
(10, '12345', 0, 'ra', 'chan', 0, '15-04-1997', 'avs@gasb.com', 9233257855, 'ab bunglow, vadodara', NULL),
(13, '123456', 0, 'nitin', 'patel', 0, '15-09-1986', 'avc@gasjb.com', 9033257750, 'aligadh', NULL),
(14, '123456', 0, 'Bijal', 'talati', 1, '15-09-1976', 'avc@gasb.com', 9033254750, 'majalpura', NULL),
(18, '123456', 0, 'jayesh', 'deshkar', 0, '15-09-1966', 'avc@gab.com', 9033257755, 'anand', NULL),
(21, '123456', 0, 'jayesh', 'deshkar', 0, '15-09-1966', 'avc@ga.com', 9033257759, 'anand', NULL),
(22, '123456', 0, 'ni', 'pa', 0, '15-09-1966', 'avc@gaqb.com', 9033257744, 'amdavad', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `college`
--
ALTER TABLE `college`
  ADD PRIMARY KEY (`colg_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`comp_name`),
  ADD UNIQUE KEY `comp_name` (`comp_name`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`),
  ADD UNIQUE KEY `colg_id` (`colg_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id_2` (`colg_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD UNIQUE KEY `enroll_no` (`enroll_no`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `univ_id` (`univ_id`);

--
-- Indexes for table `hod`
--
ALTER TABLE `hod`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `enroll_id` (`enroll_no`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `univ_id` (`univ_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `enroll_no_2` (`enroll_no`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `enroll_no` (`enroll_no`),
  ADD KEY `univ_id` (`univ_id`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`uni_id`),
  ADD UNIQUE KEY `uni_id` (`uni_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `uni_name` (`uni_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `email_2` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `article_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '14 is the length of article id', AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
