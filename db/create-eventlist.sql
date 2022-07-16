use eventlist;

create table IF NOT EXISTS user (
    user_id int NOT NULl AUTO_INCREMENT,
    firstname varchar(25) not null,
    lastname varchar(25) not null,
    username varchar(100) not null,
    password varchar(100) not null,
    email varchar(255) not null PRIMARY KEY,
    bounced BOOLEAN,
    created date,
    lastlogin datetime,
    UNIQUE KEY(username), UNIQUE KEY(user_id),
    KEY(lastname), KEY(firstname), KEY(created)
);

create table IF NOT EXISTS user_roles (
  username         varchar(100) not null,
  rolename         varchar(20) not null,
  primary key (username, rolename),
  KEY(username), KEY(rolename)
);

create table IF NOT EXISTS eventlist_title (
    eventlist_id int NOT NULl AUTO_INCREMENT PRIMARY KEY,
    user_id int NOT NULL,
    event_title varchar(80) NOT NULL,
    event_desc varchar(2000) NOT NULL,
    urlkey varchar(30) NOT NULL,
    evdate_hdr varchar(30) DEFAULT "Date",
    evname_hdr varchar(30) DEFAULT "Event",
    evlocation_hdr varchar(30) DEFAULT "Location",
    evother1_hdr varchar(30) DEFAULT "Other 1",
    evother2_hdr varchar(30) DEFAULT "Other 2",
    evo1_display tinyint DEFAULT 0,
    evo2_display tinyint DEFAULT 0,
    KEY(user_id), UNIQUE KEY(user_id, urlkey)
);

INSERT INTO eventlist_title (user_id, event_title, event_desc, urlkey) VALUES (1, "MARRS Schedule 2022", "Mid-Atlantic Road Racing (MARRS) Schedule for 2022", "MARRS-2022");

create table IF NOT EXISTS eventlist (
    evl_item_id int NOT NULl AUTO_INCREMENT PRIMARY KEY,
    eventlist_id int NOT NULl,
    user_id int NOT NULL,
    evdate varchar(10) NOT NULL,
    evname varchar(80) NOT NULL,
    evlocation varchar(80) NOT NULL,
    evother1 varchar(80),
    evother2 varchar(80),
    evname_url varchar(1024),
    evloc_url varchar(1024),
    evo1_url varchar(1024),
    evo2_url varchar(1024),
    KEY(eventlist_id), KEY(user_id)
);

INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-04-02", "Event 1", "Summit Point, WV");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-06-04", "Event 2 @ NJMP Lightning", "Millville, NJ");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-06-18", "Event 3", "Summit Point, WV");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-07-23", "Event 4", "Summit Point, WV");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-08-20", "Event 5 @ NJMP Thunderbolt", "Millville, NJ");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-09-03", "Event 6 - Labor Day", "Summit Point, WV");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-10-08", "Event 7", "Summit Point, WV");
INSERT INTO eventlist ( eventlist_id, user_id, evdate, evname, evlocation ) VALUES (1, 1, "2022-10-23", "Event 8 @ NJMP Thunderbolt", "Millville, NJ");


create table IF NOT EXISTS event_order (
    eventlist_id int NOT NULL PRIMARY KEY,
    user_id int NOT NULL,
    column_name varchar(12) NOT NULL,
    sort_order int NOT NULL,
    UNIQUE KEY (eventlist_id,sort_order)
);

create table IF NOT EXISTS app_log (
    id bigint unsigned AUTO_INCREMENT PRIMARY KEY,
    ts DATETIME not null,
    user_id int not null,
    session_id varchar(40),
    app varchar(30) not null,
    topic varchar(30) not null,
    message varchar(600) not null,
    KEY(user_id), KEY(session_id), KEY(app), KEY(topic)
);

create table IF NOT EXISTS content (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    pagename varchar(30) NOT NULL,
    idkey varchar(30),
    slotname varchar(30) NOT NULL,
    content text NOT NULL,
    UNIQUE KEY(pagename,idkey,slotname),
    KEY(pagename), KEY(slotname), KEY(idkey)
);

create table IF NOT EXISTS user_settings_info (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) not null,
    type varchar(30) not null,
    subtype varchar(30),
    default_value varchar(30) not null,
    display_text varchar(200) not null,
    KEY(name), KEY(type)
);

create table IF NOT EXISTS user_settings (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    user_id int not null,
    usi_id int not null,
    value varchar(30) not null,
    KEY(user_id), KEY(user_id, usi_id)
);

create table IF NOT EXISTS settings (
    name varchar(20) NOT NULL PRIMARY KEY,
    value varchar(100)
);

create table IF NOT EXISTS pw_token (
    email varchar(100) not null PRIMARY KEY,
    ts DATETIME not null,
    token varchar(40) not null
);

INSERT INTO user (user_id, firstname, lastname, username, password, email) VALUES ('1', 'Ted', 'Cahall', 'tedcahall', 'xxxxx', 'cahall@cahall.com');

INSERT INTO user_roles (username, rolename) VALUES ('tedcahall', 'admin');
INSERT INTO user_roles (username, rolename) VALUES ('tedcahall', 'user');




commit;