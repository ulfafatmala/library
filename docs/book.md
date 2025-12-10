#Book API Spec

##Create Book
Endpoint : POST /api/book

Request Header :
- requestId: uuid unique

Request Body :
``` json
{
    "name":"The Kite Runner",
    "author":"Khaled Hosseini",
    "publisher":"Mizan",
    "numberOfPage":340
}
```

Response Body (Success):
``` json
{
    data : {
        "id":serial number auto-generate,
        "name":"The Kite Runner",
        "author":"Khaled Hosseini",
        "publisher":"Mizan",
        "dateOfEntry":"2025-12-09",
        "numberOfPage":340
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"Name format invalid, Date of entry format invalid, ..."
}
```

##Update Book

Endpoint : PUT /api/book/{idBook}

Request Header :
- requestId: uuid unique

Request Body :
``` json
{
    "name":"The Kite Runner",
    "author":"Khaled Hosseini",
    "publisher":"Mizan",
    "dateOfEntry":"2025-12-09",
    "numberOfPage":340
}
```

Response Body (Success):
``` json
{
    data : {
        "id":10,
        "name":"The Kite Runner",
        "author":"Khaled Hosseini",
        "publisher":"Mizan",
        "dateOfEntry":"2025-12-09",
        "numberOfPage":340
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"Name format invalid, Date of entry format invalid, ..."
}
```

##Get Book

Endpoint : GET /api/book/{idBook}

Request Header :
- requestId: uuid unique

Response Body (Success):
``` json
{
    data : {
        "id":10,
        "name":"The Kite Runner",
        "author":"Khaled Hosseini",
        "publisher":"Mizan",
        "dateOfEntry":"2025-12-09",
        "numberOfPage":340
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"Book is not found"
}
```

##Seach Book

Endpoint : GET /api/book

Request Header :
- requestId: uuid unique

Query Param :
- name : String, book name, using like query, opsional
- author : String, book author, using like query, opsional
- publisher : String, book publisher, using like query, opsional
- dateOfEntry : String, book dateOfEntry, using like query, opsional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Response Body (Success):
``` json
{
    "data":[
        {
            "id":10,
            "name":"The Kite Runner",
            "author":"Khaled Hosseini",
            "publisher":"Mizan",
            "dateOfEntry":"2025-12-09",
            "numberOfPage":340
        }
    ],
    "paging":{
        "currentPage" : 0,
        "totalPage" : 10,
        "size" : 10
    }
}
```

##Remove Book

Endpoint : DELETE /api/book/{idBook}

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
    "errors":"Book is not found"
}
```
