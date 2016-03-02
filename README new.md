# GotPrintAssignment
GotPrint Assignment Application

http://localhost:8080/GotPrintUserNoteApplication/rest/userNotesService/getUserNotes/1
Authorization:gotprint:password

git remote add origin https://github.com/vaibhav-vsm/GotPrintAssignment.git

Get User Notes:
curl --header "Authorization: gotprint:password" http://localhost:8080/GotPrintUserNotesAssignment/rest/userNotesService/getUserNotes/1

Add user Notes:
curl -H "Content-Type: application/json;Authorization: gotprint:password" -X POST -d '{\"note\":\"add demo notes\", \"title\":\"Title-2\" }' http://localhost:8080/GotPrintUserNotesAssignment/rest/userNotesService/addUserNotes/(userId)

Update User Note:
curl -H "Content-Type: application/json;Authorization: gotprint:password" -X PUT -d '{\"noteId\":1, \"note\":\"add demo notes\", \"title\":\"Title-2\" }' http://localhost:8080/GotPrintUserNotesAssignment/rest/userNotesService/updateUserNote/(userId)

Delete User note:
curl -H "Content-Type: application/json;Authorization: gotprint:password" -X DELETE -d '{\"noteId\":1}' http://localhost:8080/GotPrintUserNotesAssignment/rest/userNotesService/deleteUserNote/(userId)

