CREATE TABLE `class_circle`(
  `id` int(11)NOT NULL AUTO_INCREMENT,
  `c_user_id` int(11) DEFAULT NULL comment '发布者id',
  `c_class_id` int(11) DEFAULT NULL comment '班级id',
  `c_content` text(0) DEFAULT NULL comment '发布内容',
  `c_picture` text(0) DEFAULT NULL comment '班级圈图片',
  `c_smailpicture` text(0) DEFAULT NULL comment '班级圈图片缩略图',
  `c_time` VARCHAR (255) DEFAULT NULL comment '发布班级圈的时间',
  PRIMARY KEY (`id`)
) comment '班级圈表'