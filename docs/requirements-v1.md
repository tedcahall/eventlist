# Event List V1 - Requirements

## General Feature Requirements
1. User account required
2. Multiple event lists available per user account
3. Event list has a title and multiple events
4. An Event has multiple fields
   - Each field may have a custom name
   - The field list is user orderable
   - Fields may be hidden or displayed
   - Fields may link to external URLs
5. `FUTURE:` Multiple accounts linked to one event list - for family option

## Front End Web Application
1. Requires user registration with email address and username
2. Login via either email addrss or username
3. Password complexity: 8 char, one uppercase, one lowercase one of: $#!@%

## Web Link Display of Event List
1. Unique English readable URL format: http://eventlist.com/ev/username/myeventlistname
2. No token required
3. Can be password protected (for family calendars)

## REST API
1. REST API requires a token per event list
2. Returns the list in multiple formats (JSON, HTML)

## Javascript SDK
1. SDK allows sigle line embed of calendar into webpage (requires token)
