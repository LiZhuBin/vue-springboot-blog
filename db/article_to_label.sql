DROP TABLE `article_to_label`;

CREATE TABLE `article_to_label` (
  `id` int(8) unsigned NOT NULL auto_increment,
  `article_id` int default NULL,
  `label_id` int default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (76,46),(65,43),(17,53),(40,43),(7,40),(67,59),(9,94),(67,30),(71,82),(42,63);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (20,74),(92,25),(23,5),(24,46),(100,67),(5,70),(10,97),(95,53),(53,26),(64,6);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (90,82),(44,90),(84,39),(70,99),(97,46),(46,50),(47,12),(82,43),(12,92),(91,58);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (31,2),(3,11),(14,13),(63,89),(59,64),(5,48),(69,64),(66,95),(70,59),(61,33);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (57,48),(32,33),(33,12),(56,89),(11,9),(57,44),(32,95),(69,2),(25,88),(71,1);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (12,42),(1,38),(49,19),(67,54),(8,91),(17,54),(19,1),(74,22),(62,62),(33,100);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (48,2),(77,52),(31,68),(2,65),(32,77),(26,40),(70,69),(88,13),(21,85),(23,19);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (83,16),(62,20),(14,41),(33,18),(71,91),(88,65),(38,68),(63,29),(91,93),(98,44);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (78,50),(21,42),(82,68),(87,76),(71,35),(47,10),(32,45),(23,90),(55,56),(62,18);
INSERT INTO `article_to_label` (`article_id`,`label_id`) VALUES (11,58),(51,80),(59,4),(26,49),(52,83),(91,7),(8,77),(8,90),(66,71),(74,67);
