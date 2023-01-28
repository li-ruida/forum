use forum;
#用户表

create table user_table(
   id int primary key auto_increment,
   name varchar(10) not null ,
   power int default 0, # 0是普通用户 -1是封禁用户 -2是管理员
   account varchar(16) unique ,
   password varchar(20) not null
    );
#主题表
create table  theme_table( #需要建立一个默认主题 id为1吧
     id int primary key auto_increment,
     name varchar(10) not null ,
     moderator int default 1,#默认管理员
     visible int default 1, #1可见 0不可见
     foreign key(moderator) references user_table(id)
);
#帖子表
create table post_table(
       id int primary key auto_increment,
       name varchar(10) not null ,
       writter int,
       visible int default 1, #1可见 0不可见
       content varchar(400),
       theme int,
       time date,
       foreign key(theme) references theme_table(id),
       foreign key(writter) references user_table(id)
);
#评论表
create table comment_table(
       id int primary key auto_increment,
       time date,
       writter int,
       visible int default 1, #1可见 0不可见
       content varchar(400),
       post int ,
       reply int default 0,#0为直接回复帖子 id为指向回复
       foreign key(post) references post_table(id),
       foreign key(writter) references user_table(id)
);













