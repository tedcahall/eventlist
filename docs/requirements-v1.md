# Event List V1 - Requirements

## General Feature Requirements
1. User account required
   - Users can make their accounts publicly discoverable in list or by search
2. Multiple event lists available per user account
   - Event Lists can be marked discoverable (browse or search from home page)
3. Event list has a title and multiple events
   - All Event Lists can be seen on the web by URL-key - even if not discoverable
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
4. Browse / Search all discoverable users
5. Browse / Search all discoverable Event Lists

## Web Link Display of Event List
1. Unique English readable URL format: http://eventlist.com/ev/username/myeventlistname
2. No token required
3. Can be password protected (for family calendars)

## REST API
1. REST API requires a token per event list
2. Returns the list in multiple formats (JSON, HTML)

## Javascript SDK
1. SDK allows sigle line embed of calendar into webpage (requires token)

## Authentication / Roles

### Public
- Splash screen
- Login page
- Lost Password / Change Password
- Public Users List
- Public Events List
- Events Lists (driven by two above public lists)

### Members
- Config/Add/Edit New Event List
- List own Event Lists
- Is role is `admin` or `super-admin` then admin menu appears in nav

### Admin
- User administration
- Roles (user, admin, super-admin)
- `FUTURE:` Edit Member Event Lists / Hide Member Lists / Suspend Users
