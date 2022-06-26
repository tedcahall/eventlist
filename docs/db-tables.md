# Database Tables 

## user
Holds the user login info for Tomcat and the application.  The username field is used to retrieve the event calendar.

## user_roles
The roles for the user.  Evetually there will be a primary role (owner) and secondary roles for shared calendars.

## eventlist_title
Holds the title and description of the eventlist by user_id abd evlist_id

## eventlist
Main table for the free version.  Holds the user_id, evlist_id, evdate, evname, evlocation, evother.
Also holds the links for name, location, other.

## evorder
Order of the columns for a specific evlist_id

# Pro Version (paid)
This version will have unlimited rows and sort order.  To be built later.

## pel_main
Holds title, description, user_id, pel_id.

## pel_meta
Holds the meta data for a pro table: user_id, pel_id, the column names, sort order. One row per column.

## pel_items
Holds one column of the pro table.  This includes column name, column link, column sort order
