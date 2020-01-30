# Simple-Bio-Rest-API
A Spring Boot Rest api that can perform CRUD operations on a MySQL DB. 


create bio
method: post
endpoint: http://localhost:8080/api/people
payload: 

{
	"id": 1,
	"name": "John doe",
	"sex": "M",
	"age": 20
}

method : get
endpoint: http://localhost:8080/api/people/1 (1 = ID)
payload:

{
    "id": 1,
    "name": "John doe",
    "sex": "M",
    "age": 20,
    "createdAt": null,
    "updatedAt": null
}

method: put
endpoint: http://localhost:8080/api/people/1 (1 = ID)
payload: 

{
    "id": 1,
    "name": "John doe",
    "sex": "M",
    "age": 40
}

{
    "id": 1,
    "name": "John doe",
    "sex": "M",
    "age": 40,
    "createdAt": null,
    "updatedAt": null
}

method
