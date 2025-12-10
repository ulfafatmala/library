#Rent API Spec

##Create Rent
Endpoint : POST /api/rent/{idMember}/{idBook}
Request Header :
- requestId: uuid unique

Response Body (Success):
``` json
{
    data : {
        "id":serial number auto-generate,
        "memberId" : 6,
        "memberName : "Ulfa Fatmala",
        "bookId" : 1,
        "bookName" : "Conversations on Love"
        "borrowingDate" : "2025-12-09",
        "deadlineReturnDate" : "2025-12-10",
        "returnDate":null        
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"bad request, idMember not found, idBook not found, ..."
}
```

##Update Rent
Endpoint : PUT /api/rent/{idRent}

Request Header :
- requestId: uuid unique

Request Body :
``` json
{
    "memberId" : 6,
    "bookId" : 1,
    "borrowingDate":"2025-12-09",
    "deadlineReturnDate" : "2025-12-10",
    "returnDate":"2025-12-10"
}
```

Response Body (Success):
``` json
{
    data : {
        "id":serial number auto-generate,
        "memberId" : 6,
        "memberName : "Ulfa Fatmala",
        "bookId" : 1,
        "bookName" : "Conversations on Love"
        "borrowingDate" : "2025-12-09",
        "deadlineReturnDate" : "2025-12-10",
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"bad request, idMember not found, idBook not found, ..."
}
```

##Get Rent

Endpoint : GET /api/rent/{idRent}

Request Header :
- requestId: uuid unique

Response Body (Success):
``` json
{
    data : {
        "id":serial number auto-generate,
        "memberId" : 6,
        "memberName : "Ulfa Fatmala",
        "bookId" : 1,
        "bookName" : "Conversations on Love"
        "borrowingDate" : "2025-12-09",
        "deadlineReturnDate" : "2025-12-10",
        "returnDate":"2025-12-10"
    }
}
```

Response Body (Failed 404):
``` json
{
    "errors":"Rent is not found"
}
```

##Seach Book

Endpoint : GET /api/search

Request Header :
- requestId: uuid unique

Query Param :
- memberName : String, member name, using like query, opsional
- bookName : String, book name, using like query, opsional
- borrowingDate : String, borrowing date, using like query, opsional
- deadlineReturnDate : String, deadline return date, using like query, opsional
- returnDate : String, return date, using like query, opsional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Response Body (Success):
``` json
{
    "data":[
        {            
            "id":serial number auto-generate,
            "memberId" : 6,
            "memberName : "Ulfa Fatmala",
            "bookId" : 1,
            "bookName" : "Conversations on Love"
            "borrowingDate" : "2025-12-09",
            "deadlineReturnDate" : "2025-12-10",
            "returnDate":"2025-12-10"
        }
    ],
    "paging":{
        "currentPage" : 0,
        "totalPage" : 10,
        "size" : 10
    }
}
```

##Remove Rent

Endpoint : DELETE /api/rent/{idRent}

Request Header :
- requestId: uuid unique

Response Body (Success):
``` json
{
    "data":"OK"
}
```

Response Body (Failed 404):
``` json
{
    "errors":"Rent is not found"
}
```
