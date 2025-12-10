#Member API Spec

##Create Member

Endpoint : POST /api/member

Request Body :
``` json
{
    "name":"Ulfa Fatmala",
    "email":"ulfafatmala@gmail.com",
    "phone":"6281999999",
    "address":"Jalan Kemuning 9 No.4, Depok"
}
```

Response Body (Success):
``` json
{
    data : {
        "id":serial number auto-generate,
        "name":"Ulfa Fatmala",
        "email":"ulfafatmala@gmail.com",
        "phone":"6281999999",
        "address":"Jalan Kemuning 9 No.4, Depok",
        "joinDate":"2025-12-09"
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"Email format invalid, phone format invalid, ..."
}
```
##Update Member

Endpoint : PUT /api/member/{idMember}

Request Body :
``` json
{
    "name":"Ulfa Fatmala",
    "email":"ulfafatmala@gmail.com",
    "phone":"6281999999",
    "address":"Jalan Kemuning 9 No.4, Depok",
    "joinDate":"2025-12-09"
}
```

Response Body (Success):
``` json
{
    data : {
        "id":6,
        "name":"Ulfa Fatmala",
        "email":"ulfafatmala@gmail.com",
        "phone":"6281999999",
        "address":"Jalan Kemuning 9 No.4, Depok",
        "joinDate":"2025-12-09"
    }
}
```

Response Body (Failed):
``` json
{
    "errors":"Email format invalid, phone format invalid, ..."
}
```

##Get Member

Endpoint : GET /api/member/{idMember}

Response Body (Success):
``` json
{
    data : {
        "id":6,
        "name":"Ulfa Fatmala",
        "email":"ulfafatmala@gmail.com",
        "phone":"6281999999",
        "address":"Jalan Kemuning 9 No.4, Depok",
        "joinDate":"2025-12-09"
    }
}
```

Response Body (Failed 404):
``` json
{
    "errors":"Member is not found"
}
```

##Seach Member

Endpoint : GET /api/member

Query Param :
- name : String, member name, using like query, opsional
- email : String, member email, using like query, opsional
- phone : String, member phone, using like query, opsional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Response Body (Success):
``` json
{
    "data":[
        {
            "id":6,
            "name":"Ulfa Fatmala",
            "email":"ulfafatmala@gmail.com",
            "phone":"6281999999",
            "address":"Jalan Kemuning 9 No.4, Depok",
            "joinDate":"2025-12-09"
        }
    ],
    "paging":{
        "currentPage" : 0,
        "totalPage" : 10,
        "size" : 10
    }
}
```

##Remove Member

Endpoint : DELETE /api/member/{idMember}

Response Body (Success):
``` json
{
    "data":"OK"
}
```

Response Body (Failed 404):
``` json
{
    "errors":"Member is not found"
}
```
