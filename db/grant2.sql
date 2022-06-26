# grant access to the MySQL user cahall
# These used to say 'localhost' but that did not work for AWS.  Likely needed for home and % needed for AWS
#
CREATE DATABASE IF NOT EXISTS eventlist;
CREATE USER 'cahall'@'%' IDENTIFIED BY 'bench315';
GRANT ALL on eventlist.* to 'cahall'@'%';
